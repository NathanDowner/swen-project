import ABMBackend.*;
import JDBackend.*;
import SystemUI.*;
import guiPkg.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AutomatedBankingMachine {
	private static ArrayList<User> userList = new ArrayList<User>();
	private static int userStatus = 0;
	private static ArrayList<String[]> accountData = new ArrayList<String[]>();
    private static ArrayList<PersonalClient> personalClientData = new ArrayList<PersonalClient>();
    private static ArrayList<BusinessClient> businessClientData = new ArrayList<BusinessClient>();

    private static ArrayList<ABMCard> cardList = new ArrayList<>();
    private static TransactionLogger t = new TransactionLogger();
    private static FileManager file = new FileManager();
    
	private static JFrame mainFrame = new JFrame("Johnson & Downer Client and Case Management System");;
	private static Container mainPanel;
	private static JPanel window;
	private static PersonalClient client;
	private static final User ADMINUSER = new User("admin","password");
	private static User sysUser;
	
	public static double  getAmount() {
		double amount = 0;
		((ButtonScreen)window).setButtonLabels("$5000","$1000","$500","$100","","","","Done");
		((ButtonScreen)window).setMessage("\n\n\n\n\nClick corresponding bills until desired amount then select \"Done\" when finished", 1);
		int buttonChoice;
		do {
			((ButtonScreen)window).setTime();
			buttonChoice = ((ButtonScreen)window).getButtonChoice();
			switch (buttonChoice) {
			case 0:
				amount += 5000;
				break;
			case 1:
				amount += 1000;
				break;
			case 2:
				amount += 500;
				break;
			case 3:
				amount += 100;
				break;
			}
			((ButtonScreen)window).setButtonChoice('t');
			((ButtonScreen)window).setMessage(String.format("$ %,.2f", amount),2);
		} while (buttonChoice != 7);
		((ButtonScreen)window).setButtonChoice('t');
		((ButtonScreen)window).setMessage("Account #", 2);
		return amount;
	}
	
	
	public static ArrayList<Account> getAllAccounts() {
		ArrayList<Account> allAccounts = new ArrayList<Account>();
    	for (Client cl : personalClientData) {
    		for(Account acc: cl.getAccounts()) {
    			allAccounts.add(acc);
    		}
    	}
        return allAccounts;
	}
	
	public static User searchUserList(User startU) {
		for(User u: userList) {
			if (startU.compareTo(u) == 0) {
				userStatus = 1;
				return u;
			}
		}
		return startU;
	}
		
	public static String showUserAccounts(ArrayList<Account> clientAccounts) {
		String text = "List of Accounts:\n\n";
		char letter = 'A';
		int ascii;
		for (Account acc : clientAccounts) {
				text += String.format("%c - %s\n",letter,acc.toString());
				ascii  = (int)letter +1;
				letter = (char)ascii;
		}
		return text;
	}
	
	private static void admin() {
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
			FileManager.saveData(cardList, personalClientData, businessClientData, t.getLog());
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
			break;
		}
	}

	public static void main(String[] args) {
		if (!file.loadData()) {
			initialize();
			createObjects();
		}
		else {
			personalClientData = file.getPersonalClients();
			businessClientData = file.getBusinessClients();
			cardList = file.getABMCards();
			t.setLog(file.getTransactionLog());
		}
		
		mainFrame.setBounds(100, 100, 1200, 800);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = mainFrame.getContentPane();
		
		userList.add(new User("kilidon","hothead7", "Akili", "Sterling"));
		startup();
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
		mainPanel.remove(window);
		mainPanel.setVisible(false);
		window = new ButtonScreen();
		menu();
	}
	
	public static void menu() {
		((ButtonScreen)window).setMessage("Welcome "+sysUser.getFullName(),0);
		((ButtonScreen)window).setButtonLabels("","","","","Balance Query","Withdraw","Deposit","Cancel");
		((ButtonScreen)window).setMessage("\n\n\n\n\n\n\t\tWhat would you like to do today?\n", 1);
		mainPanel.add(window);
		mainPanel.setVisible(true);
		menuContinued();
	}
	
	public static void menuContinued() {
		((ButtonScreen)window).defaultButton().requestFocusInWindow();
		int buttonChoice;
		((ButtonScreen)window).setButtonChoice('t');
		do {
			((ButtonScreen)window).setTime();
			buttonChoice = ((ButtonScreen)window).getButtonChoice();
		} while (buttonChoice < 4);
		if (buttonChoice == 7) {
			((ButtonScreen)window).setMessage("\n\n\n\n\n\n\t\t   Thank you for using the ABM", 1);
			((ButtonScreen)window).setButtonLabels("","","","","","","","Done");
			((ButtonScreen)window).setButtonChoice('t');
			do {
				((ButtonScreen)window).setTime();
				buttonChoice = ((ButtonScreen)window).getButtonChoice();
			} while (buttonChoice != 7);
			mainPanel.remove(window);
			userStatus = 0;
			startup();
		}
		else {
			((ButtonScreen)window).setButtonChoice('t');
			switch (buttonChoice) {
			case 4:
				balanceQueryMenu();
				break;
			case 5:
				withdrawMenu();
				break;
			case 6:
				depositMenu();
				break;
			default:
				menu();
				break;
			}
		}
	}
	
	private static void balanceQueryMenu() {
		ArrayList<Account> clientAccounts = client.getAccounts();
		ArrayList<Account> signatoryAccounts = client.getSignatoryAccounts();
		String text = "";
		Character letter = 'A';
		int ascii;
		int buttonChoice;
		
		if (signatoryAccounts.size() == 0)
			((ButtonScreen)window).setButtonLabels("","","","","","","","Cancel");
		else
			((ButtonScreen)window).setButtonLabels("","","","","","","Signatory","Cancel");
		text += "Which account's balance would you like to view?\n\n";
		((ButtonScreen)window).setMessage(text+showUserAccounts(client.getAccounts()), 1);
		for (int i= 0; i<clientAccounts.size();i++) {
			((ButtonScreen)window).setButtonLabel(letter.toString(),i);
			ascii  = (int)letter +1;
			letter = (char)ascii;
		}
		((ButtonScreen)window).setButtonChoice('t');
		 do{
			 ((ButtonScreen)window).setTime();
			buttonChoice = ((ButtonScreen)window).getButtonChoice();
		} while (buttonChoice != 6 && buttonChoice != 7 && (buttonChoice >clientAccounts.size()-1 || buttonChoice == -1));
		text = ""; 
		if (buttonChoice < clientAccounts.size()) {
			text += String.format("\n\n\n\n\n\n\t\t      %s\n\t\t    Balance: $ %,.2f", clientAccounts.get(buttonChoice).toString(), clientAccounts.get(buttonChoice).currentBalance());
			((ButtonScreen)window).setButtonLabels("","","","","","","","Done");
			((ButtonScreen)window).setMessage(text, 1);
			((ButtonScreen)window).setButtonChoice('t');
			do{
				((ButtonScreen)window).setTime();
				buttonChoice = ((ButtonScreen)window).getButtonChoice();
			} while (buttonChoice != 7);
		}
		else if (buttonChoice == 6) {
			if (signatoryAccounts.size() == 0)
				balanceQueryMenu();
			else {
				text = "";
				((ButtonScreen)window).setButtonLabels("","","","","","","","Cancel");
				text += "Which business account's balance would you like to view?\n\n";
				((ButtonScreen)window).setMessage(text+showUserAccounts(signatoryAccounts), 1);
				letter = 'A';
				for (int i= 0; i<signatoryAccounts.size();i++) {
					((ButtonScreen)window).setButtonLabel(letter.toString(),i);
					ascii  = (int)letter +1;
					letter = (char)ascii;
				}
				((ButtonScreen)window).setButtonChoice('t');
				do{
					((ButtonScreen)window).setTime();
					buttonChoice = ((ButtonScreen)window).getButtonChoice();
				} while (buttonChoice != 7 && (buttonChoice >signatoryAccounts.size()-1 || buttonChoice == -1));
				if (buttonChoice < signatoryAccounts.size()) {
					text += String.format("\n\n\n\n\n\n\t\t      %s\n\t\t    Balance: $ %,.2f", clientAccounts.get(buttonChoice).toString(), clientAccounts.get(buttonChoice).currentBalance());
					((ButtonScreen)window).setButtonLabels("","","","","","","","Done");
					((ButtonScreen)window).setMessage(text, 1);
					((ButtonScreen)window).setButtonChoice('t');
					do{
						((ButtonScreen)window).setTime();
						buttonChoice = ((ButtonScreen)window).getButtonChoice();
					} while (buttonChoice != 7);
				}
				else if (buttonChoice == 7) {
					balanceQueryMenu();
				}
			}
		}
		menu();
	}
	
	private static void withdrawMenu() {
		ArrayList<Account> clientAccounts = Client.getWithdrawalAccounts(client.getAccounts());
		ArrayList<Account> signatoryAccounts = Client.getWithdrawalAccounts(client.getSignatoryAccounts());
		String text = "";
		Character letter = 'A';
		int ascii;
		int buttonChoice;
		
		if (signatoryAccounts.size() == 0)
			((ButtonScreen)window).setButtonLabels("","","","","","","","Cancel");
		else
			((ButtonScreen)window).setButtonLabels("","","","","","","Signatory","Cancel");
		text += "Which account would you like to withdraw from?\n\n";
		((ButtonScreen)window).setMessage(text+showUserAccounts(clientAccounts), 1);
		for (int i= 0; i<clientAccounts.size();i++) {
			((ButtonScreen)window).setButtonLabel(letter.toString(),i);
			ascii  = (int)letter +1;
			letter = (char)ascii;
		}
		((ButtonScreen)window).setButtonChoice('t');
		 do{
			((ButtonScreen)window).setTime();
			buttonChoice = ((ButtonScreen)window).getButtonChoice();
		} while (buttonChoice != 6 && buttonChoice != 7 && (buttonChoice >clientAccounts.size()-1 || buttonChoice == -1));
		if (buttonChoice < clientAccounts.size()) {
			ABMWithdrawal(clientAccounts.get(buttonChoice));
		} 
		else if (buttonChoice == 6) {
			if (signatoryAccounts.size() == 0)
				withdrawMenu();
			else {
				text = "";
				((ButtonScreen)window).setButtonLabels("","","","","","","","Cancel");
				text += "Which business account would you like to withdraw from?\n\n";
				((ButtonScreen)window).setMessage(text+showUserAccounts(signatoryAccounts), 1);
				letter = 'A';
				for (int i= 0; i<signatoryAccounts.size();i++) {
					((ButtonScreen)window).setButtonLabel(letter.toString(),i);
					ascii  = (int)letter +1;
					letter = (char)ascii;
				}
				((ButtonScreen)window).setButtonChoice('t');
				do{
					((ButtonScreen)window).setTime();
					buttonChoice = ((ButtonScreen)window).getButtonChoice();
				} while (buttonChoice != 7 && (buttonChoice >signatoryAccounts.size()-1 || buttonChoice == -1));
				if (buttonChoice < signatoryAccounts.size()) {
					ABMWithdrawal(signatoryAccounts.get(buttonChoice));
				}
				else if (buttonChoice == 7) {
					withdrawMenu();
				}
			}
		}
		menu();
	}
	
	private static void ABMWithdrawal(Account acc) {
		String text = "";
		int buttonChoice;
		double amount;
		
		text += String.format("\n\n\n\t\t      %s", acc.toString());
		text += String.format("\n\n\t\tOld Balance: $ %,.2f",acc.currentBalance());
		((ButtonScreen)window).setButtonChoice('t');
		amount = getAmount();
		if (acc.withdraw(amount)) {
			t.recordTransaction(client.getFullName(), "withdrawal", String.format("$ ,.2f",amount), acc.getAccNum());
			FileManager.saveData(cardList, personalClientData, businessClientData, t.getLog());
			text += String.format("\n\n\t\tNew Balance: $ %,.2f",acc.currentBalance());
			text += String.format("\n\t\t\t\t\tBill Break Down:");
			text += String.format("\n\t\t\t\t\t$5,000.00 X %d",(int)amount/5000);
			text += String.format("\n\t\t\t\t\t$1,000.00 X %d",((int)amount%5000)/1000);
			text += String.format("\n\t\t\t\t\t$   500.00 X %d",(((int)amount%5000)%1000)/500);
			text += String.format("\n\t\t\t\t\t$   100.00 X %d",((((int)amount%5000)%1000)%500)/100);
			text += String.format("\n\t\t\t\t\t  = $ %,.2f",amount);
		}
		else {
			text += String.format("\n\n\t\t    Unsuccessful Withdrawal");
		}
		((ButtonScreen)window).setButtonLabels("","","","","","","","Done");
		((ButtonScreen)window).setMessage(text, 1);
		((ButtonScreen)window).setButtonChoice('t');
		do{
			((ButtonScreen)window).setTime();
			buttonChoice = ((ButtonScreen)window).getButtonChoice();
		} while (buttonChoice != 7);
	}
	
	private static void depositMenu() {
		ArrayList<Account> clientAccounts = client.getAccounts();
		ArrayList<Account> signatoryAccounts = client.getSignatoryAccounts();
		Account selectedAcc = null;
		String text = "";
		Character letter = 'A';
		int ascii;
		int buttonChoice;
		
		if (signatoryAccounts.size() == 0)
			((ButtonScreen)window).setButtonLabels("","","","","","","","Cancel");
		else
			((ButtonScreen)window).setButtonLabels("","","","","","","Signatory","Cancel");
		text += "Enter the account number of the account you would like to deposit to or select one of your own accounts\n\n";
		((ButtonScreen)window).setMessage(null, 2);
		((ButtonScreen)window).setTextFieldEnabled(true);
		((ButtonScreen)window).setMessage(text+showUserAccounts(clientAccounts), 1);
		for (int i= 0; i<clientAccounts.size();i++) {
			((ButtonScreen)window).setButtonLabel(letter.toString(),i);
			ascii  = (int)letter +1;
			letter = (char)ascii;
		}
		((ButtonScreen)window).setButtonChoice('t');
		 do{
			((ButtonScreen)window).setTime();		
			buttonChoice = ((ButtonScreen)window).getButtonChoice();
		} while (buttonChoice != 6 && buttonChoice != 7 && (buttonChoice>clientAccounts.size()-1 || buttonChoice == -1)  && ((ButtonScreen)window).getAccNum() == null);
		text = "";
		((ButtonScreen)window).setTextFieldEnabled(false);
		((ButtonScreen)window).setMessage("Account #", 2);
		if (((ButtonScreen)window).getAccNum() != null) {
			int choice = Account.findAccount(getAllAccounts(), ((ButtonScreen)window).getAccNum());
			((ButtonScreen)window).setAccNum();
			((ButtonScreen)window).setTextFieldEnabled(false);
			if(choice != -1) {
				selectedAcc = getAllAccounts().get(choice);
			}
			else {
				((ButtonScreen)window).setMessage("The entered account number does not exist", 1);
				((ButtonScreen)window).setButtonLabels("","","","","","","","Done");
				((ButtonScreen)window).setButtonChoice('t');
				do{
					((ButtonScreen)window).setTime();
					buttonChoice = ((ButtonScreen)window).getButtonChoice();
				} while (buttonChoice != 7);
				depositMenu();
			}
		}
		else if(buttonChoice<clientAccounts.size()-1) {
			selectedAcc = clientAccounts.get(buttonChoice);
		}
		else if(buttonChoice == 6) {
			if (signatoryAccounts.size() == 0)
				depositMenu();
			else {
				text = "";
				((ButtonScreen)window).setButtonLabels("","","","","","","","Cancel");
				text += "Which business account would you like to deposit to?\n\n";
				((ButtonScreen)window).setMessage(text+showUserAccounts(signatoryAccounts), 1);
				letter = 'A';
				for (int i= 0; i<signatoryAccounts.size();i++) {
					((ButtonScreen)window).setButtonLabel(letter.toString(),i);
					ascii  = (int)letter +1;
					letter = (char)ascii;
				}
				((ButtonScreen)window).setButtonChoice('t');
				do{
					((ButtonScreen)window).setTime();
					buttonChoice = ((ButtonScreen)window).getButtonChoice();
				} while (buttonChoice != 7 && (buttonChoice >signatoryAccounts.size()-1 || buttonChoice == -1));
				if (buttonChoice < signatoryAccounts.size()) {
					selectedAcc = signatoryAccounts.get(buttonChoice);
				}
				else if (buttonChoice == 7) {
					depositMenu();
				}
			}
		}
		if (selectedAcc != null)
			ABMDeposit(selectedAcc);
		menu();
	}
	
	private static void ABMDeposit(Account acc) {
		String text = "";
		int buttonChoice;
		double amount;
		
		text += String.format("\n\n\n\n\n\t\t      %s", acc.toString());
		text += String.format("\n\n\t\tOld Balance: $ %,.2f",acc.currentBalance());
		((ButtonScreen)window).setButtonChoice('t');
		amount = getAmount();
		acc.deposit(amount);
		t.recordTransaction(client.getFullName(), "deposit", String.format("$ ,.2f",amount), acc.getAccNum());
		FileManager.saveData(cardList, personalClientData, businessClientData, t.getLog());
		text += String.format("\n\n\t\tNew Balance: $ %,.2f",acc.currentBalance());
		((ButtonScreen)window).setButtonLabels("","","","","","","","Done");
		((ButtonScreen)window).setMessage(text, 1);
		((ButtonScreen)window).setButtonChoice('t');
		buttonChoice = ((ButtonScreen)window).getButtonChoice();
		do{
			((ButtonScreen)window).setTime();
			buttonChoice = ((ButtonScreen)window).getButtonChoice();
		} while (buttonChoice != 7);
	}
	
	
	private static void initialize() {
        //                            TRN,         Last Name, First Name,Address,         Parish,    Phone #1, Phone #2  , accType, AccBalace
        accountData.add(new String[]{"011111111", "ATL Ltd.","ATL Ltd.","33 Cherry Lane","Kingston","7705067","8765567","investment","45000","savings","586000"});
        accountData.add(new String[]{"023456789", "Sangsters","Sangsters","6 Mimosa Close","Kingston","3368736","8599403","chequing","1500000"});
        accountData.add(new String[]{"029564873","Burger King","Burger King","15 Cypress Ave.","Kingston","4430098","7382920","savings","1009","chequing","843000"});
        accountData.add(new String[]{"050375967","KFC Ltd.","KFC Ltd.","28 Igsora Close","Kingston","4443322","3345678","chequing","347890"});
        accountData.add(new String[]{"058086900","John's","John's","11 Magnolia Ave.","Kingston","5677877","8493321","investment","999998"});
        //                            TRN,     Last Name, First Name, Address,    Parish,    Phone #, Card #, Card pin, accType, AccBalace
        accountData.add(new String[]{"111111111", "James","Mark","33 Cherry Lane","Kingston","7705067","000000","1234","savings","500000","direct banking","90000"});
        accountData.add(new String[]{"123456789", "Dobbs","Martha","6 Mimosa Close","Kingston","3368736","111111","1234","direct banking", "100000"});
        accountData.add(new String[]{"109564873","Dunkley","Mary","15 Cypress Ave.","Kingston","4430098","222222","1234","savings", "2500000","chequing","750000"});
        accountData.add(new String[]{"150375967","Morgan","Jesse","28 Igsora Close","Kingston","4443322","333333","1234","investment","3000000"});
        accountData.add(new String[]{"158086900","Hewwit","John","11 Magnolia Ave.","Kingston","5677877","444444","1234","chequing","350000"});
    }
	
	 private static void  createObjects() {
	        String[] ai;
	        for (int i=0;i<accountData.size();i++ ) {
	            ai = accountData.get(i);
	            if (ai[0].startsWith("1")) {
	                PersonalClient pc = new PersonalClient(ai[0],ai[1],ai[2],ai[3],ai[4],ai[5],ai[6],ai[7]);
	                
	                try{
	                    for(int j = 8; j<ai.length;j+=2){
	                        pc.addAccount(ai[j],Double.parseDouble(ai[j+1]));
	                        
	                    }
	                }catch(Exception e){}
	                cardList.add(pc.getCard());
	                personalClientData.add(pc);
	            } else {
	                BusinessClient bc = new BusinessClient(ai[0],ai[1],ai[2],ai[3],ai[4],ai[5],ai[6]);

	                try{
	                    for(int m = 7; m <ai.length;m+=2){
	                        bc.addAccount(ai[m],Double.parseDouble(ai[m+1]));
	                    }
	                }catch(Exception e){}
	                businessClientData.add(bc);
	            }
	        }
	       
	        assignSignatories(0);
	        assignSignatories(1);
	        assignSignatories(2);
	        assignSignatories(3);
	        assignSignatories(2,3);
	        assignSignatories(4);

	 }
	 
	 private static void assignSignatories(int pCIndex, int bCIndex){
	        personalClientData.get(pCIndex).addBusiness(businessClientData.get(bCIndex));
	        businessClientData.get(bCIndex).addSignatory(personalClientData.get(pCIndex));
	 }

	 private static void assignSignatories(int index){
	        assignSignatories(index, index);
	 }

}
