import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.MouseInputAdapter;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class hw09_Frame extends JFrame implements ActionListener{
	public hw09_Frame(){
		initComp();
	}
	private Graphics g;
	private Container cp;
	private JPanel jplTool = new JPanel();
	private JPanel jplFunc = new JPanel();
	private JPanel jplPaint = new JPanel();
	private JPanel jplColor = new JPanel();
	private JPanel jplCChoser = new JPanel();
	private JPanel jplNet = new JPanel();
	private JPanel jplDraw = new JPanel();
	private JButton jbtnPoint = new JButton("��~");
	private JButton jbtnLine = new JButton("���u");
	private JButton jbtnReg1 = new JButton("�x��");
	private JButton jbtnReg2 = new JButton("�ꨤ�x");
	private JButton jbtnCir1 = new JButton("���");
	private JButton jbtnCir2 = new JButton("���");
	private JButton jbtnColor = new JButton("���");
	private JButton jbtnNet = new JButton("���l");
	private JButton jbtnFont = new JButton("�r��");
	private JButton jbtnExit = new JButton("Exit");
	private JButton jbtnClear = new JButton("�M��");
	private ButtonGroup radioGroup = new ButtonGroup();
	private JRadioButton jRadio1 = new JRadioButton("���U");
	private JRadioButton jRadio2 = new JRadioButton("�k�U");
	private JRadioButton jRadio3 = new JRadioButton("���W");
	private JRadioButton jRadio4 = new JRadioButton("�k�W");
	private ButtonGroup radioGroupDraw = new ButtonGroup();
	private JRadioButton jRadioDraw1 = new JRadioButton("���w�y��");
	private JRadioButton jRadioDraw2 = new JRadioButton("�ƹ�ø��");
	
	private int x1,y1,x2,y2,paintType=-1;
	private Color color = Color.BLACK;
	private String theText = "";
	private JButton btn, tempBtn;
	
	private void initComp(){
		setTitle("HW09_103021076");
		int Width = 900, Height=600;
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int)((screenSize.getWidth()-Width)*0.5), (int)((screenSize.getHeight()-Height)*0.5), Width, Height);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(jplPaint, BorderLayout.CENTER);
		cp.add(jplTool, BorderLayout.WEST);
		cp.add(jplFunc, BorderLayout.SOUTH);
		jplPaint.setBackground(Color.WHITE);
		jplTool.setBackground(Color.GRAY);
		jplFunc.setBackground(Color.GRAY);
		jplDraw.setBackground(Color.GRAY);
		
		jplCChoser.setLayout(new GridLayout(2,1,0,0));	//ColorChoser
		jplCChoser.add(jplColor);
		jplCChoser.add(jbtnColor);
		
		jplNet.setLayout(new GridLayout(4,1,0,0));		//NetStyleChoser
		jplNet.add(jRadio1);
		jplNet.add(jRadio2);
		jplNet.add(jRadio3);
		jplNet.add(jRadio4);
		jRadio1.setSelected(true);
		radioGroup.add(jRadio1);
		radioGroup.add(jRadio2);
		radioGroup.add(jRadio3);
		radioGroup.add(jRadio4);
		
		jplDraw.setLayout(new GridLayout(2,1,0,0));		//�y��ø�Ͽﶵ
		jplDraw.add(jRadioDraw1);
		jplDraw.add(jRadioDraw2);
		jRadioDraw2.setSelected(true);
		radioGroupDraw.add(jRadioDraw1);
		radioGroupDraw.add(jRadioDraw2);
		
		jplFunc.setLayout(new GridLayout(1,2,2,2));		//SOUTH
		jplFunc.add(jbtnClear);
		jplFunc.add(jbtnExit);
		
		jplTool.setLayout(new GridLayout(6,2,5,5));		//ToolBar
		jplTool.add(jbtnPoint);
		jplTool.add(jbtnLine);
		jplTool.add(jbtnReg1);
		jplTool.add(jbtnReg2);
		jplTool.add(jbtnNet);
		jplTool.add(jplNet);
		jplTool.add(jbtnCir1);
		jplTool.add(jbtnCir2);
		jplTool.add(jplCChoser);
		jplTool.add(jplDraw);
		jplTool.add(jbtnFont);
		jplColor.setBackground(color);
		
		jbtnPoint.addActionListener(this);		//���u
		jbtnLine.addActionListener(this);		//���u
		jbtnReg1.addActionListener(this);		//�x��
		jbtnReg2.addActionListener(this);		//�ꨤ�x
		jbtnCir1.addActionListener(this);		//���
		jbtnCir2.addActionListener(this);		//���
		jbtnNet.addActionListener(this);		//���l
		jbtnColor.addActionListener(this);		//���
		jbtnFont.addActionListener(this);		//�r��
		jbtnClear.addActionListener(this);
		jbtnExit.addActionListener(this);
		
		PaintListener paintListener = new PaintListener();
		jplPaint.addMouseMotionListener(paintListener);
		jplPaint.addMouseListener(paintListener);
	}
	private void paintShap(){
		try{
			g = jplPaint.getGraphics();
			g.setColor(color);
			int w = jplPaint.getWidth();
			int h = jplPaint.getHeight();
			
			if (jRadioDraw1.isSelected() && paintType != 5 && paintType != -2) {
				String res1 = JOptionPane.showInputDialog(null,
						"�п�J�_�l�y��: x,y \n �d��(X:0~" + w + " , Y:0~" + h + ")",
						"�y�п�J", JOptionPane.QUESTION_MESSAGE);
				String res2 = JOptionPane.showInputDialog(null,
						"�п�J���I�y��: x,y \n �d��(X:0~" + w + " , Y:0~" + h + ")",
						"�y�п�J", JOptionPane.QUESTION_MESSAGE);
				String[] arr1 = res1.split(",");
				String[] arr2 = res2.split(",");
				x1 = Integer.parseInt(arr1[0]);
				y1 = Integer.parseInt(arr1[1]);
				x2 = Integer.parseInt(arr2[0]);
				y2 = Integer.parseInt(arr2[1]);
//				System.out.println(x1+","+y1+" : "+x2+","+y2);
			}else if(jRadioDraw1.isSelected() && paintType == -2){
				String res1 = JOptionPane.showInputDialog(null,
						"�п�J�y��: x,y \n �d��(X:0~" + w + " , Y:0~" + h + ")",
						"�y�п�J", JOptionPane.QUESTION_MESSAGE);
				String[] arr1 = res1.split(",");
				x1 = Integer.parseInt(arr1[0]);
				y1 = Integer.parseInt(arr1[1]);
			}
			
			int xMax = Math.max(x1, x2);
			int xMin = Math.min(x1, x2);
			int yMax = Math.max(y1, y2);
			int yMin = Math.min(y1, y2);
			int width = xMax-xMin;
			int height = yMax-yMin;
			
			switch(paintType){	
				case -2:	//�r��
					g.drawString(theText, x1, y1);
					break;
				case 0:		//���u
					g.drawLine(x1, y1, x2, y2);
					break;
				case 1:		//�x��
					g.drawRect(xMin, yMin, width, height);
					break;
				case 2:		//�x��
					g.drawRoundRect(xMin, yMin, width, height, 30, 30);
					break;
				case 3:		//���
					g.drawOval(xMin, yMin, Math.max(width, height), Math.max(width, height));
					break;
				case 4:		//���
					g.drawOval(xMin, yMin, width, height);
					break;
				case 5:		//���l
					int minL = Math.min(w, h);
//					System.out.println(w+"|"+h);
					for(int i=0 ; i<=minL ; i+=20){
						if(jRadio1.isSelected()){		//���U
							g.drawLine(0, i, i, h);
						}else if(jRadio2.isSelected()){	//�k�U
							g.drawLine(w, i, w-i, h);
						}else if(jRadio3.isSelected()){	//���W
							g.drawLine(0, i, h-i, 0);
						}else if(jRadio4.isSelected()){	//�k�W
							g.drawLine(w-i, 0, w, h-i);
						}
					}
					break;
			}
		}catch(Exception ex){
//			ex.printStackTrace();
		}
	}
	private void setButtonEffect(){
		if(jRadioDraw1.isSelected() && paintType != 5 && paintType != -1) paintShap();
		jbtnPoint.setForeground(Color.BLACK);
		jbtnLine.setForeground(Color.BLACK);
		jbtnReg1.setForeground(Color.BLACK);
		jbtnReg2.setForeground(Color.BLACK);
		jbtnCir1.setForeground(Color.BLACK);;
		jbtnCir2.setForeground(Color.BLACK);
		jbtnNet.setForeground(Color.BLACK);
		jbtnFont.setForeground(Color.BLACK);
		btn.setForeground(color);
		tempBtn = btn;
	}
	
	private class PaintListener extends MouseInputAdapter {		//�e���ηƹ��ƥ�Listener
		public void mouseDragged(MouseEvent e) {				//�즲
			if(paintType == -1){
				g = jplPaint.getGraphics();
				g.setColor(color);
				g.fillOval(e.getX(), e.getY(), 3, 3);
			}else if(paintType == -2 && jRadioDraw2.isSelected()){
				g = jplPaint.getGraphics();
				g.setColor(color);
				g.drawString(theText, e.getX(), e.getY());
			}
//			System.out.println(e.getX()+","+e.getY());
        }
		public void mousePressed(MouseEvent e) {				//�I��
			x1 = e.getX();
			y1 = e.getY();
		}
		public void mouseReleased(MouseEvent e) {				//��}
			x2 = e.getX();
			y2 = e.getY();
			if(jRadioDraw2.isSelected()) paintShap();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		btn = (JButton)e.getSource();
		switch(btn.getText()){
		case "��~":
			paintType = -1;
			setButtonEffect();
			break;
		case "���u":
			paintType = 0;
			setButtonEffect();
			break;
		case "�x��":
			paintType = 1;
			setButtonEffect();
			break;
		case "�ꨤ�x":
			paintType = 2;
			setButtonEffect();
			break;
		case "���":
			paintType = 3;
			setButtonEffect();
			break;
		case "���":
			paintType = 4;
			setButtonEffect();
			break;
		case "���":
			Color c = JColorChooser.showDialog(null, "Choose a Color", color);
			if (c != null) {
				color = c;
				jplColor.setBackground(c);
				jbtnColor.setForeground(c);
				if(tempBtn != null) tempBtn.setForeground(c);
			}
			break;
		case "���l":
			paintType = 5;
			setButtonEffect();
			paintShap();
			break;
		case "�r��":
			paintType = -2;
			theText = JOptionPane.showInputDialog(null, "�п�J�r��:", "�r���J", JOptionPane.QUESTION_MESSAGE);
			setButtonEffect();
			break;
		case "�M��":
			repaint();
			break;
		case "Exit":
			System.exit(0);
			break;
		}
	}
}
