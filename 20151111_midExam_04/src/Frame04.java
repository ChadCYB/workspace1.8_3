import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Frame04 extends JFrame{
	public Frame04(){
		initcomp();
	}
	private JButton jbtnUP = new JButton("上");
	private JButton jbtnDOWN = new JButton("下");
	private JButton jbtnLEFT = new JButton("左");
	private JButton jbtnRIGHT = new JButton("右");
	private JButton jbtnExit = new JButton("Exit");
	private JLabel jbl = new JLabel("我是標籤");
	private JPanel jpl1 = new JPanel();
	private JPanel jpl2 = new JPanel();
	private int x=160,y=60;
	
	private void initcomp(){
		setTitle("minExam_04_103021076");
		setBounds(200, 150, 400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setFocusTraversalKeysEnabled(true);
		this.setLayout(new BorderLayout());
		jpl1.setBackground(Color.white);
		jpl1.setLayout(new GridLayout(2,3,5,5));
		jpl1.add(jbtnUP);
		jpl1.add(jbtnDOWN);
		jpl1.add(jbtnExit);
		jpl1.add(jbtnLEFT);
		jpl1.add(jbtnRIGHT);
		jpl2.setLayout(null);
		
		this.add(jpl1,BorderLayout.NORTH);
		this.add(jpl2,BorderLayout.CENTER);
		jbl.setBounds(x,y,100,40);
		jpl2.add(jbl);
		
		jbtnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jbtnUP.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				y -= 5;
				setLabel();
			}
		});
		jbtnDOWN.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				y += 5;
				setLabel();
			}
		});
		jbtnLEFT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				x -= 5;
				setLabel();
			}
		});
		jbtnRIGHT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				x += 5;
				setLabel();
			}
		});
	}
	private void setLabel(){
		jbl.setBounds(x,y,100,40);
	}
}
