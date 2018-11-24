package SystemUI;

import javax.swing.JPanel;
import javax.swing.JButton;

import utils.DateUtil;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import JDBackend.Case;
import JDBackend.Client;
import javax.swing.DefaultListModel;

public class ListScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblMessage = new JLabel("");
	private JLabel messagePane = new JLabel("");
	private JLabel timeLabel = new JLabel(DateUtil.today());
	private int buttonChoice;
	private JList<String> list;
	private JPanel panel_1 = new JPanel();
	private JPanel sideNav;
	private JTextField txtEnterIndex;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private String index = "";
	private JScrollPane scrollPane = new JScrollPane();
	private DefaultListModel<String> listModel = new DefaultListModel<String>();

	public void setTime() {
		timeLabel.setText(DateUtil.today());
	}
	
	public ListScreen() {
		initializeClientList();
		initialize();
	}

	public int getButtonChoice() {
		return buttonChoice;
	}
	
	public String getIndex(){
		return index;
	}
	
	public void setButtonEnabled(boolean enable, int btnNum) {
		switch (btnNum) {
		case 0:
			btnNewButton.setEnabled(enable);
			break;
		case 1:
			btnNewButton_1.setEnabled(enable);
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
	
	public int returnButtonChoice(char keyChar) {
		if(keyChar == 'q' || keyChar == 'Q') {
			return 0;
		}
		if(keyChar == 'w' || keyChar == 'W') {
			return 1;
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
	
	public void initializeClientList() {
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
		listModel.addElement("Akili");
	}
	
	
	public void setButtonLabel(String text,int btnNum) {
		switch (btnNum) {
		case 0:
			btnNewButton.setText(text);
			break;
		case 1:
			btnNewButton_1.setText(text);
			break;
		}
	}
	
	public void setButtonLabels(String btn, String btn_1) {
		int i=0;
		setButtonLabel(btn,i++);
		setButtonLabel(btn_1,i++);
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
		
		JLabel lblEnterIndex = new JLabel("Enter Desired Index:");
		lblEnterIndex.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblEnterIndex.setBounds(620, 208, 212, 60);
		panel_1.add(lblEnterIndex);
		
		list = new JList<>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(31, 170, 511, 477);
		scrollPane.setBounds(31, 170, 511, 477);
		scrollPane.add(list);
		panel_1.add(scrollPane);
		
		txtEnterIndex = new JTextField();
		txtEnterIndex.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterIndex.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtEnterIndex.setBounds(609, 328, 72, 41);
		panel_1.add(txtEnterIndex);
		txtEnterIndex.setColumns(10);
		txtEnterIndex.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = txtEnterIndex.getText();	
			}
		});
		
		btnNewButton = new JButton();
		btnNewButton.setBounds(736, 310, 140, 70);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChoice = 0;
				index = txtEnterIndex.getText();
			}
		});
		btnNewButton.addKeyListener( new KeyListener() {
			public void keyTyped(KeyEvent key) {
				buttonChoice = returnButtonChoice(key.getKeyChar());
				buttonChoice = 0;
				index = txtEnterIndex.getText();
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {
			}
		});
		
		btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(736, 529, 140, 70);
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
	}
}