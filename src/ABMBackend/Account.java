package ABMBackend;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable{
    private static int lastAccNum = 3456;
    private String accNum;
    private final AccountType type;
    private double balance;
    private final static double RESERVE = 100;

    public Account(AccountType accType, double accBalance){
        type = accType;
        balance = accBalance;
        this.accNum = getNextAccNum();
    }

    private static String getNextAccNum() {
        lastAccNum++;
        return String.format("%07d",lastAccNum);
    }
    
    public String getAccNum(){
        return this.accNum;
    }

    public String getType(){
        return type.longName();
    }

    public AccountType getAccountType(){
        return type;
    }

    public double currentBalance(){
        return balance;
    }

    public double calcInterest(int days){
        double totalInterest, daysInterest;
        totalInterest = balance * type.interestRate();
        daysInterest = totalInterest * ((double)days/365.25);
        return daysInterest;
    }
    
    public static int findAccount(ArrayList<Account> accList, String accNum) {
    	for (int i = 0; i<accList.size(); i++) {
    		if(accList.get(i).getAccNum().compareTo(accNum) == 0) {
    			return i;
    		}
    	}
    	return -1;
    }

    /**
    * This method accepts a deposit amount
    * @param money The amount of money deposited
    * @return boolean Returns true if the deposit was added, false otherwise
    */
    public boolean deposit(double money){
        balance += money;
        return true;
    }
    

    /**
    * This method accepts a withdrawal amount and, if the withdrawal amount is less than the balance, removes this from the balance
    * @param money The amount of money withdrawn
    * @return boolean Returns true if the withdrawal occurs, false otherwise
    */
    public boolean withdraw(double money){
        if ((money) < balance - RESERVE){
            balance -= (money);
            return true;
        } else
            return false;
    }

    public String toString() {
        return String.format("%s %s",accNum, getType());
    }

}
