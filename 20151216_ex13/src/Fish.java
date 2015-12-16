import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Fish extends JLabel implements Runnable {
	private int frmW, frmH, x, y, r1, r;
	private int fishNum = 418;
	private ImageIcon[][] imgIcon = new ImageIcon[2][fishNum];
	private boolean dirFlag = true;
	private Timer t1;

	
	public Fish(int h, int w) {
		frmH = h;
		frmW = w;
		x = (int)(Math.random()*frmW)-50;
		y = (int)(Math.random()*frmH)-50;
		r = (int)(Math.random()*2);
		if(r == 1) this.dirFlag = false;
		addFish();
		
		r1 = (int)(Math.random()*418);
		System.out.println("fishID:"+r1+"|("+x+","+y+")");
		this.setIcon(imgIcon[r][r1]);
		this.setBounds(x,y,this.getIcon().getIconWidth(), this.getIcon().getIconHeight());
	}
	private void addFish(){	
		String[] left = new String[fishNum];
		String[] right = new String[fishNum];
		String l,r;
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
			left[i-1] = "images/LeftSide/"+l;
			right[i-1] = "images/RightSide/"+r;
//			System.out.println(left[i-1]+":"+right[i-1]);
		}
		for(int i=0 ; i<fishNum ; i++){
			imgIcon[0][i] = new ImageIcon(left[i]);
			imgIcon[1][i] = new ImageIcon(right[i]);
		}
	}
	@Override
	public void run() {
		t1 = new Timer((int)(Math.random()*1000+50), ae -> {
			if(Fish.this.dirFlag){
				if((x-10) >0){
					x -= 10;
				}else{
					Fish.this.dirFlag = !Fish.this.dirFlag;
					r = 1;
					x += 10;
					this.setIcon(imgIcon[r][r1]);
				}
			}else{
				if((x+Fish.this.getIcon().getIconWidth()+20) < frmW){
					x += 10;
				}else{
					Fish.this.dirFlag = !Fish.this.dirFlag;
					r = 0;
					x -= 10;
					this.setIcon(imgIcon[r][r1]);
				}
			}
			Fish.this.setLocation(x, y);
		});
		t1.start();
	}
}
