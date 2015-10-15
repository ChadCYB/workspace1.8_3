package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;

public class hw05Controller {

    @FXML
    private MenuItem m01,m02,m03,m04,m05;

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
    void m1(ActionEvent event) {		//OPEN檔案
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
    void m2(ActionEvent event) {		//SAVE檔案
    	try{
    		FileChooser fileChooser = new FileChooser();
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);
            
            File file = fileChooser.showSaveDialog(new Stage());	//Show save file dialog
            if(file != null){
            	txt1.setText("路徑:"+file.getAbsolutePath());
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
    void m3(ActionEvent event) {		//離開
    	System.exit(0);
    }

    @FXML
    void m4(ActionEvent event) {		//HELP
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText(null);
    	alert.setContentText("About!");

    	alert.showAndWait();
    }
    @FXML
    void m5(ActionEvent event) {		//SET
    	// Create the custom dialog.
    	Dialog<Pair<Color, Color>> dialog = new Dialog<>();
    	dialog.setTitle("Color Set Dialog");
    	dialog.setHeaderText("請設定顏色:");
    	// Set the button types.
    	ButtonType okButtonType = new ButtonType("OK", ButtonData.OK_DONE);
    	dialog.getDialogPane().getButtonTypes().addAll(okButtonType, ButtonType.CANCEL);
    	// Create the Labels and Color Picker.
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(20, 150, 10, 10));
    	
    	ColorPicker colorPicker1 = new ColorPicker(Color.BLACK);
    	ColorPicker colorPicker2 = new ColorPicker(Color.WHITE);
    	
    	grid.add(new Label("字體色:"), 0, 0);
    	grid.add(colorPicker1, 1, 0);
    	grid.add(new Label("背景色:"), 0, 1);
    	grid.add(colorPicker2, 1, 1);
    	
    	dialog.getDialogPane().setContent(grid);
    	// Convert the result to a color-color-pair when the ok button is clicked.
    	dialog.setResultConverter(dialogButton -> {
    	    if (dialogButton == okButtonType) {
    	        return new Pair<>(colorPicker1.getValue(), colorPicker2.getValue());
    	    }
    	    return null;
    	});
    	
    	Optional<Pair<Color, Color>> result = dialog.showAndWait();
    	//取得Dialog的Color
    	result.ifPresent(colorVal -> {
    	    System.out.println("c1=" + colorVal.getKey() + ", c2=" + colorVal.getValue());
    	    setColor(colorVal.getKey(),colorVal.getValue());
    	});
    }
    
	private void setColor(Color c1, Color c2) {
		jta1.setStyle(" -fx-font-family: " + family + ";"
					+ " -fx-font-style: " + style + ";"
					+ " -fx-font-weight: " + weight + ";"
					+ " -fx-font-size: " + size + ";"
					+ " -fx-text-fill: " + toRgbString(c1) + ";"
					+ " -fx-control-inner-background: " + toRgbString(c2) + ";");
	}
	private String toRgbString(Color c) {
		return "rgb(" + to255Int(c.getRed()) 
				+ "," + to255Int(c.getGreen())
				+ "," + to255Int(c.getBlue()) + ")";
	}
	private int to255Int(double d) {
		return (int) (d * 255);
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
