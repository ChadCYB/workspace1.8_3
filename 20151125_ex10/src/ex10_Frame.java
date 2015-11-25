import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ex10_Frame extends JFrame{
	public ex10_Frame(DB_Conn db){
		dbConn = db;
		initComp();
	}
	private Container cp;
	private Container cp2;
	private JButton jbtn_Conn = new JButton("Conn. DB");
	private JButton jbtn_Show = new JButton("Show Data");
	private JButton jbtn_Exit = new JButton("Exit");
	private JPanel jp1 = new JPanel(new GridLayout(1,4,3,3));
	private JDesktopPane jdp = new JDesktopPane();
	private JInternalFrame jif1;
	private DB_Conn dbConn;
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private ResultSet rs;
	private ResultSetMetaData meta;
	
	private void initComp(){
		setVisible(true);
		this.setTitle("DB");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//關閉整個程式
		this.setResizable(true);
		setBounds(200, 200, 600, 500);
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(jp1, BorderLayout.NORTH);
		cp.add(jdp, BorderLayout.CENTER);		
		jp1.add(jbtn_Conn);
		jp1.add(jbtn_Show);
		jp1.add(jbtn_Exit);
		jbtn_Show.setEnabled(false);
		
		jbtn_Conn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dbConn = new DB_Conn();
				if(dbConn != null){
					jif1 = new JInternalFrame("DB Connected");
					jif1.setBounds(0,0,500,300);
					jdp.add(jif1);
					jif1.setVisible(true);
					jbtn_Show.setEnabled(true);
					cp2 = jif1.getContentPane();
				}
			}
		});
		jbtn_Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				showData();
			}
		});
		jbtn_Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});
	}
	
	private void showData(){
		try{
			String sql = "SELECT * FROM `users` WHERE 1";
			rs = dbConn.dbSearch(sql);
			int colCount = 0;
			if(rs != null){
				meta = rs.getMetaData();
				colCount = meta.getColumnCount();
				while(rs.next()){
					String[] record = new String[colCount];
					for(int i=0 ; i<colCount ; i++){
						record[i] = rs.getString(i+1);
						jta.append(record[i]+"\t");
//						System.out.println(record[i]+"\t");
					}
					jta.append("\n");
				}
				cp2.add(jsp);
				jif1.setBounds(1, 0, 500, 300);	//解決資料不會顯示問題
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
