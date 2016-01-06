import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ex04 extends JFrame{
	private JLabel jlbT[] = new JLabel[6];
	private JLabel jlbA[] = new JLabel[6];
	private JButton jbtnRun = new JButton("Run");
	private JButton jbtnExit = new JButton("Exit");
	private JPanel jplUp = new JPanel();
	private JPanel jplDown = new JPanel();
	private Container cp;
	private int Width = 600, Height = 400;
	
	public ex04(){
		initComp();
	}
	private void initComp(){
		this.setTitle("103021076_EX04");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int)((screenSize.getWidth()-Width)*0.5), (int)((screenSize.getHeight()-Height)*0.5), Width, Height);
		
		cp = this.getContentPane();
		cp.setLayout(new GridLayout(2,1,5,5));
		cp.add(jplUp);
		cp.add(jplDown);
		
		jplUp.setLayout(new GridLayout(1,2,5,5));
		jplUp.add(jbtnRun);
		jplUp.add(jbtnExit);
		jplDown.setLayout(new GridLayout(2,6,5,5));
		for(int i=0 ; i<6 ; i++){
			jlbT[i] = new JLabel("²Ä"+(i+1)+"­Ó", SwingConstants.CENTER);
			jlbA[i] = new JLabel("", SwingConstants.CENTER);
			jlbT[i].setOpaque(true);
			jlbA[i].setOpaque(true);
			jlbT[i].setBackground(new Color(170,170,225));
			jlbA[i].setBackground(new Color(170,225,170));
			jplDown.add(jlbT[i]);
		}
		for(int i=0 ; i<6 ; i++){
			jplDown.add(jlbA[i]);
		}
		jbtnRun.addActionListener(ae -> {
			int[] num = randNum();
			for(int i=0 ; i<6 ; i++){
				jlbA[i].setText(num[i]+"");;
			}
		});
		jbtnExit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	private int[] randNum(){
		int[] result = new int[6];
		for(int i=0 ; i<6 ; i++){
			result[i] = (int)(Math.random()*24)+1;
			for(int j=0 ; j<i ; j++){
				if(result[i] == result[j]){
					i--;
				}
			}
		}
		return result;
	}
}
