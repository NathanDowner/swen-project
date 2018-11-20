package ABMBackend;

import java.io.Serializable;

public enum Parish implements Serializable{
    KingstonStAndrew("Kingston and St. Andrew"),
    StThomas("St. Thomas"),
    Portland("Portland"),
    StMary("St. Mary"),
    StAnn("St. Ann"),
    Trelawny("Trelawny"),
    StJames("St. James"),
    Hanover("Hanover"),
    Westmoreland("Westmoreland"),
    StElizabeth("St. Elizabeth"),
    Manchester("Manchester"),
    Clarendon("Clarendon"),
    StCatherine("St. Catherine");

    private final String fullname;
	
    Parish(String name){
        this.fullname = name;
    }
	
    public String fullName(){
        return this.fullname;
    }
    public static Parish findByName(String name){
        for (Parish pq: Parish.values()){
            if (name.equalsIgnoreCase(pq.fullName())){
                return pq;
            }
        }
        return Parish.KingstonStAndrew;
    }
}