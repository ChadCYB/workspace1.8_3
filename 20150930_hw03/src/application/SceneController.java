package application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
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
    	combo1.getItems().removeAll(combo1.getItems());
        combo1.getItems().addAll("AAA", "BBB", "CCC");
        combo1.getSelectionModel().select("AAA");
    }
    @FXML
    void endScene(ActionEvent event) {
    	System.exit(0);
    }


}
