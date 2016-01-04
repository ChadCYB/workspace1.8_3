import org.opencv.core.Mat;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.Videoio;
import org.opencv.imgproc.Imgproc;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ex15 extends JFrame {
	private BufferedImage image;
	private JButton jbtnBrows = new JButton("Brows");
	private JFileChooser jfc = new JFileChooser();
	private ImagePanel jpn = new ImagePanel();
	private Container cp;
	int width, height;
	double alpha = 2, beta = 50;
	String fileName = "";
	
	public ex15(){
		initComp();
	}
	private void initComp() {
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(jbtnBrows, BorderLayout.SOUTH);
		jbtnBrows.addActionListener(ae ->{	
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			jfc.setFileFilter(filter);
			jfc.setCurrentDirectory(new File( "D:\\Programed\\Eclipse\\workspace1.8_3\\20151230_ex15" ));
			int flag = jfc.showOpenDialog(ex15.this);
			if (flag == JFileChooser.APPROVE_OPTION) {
				fileName = jfc.getSelectedFile().getAbsolutePath();
				jpn.setImage(fileName);
				jpn.repaint();
				imgProcess(fileName);
			}
		});
		cp.add(jpn, BorderLayout.CENTER);
	}
	private void imgProcess(String fName) {
		try {
			File input = new File(fName);
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					Color c = new Color(image.getRGB(j, i));
					int red = (int) (c.getRed() * 0.299);
					int green = (int) (c.getGreen() * 0.587);
					int blue = (int) (c.getBlue() * 0.114);
					Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
					image.setRGB(j, i, newColor.getRGB());
				}
			}
			File ouptut = new File("img01_grayscale.jpg");
			ImageIO.write(image, "jpg", ouptut);
			
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			Mat source = Imgcodecs.imread(fileName , Imgcodecs.CV_LOAD_IMAGE_COLOR);
			Mat destination = new Mat(source.rows(), source.cols(), source.type());
			source.convertTo(destination, -1, alpha, beta);
			Imgcodecs.imwrite("BrightWithAlpha2Beta50.jpg", destination);
			
			Mat source1 = Imgcodecs.imread("img01_grayscale.jpg", Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
			Mat destination1 = new Mat(source.rows(), source.cols(), source.type());
			Imgproc.equalizeHist(source1, destination1);
			Imgcodecs.imwrite("img01_contrast.jpg", destination1);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}