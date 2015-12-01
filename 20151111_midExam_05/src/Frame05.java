import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame05 extends JFrame{
	public Frame05(){
		initcomp();
	}
	private JButton jbtnPush = new JButton("Push");
	private JButton jbtnExit = new JButton("Exit");
	private int pushCount = 0;
	
	private void initcomp(){
		setTitle("次數: 0");
		setBounds(200, 150, 300, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jbtnPush.setBounds(90, 50, 100, 30);
		jbtnExit.setBounds(90, 110, 100, 30);
		this.setLayout(null);
		this.add(jbtnPush);
		this.add(jbtnExit);
		
		jbtnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jbtnPush.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setPush();
			}
		});
	}
	private void setPush(){
		pushCount++;
		setTitle("次數: "+pushCount);
	}
}
