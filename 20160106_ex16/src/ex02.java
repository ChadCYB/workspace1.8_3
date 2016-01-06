import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ex02 extends JFrame{
	private JButton jbtnFirst = new JButton("第一張");
	private JButton jbtnPre = new JButton("前一張");
	private JButton jbtnFor = new JButton("下一張");
	private JButton jbtnLast = new JButton("最後一張");
	private ImagePanel imgP = new ImagePanel();
	private JPanel jpl = new JPanel();
	private JButton jbtnExit = new JButton("Exit");
	private Container cp;
	private int Width = 600, Height = 500, imgNum = 0;
	
	public ex02(){
		initComp();
	}
	private void initComp(){
		this.setTitle("103021076_EX02");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int)((screenSize.getWidth()-Width)*0.5), (int)((screenSize.getHeight()-Height)*0.5), Width, Height);
		
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(jpl, BorderLayout.NORTH);
		cp.add(imgP, BorderLayout.CENTER);
		cp.add(jbtnExit, BorderLayout.SOUTH);
		jpl.setLayout(new GridLayout(1,4,5,5));
		jpl.add(jbtnFirst);
		jpl.add(jbtnPre);
		jpl.add(jbtnFor);
		jpl.add(jbtnLast);
		jduge();
		jbtnFirst.addActionListener(ae -> {
			imgNum = 0;
			jduge();
		});
		jbtnPre.addActionListener(ae -> {
			imgNum--;
			jduge();
		});
		jbtnFor.addActionListener(ae -> {
			imgNum++;
			jduge();
		});
		jbtnLast.addActionListener(ae -> {
			imgNum = 3;
			jduge();
		});
		jbtnExit.addActionListener(ae -> {
			System.exit(0);
		});
	}
	private void jduge(){
//		System.out.println(imgNum);
		imgP.changeBG(imgNum);
		if(imgNum == 0){
			jbtnFirst.setEnabled(false);
			jbtnPre.setEnabled(false);
			jbtnFor.setEnabled(true);
			jbtnLast.setEnabled(true);
		}else if(imgNum == 3){
			jbtnFirst.setEnabled(true);
			jbtnPre.setEnabled(true);
			jbtnFor.setEnabled(false);
			jbtnLast.setEnabled(false);
		}else{
			jbtnFirst.setEnabled(true);
			jbtnPre.setEnabled(true);
			jbtnFor.setEnabled(true);
			jbtnLast.setEnabled(true);
		}
	}
}
class ImagePanel extends JPanel{
	private BufferedImage pic;
	private BufferedImage[] image = new BufferedImage[4]; 
	private int imgNum = 0;
	public ImagePanel(){
		try{
			image[0] = ImageIO.read(new File("imgs/img01.jpg"));
			image[1] = ImageIO.read(new File("imgs/img02.jpg"));
			image[2] = ImageIO.read(new File("imgs/img03.jpg"));
			image[3] = ImageIO.read(new File("imgs/img04.jpg"));
			
			pic = image[0];
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(pic, 0, 0, null);
	}
	public void changeBG(int num) {
		pic = image[num];
	    repaint();
	}
}

