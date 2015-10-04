package application;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SceneController {
	ObservableList<String> msl = FXCollections.observableArrayList("AA","BB","CC");
    @FXML
    private TextArea jta1;

    @FXML
    private Button btnEnd;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private ComboBox combo1;

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
    	combo1.setValue("AA");
    	combo1.setItems(msl);
    }
    @FXML
    void endScene(ActionEvent event) {
    	System.exit(0);
    }


}
