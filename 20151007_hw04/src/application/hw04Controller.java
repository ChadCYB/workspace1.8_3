package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;

public class hw04Controller {
	@FXML
	private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAdd, btnSub, btnMult, btnDiv, btnCls,
			btnDot;
	@FXML
	private TextField txt, txt2;

	private boolean dot = false, nub = false, first = true;
	private double temp, sum = 0;
	private int cal;

	@FXML
	void btnCAL_act(ActionEvent event) { 				// �p����s�I��
		Button obj = (Button) event.getSource();
		calAct(obj.getText());
	}
	void calAct(String str){
		try {
			if (nub) { 									// �P�_�p����s�I����O�_���I���Ʀr���s
				if (first) {							// �P�_�O�_���Ĥ@�ӭp��
					sum = Double.parseDouble(txt.getText());
					first = false;
				} else {
					temp = Double.parseDouble(txt.getText());
					switch (cal) {
						case 1: sum += temp; break;
						case 2: sum -= temp; break;
						case 3: sum *= temp; break;
						case 4: sum /= temp; break;
					}
				}
			}
			switch (str) {								//���o�ثe���U���p����s
				case "+": cal = 1; break;
				case "-": cal = 2; break;
				case "*": cal = 3; break;
				case "/": cal = 4; break;
			}
			txt2AddText(str);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	void txt2AddText(String str) {						// �p�Ʀr��ܳB�z
		txt2.setText((sum==0)?"0.0":sum + str);
		txt.setText("0");
		nub = false;
	}

	@FXML
	void btnCls_act(ActionEvent event) {				// �M�����s�I��
		dot = false;
		nub = false;
		first = true;
		temp = 0;
		sum = 0;
		txt.setText("0");
		txt2.setText("0");
	}

	@FXML
	void btnDot_act(ActionEvent event) {				// �p���I���s�I��
		if (!dot) {
			txt.setText(txt.getText() + ".");
			dot = true;
		}
	}

	@FXML
	void btnNum_act(ActionEvent event) {				// �Ʀr���s�I��
		Button obj = (Button) event.getSource();
		txtAddText(obj.getText());
	}

	void txtAddText(String str) {						// �j�Ʀr��ܳB�z
		if (txt.getText().equals("0")) {
			txt.setText(str);
		} else {
			txt.setText(txt.getText() + str);
		}
		nub = true;
	}

	@FXML
	void btn_Pressed(MouseEvent event) { 				// ���s����
		Button obj = (Button) event.getSource();
		obj.setStyle(" -fx-background-color: #00246B; " + " -fx-background-radius: 20; ");
	}

	@FXML
	void btn_Released(MouseEvent event) { 				// ���s����
		Button obj = (Button) event.getSource();
		obj.setStyle(" -fx-background-color: #001A4C; " + " -fx-background-radius: 100; ");
	}
	@FXML
	void keyType(KeyEvent event) { 						// ��L�����ƥ�
//		System.out.println(event.getSource().getClass().getName());
		switch (event.getCode()) {						// getCode�u��ΦbkeyPressed�H��keyReleased�ƥ�!!
			case NUMPAD1:	txtAddText("1"); break;
			case NUMPAD2:	txtAddText("2"); break;
			case NUMPAD3:	txtAddText("3"); break;
			case NUMPAD4:	txtAddText("4"); break;
			case NUMPAD5:	txtAddText("5"); break;
			case NUMPAD6:	txtAddText("6"); break;
			case NUMPAD7:	txtAddText("7"); break;
			case NUMPAD8:	txtAddText("8"); break;
			case NUMPAD9:	txtAddText("9"); break;
			case NUMPAD0:	txtAddText("0"); break;
			case ADD:		calAct("+"); break;
			case SUBTRACT:	calAct("-"); break;
			case MULTIPLY:	calAct("*"); break;
			case DIVIDE:	calAct("/"); break;
			
			default:
				System.out.println(event.getCode());
				break;
        }
        
	}
}
