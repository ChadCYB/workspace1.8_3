import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

import javax.swing.*;

public class ex12_Server extends JFrame {
    private Server serverSkt;	// Server�����
    private boolean isServer; 	// �O�_��Server
    
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
	
    public ex12_Server() {
		setTitle("Server");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(20,100,600,400);
		cp = this.getContentPane();
		cp.setLayout(null);
		cp.setBackground(new Color(255, 191, 128));
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
    	jtfIP.setEditable(false);
    	
        jbtnStart.addActionListener(new ActionListener() {		//�إ߳s�u
            public void actionPerformed(ActionEvent e) {
            	jbtnEnter.setEnabled(true); jbtnStop.setEnabled(true);
            	jtaIn.setText(""); jtaLog.setText("");
            	int port = Integer.parseInt(jtfPort.getText());
            	startServer(port);
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
                	Server.skt.close();
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
                String EncStr = jtfOut.getText();
                serverSkt.dataOutput(EncStr);	// �N��Ƴz�L�s�u������e�X
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
	
    public void update() {    // ���o�T��
        String inMessage,Str;
		inMessage = serverSkt.getMessage();
		Str=(inMessage!=null) ? inMessage:"";
		jtaIn.append("remote:"+Str+"\n");		//<<<<<<<<<<<<<<<<
    }

    private void startServer(int port) {			// ���A��
        serverSkt = new Server(port);
        serverSkt.setMessage(this);
        serverSkt.start();		
        isServer = true;
        jtfIP.setText("Server");
        setGUI(false);
    }
    
    public static class Server extends Thread { 
        private static ServerSocket skt;	// ServerSocket
        private Socket client;      		// �������Ȥ��Socket
        private BufferedReader theInputStream;
        private PrintStream theOutputStream;
        private String message;                 
        private ex12_Server chatBox; 
     
        public Server(int port) {
            try {
                skt = new ServerSocket(port);
            }catch (IOException e) {
            	jtaLog.append("Error: "+e+"\n");
            }
        }
        public void setMessage(ex12_Server ex12_Server){
        	chatBox = ex12_Server;
        }
        public String getMessage(){
        	return message;
        }
        public void run(){
            try{
            	jtaLog.append("Try to connect...\n");
                client = skt.accept();
                jtaLog.append("Client "+client.getInetAddress()+"/ Connected.\n");

                theInputStream = new BufferedReader(new InputStreamReader(client.getInputStream())); // �إ�Ū���w�İ�   
                theOutputStream = new PrintStream(client.getOutputStream());// �إ߸�ƥ�X����
        
                while((message = theInputStream.readLine()) != null){		// �j��Ū�����
                    chatBox.update();
                }
                if(message == null){
                    skt.close();
                    jtaLog.append("Disconnect!\n");
                    chatBox.setGUI(true);
                }
            }catch (IOException e){
            	jtaLog.append("Error: "+e+"\n");
                chatBox.setGUI(true);
            }
        }
        public void dataOutput(String data){
        	theOutputStream.println(data);
        }
    }
}