/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABMBackend;

import java.util.*;
import utils.DateUtil;

/**
 *
 * @author Nathaniel TransactionLogger keeps track of transactions made in an
 * array list of strings.
 */
public class TransactionLogger {

    private static ArrayList<String> log = new ArrayList<>();
    
    /**
     * Stores transaction information in a log
     * @param client name of client performing the action
     * @param action state if the client is depositing or withdrawing (deposits or withdraws)
     * @param amount how much money was added/removed
     * @param accountNum which account did the transaction occur on
     */
    public void recordTransaction(String client, String action, String amount, String accountNum) {
        String info = String.format("%s %s $%s to account %s", client, action, amount, accountNum);
        recordTransaction(info);
    }

    /**
     * Stores transaction information in a log
     * @param info String in the following format: [client] [action] $[amount] to account [account number]
     */
    public void recordTransaction(String info) {
        info = DateUtil.today() + " " + info;
        log.add(info);
    }

    public ArrayList<String> getLog() {
        return log;
    }
    
    public void setLog(ArrayList<String> logIn){
        log = logIn;
    }
    
    @Override
    public String toString(){
        String s = "";
        s = log.stream().map((p) -> p + "\n").reduce(s, String::concat);
        return s;
    }
}
