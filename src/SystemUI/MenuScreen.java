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
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class MenuScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JLabel lblMessage = new JLabel("");
	private JLabel messagePane = new JLabel("");
	private JLabel timeLabel = new JLabel(DateUtil.today());
	private int buttonChoice;
	private String accNum;
	private JPanel sideNav;

	public void setTime() {
		timeLabel.setText(DateUtil.today());
	}
	
	public MenuScreen() {
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
		case 8:
			btnNewButton_8.setEnabled(enable);
		}
	}
	
	public void setEndabledAll(boolean enabled) {
		for(int i=0; i<9; i++) {
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
		if(keyChar == 's' || keyChar == 'S') {
			return 4;
		}
		if(keyChar == 'd' || keyChar == 'D') {
			return 5;
		}
		if(keyChar == 'z' || keyChar == 'Z') {
			return 6;
		}
		if(keyChar == 'x' || keyChar == 'X') {
			return 7;
		}
		if(keyChar == 'c' || keyChar == 'C') {
			return 8;
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
			//txtEnterAmount.setText(text);
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
		case 8:
			btnNewButton_8.setText(text);
			break;
		}
	}
	
	public void setButtonLabels(String btn, String btn_1, String btn_2, String btn_3, String btn_4, String btn_5, String btn_6, String btn_7, String btn_8) {
		int i=0;
		setButtonLabel(btn,i++);
		setButtonLabel(btn_1,i++);
		setButtonLabel(btn_2,i++);
		setButtonLabel(btn_3,i++);
		setButtonLabel(btn_4,i++);
		setButtonLabel(btn_5,i++);
		setButtonLabel(btn_6,i++);
		setButtonLabel(btn_7,i++);
		setButtonLabel(btn_8,i++);
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
		
		btnNewButton = new JButton();
		btnNewButton.setBounds(102, 175, 140, 70);
		panel_1.add(btnNewButton);
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
		
		btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(464, 175, 140, 70);
		panel_1.add(btnNewButton_1);
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
		
		btnNewButton_2 = new JButton();
		btnNewButton_2.setBounds(792, 175, 140, 70);
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
		
		btnNewButton_3 = new JButton();
		btnNewButton_3.setBounds(102, 375, 140, 70);
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
		
		btnNewButton_4 = new JButton();
		btnNewButton_4.setBounds(464, 375, 140, 70);
		panel_1.add(btnNewButton_4);
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
		
		btnNewButton_5 = new JButton();
		btnNewButton_5.setBounds(792, 375, 140, 70);
		panel_1.add(btnNewButton_5);
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
		
		btnNewButton_6 = new JButton();
		btnNewButton_6.setBounds(102, 607, 140, 70);
		panel_1.add(btnNewButton_6);
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
		
		btnNewButton_7 = new JButton();
		btnNewButton_7.setBounds(464, 607, 140, 70);
		panel_1.add(btnNewButton_7);
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
		
		btnNewButton_8 = new JButton();
		btnNewButton_8.setBounds(792, 607, 140, 70);
		panel_1.add(btnNewButton_8);
		btnNewButton_8.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 8;
			}
		});
		btnNewButton_8.addKeyListener( new KeyListener() {
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