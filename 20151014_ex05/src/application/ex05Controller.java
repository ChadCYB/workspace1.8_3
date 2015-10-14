package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ex05Controller {

    @FXML
    private MenuItem m01,m02,m03,m04;

    @FXML
    private Label txt1,txt2;

    @FXML
    private ComboBox<String> combo1,combo2,combo3;

    @FXML
    private TextArea jta1;

    private String family,style,weight,size;
    private File file;

	private void cssUpdate() {
		jta1.setStyle(" -fx-font-family: " + family + ";"
					+ " -fx-font-style: " + style + ";"
					+ " -fx-font-weight: " + weight + ";"
					+ " -fx-font-size: " + size + ";");
//		jta1.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
	}

    @FXML
    void com1(ActionEvent event) {
    	switch(combo1.getValue()){
			case "新細明體":
				family = "PMingLiU";
				break;
			case "標楷體":
				family = "DFKai-sb";
				break;
			case "微軟黑正體":
				family = "Microsoft JhengHei";
				break;
			default:
				family = combo1.getValue();
				break;
		}
		cssUpdate();
    }

    @FXML
    void com2(ActionEvent event) {
    	switch(combo2.getValue()){
			case "一般":
				style = "normal";
				weight = "normal";
				break;
			case "粗體":
				style = "normal";
				weight = "bold";
				break;
			case "斜體":
				style = "italic";
				weight = "normal";
				break;
			case "粗斜體":
				style = "italic";
				weight = "bold";
				break;
			}
			cssUpdate();
    }

    @FXML
    void com3(ActionEvent event) {
    	size = combo3.getValue();
		cssUpdate();
    }
    @FXML
    void m1(ActionEvent event) {
    	try{
    		FileChooser chooser = new FileChooser();
    		chooser.setTitle("Open File");
    		
    		int bufSize = 0;
    		file = chooser.showOpenDialog(new Stage());
//    		System.out.println(file.getAbsolutePath());
    		FileInputStream fileStream = new FileInputStream(file.getAbsolutePath());
    		txt1.setText("路徑:"+file.getAbsolutePath());
    		byte buf[] = new byte[fileStream.available()];
    		
    		fileStream.read(buf);
    		jta1.setText(new String(buf));
    		fileStream.close();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }

    @FXML
    void m2(ActionEvent event) {
    	try{
    		FileChooser fileChooser = new FileChooser();
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            
            File file = fileChooser.showSaveDialog(new Stage());	//Show save file dialog
            txt1.setText("路徑:"+file.getAbsolutePath());
            if(file != null){
                SaveFile(jta1.getText(), file);
            }
            
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = null;
             
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
    }
    @FXML
    void m3(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void m4(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText(null);
    	alert.setContentText("About!");

    	alert.showAndWait();
    }
    
    @FXML
    void txtChange(KeyEvent event) {
//    	System.out.println("change");
    	txt2.setText("字數:"+jta1.getText().length());
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
		family = "PMingLiU";
		style = "normal";
		weight = "normal";
		size = "18";
		txt2.setText("字數:"+jta1.getText().length());
		txt1.setText("路徑:");
		cssUpdate();
	}
}
