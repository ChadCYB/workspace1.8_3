import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ex03 extends JFrame{
	private JLabel jlb = new JLabel("測試年:");
	private JButton jbtnExit = new JButton("結束");
	private JButton jbtn = new JButton("測試");
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private JTextField jtf = new JTextField();
	private Container cp;
	private int Width = 500, Height = 500;
	
	public ex03(){
		initComp();
	}
	private void initComp(){
		this.setTitle("103021076_EX03");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int)((screenSize.getWidth()-Width)*0.5), (int)((screenSize.getHeight()-Height)*0.5), Width, Height);
		
		cp = this.getContentPane();
		cp.setLayout(null);
		cp.add(jlb);
		cp.add(jbtnExit);
		cp.add(jbtn);
		cp.add(jsp);
		cp.add(jtf);
		
		jlb.setBounds(20, 20, 50, 30);
		jtf.setBounds(70, 20, 100, 30);
		jbtn.setBounds(180, 20, 80, 30);
		jbtnExit.setBounds(380, 20 ,80, 30);
		jsp.setBounds(20,70,445,360);
		
		jbtn.addActionListener(ae -> {
			try{
				int year = Integer.parseInt(jtf.getText());
				if(year > 0){
					if(isLeapYear(year)){
						jta.append(year+" 是閏年!\n");
					}else{
						jta.append(year+" 不是閏年!\n");
					}
				}else{
					jta.append("資料錯誤!\n");
				}
				
			}catch(NumberFormatException ex){
				jta.append("格式錯誤!!\n");
//				ex.printStackTrace();
			}
		});
		jbtnExit.addActionListener(ae -> {
			System.exit(0);
		});
	}
	private boolean isLeapYear(int year){
		return ((year%4==0)&&(year%100!=0))||(year%400==0);
	}
}






















