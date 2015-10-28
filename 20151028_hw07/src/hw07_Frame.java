import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class hw07_Frame extends JFrame{
	public hw07_Frame(){
		initComp();
	}
	
	private Container cp;
	private JPanel jplTop = new JPanel();
	private JPanel jplNum = new JPanel();
	private JPanel jplBtn = new JPanel();
	private JLabel jlb1 = new JLabel(":",SwingConstants.CENTER);
	private JLabel jlb2 = new JLabel(":",SwingConstants.CENTER);
	private JButton jbtnGo = new JButton("Go");
	private JButton jbtnContinue = new JButton("Pause");
	private JButton jbtnRecord = new JButton("Record");
	private JButton jbtnStop = new JButton("Stop");
	private JButton jbtnExit = new JButton("Exit");
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private JLabel[] iConHour = new JLabel[2];
	private JLabel[] iConMin = new JLabel[2];
	private JLabel[] iConSec = new JLabel[2];
	
	private Timer t1;
	private boolean tt = true, pauseStatus = false, go = true , cont = false , stop=false , rec = false;
	private int sec = 0, min = 0, hour = 0, count = 0, delay = 1000, recCount = 0;
	
	private static String[] imageList = {
		"img/0.jpg", "img/1.jpg", "img/2.jpg", "img/3.jpg", "img/4.jpg",
		"img/5.jpg", "img/6.jpg", "img/7.jpg", "img/8.jpg", "img/9.jpg"
	};
	
	private void initComp(){
		this.setTitle("HW07_103021076");
		this.setBounds(200,200,900,500);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(jplTop, BorderLayout.NORTH);
		cp.add(jsp, BorderLayout.CENTER);
		
		jplTop.setLayout(new GridLayout(2,1,5,5));
		jplTop.add(jplNum);
		jplTop.add(jplBtn);
		
		jplNum.setLayout(new GridLayout(1,8,0,0));		//顯示器Panel
		jplNum.setBackground(Color.BLACK);
		jlb1.setFont(new Font("Arial", Font.BOLD, 80));
		jlb2.setFont(new Font("Arial", Font.BOLD, 80));
		numJplAdd();

		jplBtn.setLayout(new GridLayout(1,5,5,5));		//按鈕Panel
		jplBtn.add(jbtnGo);
		jplBtn.add(jbtnContinue);
		jplBtn.add(jbtnRecord);
		jplBtn.add(jbtnStop);
		jplBtn.add(jbtnExit);
		
		btnSet();
		
		jbtnGo.addActionListener(new ActionListener(){			//開始
			public void actionPerformed(ActionEvent arg0) {
				t1.start();
				go = !go;
				cont = !cont;
				stop = !stop;
				rec = !rec;
				btnSet();
			}
		});
		jbtnContinue.addActionListener(new ActionListener(){	//暫停
			public void actionPerformed(ActionEvent arg0) {
				pauseStatus = !pauseStatus;
				if(pauseStatus){
					jbtnContinue.setText("Continue");
					t1.stop();
				}else{
					jbtnContinue.setText("Pause");
					t1.start();
				}
			}
		});
		jbtnRecord.addActionListener(new ActionListener(){		//紀錄
			public void actionPerformed(ActionEvent arg0) {
				jta.append((++recCount) + "-th record: " + hour + " : " + min  + " : " + sec + "\n");
			}
		});
		jbtnStop.addActionListener(new ActionListener(){		//停止
			public void actionPerformed(ActionEvent arg0) {
				t1.stop();
				count=0;
				go = !go;
				cont = !cont;
				stop = !stop;
				rec = !rec;
				tt = true;
				btnSet();
			}
		});
		jbtnExit.addActionListener(new ActionListener(){		//結束程式
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		t1 = new Timer(delay, new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				count++;
				hour = count/60/60;
				min = count/60%60;
				sec = count%60;
//				System.out.println(hour+":"+min+":"+sec);
				
				iconSet(iConHour,hour);
				iconSet(iConMin,min);
				iconSet(iConSec,sec);
				showDot();
			}
		});
		
	}
	private void iconSet(JLabel[] jlb, int num){
		int digit = num%10;
		int ten = num/10%10;
		//org ImageIcon 170*213
		jlb[1].setIcon(new ImageIcon(new ImageIcon(imageList[digit]).getImage().getScaledInstance(85, 106, 0)));
		jlb[0].setIcon(new ImageIcon(new ImageIcon(imageList[ten]).getImage().getScaledInstance(85, 106, 0)));
	}
	private void numJplAdd() {
		for(int i=0 ; i<2 ; i++){
			iConHour[i] = new JLabel("",SwingConstants.CENTER);
			iConMin[i] = new JLabel("",SwingConstants.CENTER);
			iConSec[i] = new JLabel("",SwingConstants.CENTER);
		}
		iconSet(iConHour,88);
		iconSet(iConMin,88);
		iconSet(iConSec,88);
		
		jplNum.add(iConHour[0]);
		jplNum.add(iConHour[1]);
		jplNum.add(jlb1);
		jplNum.add(iConMin[0]);
		jplNum.add(iConMin[1]);
		jplNum.add(jlb2);
		jplNum.add(iConSec[0]);
		jplNum.add(iConSec[1]);
	}
	private void showDot(){
		if(tt){
			jlb1.setForeground(Color.green);
			jlb2.setForeground(Color.green);
		}else{
			jlb1.setForeground(Color.gray);
			jlb2.setForeground(Color.gray);
		}
		tt = !tt;
	}
	private void btnSet(){
		tt = true;
		showDot();
		jbtnGo.setEnabled(go);
		jbtnContinue.setEnabled(cont);
		jbtnRecord.setEnabled(rec);
		jbtnStop.setEnabled(stop);
	}
}
