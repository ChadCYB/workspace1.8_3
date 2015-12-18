import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Fish extends JLabel implements Runnable{
	private int frmW, frmH, x, y, fishID, exploID, countExp = 0;
	private int fishNum = 418, exploNum = 3;
	private ImageIcon[] imgIcon = new ImageIcon[2];
	private ImageIcon exploIcon,fishIcon;
	private boolean leftRight=true, explo=false;
	private Timer t1;

	public Fish(int h, int w) {
		this.frmH = h;
		this.frmW = w;
		this.x = (int)(Math.random()*frmW)-50;
		this.y = (int)(Math.random()*frmH)-50;
		this.leftRight = ((int)(Math.random()*2) == 0);
		this.importImgIcon();
		
//		this.setBorderPainted(false);
//		this.setContentAreaFilled(false);
		this.setOpaque(false);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		
		System.out.println("fishID:"+fishID+"|("+x+","+y+")");
		this.fishIcon = imgIcon[(leftRight)?0:1];
		this.iconSet();
		this.setBounds(x,y,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				if(!explo){
					System.out.println("Pressed");
					System.out.println("(" + x + "," + y + ")");
					explo = true;
				}
			}
			
		});
	}
	private void importImgIcon(){	
		try{
			fishID = (int)(Math.random()*fishNum)+1;
			exploID = (int)(Math.random()*exploNum)+1;
			
			String fishL, fishR;
			if(fishID < 10){
				fishL = "fishL00"+fishID+".png";
				fishR = "fishR00"+fishID+".png";
			}else if(fishID <100){
				fishL = "fishL0"+fishID+".png";
				fishR = "fishR0"+fishID+".png";
			}else{
				fishL = "fishL"+fishID+".png";
				fishR = "fishR"+fishID+".png";
			}
			imgIcon[0] = new ImageIcon("images/LeftSide/"+fishL);
			imgIcon[1] = new ImageIcon("images/RightSide/"+fishR);
			exploIcon = new ImageIcon("images/explosion/explosion00"+exploID+".png");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	private void iconSet(){
		this.setIcon(fishIcon);
	}
/*
	private void addAllImgIcon(){	
		String[] left = new String[fishNum];
		String[] right = new String[fishNum];
		String l,r,e;
		for(int i=1 ; i<=fishNum ; i++){
			if(i < 10){
				l = "fishL00"+i+".png";
				r = "fishR00"+i+".png";
			}else if(i <100){
				l = "fishL0"+i+".png";
				r = "fishR0"+i+".png";
			}else{
				l = "fishL"+i+".png";
				r = "fishR"+i+".png";
			}
			imgIcon[0][i-1] = new ImageIcon("images/LeftSide/"+l);
			imgIcon[1][i-1] = new ImageIcon("images/RightSide/"+r);
//			System.out.println(left[i-1]+":"+right[i-1]);
		}
		for(int i=1 ; i<=exploNum ; i++){
			e = "explosion00"+i+".png";
			exploIcon[i-1] = new ImageIcon("images/explosion/"+e);
		}
	}*/
	@Override
	public void run() {
		this.t1 = new Timer((int)(Math.random()*1000+50), ae -> {
			if(!explo){
				if(this.leftRight){							//¥ª´å
					if((x-10) >0){
						x -= 10;
					}else{
						this.leftRight = !this.leftRight;
						fishIcon = imgIcon[1];
						x += 10;
						iconSet();
					}
				}else{										//¥k´å
					if((x+this.getIcon().getIconWidth()+20) < frmW){
						x += 10;
					}else{
						this.leftRight = !this.leftRight;
						fishIcon = imgIcon[0];
						x -= 10;
						iconSet();
					}
				}
			}else {
				fishIcon = exploIcon;
				iconSet();
				countExp++;
				if(countExp==2){
					this.setVisible(false);
					t1.stop();
				}
			}
			this.setLocation(x, y);
			System.out.println(x+":"+y);
		});
		t1.start();
	}
}
