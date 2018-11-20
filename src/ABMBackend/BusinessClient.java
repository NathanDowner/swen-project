package ABMBackend;

import java.io.Serializable;
import java.util.*;

public class BusinessClient extends Client implements Serializable{
    private String tradingName;
    private String officialName;
    private String telephone;
    private String telephone2;
    private ArrayList<PersonalClient> signatories = new ArrayList<PersonalClient>();

    public BusinessClient(String ctrn, String tname, String oname, String address_, String parish_, String tel1_,
    String tel2_){
        super(ctrn, address_, parish_);
        tradingName = tname;
        officialName = oname;
        telephone = tel1_;
        telephone2 = tel2_;
    }

    public BusinessClient(String ctrn, String tname, String oname, String address_, String parish_, String tel1_,
    String tel2_, PersonalClient p){
        this(ctrn,tname,oname,address_,parish_,tel1_,tel2_);
        addSignatory(p);
    }

    public void addSignatory(PersonalClient p){
        signatories.add(p);
    }

    public ArrayList<PersonalClient> getSignatories() {
        return this.signatories;
    }

    public String getName(){
        return tradingName;
    }

    public String getFullName(){
        return String.format("%s / %s", tradingName,officialName);
    }

    public String getTelephone(){
        if (telephone2.length() > 1)
            return String.format("%s, %s",telephone,telephone2);
        else
            return telephone;
    }
}
