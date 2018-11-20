package guiPkg;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import utils.DateUtil;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

public class ButtonScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane messagePane;
	private JLabel lblMessage;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JLabel timeLabel = new JLabel(DateUtil.today());
	private int buttonChoice;
	private static JTextField txtEnterAmount;
	private String accNum;

	public void setTime() {
		timeLabel.setText(DateUtil.today());
	}
	
	public ButtonScreen() {
		initialize();
	}

	public int getButtonChoice() {
		return buttonChoice;
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
		case 4:
			btnNewButton_4.setEnabled(enable);
			break;
		case 5:
			btnNewButton_5.setEnabled(enable);
			break;
		case 6:
			btnNewButton_6.setEnabled(enable);
			break;
		case 7:
			btnNewButton_7.setEnabled(enable);
			break;
		}
	}
	
	public void setEndabledAll(boolean enabled) {
		for(int i=0; i<8; i++) {
			setButtonEnabled(enabled, i);
		}
	}
	
	public static void setTextFieldFocus() {
		txtEnterAmount.requestFocus();
	}
	
	public void setTextFieldEnabled(boolean enabled) {
		txtEnterAmount.setEnabled(enabled);
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
		if(keyChar == 's' || keyChar == 'S') {
			return 2;
		}
		if(keyChar == 'x' || keyChar == 'X') {
			return 3;
		}
		if(keyChar == 'p' || keyChar == 'P') {
			return 4;
		}
		if(keyChar == 'o' || keyChar == 'O') {
			return 5;
		}
		if(keyChar == 'k' || keyChar == 'K') {
			return 6;
		}
		if(keyChar == 'm' || keyChar == 'M') {
			return 7;
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
		case 2:
			txtEnterAmount.setText(text);
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
		case 4:
			btnNewButton_4.setText(text);
			break;
		case 5:
			btnNewButton_5.setText(text);
			break;
		case 6:
			btnNewButton_6.setText(text);
			break;
		case 7:
			btnNewButton_7.setText(text);
			break;
		}
	}
	
	public void setButtonLabels(String btn, String btn_1, String btn_2, String btn_3, String btn_4, String btn_5, String btn_6, String btn_7) {
		int i=0;
		setButtonLabel(btn,i++);
		setButtonLabel(btn_1,i++);
		setButtonLabel(btn_2,i++);
		setButtonLabel(btn_3,i++);
		setButtonLabel(btn_4,i++);
		setButtonLabel(btn_5,i++);
		setButtonLabel(btn_6,i++);
		setButtonLabel(btn_7,i++);
	}
	
	private void initialize() {
		buttonChoice = -1;
		
		this.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(26, 70, 161, 364);
		this.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton();
		btnNewButton.setBounds(10, 24, 140, 70);
		btnNewButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 0;
			}
		});
		btnNewButton.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(10, 105, 140, 70);
		btnNewButton_1.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 1;
			}
		});
		btnNewButton_1.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton();
		btnNewButton_2.setBounds(10, 186, 140, 70);
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
		panel_1.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton();
		btnNewButton_3.setBounds(10, 266, 140, 70);
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
		panel_1.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(758, 70, 161, 364);
		this.add(panel_2);
		panel_2.setLayout(null);
		
		btnNewButton_4 = new JButton();
		btnNewButton_4.setBounds(10, 26, 140, 70);
		btnNewButton_4.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 4;
			}
		});
		btnNewButton_4.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice =returnButtonChoice(key.getKeyChar());
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		panel_2.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton();
		btnNewButton_5.setBounds(10, 105, 140, 70);
		btnNewButton_5.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 5;
			}
		});
		btnNewButton_5.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		panel_2.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton();
		btnNewButton_6.setBounds(10, 186, 140, 70);
		btnNewButton_6.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 6;
			}
		});
		btnNewButton_6.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		panel_2.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton();
		btnNewButton_7.setBounds(10, 266, 140, 70);
		btnNewButton_7.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 7;
			}
		});
		btnNewButton_7.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		panel_2.add(btnNewButton_7);
		
		messagePane = new JTextPane();
		messagePane.setBackground(SystemColor.inactiveCaptionBorder);
		messagePane.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		messagePane.setEditable(false);
		messagePane.setBounds(202, 90, 541, 317);
		this.add(messagePane);
		
		timeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timeLabel.setBounds(33, 20, 134, 28);
		add(timeLabel);
		
		lblMessage = new JLabel();
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Sitka Small", Font.BOLD, 18));
		lblMessage.setBounds(197, 56, 546, 23);
		add(lblMessage);
		
		txtEnterAmount = new JTextField();
		txtEnterAmount.setText("Amount");
		txtEnterAmount.setEnabled(false);
		txtEnterAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEnterAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterAmount.setBounds(725, 20, 194, 50);
		txtEnterAmount.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accNum = txtEnterAmount.getText();
			}
		});
		add(txtEnterAmount);
		txtEnterAmount.setColumns(10);
		
	}
}
