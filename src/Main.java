import java.awt.Container;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import JDBackend.*;
import SystemUI.*;

public class Main {
    
    private static ArrayList<Client> clientList = new ArrayList<Client>();
    private static ArrayList<Case> caseList = new ArrayList<Case>();
    private static ArrayList<User> userList = new ArrayList<User>();
	private static int userStatus = 0;
    
    private static User sysUser;
	private static final User ADMINUSER = new User("admin","password");

    
    private static JFrame mainFrame = new JFrame("Johnson & Downer Client and Case Management System");;
	private static Container mainPanel;
	private static JPanel window;

    
	public static User searchUserList(User startU) {
		for(User u: userList) {
			if (startU.compareTo(u) == 0) {
				userStatus = 1;
				return u;
			}
		}
		return startU;
	}
	
	public static void search() {
		ArrayList<String> searchKeys = new ArrayList<String>();
		mainPanel.remove(window);
		mainPanel.setVisible(false);
		window = new SearchScreen();
		((SearchScreen)window).setMessage("Welcome to the Search Screen", 0);
		((SearchScreen)window).setMessage("How would you like to search "+ sysUser.getFName()+"?", 1);
		((SearchScreen)window).setButtonLabels("Enter","Enter","Enter","Cancel");
		mainPanel.add(window);
		mainPanel.setVisible(true);
		((SearchScreen)window).defaultButton().requestFocusInWindow();
		int buttonChoice; 
		do {
			buttonChoice = ((SearchScreen)window).getButtonChoice();
		}while(buttonChoice < 0);
		if (buttonChoice<3) {
			searchKeys = ((SearchScreen)window).getSearchKeys();
			while (searchKeys.get(buttonChoice).compareTo("") == 0) {
				((SearchScreen)window).setMessage("Try again "+ sysUser.getFName(), 1);
				((SearchScreen)window).setButtonChoice('t');
				searchKeys = ((SearchScreen)window).getSearchKeys();
			}
		}
		switch (buttonChoice){
			case 0:
				searchForClient(buttonChoice, searchKeys.get(buttonChoice));
				break;
			case 1:
				searchForClient(buttonChoice, searchKeys.get(buttonChoice));
				break;
			case 2:
				searchForCase(searchKeys.get(buttonChoice));
				break;
			case 3:
				menu();
				break;
		}
	}
	
	public static ArrayList<Client> searchForClient(int choice, String key){
		ArrayList<Client> searchResults = new ArrayList<Client>();
		
		if (choice == 0) {
			for (Client cl: clientList) {
				if (cl.getClientId().contains(key)) {
					searchResults.add(cl);
				}
			}
		}
		else {
			for (Client cl: clientList) {
				if ((cl.getFname()+ " "+cl.getLname()).contains(key)) {
					searchResults.add(cl);
				}
			}
		}
		
		return searchResults;	
	}
	
	public static ArrayList<Case> searchForCase(String key){
		ArrayList<Case> searchResults = new ArrayList<Case>();
		
		for (Case cs: caseList) {
			if (cs.getCaseID().contains(key)) {
				searchResults.add(cs);
			}
		}
		return searchResults;
	}
    
    private static void admin() {/*
		mainPanel.remove(window);
		mainPanel.setVisible(false);
		window = new ButtonScreen();
		((ButtonScreen)window).setMessage("Welcome Administrator",0);
		((ButtonScreen)window).setButtonLabels("","","","","","","Continue","Exit");
		((ButtonScreen)window).setMessage("\n\n\n\n\n\n\t\tPress exit to close the application?\n", 1);
		mainPanel.add(window);
		mainPanel.setVisible(true);
		((ButtonScreen)window).defaultButton().requestFocusInWindow();
		int buttonChoice;
		((ButtonScreen)window).setButtonChoice('t');
		do {
			((ButtonScreen)window).setTime();
			buttonChoice = ((ButtonScreen)window).getButtonChoice();
		} while (buttonChoice == -1);
		switch (buttonChoice) {
		case 6:
			startup();
			break;
		case 7:
			//FileManager.saveData(cardList, personalClientData, businessClientData, t.getLog());
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
			break;
		}*/
	}
    
    public static void startup() {
		window = new LogInScreen();
		
		mainPanel.add(window);
		mainFrame.setVisible(true);
		User startUser = ((LogInScreen)window).getUser();
		do {
			((LogInScreen)window).setTime();
			startUser = ((LogInScreen)window).getUser();
		} while (startUser == null);
		if (startUser.compareTo(ADMINUSER)==0) {
			admin();
		}
		sysUser = searchUserList(startUser);
		
		while (userStatus == 0) {
			((LogInScreen)window).setTime();
			((LogInScreen)window).setMessage("Unknown username or invalid password, kindly try again");
			startUser = null;
			while (startUser == null) {
				startUser = ((LogInScreen)window).getUser();
				((LogInScreen)window).setTime();
			}
			if (startUser.compareTo(ADMINUSER)==0) {
				admin();
			}
			sysUser = searchUserList(startUser);
		}
		menu();
	}
	
	public static void menu() {
		mainPanel.remove(window);
		mainPanel.setVisible(false);
		window = new MenuScreen();
		((MenuScreen)window).setMessage("Welcome "+sysUser.getFullName(),0);
		((MenuScreen)window).setButtonLabels("Search","Add Client","Edit CLient","Generate Statement","Send Email","Add Case","Update Case","Coming Soon","Logout");
		((MenuScreen)window).setMessage("\n\n\n\n\n\n\t\tWhat would you like to do today?\n", 1);
		mainPanel.add(window);
		mainPanel.setVisible(true);
		/*menuContinued();
	}
	
	public static void menuContinued() {*/
		((MenuScreen)window).defaultButton().requestFocusInWindow();
		int buttonChoice;
		((MenuScreen)window).setButtonChoice('t');
		do {
			((MenuScreen)window).setTime();
			buttonChoice = ((MenuScreen)window).getButtonChoice();
		} while (buttonChoice < 0);
		if (buttonChoice == 8) {
			((MenuScreen)window).setMessage("\n\n\n\n\n\n\t\t   Thank you for using the system", 1);
			((MenuScreen)window).setButtonLabels("","","","","","","","Sign In","Exit");
			((MenuScreen)window).setButtonChoice('t');
			do {
				((MenuScreen)window).setTime();
				buttonChoice = ((MenuScreen)window).getButtonChoice();
			} while (buttonChoice != 8 && buttonChoice != 7);
			if (buttonChoice == 8) {
				mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
			}
			else {
				mainPanel.remove(window);
				userStatus = 0;
				startup();
			}
		}
		else {
			((MenuScreen)window).setButtonChoice('t');
			switch (buttonChoice) {
			case 0:
				search();
				break;
			case 1:
				mainPanel.remove(window);
				mainPanel.setVisible(false);
				window = new ListScreen();
				((ListScreen)window).setMessage("Welcome "+sysUser.getFullName(),0);
				((ListScreen)window).setButtonLabels("Enter","Cancel");
				((ListScreen)window).setMessage("Click your selection", 1);
				((ListScreen)window).initializeClientList();
				mainPanel.add(window);
				mainPanel.setVisible(true);
				break;
			case 6:
				break;
			default:
				menu();
				break;
			}
		}
	}
    
    public static void main(String[] args) {
		mainFrame.setBounds(100, 100, 1200, 800);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = mainFrame.getContentPane();
		
		userList.add(new User("kilidon","hothead7", "Akili", "Sterling"));
		userList.add(new User("","", "Akili", "Sterling"));
		startup();
	}
}
