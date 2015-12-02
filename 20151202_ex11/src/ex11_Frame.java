/*
 Jfreechart 圖表繪製
 * */
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
import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class ex11_Frame extends JFrame{
	public ex11_Frame(DB_Conn db){
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
	private JInternalFrame jifPie1;
	private JInternalFrame jifPie2;
	private JInternalFrame jifPie3;
	private JScrollPane jsp;
	private JTable jtable;
	private DB_Conn dbConn;
	private Object[][] objData;
	private int[][] Score;
	
	private ResultSet rs;
	private ResultSetMetaData meta;

	private void initComp(){
		setVisible(true);
		this.setTitle("DB");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//關閉整個程式
		this.setResizable(true);
		setBounds(100, 100, 1030, 680);
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
				drawPieChart();
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
			String sql = "SELECT * FROM `score` WHERE 1";
			rs = dbConn.dbSearch(sql);
			int colCount = 0;
			if(rs != null){
				meta = rs.getMetaData();
				int rowCount = 0, row = 0;
				while(rs.next()) rowCount++;				//幾筆資料
				colCount = meta.getColumnCount();			//幾筆欄位
				objData = new Object[rowCount][colCount];	//儲存資料用的物件陣列
				Score = new int[colCount-2][5];
//				System.out.println(rowCount+","+colCount);
				rs.first();									//指標移到第一筆
				do{
					for(int i=0 ; i<colCount ; i++){
						objData[row][i] = rs.getString(i+1);
						if(i>=2)scoreCount(row,i);			//第三筆資料是成績
//						System.out.println(rs.getString(i+1));
					}
					row++;
				}while(rs.next());

				String[] tableHeading = {"學號","姓名","英文","程設","數學"};
				jtable = new JTable(objData,tableHeading);
				jsp = new JScrollPane(jtable);
				
				cp2.add(jsp);
				jif1.setBounds(0, 0, 500, 300);	//解決資料不會顯示問題
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void scoreCount(int r, int c) {
		double val = Double.parseDouble(objData[r][c]+"");
		c-=2;			//第三筆開始才是成績資料
		if(val>90){
			Score[c][0]++;
		}else if(val>80){
			Score[c][1]++;
		}else if(val>70){
			Score[c][2]++;
		}else if(val>60){
			Score[c][3]++;
		}else{
			Score[c][4]++;
		}
	}

	private void drawPieChart(){
		jifPie1 = new JInternalFrame("English");
		jifPie2 = new JInternalFrame("Programming");
		jifPie3 = new JInternalFrame("Mathematic");
		jdp.add(jifPie1);
		jdp.add(jifPie2);
		jdp.add(jifPie3);
		jifPie1.setVisible(true);
		jifPie2.setVisible(true);
		jifPie3.setVisible(true);
		jifPie1.setBounds(500, 0, 500, 300);
		jifPie2.setBounds(0, 300, 500, 300);
		jifPie3.setBounds(500, 300, 500, 300);
		
		// create a chart
		JFreeChart chart1 = ChartFactory.createPieChart(
				"English",
				creatDataset(0),
				true, // legend
				true, // tooltips
				false // URLs
		);
		JFreeChart chart2 = ChartFactory.createPieChart(
				"Programming",
				creatDataset(1),
				true, // legend
				true, // tooltips
				false // URLs
		);
		JFreeChart chart3 = ChartFactory.createPieChart(
				"Mathematic",
				creatDataset(2),
				true, // legend
				true, // tooltips
				false // URLs
		);
		jifPie1.add(new ChartPanel(chart1));	//chart轉chartpane
		jifPie2.add(new ChartPanel(chart2));	//chart轉chartpane
		jifPie3.add(new ChartPanel(chart3));	//chart轉chartpane

	}
	private PieDataset creatDataset(int flag){
		DefaultPieDataset data = new DefaultPieDataset();	// create a dataset
		data.setValue(">90", Score[flag][0]);
		data.setValue("90~81", Score[flag][1]);
		data.setValue("80~71", Score[flag][2]);
		data.setValue("70~60", Score[flag][3]);
		data.setValue("<60", Score[flag][4]);
		return data;

	}
}
