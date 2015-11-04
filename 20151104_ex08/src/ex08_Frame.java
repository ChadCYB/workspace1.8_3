import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ex08_Frame extends JFrame{
	public ex08_Frame(){
		initComp();
	}
	private Container cp;
	private JPanel jpl1 = new JPanel();
	private JTextArea jtaEnc = new JTextArea();
	private JTextArea jtaDec = new JTextArea();
	private JScrollPane jspEnc = new JScrollPane(jtaEnc);
	private JScrollPane jspDec = new JScrollPane(jtaDec);
	
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm1 = new JMenu("檔案");
	private JMenu jm2 = new JMenu("設定");
	private JMenu jm3 = new JMenu("說明");
	private JMenu subMenu = new JMenu("開檔");
	private JMenuItem jmi_Encrypt = new JMenuItem("開啟明文檔");
	private JMenuItem jmi_Decrypt = new JMenuItem("開啟加密檔");
	private JMenuItem jmi_SaveFile = new JMenuItem("存檔");
	private JMenuItem jmi_Exit = new JMenuItem("結束");
	
	private JLabel jbl1 = new JLabel("目前開啟檔案:");
	private JLabel jbl2 = new JLabel("金鑰", SwingConstants.CENTER);
	private JTextField jtf = new JTextField("0");
	private JButton jbtn_Enc = new JButton("加密");
	private JButton jbtn_Dec = new JButton("解密");
	private JButton jbtn_Clear = new JButton("清除");
	private JButton jbtn_Exit = new JButton("離開");
	private JFileChooser jfc = new JFileChooser();
	private File file;
//	private Icon icon1 = new ImageIcon();
	
	private void initComp(){
		setTitle("EX08_103021076");
		setBounds(200, 200, 600, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setJMenuBar(jmb);
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		subMenu.add(jmi_Encrypt);
		subMenu.add(jmi_Decrypt);
		jm1.add(subMenu);
		jm1.add(jmi_SaveFile);
		jm1.add(jmi_Exit);
		
		cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		jspEnc.setPreferredSize(new Dimension(230,600));
		jspDec.setPreferredSize(new Dimension(230,600));
		cp.add(jpl1, BorderLayout.CENTER);
		cp.add(jspEnc, BorderLayout.EAST);
		cp.add(jspDec, BorderLayout.WEST);
		cp.add(jbl1, BorderLayout.SOUTH);
		
		jpl1.setLayout(new GridLayout(6,1,5,5));
		jpl1.add(jbl2);
		jpl1.add(jtf);
		jpl1.add(jbtn_Enc);
		jpl1.add(jbtn_Dec);
		jpl1.add(jbtn_Clear);
		jpl1.add(jbtn_Exit);
		
		jbtn_Exit.addActionListener(new ActionListener(){	//結束
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		jmi_Exit.addActionListener(new ActionListener(){	//結束
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		jmi_SaveFile.addActionListener(new ActionListener(){//儲存密文檔案
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SaveFile(jtaEnc.getText());
				jbl1.setText("目前開啟檔案:"+file.getPath());
			}
		});
		jmi_Encrypt.addActionListener(new ActionListener(){	//開啟加密檔
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jtaDec.setText(fileRead());					//讀取檔案
				jbl1.setText("目前開啟檔案:"+file.getPath());
			}
		});
		jmi_Decrypt.addActionListener(new ActionListener(){	//開啟解密檔案
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jtaEnc.setText(fileRead());					//讀取檔案
				jbl1.setText("目前開啟檔案:"+file.getPath());
			}
		});
		jbtn_Enc.addActionListener(new ActionListener(){	//加密
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = jtaDec.getText();
				int key = Integer.parseInt(jtf.getText());
				jtaEnc.setText(Caesar(text,key,true));
			}
		});
		jbtn_Dec.addActionListener(new ActionListener(){	//解密
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = jtaEnc.getText();
				int key = Integer.parseInt(jtf.getText());
				jtaDec.setText(Caesar(text,key,false));
			}
		});
		jbtn_Clear.addActionListener(new ActionListener(){	//清除
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jtaDec.setText("");
				jtaEnc.setText("");
			}
		});
		jbtn_Exit.addActionListener(new ActionListener(){	//離開
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	private String Caesar(String str, int key, Boolean func){
		String result = "";
		if(func){	//加密
			for(int i=0 ; i<str.length() ; i++){
				result += (char)(str.charAt(i)+key);
			}
		}else{		//解密
			for(int i=0 ; i<str.length() ; i++){
				result += (char)(str.charAt(i)-key);
			}
		}
		return result;
	}
	private String fileRead(){					//讀取檔案
		String fData = "";
		jfc.showOpenDialog(this);
		file = jfc.getSelectedFile();
		String fName = file.getPath();
		try{
			FileInputStream fis = new FileInputStream(fName);
			file = jfc.getSelectedFile();
			byte data[] = new byte[fis.available()];
			fis.read(data);
			fis.close();
			fData = new String(data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return fData;
	}
    private void SaveFile(String fData){	//存檔
    	System.out.println(fData);
    	jfc.showSaveDialog(this);			//Show save file dialog
    	file = jfc.getSelectedFile();
		String fName = file.getPath();
		try{
			FileOutputStream fos = new FileOutputStream(fName);
			byte data[] = fData.getBytes();
			fos.write(data);
			fos.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
    }
}