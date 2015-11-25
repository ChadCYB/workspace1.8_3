import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public class DB_Conn {
	private Properties properties = new Properties();
	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	private String host, username, password;
	public DB_Conn(){
		String configFile = "config.properties";
		try {
			properties.load(new FileInputStream(configFile));	//Ū���]�w��
		} catch (FileNotFoundException ex) {					//�䤣���ɮ�
			ex.printStackTrace();
			return;
		} catch (IOException ex) {
			ex.printStackTrace();
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
		host = properties.getProperty("host", "jdbc:mysql://localhost/default");	//(�ݭn�����,�w�]��)
		username = properties.getProperty("username");								//(�ݭn�����)
		password = properties.getProperty("password", "");							//(�ݭn�����,�w�]��)
		if(username == null || username.isEmpty()){			//user ���]�w
			System.out.println("user passwd not set");
		}
		if(password.isEmpty()){								//password ���]�w, ���w�]�ȪŦr��
			System.out.println("database passwd not set");
		}
	}

	public ResultSet dbSearch(String sql){			//��Ʈw�d�ߥ\��
		Connection dbConn = null;							//��Ʈw�s��
		Statement stmt = null;								//��Ʈw�ާ@
		ResultSet rs1 = null;
		try {
			Class.forName(DBDRIVER);						//���J�X�ʵ{��
			dbConn = DriverManager.getConnection(host,username,password);		//�s����Ʈw(URL,user,passwd)
			if(!sql.equals("")){
				stmt = dbConn.createStatement();			//�بҹ���Statement����
				rs1 = stmt.executeQuery(sql);				//����SQL�ާ@
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs1;											//�^�Ǭd�߸��
	}
	public boolean validate(String aID, String aPIN){		//�b������
		ResultSet rs = null;
		String sql = 
			("SELECT * FROM account WHERE userID = '" +aID+ "' AND passwd = MD5('"+ aPIN +"')");
		boolean loginFlag = false;
		try {
			rs = this.dbSearch(sql);
			int count = 0;
			while(rs.next()) count++;
			loginFlag = (count == 1) ? true:false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginFlag;									//�^�Ǭd�߸��
	}
}