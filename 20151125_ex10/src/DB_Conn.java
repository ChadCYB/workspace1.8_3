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
			properties.load(new FileInputStream(configFile));	//讀取設定檔
		} catch (FileNotFoundException ex) {					//找不到檔案
			ex.printStackTrace();
			return;
		} catch (IOException ex) {
			ex.printStackTrace();
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
		host = properties.getProperty("host", "jdbc:mysql://localhost/default");	//(需要的欄位,預設值)
		username = properties.getProperty("username");								//(需要的欄位)
		password = properties.getProperty("password", "");							//(需要的欄位,預設值)
		if(username == null || username.isEmpty()){			//user 未設定
			System.out.println("user passwd not set");
		}
		if(password.isEmpty()){								//password 未設定, 給預設值空字串
			System.out.println("database passwd not set");
		}
	}

	public ResultSet dbSearch(String sql){			//資料庫查詢功能
		Connection dbConn = null;							//資料庫連結
		Statement stmt = null;								//資料庫操作
		ResultSet rs1 = null;
		try {
			Class.forName(DBDRIVER);						//載入驅動程式
			dbConn = DriverManager.getConnection(host,username,password);		//連結資料庫(URL,user,passwd)
			if(!sql.equals("")){
				stmt = dbConn.createStatement();			//建例實體Statement物件
				rs1 = stmt.executeQuery(sql);				//執行SQL操作
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs1;											//回傳查詢資料
	}
	public boolean validate(String aID, String aPIN){		//帳號驗證
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
		return loginFlag;									//回傳查詢資料
	}
}