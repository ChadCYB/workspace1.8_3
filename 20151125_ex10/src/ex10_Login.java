import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class ex10_Login extends JFrame implements ActionListener {
	public ex10_Login(){
		initComp();
	}

	private JButton jbtnClear1 = new JButton("Clear");
	private JButton jbtnClear2 = new JButton("Clear");
	private JLabel jlb1 = new JLabel("ID:");
	private JLabel jlb2 = new JLabel("Password:");
	private JTextField jtfAcc = new JTextField("user1");
	private JPasswordField jpfPass = new JPasswordField("user1");

	private JButton jbtnCancel = new JButton("Cancel");
	private JButton jbtnEnter = new JButton("Enter");
	private Container cp;
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();

	private void initComp(){
		setVisible(true);
		this.setTitle("Login");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	//關閉整個程式
		this.setResizable(true);
		setBounds(300, 300, 300, 200);
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(jp1, BorderLayout.CENTER);
		cp.add(jp2, BorderLayout.SOUTH);
		
		jlb1.setFont(new Font("Arial", Font.BOLD, 15));
		jlb2.setFont(new Font("Arial", Font.BOLD, 15));
		jlb1.setHorizontalAlignment(SwingConstants.RIGHT);
		jlb2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		jp1.setLayout(new GridLayout(2, 3, 10, 20));
		jp1.setBackground(new Color(180, 240, 245));
		jp1.add(jlb1);
		jp1.add(jtfAcc);
		jp1.add(jbtnClear1);
		jp1.add(jlb2);
		jp1.add(jpfPass);
		jp1.add(jbtnClear2);
		
		jp2.setLayout(new GridLayout(1,2,10,20));
		jp2.setBackground(Color.orange);
		jp2.add(jbtnCancel);
		jp2.add(jbtnEnter);
		
		jbtnClear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jtfAcc.setText("");
			}
		});
		jbtnClear2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jpfPass.setText("");
			}
		});
		jbtnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				jtfAcc.setText("");
				jpfPass.setText("");
			}
		});
		jbtnEnter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String sAcc = jtfAcc.getText();
				String sPass = jpfPass.getText();
				DB_Conn db = new DB_Conn();
				if(db.validate(sAcc, sPass)){
					JOptionPane.showMessageDialog(cp, "登入成功!!");
					ex10_Frame jframe = new ex10_Frame(db);
					setVisible(false);
				}else{
					JOptionPane.showMessageDialog(cp, "登入失敗");
				}
			}
		});
	}

	public void actionPerformed(ActionEvent e) { 		//接收按鈕指令
		JButton HitBtn = (JButton) e.getSource(); 		//查詢來源
		jpfPass.setText(jpfPass.getText() + HitBtn.getText());
	}

}