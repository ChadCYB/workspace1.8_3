import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private BufferedImage pic, image1, image2;
	private int imgW, imgH;
	private boolean tt = true;
	public ImagePanel(){
		try{
			image1 = ImageIO.read(new File("images/background/bg_1.jpg"));
			image2 = ImageIO.read(new File("images/background/bg_2.jpg"));
			
			pic = image1;
			imgW = image1.getWidth();
			imgH = image1.getHeight();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(pic, 0, 0, null);
	}
	public int getHeight(){
		return imgH;
	}
	public int getWidth(){
		return imgW;
	}

	public void changeBG() {
		tt = !tt;
		if(tt){
			pic = image1;
		}else{
			pic = image2;
		}
	    repaint();
	}
}
