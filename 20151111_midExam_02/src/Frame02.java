import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame02 extends JFrame{
	public Frame02(){
		initcomp();
	}
	private JButton jbtnRun = new JButton("RUN");
	private JButton jbtnExit = new JButton("Exit");
	private JLabel jbl1 = new JLabel(" 身高(CM) ");
	private JLabel jbl2 = new JLabel(" 體重(KG) ");
	private JTextField jtf1 = new JTextField();
	private JTextField jtf2 = new JTextField();
	private JTextField jtf3 = new JTextField(" 您的BMI = ");
	
	private void initcomp(){
		setTitle("minExam_02_103021076");
		setBounds(200, 150, 400, 230);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		jbl1.setBounds(60,40,80,20);
		jbl2.setBounds(60,80,80,20);
		jtf3.setBounds(60,120,240,20);
		
		jtf1.setBounds(140, 40, 80, 20);
		jtf2.setBounds(140, 80, 80, 20);
		
		jbtnRun.setBounds(240, 40, 80, 20);
		jbtnExit.setBounds(240, 80, 80, 20);
		
		this.add(jbl1);
		this.add(jbl2);
		this.add(jtf3);
		jtf3.setEditable(false);
		this.add(jtf1);
		this.add(jtf2);
		this.add(jbtnRun);
		this.add(jbtnExit);
		
		jbtnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jbtnRun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					double h = Float.parseFloat(jtf1.getText())/100.0;
					double w = Float.parseFloat(jtf2.getText());
					double bmi = (double) (w/(h*h));
					jtf3.setText(" 您的BMI = "+bmi);
				}catch(Exception ex){
					jtf3.setText(" 輸入資訊錯誤 ");
				}
				
			}
		});
	}
}
