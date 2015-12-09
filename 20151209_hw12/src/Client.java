import java.io.*;
import java.net.*;


public class Client extends Thread{
	private Socket sock;
	private PrintStream outStream;
	private BufferedReader inStream;
	private ClientFrame clnFrame;
	private final String ip = "127.0.0.1";
	private final int port = 22555;
	
	public Client(ClientFrame mFrame){
		this.setDaemon(true);
		clnFrame = mFrame;
	}
	public void run(){						//�h�����
		try{
			sock = new Socket(ip, port);
			inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));	//�إߦ�y������Server�ݸ��
			outStream = new PrintStream(sock.getOutputStream());							//�إ߼g�X��ƪ���y��Ʀ�Server��
			while(true){
				String[] data = inStream.readLine().split(" ");
				int valX = Integer.parseInt(data[0]);
				int valY = Integer.parseInt(data[1]);
				if(valX != 0) clnFrame.updateSvrJLB(valX, 0);			//������A�I�s��Ƨ�sJLable
				if(valY != 0) clnFrame.updateSvrJLB(0, valY);			//������A�I�s��Ƨ�sJLable
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void closeSocket(){				//�q�}�s�u
		try{
			inStream.close();
			sock.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void writeData(String str){		//�g�J���
		try{
			if(outStream != null){
				outStream.println(str);
			}else{
				System.out.println("Error: �|���s�u");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
