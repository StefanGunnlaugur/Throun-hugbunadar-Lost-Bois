package TripProcess;


public class User {
    private String id, fName, lName, email;
    private double cardnr;
    
    public User(String id, String fName, String lName, String email, double cardnr) {
        this.id = id; 
        this.fName = fName; 
        this.lName = lName;
        this.email = email;
        this.cardnr = cardnr;
    }
    
    public String getId() {
        return id;
    }
    
    public String getFName() {
        return fName;
    }
    
    public String getLName() {
        return lName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public double getCardnr() {
        return cardnr;
    }
    
}
