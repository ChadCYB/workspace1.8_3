import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame06 extends JFrame{
	public Frame06(){
		initcomp();
	}
	private JLabel jbl1 = new JLabel("　圖形高度:　");
	private JLabel jbl2 = new JLabel("　背景顏色:　");
	private JLabel jbl3 = new JLabel("　字形顏色:　");
	private JButton jbtnRun = new JButton("Run");
	private JButton jbtnClean = new JButton("Clean");
	private JButton jbtnExit = new JButton("Exit");
	private JTextField jtf1 = new JTextField("6");
	private JComboBox jcb1 = new JComboBox();
	private JComboBox jcb2 = new JComboBox();
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private JPanel jpl1 = new JPanel();
	private String[] arr = {"白色","藍色","紅色","綠色","洋藍色","黑色","黃色"};
	private void initcomp(){
		setTitle("minExam_03_103021076");
		setBounds(200, 150, 500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		jpl1.setLayout(new GridLayout(3,3,5,5));
		jpl1.add(jbl1);
		jpl1.add(jtf1);
		jpl1.add(jbtnRun);
		jpl1.add(jbl2);
		jpl1.add(jcb1);
		jpl1.add(jbtnClean);
		jpl1.add(jbl3);
		jpl1.add(jcb2);
		jpl1.add(jbtnExit);
		this.add(jpl1,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.CENTER);
		
		for(String s:arr){
			jcb1.addItem(s);
			jcb2.addItem(s);
		}
		jcb1.setSelectedItem("白色");
		jcb2.setSelectedItem("黑色");
		setColor();
		
		jcb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setColor();
			}
		});
		jcb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setColor();
			}
		});
		jbtnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jbtnClean.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jta.setText("");
			}
		});
		jbtnRun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int h = Integer.parseInt(jtf1.getText());
				jta.append(show(h));
			}
		});
	}
	private String show(int h){
		String str = "";
		for(int i=0 ; i<h ; i++){
			for(int j=0 ; j<=i ; j++){
				str += "@";
			}
			str += "\n";
		}
		return str;
	}
	private void setColor(){
		Color c1 = getColor(jcb1.getSelectedIndex());
		Color c2 = getColor(jcb2.getSelectedIndex());
		jta.setForeground(c2);
		jta.setBackground(c1);
	}
	private Color getColor(int i){
//		"白色","藍色","紅色","綠色","洋藍色","黑色","黃色"
		Color c = null;
		switch(i){
		case 0:
			c = Color.WHITE;
			break;
		case 1:
			c = Color.BLUE;
			break;
		case 2:
			c = Color.RED;
			break;
		case 3:
			c = Color.GREEN;
			break;
		case 4:
			c = Color.CYAN;
			break;
		case 5:
			c = Color.BLACK;
			break;
		case 6:
			c = Color.YELLOW;
			break;
		}
		return c;
	}
}
