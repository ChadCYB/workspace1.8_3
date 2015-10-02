package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Scene1Controller {

    @FXML
    private Button btn_cal;
    @FXML
    private Button btn_exit;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_height;
    @FXML
    private TextField tf_weight;
    @FXML
    private ToggleGroup group1;
    @FXML
    private RadioButton rad_1;
    @FXML
    private RadioButton rad_2;
    @FXML
    private TextField waistline;
    @FXML
    private TextArea jta1;

    @FXML
    void endScene(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void startCal(ActionEvent event) {
    	try{
    		String name = tf_name.getText();
    		float h = Float.parseFloat(tf_height.getText());
    		float w = Float.parseFloat(tf_weight.getText());
    		float l = Float.parseFloat(waistline.getText());
    		float BMI = (float) (w/Math.pow((h/100),2)); 
    		jta1.appendText("BMI公式:\nBMI = 體重(KG)/身高(M)*2\n");
    		jta1.appendText(name+"，你好\n");
    		jta1.appendText("BMI = "+BMI+"，你屬於"+BMIcheck(BMI)+"喔!\n");
    		if(waistlineCheck(l)){
    			jta1.appendText("你的腰圍超出正常值了，身材走鐘了哦!!!\n");
    		}
    		jta1.appendText("=======================================\n");
    	}catch(Exception ex){
    		ex.printStackTrace();
    		jta1.appendText("資料錯誤\n");
    	}
    	
    }
    boolean waistlineCheck(float l){
    	if(rad_1.isSelected() && (l>=90) || rad_2.isSelected() && (l>=80) ){	//男||女
			return true;
		}else{
			return false;
		}
    }
    String BMIcheck(float bmi){
    	String str="";
    	if(bmi < 18.5){
    		str = "體重過輕";
    	}else if(bmi < 24){
    		str = "正常體位";
    	}else if(bmi < 27){
    		str = "過重";
    	}else if(bmi < 30){
    		str = "輕度肥胖";
    	}else if(bmi < 35){
    		str = "中度肥胖";
    	}else{
    		str = "重度肥胖";
    	}
    	return str;
    }
}
