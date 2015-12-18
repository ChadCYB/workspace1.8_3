import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class hw13_Frame extends JFrame{
	private Container cp;
	private JPanel tooljpn = new JPanel(new GridLayout(1,3,5,5));
	private ImagePanel jpn = new ImagePanel();
	private JButton btn_Add = new JButton("Add Fish");
	private JButton btn_Bg = new JButton("Change Background");
	private JButton btn_Exit = new JButton("Exit");
	private static ArrayList<Fish> fishArr = new ArrayList<Fish>();
	private static ArrayList<Fish2> fish2Arr = new ArrayList<Fish2>();
	private ArrayList<Thread> threadArr = new ArrayList<Thread>();
	private int Width,Height;
	public hw13_Frame(){
		initComp();
	}
	private void initComp(){
		setVisible(true);
		this.setResizable(false);
		this.setTitle("103021076 水族箱");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Height = jpn.getHeight();
		Width = jpn.getWidth();
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int)((screenSize.getWidth()-Width)*0.5), (int)((screenSize.getHeight()-Height)*0.5), Width, Height);
		
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(tooljpn, BorderLayout.NORTH);
		cp.add(jpn, BorderLayout.CENTER);
		
		tooljpn.add(btn_Add);
		tooljpn.add(btn_Bg);
		tooljpn.add(btn_Exit);
		
		btn_Exit.addActionListener(ae -> {		//離開
			System.exit(0);
		});
		btn_Bg.addActionListener(ae ->{			//背景切換
			jpn.changeBG();
		});
		btn_Add.addActionListener(ae -> {
			fishArr.add(new Fish(Height,Width));						//新增一條魚 加入ArrayList
			jpn.add(fishArr.get(fishArr.size()-1));						//放入Jpanel
			threadArr.add(new Thread(fishArr.get(fishArr.size()-1)));	//加入執行緒
			threadArr.get(threadArr.size()-1).start();					//執行
			System.out.println("fishThread:"+threadArr.size());
		});
	}
}
