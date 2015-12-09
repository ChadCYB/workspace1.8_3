import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ServerFrame extends JFrame{
	
	private Server sev;
	private String strMove="10";
	
	private JPanel contentPane = new JPanel();
	private JPanel panel=new JPanel(new GridLayout(1,2,3,3));
	private JPanel jplTop=new JPanel(new GridLayout(1,6,3,3));
	private JPanel jplLeft=new JPanel();
	private JPanel jplRight=new JPanel();
	private JLabel jlbClient = new JLabel("Client");
	private JLabel jlbServer = new JLabel("Server");
	private JButton jbtnLeft=new JButton("Left");
	private JButton jbtnRight=new JButton("Right");
	private JButton jbtnUp=new JButton("Up");
	private JButton jbtnDown=new JButton("Down");
	private JButton jbtnConn=new JButton("Start Sev");
	private JButton jbtnExit=new JButton("Exit");
	private JTextArea jtArea = new JTextArea();
	private JScrollPane scrollpane=new JScrollPane(jtArea);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					ServerFrame sframe=new ServerFrame();
					sframe.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public ServerFrame(){
		initComp();
	}
	public void initComp(){
		this.setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(660,100,600,500);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(scrollpane,BorderLayout.SOUTH);
		contentPane.add(jplTop,BorderLayout.NORTH);
		
		jtArea.setRows(10);
		jplLeft.setLayout(null);
		jplRight.setLayout(null);
		jplLeft.setBackground(Color.LIGHT_GRAY);
		jplRight.setBackground(Color.cyan);
		panel.add(jplLeft);
		panel.add(jplRight);
		
		jlbClient.setBounds(5,5,120,30);
		jlbServer.setBounds(5,5,120,30);
		jplLeft.add(jlbClient);
		jplRight.add(jlbServer);
		jplTop.add(jbtnLeft);
		jplTop.add(jbtnRight);
		jplTop.add(jbtnUp);
		jplTop.add(jbtnDown);
		jplTop.add(jbtnConn);
		jplTop.add(jbtnExit);
		
		jbtnUp.addActionListener(new ActionListener(){			//上移
			public void actionPerformed(ActionEvent e){
				jlbServer.setLocation(jlbServer.getX(),jlbServer.getY()-Integer.parseInt(strMove));
				try{
					sev.writeData("0 -"+strMove);
				}catch(Exception ex){
					jtArea.append("Exception:"+ex.toString()+"\n");
				}
			}
		});
		
		jbtnDown.addActionListener(new ActionListener(){		//下移
			public void actionPerformed(ActionEvent e){
				jlbServer.setLocation(jlbServer.getX(),jlbServer.getY()+Integer.parseInt(strMove));
				try{
					sev.writeData("0 "+strMove);
				}catch(Exception ex){
					jtArea.append("Exception:"+ex.toString()+"\n");
				}
			}
		});
		
		
		jbtnLeft.addActionListener(new ActionListener(){		//左移
			public void actionPerformed(ActionEvent e){
				jlbServer.setLocation(jlbServer.getX()-Integer.parseInt(strMove),jlbServer.getY());
				try{
					sev.writeData("-"+strMove+" 0");
				}catch(Exception ex){
					jtArea.append("Exception:"+ex.toString()+"\n");
				}
			}
		});
		
		jbtnRight.addActionListener(new ActionListener(){		//右移
			public void actionPerformed(ActionEvent e){
				jlbServer.setLocation(jlbServer.getX()+Integer.parseInt(strMove),jlbServer.getY());
				try{
					sev.writeData(strMove+" 0");
				}catch(Exception ex){
					jtArea.append("Exception:"+ex.toString()+"\n");
				}
			}
		});
		
		jbtnConn.addActionListener(new ActionListener(){		//接收連線
			public void actionPerformed(ActionEvent e){
				lunchServerThread();
			}
		});
		
		jbtnExit.addActionListener(new ActionListener(){		//結束程式
			public void actionPerformed(ActionEvent e){
				dispose();
				if(sev !=null){
					sev.closeSocket();
				}
				System.exit(0);
			}
		});
		
	}
	public void lunchServerThread(){
		sev=new Server(this);
		sev.start();
	}
	public void addMessage(String str){
		jtArea.append(str+"\n");
	}
	public void updateClientJLB(int x,int y){
		jlbClient.setLocation(jlbClient.getX()+x,jlbClient.getY()+y);
//		System.out.println(x+"\t"+y);
	}
}