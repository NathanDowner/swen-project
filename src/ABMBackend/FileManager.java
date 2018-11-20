/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ABMBackend;

import java.io.*;
import java.util.*;

/**
 *
 * @author Nathaniel
 */
public class FileManager {
    private ArrayList<PersonalClient> pCD = new ArrayList<PersonalClient>();
    private ArrayList<BusinessClient> bCD = new ArrayList<BusinessClient>();
    private ArrayList<ABMCard> cardList = new ArrayList<ABMCard>();
    private ArrayList<String> log = new ArrayList<>();
    
    /**
     * Creating a new FileManager loads all relevant data from files into the File Manager Object. This information can
     * be returned using the various getter methods;
     */
    public FileManager(){
        //loadData();
    }
    
    public static boolean saveData(ArrayList<ABMCard> ABMList, ArrayList<PersonalClient> pCl, 
            ArrayList<BusinessClient> bCl, ArrayList<String> log){
        try{
            FileOutputStream fos;
            ObjectOutputStream oos;
            String fileName;
            //Saving the ABMCard List
            try{
                fileName = "ABMCards.txt";
                fos = new FileOutputStream(fileName);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(ABMList);
                oos.close();
            } catch(Exception e) {System.out.println("Card List not saved");}
            
            //Saving the Personal Client List
            try{
                fileName = "pClient.txt";
                fos = new FileOutputStream(fileName);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(pCl);
                oos.close();
            } catch(Exception e) {System.out.println("PClient List not saved");}
            
            //Saving the Business Client List
            try{
                fileName = "bClient.txt";
                fos = new FileOutputStream(fileName);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(bCl);
                oos.close();
            } catch(Exception e) {System.out.println("BClient List not saved");}
            
            //Saving the log
            try{
                fileName = "log.txt";
                fos = new FileOutputStream(fileName);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(log);
                oos.close();
            } catch(Exception e) {System.out.println("Log not saved");}
            
            return true;
        } catch (Exception ex) {
            System.out.println("Data Not Saved");
            return false;
        }
    }
    
    public boolean loadData(){
        try{
            ObjectInputStream ois;
            FileInputStream fin;
            String fileName;
            
            //Loading the Personal Client List
            try{
                fileName = "pClient.txt";
                fin = new FileInputStream(fileName);
                ois = new ObjectInputStream(fin);
                pCD = (ArrayList<PersonalClient>) ois.readObject();
                ois.close();
            } catch (Exception e){
            	System.out.println("Could not load PClient List");
            	return false;
            	}
            
            //Loading the Business Client List
            try{
                fileName = "bClient.txt";
                fin = new FileInputStream(fileName);
                ois = new ObjectInputStream(fin);
                bCD = (ArrayList<BusinessClient>) ois.readObject();
                ois.close();
            } catch (Exception e){System.out.println("Could not load BClient List");}
            
            //Loading the log
            try{
                fileName = "log.txt";
                fin = new FileInputStream(fileName);
                ois = new ObjectInputStream(fin);
                log = (ArrayList<String>) ois.readObject();
                ois.close();
            } catch (Exception e){System.out.println("Could not load Log");}
            
            linkData();
            return true;
        } catch (Exception ex) {
            System.out.println("Failed to load Data");
            return false;
        }
    }
   
    private void linkData(){
        for (PersonalClient p: pCD)
            cardList.add(p.getCard());
    }
    
    public ArrayList<ABMCard> getABMCards(){
        return cardList;
    }
    
    public ArrayList<PersonalClient> getPersonalClients(){
        return pCD;
    }
    
    public ArrayList<BusinessClient> getBusinessClients(){
        return bCD;
    }
    
    public ArrayList<String> getTransactionLog(){
        return log;
    }
    
}
