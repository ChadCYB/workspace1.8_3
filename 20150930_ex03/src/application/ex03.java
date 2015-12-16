package application;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ex03 extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private CheckboxGroup grp = new CheckboxGroup();
	private Checkbox cb1 = new Checkbox("�L��");
	private Checkbox cb2 = new Checkbox("�p��");
	private Checkbox cb3 = new Checkbox("����");
	private Checkbox cb4 = new Checkbox("����|�Q��");
	private Checkbox cb5 = new Checkbox("����|�Q��");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ex03 frame = new ex03();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ex03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(50, 20));
		setContentPane(contentPane);
		JTextArea textArea = new JTextArea(10,30);
		
		JPanel pan_Noodle = new JPanel();
		contentPane.add(pan_Noodle, BorderLayout.WEST);
		pan_Noodle.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel pan_food = new JPanel();
		pan_Noodle.add(pan_food);
		pan_food.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_food = new JLabel("�\�I");
		pan_food.add(lbl_food);
		
		JRadioButton rb_bn = new JRadioButton("\u725B\u8089\u9EB5");
		pan_Noodle.add(rb_bn);
		
		JRadioButton rb_sn = new JRadioButton("\u967D\u6625\u9EB5");
		pan_Noodle.add(rb_sn);
		
		JRadioButton rb_vmn = new JRadioButton("\u69A8\u83DC\u8089\u7D72\u9EB5");
		pan_Noodle.add(rb_vmn);
		
		JRadioButton rb_in = new JRadioButton("\u50BB\u74DC\u9EB5");
		pan_Noodle.add(rb_in);
		
		JRadioButton rb_life = new JRadioButton("\u990A\u751F\u9EB5");
		pan_Noodle.add(rb_life);
		
		JPanel pan_num = new JPanel();
		contentPane.add(pan_num, BorderLayout.CENTER);
		pan_num.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel pan_n = new JPanel();
		pan_num.add(pan_n);
		pan_n.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_num = new JLabel("\u6578\u91CF");
		pan_n.add(lbl_num);
		
		JPanel panel = new JPanel();
		pan_num.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		pan_num.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		pan_num.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		pan_num.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		pan_num.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_4 = new JTextField();
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel pan_spicy = new JPanel();
		contentPane.add(pan_spicy, BorderLayout.EAST);
		pan_spicy.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel pan_sp = new JPanel();
		pan_spicy.add(pan_sp);
		pan_sp.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//�]�w���h��@
		cb1.setCheckboxGroup(grp);
		cb2.setCheckboxGroup(grp);
		cb3.setCheckboxGroup(grp);
		cb4.setCheckboxGroup(grp);
		cb5.setCheckboxGroup(grp);
		JLabel label = new JLabel("\u8FA3\u5EA6");
		pan_sp.add(label);
		pan_spicy.add(cb1);
		pan_spicy.add(cb2);
		pan_spicy.add(cb3);
		pan_spicy.add(cb4);
		pan_spicy.add(cb5);
		
		JButton button = new JButton("\u78BA\u5B9A");
		pan_spicy.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("�z���I�\���G�p�U�G\n");
				if(rb_bn.isSelected()){
					textArea.append(rb_bn.getText()+" "+textField.getText()+" ��\n");
				}else if(rb_sn.isSelected()){
					textArea.append(rb_sn.getText()+" "+textField_1.getText()+" ��\n");
				}else if(rb_vmn.isSelected()){
					textArea.append(rb_vmn.getText()+" "+textField_2.getText()+" ��\n");
				}else if(rb_in.isSelected()){
					textArea.append(rb_in.getText()+" "+textField_3.getText()+" ��\n");
				}else if(rb_life.isSelected()){
					textArea.append(rb_life.getText()+" "+textField_4.getText()+" ��\n");
				}
				//getState���o��U�I�諸���A
				if(cb1.getState() == true){
					textArea.append("���׬��G�L���ԡI�pCASE");
				}else if(cb2.getState() == true){
					textArea.append("���׬��G�p���H�Pı��L���t���h�Ӥw�I");
				}else if(cb3.getState() == true){
					textArea.append("���׬��G�����Pı�]�S�ƻ���I");
				}else if(cb4.getState() == true){
					textArea.append("���׬��G����|�Q���H�Pı�٥i�H��(�j�j");
				}else if(cb5.getState() == true){
					textArea.append("���׬��G����|�Q���]�����I�ɤѩ�");
				}
			}
		});
		
		JPanel pan_show = new JPanel();
		contentPane.add(pan_show, BorderLayout.SOUTH);
		pan_show.setLayout(new BorderLayout(0, 0));
		
		//�N�s�W��JTextArea��iJScrollPane�A�A�NJScrollPane�O�J��ContentPane�̡A
		//JScrollPane�@�w�n�]�w���b��X�b�MY�b(=�j�p)
		JScrollPane scroll=new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);//�]�w���ä[���Y�b���ʮe��
		scroll.setSize(500,200);
		pan_show.add(scroll);
	}
}