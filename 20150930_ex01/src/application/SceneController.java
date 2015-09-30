package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class SceneController {

    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check4;
    @FXML
    private CheckBox check5;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private TextField txt4;
    @FXML
    private TextField txt5;

    @FXML
    private RadioButton radio1;
    @FXML
    private ToggleGroup rg1;
    @FXML
    private RadioButton radio2;
    @FXML
    private RadioButton radio3;
    @FXML
    private RadioButton radio4;
    @FXML
    private RadioButton radio5;

    @FXML
    private Button btnOK;
    @FXML
    private TextArea fta;
    boolean numJugle(String str){
    	return (str.matches("[0-9]+"));    		
    }
    @FXML
    void btnSubmmit(ActionEvent event) {
    	String str = "�z���I�\���e�p�U:\n";
    	if(check1.isSelected() && numJugle(txt1.getText())){
    		str += "������ "+Integer.parseInt(txt1.getText())+" ��\n";
    	}
    	if(check2.isSelected() && numJugle(txt2.getText())){
    		str += "���K�� "+Integer.parseInt(txt2.getText())+" ��\n";
    	}
    	if(check3.isSelected() && numJugle(txt3.getText())){
    		str += "�^��׵��� "+Integer.parseInt(txt3.getText())+" ��\n";
    	}
    	if(check4.isSelected() && numJugle(txt4.getText())){
    		str += "�̥��� "+Integer.parseInt(txt4.getText())+" ��\n";
    	}
    	if(check5.isSelected() && numJugle(txt5.getText())){
    		str += "�i���� "+Integer.parseInt(txt5.getText())+" ��\n";
    	}

    	if(radio1.isSelected()){
    		str += "���׬�: "+radio1.getText();
    	}else if(radio2.isSelected()){
    		str += "���׬�: "+radio2.getText();
    	}else if(radio3.isSelected()){
    		str += "���׬�: "+radio3.getText();
    	}else if(radio4.isSelected()){
    		str += "���׬�: "+radio4.getText();
    	}else if(radio5.isSelected()){
    		str += "���׬�: "+radio5.getText();
    	}
    	fta.setText(str);
    }
    @FXML
    void act1(ActionEvent event) {
    	if(check1.isSelected()){
    		txt1.setDisable(false);
    	}else{
    		txt1.setDisable(true);
    		txt1.setText("");
    	}
    }

    @FXML
    void act2(ActionEvent event) {
    	if(check2.isSelected()){
    		txt2.setDisable(false);
    	}else{
    		txt2.setDisable(true);
    		txt2.setText("");
    	}
    }

    @FXML
    void act3(ActionEvent event) {
    	if(check3.isSelected()){
    		txt3.setDisable(false);
    	}else{
    		txt3.setDisable(true);
    		txt3.setText("");
    	}
    }

    @FXML
    void act4(ActionEvent event) {
    	if(check4.isSelected()){
    		txt4.setDisable(false);
    	}else{
    		txt4.setDisable(true);
    		txt4.setText("");
    	}
    }

    @FXML
    void act5(ActionEvent event) {
    	if(check5.isSelected()){
    		txt5.setDisable(false);
    	}else{
    		txt5.setDisable(true);
    		txt5.setText("");
    	}
    }


}
