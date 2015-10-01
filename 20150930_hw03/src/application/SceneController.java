package application;

import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SceneController {

    @FXML
    private TextArea jta1;

    @FXML
    private Button btnEnd;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private ComboBox<String> combo1;

    @FXML
    private ComboBox<String> combo2;

    @FXML
    private ComboBox<String> combo3;

    @FXML
    private ComboBox<String> combo4;

    @FXML
    private ComboBox<String> combo5;

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn10;

    @FXML
    private Button btn11;
    
    void initialize() {
    	assert combo1 != null : "fx:id=\"combo1\" was not injected: check your FXML file 'MainScence1.fxml'.";
        // Initialize your logic here: all @FXML variables will have been injected
        combo1.getItems().clear();
        combo1.getItems().addAll("0","Mick Jagger","David Bowie");   

    }

}
