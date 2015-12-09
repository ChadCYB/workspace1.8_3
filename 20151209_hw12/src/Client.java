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
	public void run(){						//多執行緒
		try{
			sock = new Socket(ip, port);
			inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));	//建立串流接收自Server端資料
			outStream = new PrintStream(sock.getOutputStream());							//建立寫出資料的串流資料至Server端
			while(true){
				String[] data = inStream.readLine().split(" ");
				int valX = Integer.parseInt(data[0]);
				int valY = Integer.parseInt(data[1]);
				if(valX != 0) clnFrame.updateSvrJLB(valX, 0);			//接收後，呼叫函數更新JLable
				if(valY != 0) clnFrame.updateSvrJLB(0, valY);			//接收後，呼叫函數更新JLable
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void closeSocket(){				//段開連線
		try{
			inStream.close();
			sock.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void writeData(String str){		//寫入資料
		try{
			if(outStream != null){
				outStream.println(str);
			}else{
				System.out.println("Error: 尚未連線");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
