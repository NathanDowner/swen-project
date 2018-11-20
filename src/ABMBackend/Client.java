package ABMBackend;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Client implements Serializable{

    protected String trn;
    protected ArrayList<Address> addresses;
    protected ArrayList<Account> accounts;

    public abstract String getName();
    public abstract String getFullName();
    public abstract String getTelephone();


    public Client(String clid, String address_, String parish_){
        accounts = new ArrayList<Account>();
        addresses = new ArrayList<Address>();
        trn = clid;

        Parish pa = Parish.findByName(parish_);
        addresses.add(new Address(address_, pa));
    }
    
    public String getTRN(){
        return trn;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }
    public void addAccount(String type, double balance){
        type = String.join("", type.split(" "));
        AccountType act = AccountType.valueOf(type);
        addAccount(new Account(act, balance));
    }
    
    public void addAddress(Address addr_){
        addresses.add(addr_);
    }

    public Account getAccount(int seq){
        if (seq < accounts.size())
            return accounts.get(seq);
        else
            return null;
    }
    
    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }
    
    public static ArrayList<Account> getWithdrawalAccounts(ArrayList<Account> accounts){
    	ArrayList<Account> withdrawalAccounts = new ArrayList<Account>();
    	for(Account acc : accounts) {
    		if(!acc.getAccountType().equals(AccountType.investment)) {
				withdrawalAccounts.add(acc);
    		}
    	}
    	return withdrawalAccounts;
    }

    public Parish getPrimaryParish(){
        Address p;
        try{
            p = this.addresses.get(0);
        }
        catch(Exception e){
            p = null;
        }
        return p.getParish();
    }

    public String toString(){
        String f = "Client: %s (%s)\n  Tel: %s%s%s";
        String aa, ac;
        ac = "\n  Accounts:";
        for (Account a : accounts){
            ac += String.format("\n    %-20s:    $%,12.2f", a.getType(), a.currentBalance());
        }
        aa = "\n  Address:";
        for (Address b: addresses){
            aa += String.format("\n    %s", b.toString());
        }
        return String.format(f, getName(), trn, getTelephone(), ac, aa);

    }
    
    
        
}
