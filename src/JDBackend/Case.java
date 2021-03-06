
import java.io.File;
import java.util.*;

public class Case {
    private String caseID;
    private Date startDate;
    private ArrayList<String> status;
    private double baseFee;
    private ArrayList<Cost> caseCosts=new ArrayList<Cost>();
    private String clientName;
    private CaseType caseType;
    private ArrayList<Contact> contact=new ArrayList<Contact>();
    private ArrayList<String> subTypes= new ArrayList<String>();
    private ArrayList<File> caseFiles=new ArrayList<File>();
    private Date endDate;
    private boolean inProgress;

    public Case() {
    }

    public String getCaseID() {
        return caseID;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ArrayList<String> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<String> status) {
        this.status = status;
    }

    public double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(double baseFee) {
        this.baseFee = baseFee;
    }

    public ArrayList<Cost> getCaseCosts() {
        return caseCosts;
    }

    public void setCaseCosts(ArrayList<Cost> caseCosts) {
        this.caseCosts = caseCosts;
    }
    
    public double getCostToDate(){
        double total = 0;
        
        
        
    }
    
    }
    
    public void setContacts(ArrayList<Contact> contact){
        this.contact=contact;
    }
    
    public ArrayList<Contact> getContact(){
        return contact;
    }
    
    public void addContact(setContacts){
        contact.add(getContact);
    }
    

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    public ArrayList<String> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(ArrayList<String> subTypes) {
        this.subTypes = subTypes;
    }

    public ArrayList<File> getCaseFiles() {
        return caseFiles;
    }

    public void setCaseFiles(ArrayList<File> caseFiles) {
        this.caseFiles = caseFiles;
    }
    
    public void addCaseFile(ArrayList<File>caseFiles){
        caseFiles.add(caseFiles)
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
    

    public Case(String caseID, Date startDate, ArrayList<String> status, double baseFee, String clientName, CaseType caseType, ArrayList<String> subTypes, ArrayList<File> caseFiles, Date endDate, boolean inProgress) {
        this.caseID = caseID;
        this.startDate = startDate;
        this.status = status;
        this.baseFee = baseFee;
        this.clientName = clientName;
        this.caseType = caseType;
        this.subTypes = subTypes;
        this.caseFiles = caseFiles;
        this.endDate = endDate;
        this.inProgress = inProgress;
    }
    




}