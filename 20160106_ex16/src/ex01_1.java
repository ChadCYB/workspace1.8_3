import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ex01_1 extends JFrame{
	private JButton jbnuse1 = new JButton("套用");
	private JButton jbnuse2 = new JButton("套用");
	private JButton jbnexit = new JButton("結束");
	private JLabel jlbbg = new JLabel("背景顏色");
	private JLabel jlbft = new JLabel("字體顏色");
	private JLabel jlbs[][] = new JLabel[2][3];
	private JTextField jtfs[][] = new JTextField[2][3];
	private String colors[][] = {{"紅","綠","藍"},{"紅","綠","藍"}};
	private JLabel jlbshow = new JLabel("　　亞洲大學　資工工程系");
	//private JPanel jpnshow = new JPanel();
	
	public ex01_1(){
		initComp();
	}
	
	public void initComp(){
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,200,400,600);
		jlbbg.setBounds(50,50,60,50);
		jlbft.setBounds(50,200,60,50);
		jbnuse1.setBounds(300,150,60,50);
		jbnuse2.setBounds(300,300,60,50);
		jbnexit.setBounds(300,50,60,50);
		jlbshow.setBounds(50,380,300,150);
		add(jbnuse1);
		add(jbnuse2);
		add(jbnexit);
		add(jlbbg);
		add(jlbft);
		add(jlbshow);
		int y = 50;
		int d = 80;
		for(int i=0;i<3;i++){
			jlbs[0][i] = new JLabel();
			jlbs[0][i].setBounds(y+(d*i),80,60,50);
			jlbs[0][i].setText(colors[0][i]);
			
			jlbs[1][i] = new JLabel();
			jlbs[1][i].setBounds(y+(d*i),230,60,50);
			jlbs[1][i].setText(colors[1][i]);
			add(jlbs[0][i]);
			add(jlbs[1][i]);
		}
		for(int i=0;i<3;i++){
			jtfs[0][i] = new JTextField();
			jtfs[0][i].setBounds(y+(d*i),150,60,50);
			
			jtfs[1][i] = new JTextField();
			jtfs[1][i].setBounds(y+(d*i),300,60,50);
			add(jtfs[0][i]);
			add(jtfs[1][i]);
		}
		for(int i=0;i<2;i++){
			for(int j=0;j<3;j++){
				jtfs[i][j].setFont(new Font("標楷體",Font.BOLD+Font.ITALIC,14));
			}
		}
		jtfs[0][0].setBackground(Color.red);
		jtfs[0][1].setBackground(Color.green);
		jtfs[0][2].setBackground(Color.blue);
		jtfs[1][0].setBackground(Color.red);
		jtfs[1][1].setBackground(Color.green);
		jtfs[1][2].setBackground(Color.blue);
		jbnuse1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int R1 = Integer.valueOf(jtfs[0][0].getText());
				int G1 = Integer.valueOf(jtfs[0][1].getText());
				int B1 = Integer.valueOf(jtfs[0][2].getText());
				if(R1>255){
					jtfs[0][0].setText("255");
				}else if(G1>255){
					jtfs[0][1].setText("255");
				}else if(B1>255){
					jtfs[0][2].setText("255");
				}
				Color Color1 = new Color(R1, G1, B1);
				jlbshow.setOpaque(true);
				jlbshow.setBackground(Color1);
			}
		});
		jbnuse2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int R2 = Integer.valueOf(jtfs[1][0].getText());
				int G2 = Integer.valueOf(jtfs[1][1].getText());
				int B2 = Integer.valueOf(jtfs[1][2].getText());
				if(R2>255){
					jtfs[1][0].setText("255");
				}else if(G2>255){
					jtfs[1][1].setText("255");
				}else if(B2>255){
					jtfs[1][2].setText("255");
				}
				Color Color2 = new Color(R2, G2, B2);
				jlbshow.setForeground(Color2);
			}
		});
		jbnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
