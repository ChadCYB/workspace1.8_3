import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame07 extends JFrame{
	public Frame07(){
		initcomp();
	}
	private JButton jbtnZoomIn = new JButton("©ñ¤j");
	private JButton jbtnZoomOut = new JButton("ÁY¤p");
	private JButton jbtnExit = new JButton("Exit");
	private int x = 300 ,y = 300;
	
	private void initcomp(){
		setTitle("minExam_07_103021076");
		setBounds(200, 200, 300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jbtnZoomIn.setBounds(90, 50, 100, 30);
		jbtnZoomOut.setBounds(90, 110, 100, 30);
		jbtnExit.setBounds(90, 170, 100, 30);
		this.setLayout(null);
		this.add(jbtnZoomIn);
		this.add(jbtnZoomOut);
		this.add(jbtnExit);
		
		jbtnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jbtnZoomIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				x += 10;
				y += 10;
				setFrame();
			}
		});
		jbtnZoomOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				x -= 10;
				y -= 10;
				setFrame();
			}
		});
	}
	private void setFrame(){
		this.setBounds(200,200,x,y);
	}
}
