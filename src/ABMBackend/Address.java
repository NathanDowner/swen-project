package ABMBackend;

import java.io.Serializable;

public class Address implements Serializable{

    private String address;
    private Parish parish;

    public Address(String street, Parish p){
        this.address = street;
        this.parish = p;
    }

    public Address(String street, String p){
        this.address = street;
        this.parish = Parish.findByName(p);
    }

    public String getAddress(){
        return String.format("%s, %s", this.address, this.parish.fullName());
    }
    public String getAddressOnly(){
        return this.address;
    }

    public Parish getParish(){
        return this.parish;
    }

    @Override
    public String toString(){
        return getAddress();
    }
}