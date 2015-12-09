import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

import javax.swing.*;

public class ex12_Client extends JFrame {
	private Client clientSkt;	// Client�����
    
    private JButton jbtnEnter=new JButton("�ǰe");
	private JButton jbtnCls=new JButton("�M���T����");
	private JButton jbtnStart=new JButton("�إ߳s�u");
	private JButton jbtnStop=new JButton("���_�s�u");
	private JLabel jlb2=new JLabel("IP:");
	private JLabel jlb3=new JLabel("Port:");
	private JTextField jtfOut=new JTextField();
	private JTextField jtfIP=new JTextField("127.0.0.1");
	private JTextField jtfPort=new JTextField("8888");
	private JTextArea jtaIn=new JTextArea("Message In\n");
	private static JTextArea jtaLog=new JTextArea("Log\n");
	private JScrollPane jsp1=new JScrollPane(jtaIn);
	private JScrollPane jsp2=new JScrollPane(jtaLog);
	private Container cp;
	
    public ex12_Client() {
		setTitle("Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(650,100,600,400);
		cp = this.getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(128, 170, 255));
		jbtnEnter.setEnabled(false);
		jbtnStop.setEnabled(false);
		jtaIn.setEditable(false);
		
		cp.add(jbtnEnter);
		cp.add(jbtnCls);
		cp.add(jbtnStart);
		cp.add(jbtnStop);
		cp.add(jlb2);
		cp.add(jlb3);
		cp.add(jtfOut);
		cp.add(jtfIP);
		cp.add(jtfPort);
		cp.add(jsp1);
		cp.add(jsp2);
		jbtnStart.setBounds(475, 15, 95, 40);
		jbtnStop.setBounds(475, 65, 95, 40);
		jbtnEnter.setBounds(228, 295, 60, 65);		
		jbtnCls.setBounds(125, 330, 100, 30);
		jlb2.setBounds(305, 20, 60, 30);
		jlb3.setBounds(305, 65, 60, 30);
		jtfOut.setBounds(10, 295, 215, 30);
		jtfIP.setBounds(335, 20, 135, 30);
		jtfPort.setBounds(335, 65, 135, 30);
		jsp1.setBounds(10, 10, 280, 280);
		jsp2.setBounds(300, 120, 280, 235);
    	
        jbtnStart.addActionListener(new ActionListener() {		//�إ߳s�u
            public void actionPerformed(ActionEvent e) {
            	jbtnEnter.setEnabled(true); jbtnStop.setEnabled(true);
            	jtaIn.setText(""); jtaLog.setText("");
            	int port = Integer.parseInt(jtfPort.getText());
				startClient(port,jtfIP.getText());
            }
        });
		jbtnCls.addActionListener(new ActionListener(){			//�M���T����
			public void actionPerformed(ActionEvent ae){
				jtaIn.setText("");
			}
		});
		jbtnStop.addActionListener(new ActionListener(){		//�_�u
			public void actionPerformed(ActionEvent ae){
				setGUI(true);
                try {
                	Client.skt.close();
				} catch (IOException e) {
					jtaLog.append("Error: "+e+"\n");
				}
                jtaLog.append("Disconnect!\n");
			}	//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		});
        addWindowListener(  // ���U�����s�ɵ���
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        jbtnEnter.addActionListener(new ActionListener(){		//�ǰe
    		public void actionPerformed(ActionEvent ae){
                jtaIn.append("local: " + jtfOut.getText() + "\n");
                String EncStr= jtfOut.getText();
                clientSkt.dataOutput(EncStr);                
                jtfOut.setText("");jtaLog.append("Message Sent \n");
    		}
    	});
    }
	
	public void setGUI(boolean state) {
    	jtfIP.setEnabled(state);
        jtfPort.setEnabled(state);
        jbtnStart.setEnabled(state);
		jbtnStop.setEnabled(!state);
		jbtnEnter.setEnabled(!state);
    }
    public void update() {    		// ���o�T��
        String inMessage,Str;
		inMessage = clientSkt.getMessage();
		Str=(inMessage!=null) ? inMessage:"";
		jtaIn.append("remote:"+Str+"\n");		//<<<<<<<<<<<<<<<<
    }

    private void startClient(int port,String IP){	// �Ȥ��
        clientSkt = new Client(IP, port);
        clientSkt.setMessage(this);
        setGUI(false);
        clientSkt.start();
    }
    
    public static class Client extends Thread {
        private static Socket skt;			// �Ȥ�ݳs�uSocket����
        private InetAddress host;			// ���w�����A��IP
        private int port;					// ���w�����A�ݳs����
        private BufferedReader theInputStream;
        private PrintStream theOutputStream;
        private String message;				// ���A�ݶǦ^�����
        private ex12_Client chatBox;		// ��ѵ{������
     
        public Client(String ip, int port) {
            try {
                host = InetAddress.getByName(ip);
                this.port = port;
            }catch (IOException e) {
                jtaLog.append("Error: "+e+"\n");
            }
        }
        public void setMessage(ex12_Client ex12_Client) {// ���wSocket���T���[���
            chatBox = ex12_Client;
        }
        public String getMessage() { // ���o�T��
            return message;
        }
        public void run() {
            try {
            	jtaLog.append("Try to connect...\n");
            	skt = new Socket(host, port);
            	jtaLog.append("Connect Success!\n");	
                theInputStream = new BufferedReader(new InputStreamReader(skt.getInputStream()));
                theOutputStream = new PrintStream(skt.getOutputStream());
                while((message = theInputStream.readLine()) != null) { // Ū����ưj��
                    chatBox.update();
                }
                if(message == null){
                    skt.close();
                    jtaLog.append("Disconnect!\n");
                    chatBox.setGUI(true);
                }
            }catch (IOException e){
            	jtaLog.append("Error: "+e+"\n");
            }
        }
        public void dataOutput(String data){
        	theOutputStream.println(data);
        }
    }
}