import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Boat extends JLabel implements Runnable{
	private int frmW, frmH, x, y, boatID, threadID;
	private int boatNum = 5;
	private ImageIcon boatIcon;
	private Timer t1;
	boolean leftRight = true;
	private ex14_Frame frm;

	public Boat(ex14_Frame frame ,int h, int w) {
		this.frmH = h;
		this.frmW = w;
		this.frm = frame;
		//556,1020 || 486,1000
		//
		do{
			this.x = (int)(Math.random()*frmW);
			this.y = (int)(Math.random()*frmH);
		}while(x<80 || x>frmH-200 || y<80 || y>frmW-200);
		
		this.importImgIcon();
		this.leftRight = false;
		
//		this.setBorderPainted(false);
//		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		
		System.out.println("boatID:"+boatID+"|("+x+","+y+")");

		this.iconSet();
		this.setBounds(x,y,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				System.out.println(threadID+"-Clicked");
				frm.setBoat(Boat.this);
			}
		});
	}
	private void importImgIcon(){	
		try{
			boatID = (int)(Math.random()*boatNum)+1;
			boatIcon = new ImageIcon("images/boats/boat0"+boatID+".png");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void setID(int id){
		threadID = id;
	}
	private void iconSet(){
		this.setIcon(boatIcon);
	}

	@Override
	public void run() {
		this.repaint();
	}
	public void movingShip(int x1, int y1) {
		this.t1 = new Timer((int)(Math.random()*10+10), ae -> {
			double m = (double)(y1 - y)/ (double)(x1 - x);
			System.out.println(threadID+"\t"+(int)(m*100)+"("+x+","+y+")");
			int x2 = 0 , y2 = 0;
			if(x1 > x){
				x2 = x+10;
				if(x2 > x1){
					x2 = x1;
				}
			}else{
				x2 = x-10;
				if(x2 < x1){
					x2 = x1;
				}
			}
			y2 = y+(int)((x2-x)*m);
			Boat.this.setLocation(x2,y2);
			System.out.println(threadID+"\t"+x2+","+y2);
			x = x2;
			y = y2;
			if(x2 == x1){
				t1.stop();
			}
		});
		t1.start();
	}
	
}
