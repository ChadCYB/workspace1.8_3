import java.io.*;
import java.net.*;

public class Server extends Thread{
	private ServerSocket svsSock;
	private Socket sock;
	private ServerFrame svrFrm;
	private PrintStream outStream;
	private BufferedReader inStream;
	private final int port = 22555;
	
	public Server(ServerFrame sFrame){
		svrFrm = sFrame;
		try{
			svsSock = new ServerSocket(port);
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public void run(){
		try{
			svrFrm.addMessage("Listening...");
			sock = svsSock.accept();
			svrFrm.addMessage(sock.getInetAddress()+" connected!");
			inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			outStream = new PrintStream(sock.getOutputStream());
			while(true){
				String[] data = inStream.readLine().split(" ");
				int valX = Integer.parseInt(data[0]);
				int valY = Integer.parseInt(data[1]);
				if(valX != 0) svrFrm.updateClientJLB(valX, 0);
				if(valY != 0) svrFrm.updateClientJLB(0, valY);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void closeSocket(){
		try{
			outStream.close();
			sock.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void writeData(String str){
		try{
			if(outStream != null){
				outStream.println(str);
			}else{
				System.out.println("Error: ©|¥¼³s½u");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
