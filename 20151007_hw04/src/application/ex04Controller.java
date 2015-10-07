package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

public class ex04Controller {

    @FXML
    private TextArea jta1;
    @FXML
    private TextArea jta2;
    @FXML
    private Label txt1;
    @FXML
    private Label txt2;
    @FXML
    private Button btn_EXIT;
    @FXML
    private Button btn_chBLUE;

    @FXML
    void jta1_Pressed(MouseEvent event) {
    	txt1.setStyle(" -fx-background-color: #FFFF00 ;");
    	System.out.println("Pressed");
    }
    @FXML
    void jta1_Entered(MouseEvent event) {
		txt1.setStyle(" -fx-background-color: #FF0000 ;");
		System.out.println("Entered");
    }
    @FXML
    void jta1_Exited(MouseEvent event) {
		txt1.setStyle(" -fx-background-color: #66FF66 ;");
		System.out.println("Exited");
    }
    @FXML
    void jta1_Released(MouseEvent event) {
		txt1.setStyle(" -fx-background-color: #66FF66 ;");
		System.out.println("Released");
    }
    
    
    @FXML
    void jta2_Released(KeyEvent event) {
    	txt2.setText(jta2.getText());
    }
    
    
    @FXML
    void btn2_Click(ActionEvent event) {
    	System.exit(0);
    }
    @FXML
    void btn1_Click(ActionEvent event) {
    	jta1.setStyle(" -fx-control-inner-background: #00FFFF ;");
    }

}
