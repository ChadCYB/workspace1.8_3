import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ex06_Frame extends JFrame implements ActionListener{
	
	public ex06_Frame(){
		initComp();
	}
	private JButton[] jbtnArr = new JButton[12];
	private JPasswordField jpf = new JPasswordField();
	private JCheckBox jcb = new JCheckBox("Show password"); 
	private Container cp;
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	
	private void initComp(){
		setVisible(true);
		setTitle("103021076_EX06");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		setBounds(300,300,400,500);
		
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(jp1, BorderLayout.NORTH);
		cp.add(jp2, BorderLayout.CENTER);
		cp.add(jp3, BorderLayout.SOUTH);
		
		jp1.setLayout(new GridLayout(0,1,5,5));
		jp2.setLayout(new GridLayout(4,3,5,5));
		jp3.setLayout(new GridLayout(0,1,5,5));
		
		jp1.add(jpf);
		jp3.add(jcb);
		int random[] = new int[12];
		for(int i=0 ; i<12 ; i++){							//亂數產生
			random[i] = (int)(Math.random()*12);
			for(int j=0 ; j<i ; j++){
				if(random[i] == random[j])	i--;
			}
		}
		for(int i=0 ; i<12 ; i++){							//陣列按鈕
			String str = "";
			int rnd = random[i];
			if(rnd == 10){
				str = ".";
			}else if(rnd == 11){
				str = "EXIT";
			}else{
				str = rnd+"";
			}
			jbtnArr[i] = new JButton(str);
			jbtnArr[i].addActionListener(this);
			jbtnArr[i].setFont(new Font("Arial", Font.PLAIN, 35));
			jp2.add(jbtnArr[i]);
		}
		
		jpf.setFont(new Font("Arial", Font.PLAIN, 40));		//Password欄位字型
		jcb.addChangeListener(new ChangeListener(){			//CheckBox觸發
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if(jcb.isSelected()){
					jpf.setEchoChar((char) 0);
				}else{
					jpf.setEchoChar('*');
				}
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {			//按鈕觸發
		JButton btn = (JButton)arg0.getSource();
		if(btn.getText().equals("EXIT")){
			System.exit(0);
		}else{
			jpf.setText(jpf.getText()+btn.getText());
		}
	}
	
}
