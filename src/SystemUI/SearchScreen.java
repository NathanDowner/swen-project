package SystemUI;

import javax.swing.JPanel;
import javax.swing.JButton;

import utils.DateUtil;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class SearchScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblMessage = new JLabel("");
	private JLabel messagePane = new JLabel("");
	private JLabel timeLabel = new JLabel(DateUtil.today());
	private int buttonChoice;
	private String accNum;
	private JPanel sideNav;
	private JTextField txtEnterClientName;
	private JTextField txtEnterClientId;
	private JTextField txtEnterCaseId;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private String nameKey = "", clIdKey = "", caseIdKey  = "";

	public void setTime() {
		timeLabel.setText(DateUtil.today());
	}
	
	public SearchScreen() {
		initialize();
	}

	public int getButtonChoice() {
		return buttonChoice;
	}
	
	public ArrayList<String> getSearchKeys(){
		ArrayList<String> keys = new ArrayList<String>();
		keys.add(nameKey);
		keys.add(clIdKey);
		keys.add(caseIdKey);
		return keys;
		
	}
	
	public void setButtonEnabled(boolean enable, int btnNum) {
		switch (btnNum) {
		case 0:
			btnNewButton.setEnabled(enable);
			break;
		case 1:
			btnNewButton_1.setEnabled(enable);
			break;
		case 2:
			btnNewButton_2.setEnabled(enable);
			break;
		case 3:
			btnNewButton_3.setEnabled(enable);
			break;
		}
	}
	
	public void setEndabledAll(boolean enabled) {
		for(int i=0; i<4; i++) {
			setButtonEnabled(enabled, i);
		}
	}
	
	public static void setTextFieldFocus() {
		//txtEnterAmount.requestFocus();
	}
	
	public void setTextFieldEnabled(boolean enabled) {
		//txtEnterAmount.setEnabled(enabled);
	}
	
	public String getAccNum() {
		return accNum;
	}
	
	public void setAccNum() {
		accNum = null;
	}
	
	public int returnButtonChoice(char keyChar) {
		if(keyChar == 'q' || keyChar == 'Q') {
			return 0;
		}
		if(keyChar == 'w' || keyChar == 'W') {
			return 1;
		}
		if(keyChar == 'e' || keyChar == 'E') {
			return 2;
		}
		if(keyChar == 'a' || keyChar == 'A') {
			return 3;
		}
		return -1;
	}
	
	public void setButtonChoice(char key) {
		buttonChoice = returnButtonChoice(key);
	}
	
	public JButton defaultButton() {
		return btnNewButton;
	}
	
	public void setMessage(String text, int i) {
		switch (i) {
		case 0:
			lblMessage.setText(text);
			break;
		case 1:
			messagePane.setText(text);
			break;
		}
	}
	
	public void setButtonLabel(String text,int btnNum) {
		switch (btnNum) {
		case 0:
			btnNewButton.setText(text);
			break;
		case 1:
			btnNewButton_1.setText(text);
			break;
		case 2:
			btnNewButton_2.setText(text);
			break;
		case 3:
			btnNewButton_3.setText(text);
			break;
		}
	}
	
	public void setButtonLabels(String btn, String btn_1, String btn_2, String btn_3) {
		int i=0;
		setButtonLabel(btn,i++);
		setButtonLabel(btn_1,i++);
		setButtonLabel(btn_2,i++);
		setButtonLabel(btn_3,i++);
	}
	
	private void initialize() {
		buttonChoice = -1;
		
		this.setLayout(null);
		this.setBounds(100, 100, 1200, 800);
		
		sideNav = new JPanel();
		sideNav.setBounds(0, 0, 135, 749);
		add(sideNav);
		sideNav.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		sideNav.setLayout(null);
		
		JButton casesBtn = new JButton("Cases");
		casesBtn.setBounds(0, 298, 125, 37);
		sideNav.add(casesBtn);
		
		JButton clientBtn = new JButton("Clients");
		clientBtn.setBounds(0, 391, 125, 37);
		sideNav.add(clientBtn);
		
		JButton logBtn = new JButton("Log");
		logBtn.setBounds(0, 477, 125, 37);
		sideNav.add(logBtn);
		timeLabel.setBounds(7, 32, 118, 39);
		sideNav.add(timeLabel);
		
		timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(135, 0, 1075, 749);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblMessage.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(360, 23, 332, 54);
		panel_1.add(lblMessage);
		
		messagePane.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		messagePane.setHorizontalAlignment(SwingConstants.CENTER);
		messagePane.setBounds(242, 104, 550, 60);
		panel_1.add(messagePane);
		
		JLabel lblSearchForClient = new JLabel("Search for Client:");
		lblSearchForClient.setFont(new Font("Segoe Print", Font.PLAIN, 26));
		lblSearchForClient.setBounds(72, 175, 256, 74);
		panel_1.add(lblSearchForClient);
		
		JLabel lblSearchForCase = new JLabel("Search for Case:");
		lblSearchForCase.setFont(new Font("Segoe Print", Font.PLAIN, 26));
		lblSearchForCase.setBounds(662, 175, 256, 74);
		panel_1.add(lblSearchForCase);
		
		txtEnterClientName = new JTextField();
		txtEnterClientName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtEnterClientName.setText("Enter Client Name");
		txtEnterClientName.setBounds(32, 336, 199, 41);
		panel_1.add(txtEnterClientName);
		txtEnterClientName.setColumns(10);
		
		txtEnterClientId = new JTextField();
		txtEnterClientId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEnterClientId.setText("Enter Client ID No.");
		txtEnterClientId.setColumns(10);
		txtEnterClientId.setBounds(32, 530, 199, 41);
		panel_1.add(txtEnterClientId);
		
		txtEnterCaseId = new JTextField();
		txtEnterCaseId.setText("Enter Case ID No.");
		txtEnterCaseId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEnterCaseId.setColumns(10);
		txtEnterCaseId.setBounds(523, 423, 199, 41);
		panel_1.add(txtEnterCaseId);
		
		btnNewButton = new JButton();
		btnNewButton.setBounds(300, 323, 140, 70);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 0;
				nameKey = txtEnterClientName.getText();
				clIdKey = txtEnterClientId.getText();
			}
		});
		btnNewButton.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
				nameKey = txtEnterClientName.getText();
				clIdKey = txtEnterClientId.getText();
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		
		btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(804, 408, 140, 70);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 1;
				caseIdKey = txtEnterCaseId.getText();
			}
		});
		btnNewButton_1.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
				caseIdKey = txtEnterCaseId.getText();
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		
		btnNewButton_2= new JButton();
		btnNewButton_2.setBounds(300, 516, 140, 70);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 2;
			}
		});
		btnNewButton_2.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		
		btnNewButton_3= new JButton();
		btnNewButton_3.setBounds(413, 625, 140, 70);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 3;
			}
		});
		btnNewButton_3.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
	}
}