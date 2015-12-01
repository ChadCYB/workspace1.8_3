import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame01 extends JFrame{
	public Frame01(){
		initcomp();
	}
	private JButton jbtn = new JButton("Exit");
	
	private void initcomp(){
		setTitle("minExam_01_103021076");
		setBounds(200, 150, 300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jbtn.setBounds(90, 50, 100, 50);
		this.setLayout(null);
		this.add(jbtn);
		
		jbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
