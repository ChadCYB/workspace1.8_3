package application;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

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
	private ColorPicker colorPick1;

	@FXML
	private ColorPicker colorPick2;

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

	@FXML
	void endScene(ActionEvent event) {
		System.exit(0);
	}
	
	private String family,style,weight,size;
	private Color c1,c2;

	private void cssUpdate() {
		jta1.setStyle(" -fx-font-family: " + family + ";"
					+ " -fx-font-style: " + style + ";"
					+ " -fx-font-weight: " + weight + ";"
					+ " -fx-font-size: " + size + ";"
					+ " -fx-text-fill: " + toRgbString(c1) + ";"
					+ " -fx-control-inner-background: " + toRgbString(c2) + ";");
//		jta1.setFont(Font.font("Verdana", FontPosture.ITALIC, 20));
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
/*		<font-style> The font's style, using the following syntax:
		[ normal | italic | oblique ]

		<font-weight> The font's weight, using the following syntax:
		[ normal | bold | bolder | lighter | 100 ~ 900 ]
*/		
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
	void com4(ActionEvent event) {
		c1 = colorPick1.getValue();
		cssUpdate();		
	}

	@FXML
	void com5(ActionEvent event) {
		c2 = colorPick2.getValue();
		cssUpdate();
	}

	@FXML
	void btnClick0(ActionEvent event) {
		jtaSet("0");
	}

	@FXML
	void btnClick1(ActionEvent event) {
		jtaSet("1");
	}

	@FXML
	void btnClick2(ActionEvent event) {
		jtaSet("2");
	}

	@FXML
	void btnClick3(ActionEvent event) {
		jtaSet("3");
	}

	@FXML
	void btnClick4(ActionEvent event) {
		jtaSet("4");
	}

	@FXML
	void btnClick5(ActionEvent event) {
		jtaSet("5");
	}

	@FXML
	void btnClick6(ActionEvent event) {
		jtaSet("6");
	}

	@FXML
	void btnClick7(ActionEvent event) {
		jtaSet("7");
	}

	@FXML
	void btnClick8(ActionEvent event) {
		jtaSet("8");
	}

	@FXML
	void btnClick9(ActionEvent event) {
		jtaSet("9");
	}

	@FXML
	void btnClick10(ActionEvent event) {
		jtaSet("_");
	}

	@FXML
	void btnClick11(ActionEvent event) {
		jtaSet("@");
	}

	@FXML
	void btnEdit(ActionEvent event) {
		if (checkBox1.isSelected()) {
			jta1.setEditable(true);
		} else {
			jta1.setEditable(false);
		}
	}

	void jtaSet(String str) {
		jta1.setText(jta1.getText() + str);
	}
	
	@FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
		colorPick1.setValue(Color.BLACK);
		family = "PMingLiU";
		style = "normal";
		weight = "normal";
		size = "18";
		c1 = colorPick1.getValue();
		c2 = colorPick2.getValue();
		cssUpdate();
	}
}
