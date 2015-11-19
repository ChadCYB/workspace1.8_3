import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ex09_Frame extends JFrame{
	public ex09_Frame(){
		initComp();
	}
	private Container cp;
	private JPanel jplTool = new JPanel();
	private JPanel jplPaint = new JPanel();
	private JPanel jplColor = new JPanel();
	private Color color = Color.BLACK;
	private JButton jbtnLine = new JButton("直線");
	private JButton jbtnReg1 = new JButton("矩形");
	private JButton jbtnReg2 = new JButton("圓角矩");
	private JButton jbtnCir1 = new JButton("圓形");
	private JButton jbtnCir2 = new JButton("橢圓");
	private JButton jbtnColor = new JButton("選色");
	private JButton jbtnNet = new JButton("網子");
	private JButton jbtnExit = new JButton("Exit");
	int x1,y1,x2,y2,paintType=-1;
	
	private void initComp(){
		setTitle("EX09_103021076");
		setBounds(200, 200, 900, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(jplTool, BorderLayout.WEST);
		cp.add(jplPaint, BorderLayout.CENTER);
		cp.add(jbtnExit, BorderLayout.SOUTH);
		jplTool.setLayout(new GridLayout(9,1,5,5));
		jplTool.add(jbtnLine);
		jplTool.add(jbtnReg1);
		jplTool.add(jbtnReg2);
		jplTool.add(jbtnCir1);
		jplTool.add(jbtnCir2);
		jplTool.add(jbtnNet);
		jplTool.add(jplColor);
		jplTool.add(jbtnColor);
		jplColor.setBackground(color);
		jplPaint.setBackground(Color.WHITE);
		
		
		jbtnLine.addActionListener(new ActionListener(){		//直線
			@Override
			public void actionPerformed(ActionEvent arg0) {
				paintType = 0;
			}
		});	
		jbtnReg1.addActionListener(new ActionListener(){		//矩形
			@Override
			public void actionPerformed(ActionEvent arg0) {
				paintType = 1;
			}
		});
		jbtnReg2.addActionListener(new ActionListener(){		//圓角矩
			@Override
			public void actionPerformed(ActionEvent arg0) {
				paintType = 2;
			}
		});
		jbtnCir1.addActionListener(new ActionListener(){		//圓形
			@Override
			public void actionPerformed(ActionEvent arg0) {
				paintType = 3;
			}
		});
		jbtnCir2.addActionListener(new ActionListener(){		//橢圓
			@Override
			public void actionPerformed(ActionEvent arg0) {
				paintType = 4;
			}
		});
		jbtnNet.addActionListener(new ActionListener(){			//網子
			@Override
			public void actionPerformed(ActionEvent arg0) {
				paintType = 5;
				paintShap();
			}
		});
		
		jbtnColor.addActionListener(new ActionListener(){		//選色
			@Override
				public void actionPerformed(ActionEvent arg0) {
					Color c = JColorChooser.showDialog(null, "Choose a Color", color);
					if (c != null) {
						color = c;
						jplColor.setBackground(c);
//						repaint();
					}
				}
			});
		jbtnExit.addActionListener(new ActionListener(){
			@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		jplPaint.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				x1 = e.getX();
				y1 = e.getY();
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				x2 = e.getX();
				y2 = e.getY();
				paintShap();
			}});
	}
	private void paintShap(){
		Graphics g = jplPaint.getGraphics();
		g.setColor(color);
		
		int xMax = Math.max(x1, x2);
		int xMin = Math.min(x1, x2);
		int yMax = Math.max(y1, y2);
		int yMin = Math.min(y1, y2);
		int width = xMax-xMin;
		int height = yMax-yMin;
		
		switch(paintType){	
			case 0:		//直線
				g.drawLine(x1, y1, x2, y2);
				break;
			case 1:		//矩形
				g.drawRect(xMin, yMin, width, height);
				break;
			case 2:		//矩形
				g.drawRoundRect(xMin, yMin, width, height, 30, 30);
				break;
			case 3:		//圓形
				g.drawOval(xMin, yMin, Math.max(width, height), Math.max(width, height));
				break;
			case 4:		//橢圓
				g.drawOval(xMin, yMin, width, height);
				break;
			case 5:		//網子
				int w = jplPaint.getWidth();
				int h = jplPaint.getHeight();
				int minL = Math.min(w, h);
//				System.out.println(w+"|"+h);
				for(int i=0 ; i<=minL ; i+=20){
//					System.out.println(0+","+(h-i)+"|"+h+","+i);
					g.drawLine(0, i, i, h);
				}
				break;
		}
	}
}
