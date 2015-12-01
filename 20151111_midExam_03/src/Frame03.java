import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame03 extends JFrame{
	public Frame03(){
		initcomp();
	}
	private JLabel jbl1 = new JLabel("¡@¡@¡@¡@¡@¡@°_©l­È");
	private JLabel jbl2 = new JLabel("¡@¡@¡@¡@¡@¡@²×¤î­È");
	private JButton jbtnRun = new JButton("Run");
	private JButton jbtnExit = new JButton("Exit");
	private JTextField jtf1 = new JTextField();
	private JTextField jtf2 = new JTextField();
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private JPanel jpl1 = new JPanel();
	private void initcomp(){
		setTitle("minExam_03_103021076");
		setBounds(200, 150, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		jpl1.setLayout(new GridLayout(2,3,5,5));
		jpl1.add(jbl1);
		jpl1.add(jtf1);
		jpl1.add(jbtnRun);
		jpl1.add(jbl2);
		jpl1.add(jtf2);
		jpl1.add(jbtnExit);
		this.add(jpl1,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.CENTER);
		jbtnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jbtnRun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int v1 = Integer.parseInt(jtf1.getText());
				int v2 = Integer.parseInt(jtf2.getText());
				jta.append(cal(v1,v2)+"\n");
			}
		});
	}
	private String cal(int a1,int a2){
		int v1 = Math.min(a1, a2);
		int v2 = Math.max(a1, a2);
		String res = "";
		int i,sum = 0;
		for(i=v1 ; i<=v2 ; i++){
			sum += i;
			res += i+" + ";
		}
		res = res.substring(0,res.length()-3) + " = " + sum;
		return res;
	}
}
