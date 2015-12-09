import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ClientFrame extends JFrame {

	private Client client_1;
	private String strMove="10";
	
	private JPanel contentPane = new JPanel();
	private JPanel jplLeft = new JPanel();
	private JPanel jplRight = new JPanel();
	private JPanel jplTop = new JPanel();
	private JPanel panel = new JPanel(new GridLayout(1,2,3,3));
	private JLabel jlbLocal = new JLabel("本地");;
	private JLabel jlbServer = new JLabel("伺服器");
	private JButton jbtnUp =new JButton("up");
	private JButton jbtnDown=new JButton("Down");
	private JButton jbtnLeft = new JButton("<--");
	private JButton jbtnRight = new JButton("-->");
	private JButton jbtnConn = new JButton("Conn");
	private JButton jbtnExit = new JButton("Exit");
	private JTextArea jtArea=new JTextArea();
	private JScrollPane jSPane=new JScrollPane(jtArea);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					ClientFrame cframe=new ClientFrame();
					cframe.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public ClientFrame(){
		initComp();
	}
	
	private void initComp(){
		this.setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,100,600,500);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0,0));
		
		jtArea.setRows(10);
		jtArea.setBackground(Color.cyan);
		panel.setBackground(Color.green);
		jplTop.setBackground(Color.pink);
		jplTop.setLayout(new GridLayout(1,6,3,3));
		
		contentPane.add(jSPane,BorderLayout.SOUTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(jplTop,BorderLayout.NORTH);
		
		jlbLocal.setBounds(5,5,120,25);
		jlbServer.setBounds(5,5,120,25);
		jlbLocal.setBackground(Color.cyan);
		jlbServer.setBackground(Color.LIGHT_GRAY);
		jplLeft.setLayout(null);
		jplRight.setLayout(null);
		jplLeft.add(jlbLocal);
		jplRight.add(jlbServer);
		panel.add(jplLeft);
		panel.add(jplRight);		
		
		jplTop.add(jbtnUp);
		jplTop.add(jbtnDown);
		jplTop.add(jbtnLeft);
		jplTop.add(jbtnRight);
		jplTop.add(jbtnConn);
		jplTop.add(jbtnExit);
		
		jbtnUp.addActionListener(new ActionListener(){			//上移
			public void actionPerformed(ActionEvent e){
				jlbLocal.setLocation(jlbLocal.getX(),jlbLocal.getY()-Integer.parseInt(strMove));
				try{
					client_1.writeData("0 -"+strMove);
				}catch(Exception ex){
					jtArea.append("Exception:"+ex.toString()+"\n");
				}
			}
		});
		
		jbtnDown.addActionListener(new ActionListener(){		//下移
			public void actionPerformed(ActionEvent e){
				jlbLocal.setLocation(jlbLocal.getX(),jlbLocal.getY()+Integer.parseInt(strMove));
				try{
					client_1.writeData("0 "+strMove);
				}catch(Exception ex){
					jtArea.append("Exception:"+ex.toString()+"\n");
				}
			}
		});
		
		
		jbtnLeft.addActionListener(new ActionListener(){		//左移
			public void actionPerformed(ActionEvent e){
				jlbLocal.setLocation(jlbLocal.getX()-Integer.parseInt(strMove),jlbLocal.getY());
				try{
					client_1.writeData("-"+strMove+" 0");
				}catch(Exception ex){
					jtArea.append("Exception:"+ex.toString()+"\n");
				}
			}
		});
		
		jbtnRight.addActionListener(new ActionListener(){		//右移
			public void actionPerformed(ActionEvent e){
				jlbLocal.setLocation(jlbLocal.getX()+Integer.parseInt(strMove),jlbLocal.getY());
				try{
					client_1.writeData(strMove+" 0");
				}catch(Exception ex){
					jtArea.append("Exception:"+ex.toString()+"\n");
				}
			}
		});
		
		jbtnConn.addActionListener(new ActionListener(){		//連線
			public void actionPerformed(ActionEvent e){
				lunchClientThread();
			}
		});
		
		jbtnExit.addActionListener(new ActionListener(){		//結束程式
			public void actionPerformed(ActionEvent e){
				dispose();
				if(client_1 !=null){
					client_1.closeSocket();						//關閉連線
				}
				System.exit(0);
			}
		});
		
	}
	public void lunchClientThread(){							//Thread開視窗
		client_1 = new Client(this);
		client_1.start();
	}
	public void updateJLB_LX(int x) {
		jlbServer.setLocation(jlbServer.getX()+x , jlbServer.getY());
	}
	public void updateSvrJLB(int x, int y) {
		jlbServer.setLocation(jlbServer.getX()+x , jlbServer.getY()+y);
	}
}