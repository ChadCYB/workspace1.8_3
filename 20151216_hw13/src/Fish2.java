import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fish2 extends JPanel implements Runnable{	
	private int fishNum = 418, exploNum = 3;
	private BufferedImage fishLIcon,fishRIcon,exploIcon,pic;
	private int imgW, imgH, frmH, frmW;
	private int x, y, fishID, exploID, threadID=-1;
	private boolean explor = false, lr = false;
	private Timer t1;
	
	public Fish2(int h, int w){
		frmH = h; frmW = w;
		importImgIcon();					//仔入圖庫
		x = (int)(Math.random()*frmW)-50;	//亂數座標
		y = (int)(Math.random()*frmH)-50;
		lr = ((int)(Math.random()*2) == 0);	//亂數左右
		pic = (lr)?fishLIcon:fishRIcon;
		
		imgW = pic.getWidth();
		imgH = pic.getHeight();
		
		repaint();
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("Pressed");
				pic = exploIcon;
				repaint();
				System.out.println("(" + x + "," + y + ")");
			}

			public void mouseReleased(MouseEvent e) {
				System.out.println("Released");
				pic = (lr)?fishLIcon:fishRIcon;
				repaint();
			}
		});
	}
	private void setThreadID(int id){
		threadID = id;
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
			fishLIcon = ImageIO.read(new File("images/LeftSide/"+fishL));
			fishRIcon = ImageIO.read(new File("images/RightSide/"+fishR));
			exploIcon = ImageIO.read(new File("images/explosion/explosion00"+exploID+".png"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(pic, 0, 0, null);
		Fish2.this.setLocation(x,y);
	}
	public int getHeight(){
		return imgH;
	}
	public int getWidth(){
		return imgW;
	}

	@Override
	public void run() {
		t1 = new Timer((int)(Math.random()*1000+50), ae -> {
			if(!explor){
				if(Fish2.this.lr){
					if((x-10) >0){
						x -= 10;
					}else{
						Fish2.this.lr = !Fish2.this.lr;
						x += 10;
						repaint();
					}
				}else{
					if((x+Fish2.this.getWidth()+20) < frmW){
						x += 10;
					}else{
						Fish2.this.lr = !Fish2.this.lr;
						x -= 10;
						repaint();
					}
				}
				System.out.println(x+":"+y);
			}
		});
		t1.start();
	}
}
