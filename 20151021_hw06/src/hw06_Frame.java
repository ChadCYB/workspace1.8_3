import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class hw06_Frame extends JFrame{
	public hw06_Frame(){
		initComp();
	}
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private Container cp;
	private JLabel jlb1 = new JLabel("顯示字:");
	private JLabel jlb2 = new JLabel("高度:");
	private JTextField jtf = new JTextField("大");
	private JTextField jtf2 = new JTextField("15");
	
	String[] petStrings = { "▲","△","◢","◣","◤","◥" };
	private JComboBox jcombo = new JComboBox(petStrings);
	private JButton jbtn = new JButton("RUN");
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	
	private void initComp(){
		setVisible(true);
		setBounds(300,300,600,600);
		this.setTitle("103021076_HW06");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(jp1, BorderLayout.NORTH);
		cp.add(jp2, BorderLayout.CENTER);
		jp1.setLayout(new GridLayout(2,3,5,5));
		
		jlb1.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb2.setHorizontalAlignment(SwingConstants.RIGHT);
		jp1.add(jlb1);
		jp1.add(jtf);
		jp1.add(jcombo);
		jp1.add(jlb2);
		jp1.add(jtf2);
		jp1.add(jbtn);
		
		jp2.setLayout(new GridLayout(0,1,5,5));
		jp2.add(jsp);
		
		jbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				switch(jcombo.getSelectedItem().toString()){
				case "▲":
					break;
				
				}
				System.out.println(jcombo.getSelectedItem().toString());
				
			}
			
		});
	}
}
