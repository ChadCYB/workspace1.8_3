import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ex14_Frame extends JFrame{
	private Container cp;
	private JPanel tooljpn = new JPanel(new GridLayout(1,3,5,5));
	private ImagePanel jpn = new ImagePanel();
	private JButton btn_Add = new JButton("Add Boat");
	private JButton btn_Bg = new JButton("Change Background");
	private JButton btn_Exit = new JButton("Exit");
	private ArrayList<Boat> boatArr = new ArrayList<Boat>();
	private ArrayList<Thread> threadArr = new ArrayList<Thread>();
	private int Width,Height;
	private Point hotSpot = new Point(0,0);
	private Boat selectedBoat;
	private boolean isSelectedBoat = false;
	private Image mouseCursor = new ImageIcon("images/target.png").getImage();
	private static String name = "MyCursor";
	
	public ex14_Frame(){
		initComp();
	}
	private void initComp(){
		setVisible(true);
		this.setResizable(false);
		this.setTitle("103021076 航海圖");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Height = jpn.getHeight()+70;
		Width = jpn.getWidth()+20;
		System.out.println(Height+","+Width);
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
			boatArr.add(new Boat(this,Height,Width));					//新增一條船 加入ArrayList
			jpn.add(boatArr.get(boatArr.size()-1));						//放入Jpanel
			threadArr.add(new Thread(boatArr.get(boatArr.size()-1)));	//加入執行緒
			boatArr.get(boatArr.size()-1).setID(threadArr.size());		//設船隻ID
			threadArr.get(threadArr.size()-1).start();					//執行
			System.out.println("boatThread:"+threadArr.size());
		});
		
		jpn.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isSelectedBoat){
					System.out.println("frm.moveShip");
					selectedBoat.movingShip(e.getX(), e.getY());
					isSelectedBoat = false;
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				jpn.setCursor(getToolkit().createCustomCursor(mouseCursor, hotSpot, name));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				jpn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			
		});
	}
	public void setBoat(Boat boat) {
		System.out.println("setBoat");
		isSelectedBoat = true;
		selectedBoat = boat;
	}
}
