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
    	String str = "您的點餐內容如下:\n";
    	if(check1.isSelected() && numJugle(txt1.getText())){
    		str += "牛肉麵 "+Integer.parseInt(txt1.getText())+" 份\n";
    	}
    	if(check2.isSelected() && numJugle(txt2.getText())){
    		str += "陽春麵 "+Integer.parseInt(txt2.getText())+" 份\n";
    	}
    	if(check3.isSelected() && numJugle(txt3.getText())){
    		str += "榨菜肉絲麵 "+Integer.parseInt(txt3.getText())+" 份\n";
    	}
    	if(check4.isSelected() && numJugle(txt4.getText())){
    		str += "傻瓜麵 "+Integer.parseInt(txt4.getText())+" 份\n";
    	}
    	if(check5.isSelected() && numJugle(txt5.getText())){
    		str += "養生麵 "+Integer.parseInt(txt5.getText())+" 份\n";
    	}

    	if(radio1.isSelected()){
    		str += "辣度為: "+radio1.getText();
    	}else if(radio2.isSelected()){
    		str += "辣度為: "+radio2.getText();
    	}else if(radio3.isSelected()){
    		str += "辣度為: "+radio3.getText();
    	}else if(radio4.isSelected()){
    		str += "辣度為: "+radio4.getText();
    	}else if(radio5.isSelected()){
    		str += "辣度為: "+radio5.getText();
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
