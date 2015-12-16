import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Fish extends JLabel implements Runnable {
	private int frmW, frmH, x, y, r1, r, rnd;
	private int fishNum = 418, exploNum = 3;
	private ImageIcon[][] imgIcon = new ImageIcon[2][fishNum];
	private ImageIcon[] exploIcon = new ImageIcon[exploNum];
	private ImageIcon fishIcon;
	private boolean dirFlag = true, explor = false;
	private Timer t1;

	
	public Fish(int h, int w) {
		frmH = h;
		frmW = w;
		x = (int)(Math.random()*frmW)-50;
		y = (int)(Math.random()*frmH)-50;
		r = (int)(Math.random()*2);
		if(r == 1) this.dirFlag = false;
		addImgIcon();
		
		r1 = (int)(Math.random()*fishNum);
		rnd = (int)(Math.random()*exploNum);
		System.out.println("fishID:"+r1+"|("+x+","+y+")");
		fishIcon = imgIcon[r][r1];
		this.setIcon(fishIcon);
		this.setBounds(x,y,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
		         System.out.println("Pressed");
				fishIcon = exploIcon[rnd];
				setIcon(fishIcon);
				Fish.this.setLocation(x, y);
				explor = true;
		    }
			public void mouseReleased(MouseEvent e) {
		         System.out.println("Released");
				fishIcon = imgIcon[r][r1];
				setIcon(fishIcon);
				explor = false;
		    }
		});
	}

	private void addImgIcon(){	
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
	}
	@Override
	public void run() {
		t1 = new Timer((int)(Math.random()*1000+50), ae -> {
			if(!explor){
				if(Fish.this.dirFlag){
					if((x-10) >0){
						x -= 10;
					}else{
						Fish.this.dirFlag = !Fish.this.dirFlag;
						r = 1;
						x += 10;
						this.setIcon(fishIcon);
					}
				}else{
					if((x+Fish.this.getIcon().getIconWidth()+20) < frmW){
						x += 10;
					}else{
						Fish.this.dirFlag = !Fish.this.dirFlag;
						r = 0;
						x -= 10;
						this.setIcon(fishIcon);
					}
				}
				Fish.this.setLocation(x, y);
				System.out.println(x+":"+y);
			}
		});
		t1.start();
	}
}
