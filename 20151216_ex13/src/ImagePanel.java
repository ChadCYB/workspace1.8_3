import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private BufferedImage image;
	private int imgW, imgH;
	public ImagePanel(){
		try{
			image = ImageIO.read(new File("images/bg_1.jpg"));
			imgW = image.getWidth();
			imgH = image.getHeight();
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
	public int getHeight(){
		return imgH;
	}
	public int getWidth(){
		return imgW;
	}
}
