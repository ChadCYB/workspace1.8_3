import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ex13_Frame extends JFrame{
	private Container cp;
	private JPanel tooljpn = new JPanel(new GridLayout(1,2,5,5));
	private ImagePanel jpn = new ImagePanel();
	private JButton btn_Add = new JButton("Add Fish");
	private JButton btn_Exit = new JButton("Exit");
	private ArrayList<Fish> fishArr = new ArrayList<Fish>();
	private ArrayList<Thread> threadArr = new ArrayList<Thread>();
	private int h,w;
	public ex13_Frame(){
		initComp();
	}
	private void initComp(){
		setVisible(true);
		this.setResizable(false);
		this.setTitle("103021076 水族箱");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		h = jpn.getHeight();
		w = jpn.getWidth();
		this.setBounds(100,100,w,h+50);
		
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(tooljpn, BorderLayout.NORTH);
		cp.add(jpn, BorderLayout.CENTER);
		
		tooljpn.add(btn_Add);
		tooljpn.add(btn_Exit);
		
		btn_Exit.addActionListener(ae -> {
			System.exit(0);
		});
		btn_Add.addActionListener(ae -> {
			Fish fTemp = new Fish(h,w);			//新增一條魚
			fishArr.add(fTemp);					//加入ArrayList
			jpn.add(fTemp);						//放入Jpanel
			threadArr.add(new Thread(fTemp));	//加入執行緒
			threadArr.get(threadArr.size()-1).start();	//執行
			System.out.println("fishThread:"+threadArr.size());
		});
	}
}
