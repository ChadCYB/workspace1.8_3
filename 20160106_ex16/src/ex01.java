import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ex01 extends JFrame{
	private JLabel jlbR1 = new JLabel("¬õ");
	private JLabel jlbG1 = new JLabel("ºñ");
	private JLabel jlbB1 = new JLabel("ÂÅ");
	private JLabel jlbT1 = new JLabel("­I´ºÃC¦â");
	private JLabel jlbR2 = new JLabel("¬õ");
	private JLabel jlbG2 = new JLabel("ºñ");
	private JLabel jlbB2 = new JLabel("ÂÅ");
	private JLabel jlbT2 = new JLabel("­I´ºÃC¦â");
	private JButton jbtnExit = new JButton("µ²§ô");
	private JButton jbtnBg = new JButton("®M¥Î");
	private JButton jbtnFont = new JButton("®M¥Î");
	private JTextArea jta = new JTextArea();
	private JTextField jtfR1 = new JTextField();
	private JTextField jtfG1 = new JTextField();
	private JTextField jtfB1 = new JTextField();
	private JTextField jtfR2 = new JTextField();
	private JTextField jtfG2 = new JTextField();
	private JTextField jtfB2 = new JTextField();
	private Container cp;
	private int Width = 500, Height = 500;
	
	public ex01(){
		initComp();
	}
	private void initComp(){
		this.setTitle("103021076_EX01");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int)((screenSize.getWidth()-Width)*0.5), (int)((screenSize.getHeight()-Height)*0.5), Width, Height);
		
		cp = this.getContentPane();
		cp.setLayout(null);
		cp.add(jlbT1);
		cp.add(jlbR1);
		cp.add(jlbG1);
		cp.add(jlbB1);
		cp.add(jlbT2);
		cp.add(jlbR2);
		cp.add(jlbG2);
		cp.add(jlbB2);
		
		jlbR1.setBounds(5,5,100,20);
	}
}
