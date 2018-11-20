package ABMBackend;

import java.io.Serializable;
import java.util.*;



public class PersonalClient extends Client implements Serializable{
    private String surname, firstname, telephone;
    private ArrayList<BusinessClient> signatoryOf = new ArrayList<BusinessClient>();
    private ABMCard card;

    public PersonalClient(String ctrn, String sname, String fname, String address_, String parish_, String tel_){
        super(ctrn, address_, parish_);
        surname = sname;
        firstname = fname;
        telephone = tel_;
    }

    public PersonalClient(String ctrn, String sname, String fname, String address, String parish, String telephone, BusinessClient sig) {
        this(ctrn,sname,fname,address,parish,telephone);
        addBusiness(sig);
    }

    public PersonalClient(String ctrn, String sname, String fname, String address_, String parish_, String tel_, String snum, String pin){
        this(ctrn, sname, fname, address_, parish_, tel_);
        card = new ABMCard(snum,pin,this);
    }

    public void addBusiness(BusinessClient b){
        signatoryOf.add(b);
    }
    


    public void setABMCard(ABMCard ac){
        card = ac;
    }

    public void setABMCard(String snum, String pin){
        setABMCard(new ABMCard(snum,pin,this));
    }

    @Override
    public String getName(){
        return String.format("%s, %s", surname, firstname);
    }

    @Override
    public String getFullName(){
        return getName();
    }

    @Override
    public String getTelephone(){
        return telephone;
    }

    public ABMCard getCard(){
        return card;
    }
    
    public ArrayList<BusinessClient> getBusinesses(){
        return signatoryOf;
    }

    public ArrayList<Account> getSignatoryAccounts(){
    	ArrayList<Account> signatoryAccounts = new ArrayList<Account>();
    	for (BusinessClient bClient : signatoryOf) {
    		signatoryAccounts.addAll(bClient.getAccounts());
    	}
    	return signatoryAccounts;
    }
}
