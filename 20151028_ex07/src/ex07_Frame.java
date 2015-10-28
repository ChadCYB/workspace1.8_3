import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JLabel;

public class ex07_Frame extends JFrame{
	public ex07_Frame(){
		initComp();
	}
	private Container cp;
	private Timer t1;
	private JButton[] jbtHour= new JButton[14];
	private JButton[] jbtMins= new JButton[14];
	private JButton[] jbtSecs= new JButton[14];
	private JButton jbtnStart= new JButton("Strat");
	private JButton jbtnPause= new JButton("Pause");
	private JButton jbtnExit= new JButton("Exit");
	private JLabel jbl1 = new JLabel(":");
	private JLabel jbl2 = new JLabel(":");
	private int sec=0 , min=0 , hour=0, count=0, delay=1000;
	private boolean tt = true;
	
	private void initComp(){
		setVisible(true);
		setBounds(200,200,900,400);
		
		this.setTitle("EX07_103021076");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cp = this.getContentPane();
		cp.setLayout(null);
		
		jbtnStart.setBounds(60,270,200,50);
		jbtnPause.setBounds(340,270,200,50);
		jbtnExit.setBounds(620,270,200,50);
		
		int dotx = 270;
		jbl1.setBounds(dotx+3,30,47,170);
		jbl2.setBounds(dotx+283,30,47,170);
		jbl1.setFont(new Font("Arial", Font.PLAIN, 150));
		jbl2.setFont(new Font("Arial", Font.PLAIN, 150));
//		jbl1.setOpaque(true);
//		jbl1.setBackground(Color.BLACK);
//		jbl2.setOpaque(true);
//		jbl2.setBackground(Color.RED);
		cp.add(jbtnStart);
		cp.add(jbtnPause);
		cp.add(jbtnExit);
		cp.add(jbl1);
		cp.add(jbl2);
		
		for(int i=0;i<14;i++){
			jbtHour[i] = new JButton();
			jbtMins[i] = new JButton();
			jbtSecs[i] = new JButton();
			jbtHour[i].setBackground(Color.yellow);
			jbtMins[i].setBackground(Color.yellow);
			jbtSecs[i].setBackground(Color.yellow);

			cp.add(jbtHour[i]);
			cp.add(jbtMins[i]);
			cp.add(jbtSecs[i]);
		}
		int x1 = 50;
		int y1 = 42;
		jbtHour[0].setBounds(x1+25, y1, 50, 20);
		jbtHour[1].setBounds(x1+77, y1+16, 20, 60);
		jbtHour[2].setBounds(x1+77, y1+90, 20, 60);
		jbtHour[3].setBounds(x1+25, y1+150, 50, 20);
		jbtHour[4].setBounds(x1, y1+90, 20, 60);
		jbtHour[5].setBounds(x1, y1+16, 20, 60);
		jbtHour[6].setBounds(x1+25, y1+72, 50, 20);
		
		jbtHour[7].setBounds(x1+141, y1, 50, 20);
		jbtHour[8].setBounds(x1+193, y1+16, 20, 60);
		jbtHour[9].setBounds(x1+193, y1+90, 20, 60);	
		jbtHour[10].setBounds(x1+141, y1+150, 50, 20);
		jbtHour[11].setBounds(x1+118, y1+90, 20, 60);
		jbtHour[12].setBounds(x1+118, y1+16, 20, 60);
		jbtHour[13].setBounds(x1+141, y1+72, 50, 20);
		
		int x2 = x1+280;
		jbtMins[0].setBounds(x2+25, y1, 50, 20);
		jbtMins[1].setBounds(x2+77, y1+16, 20, 60);
		jbtMins[2].setBounds(x2+77, y1+90, 20, 60);
		jbtMins[3].setBounds(x2+25, y1+150, 50, 20);
		jbtMins[4].setBounds(x2, y1+90, 20, 60);
		jbtMins[5].setBounds(x2, y1+16, 20, 60);
		jbtMins[6].setBounds(x2+25, y1+72, 50, 20);
		
		jbtMins[7].setBounds(x2+141, y1, 50, 20);
		jbtMins[8].setBounds(x2+193, y1+16, 20, 60);
		jbtMins[9].setBounds(x2+193, y1+90, 20, 60);	
		jbtMins[10].setBounds(x2+141, y1+150, 50, 20);
		jbtMins[11].setBounds(x2+118, y1+90, 20, 60);
		jbtMins[12].setBounds(x2+118, y1+16, 20, 60);
		jbtMins[13].setBounds(x2+141, y1+72, 50, 20);
		
		int x3 = x2+280;
		jbtSecs[0].setBounds(x3+25, y1, 50, 20);
		jbtSecs[1].setBounds(x3+77, y1+16, 20, 60);
		jbtSecs[2].setBounds(x3+77, y1+90, 20, 60);
		jbtSecs[3].setBounds(x3+25, y1+150, 50, 20);
		jbtSecs[4].setBounds(x3, y1+90, 20, 60);
		jbtSecs[5].setBounds(x3, y1+16, 20, 60);
		jbtSecs[6].setBounds(x3+25, y1+72, 50, 20);
		
		jbtSecs[7].setBounds(x3+141, y1, 50, 20);
		jbtSecs[8].setBounds(x3+193, y1+16, 20, 60);
		jbtSecs[9].setBounds(x3+193, y1+90, 20, 60);	
		jbtSecs[10].setBounds(x3+141, y1+150, 50, 20);
		jbtSecs[11].setBounds(x3+118, y1+90, 20, 60);
		jbtSecs[12].setBounds(x3+118, y1+16, 20, 60);
		jbtSecs[13].setBounds(x3+141, y1+72, 50, 20);
		
		t1 = new Timer(delay , new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				count++;
				hour = count/60/60;
				min = count/60%60;
				sec = count%60;
				
				showDot();
				showNum(jbtHour,hour);
				showNum(jbtMins,min);
				showNum(jbtSecs,sec);
			}
		});
		jbtnStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				t1.start();
			}
		});
		jbtnPause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				tt = true;
				showDot();
				t1.stop();
			}
		});
		jbtnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});
	}
	public void showDot(){
		jbl1.setVisible(tt);
		jbl2.setVisible(tt);
		tt = !tt;
	}
	public void showNum(JButton[] jbt,int num){
		int[][] data = {{0,1,2,3,4,5},	//0
						{1,2},			//1
						{0,1,3,4,6},	//2
						{0,1,2,3,6},	//3
						{1,2,5,6},		//4
						{0,2,3,5,6},	//5
						{0,2,3,4,5,6},	//6
						{0,1,2,5},		//7
						{0,1,2,3,4,5,6},//8
						{0,1,2,3,5,6}};	//9
		int dec = num%10;		//计
		int ten = num/10;		//计
		clearNum(jbt);
		for(int i:data[dec]){	//计
			jbt[i+7].setVisible(true);
		}
		for(int i:data[ten]){	//计
			jbt[i].setVisible(true);
		}
	}
	public void clearNum(JButton[] jbt){
		for(int i=0 ; i<jbt.length ; i++){
			jbt[i].setVisible(false);;
		}
	}
}