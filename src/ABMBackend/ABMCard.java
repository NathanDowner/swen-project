package ABMBackend;

import java.io.Serializable;

public class ABMCard implements Comparable, Serializable{
    private String snum, pin;
    private PersonalClient pClient;

    public ABMCard(String snum, String pin, PersonalClient pClient){
        this.snum = snum;
        this.pin = pin;
        this.pClient = pClient;
    }
    
    public ABMCard(String snum, String pin){
        this.snum = snum;
        this.pin = pin;
    }

    public String getSerialNumber(){
        return snum;
    }

    public String getPin(){
        return pin;
    }

    public PersonalClient getClient(){
        return pClient;
    }
    
    public String toString(){
        return " Serial Number:" + snum + " Pin:" + pin;
    }

    @Override
    public int compareTo(Object o) {
        if(snum.equals(((ABMCard)o).getSerialNumber()) && pin.equals(((ABMCard)o).getPin()))
            return 0;
        else if(snum.equals(((ABMCard)o).getPin()))
            return 1;
        else
            return -1;
    }
}
