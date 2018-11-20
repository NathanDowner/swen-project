package guiPkg;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import JDBackend.User;
import utils.*;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.border.BevelBorder;


public class StartScreen extends JPanel{


	private static final long serialVersionUID = 1L;
	private JLabel lblMessage;
	private JPasswordField passwordField;
	private JTextField textField;
	private String username;
	private String password;
	private User tempUser;
	private JLabel timeLabel = new JLabel(DateUtil.today());
	private JPanel panel;
	private JPanel panel_1;;

	
	public StartScreen() {
		initialize(); 
	}
	
	public void setTime() {
		timeLabel.setText(DateUtil.today());		
	}

	private void getEnteredUsername() {
		username = textField.getText();

	}
	
	private void getEnteredPassword() {
		password = new String(passwordField.getPassword());
	}
	
	public User getUser() {
		return tempUser;
	}
	
	public void setMessage(String text) {
		lblMessage.setText(text);
	}
	

	private void initialize() {
		this.setLayout(null);
		this.setBounds(100, 100, 1200, 800);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Username:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(699, 369, 168, 72);
		this.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password:");
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(715, 509, 152, 33);
		this.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(924, 507, 187, 28);
		passwordField.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEnteredUsername();
				getEnteredPassword();
				tempUser = new User(username, password);
			}
		});
		this.add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(924, 387, 187, 28);
		textField.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getEnteredUsername();
				getEnteredPassword();
				tempUser = new User(username, password);
			}
		});
		this.add(textField);
		
		lblMessage = new JLabel("Kindly enter your login details below,");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		lblMessage.setBounds(810, 257, 315, 89);
		add(lblMessage);
		
		timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timeLabel.setBounds(960, 670, 134, 28);
		add(timeLabel);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setBounds(0, 0, 1200, 180);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the Johnson and Downer Client and Case System");
		lblNewLabel.setBounds(291, 78, 617, 26);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, new Color(245, 245, 220)));
		panel_1.setBounds(0, 179, 705, 622);
		add(panel_1);
		panel_1.setLayout(null);
	}
}
