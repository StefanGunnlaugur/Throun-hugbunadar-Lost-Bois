package TripProcess;


import TripProcess.User;
import TripProcess.Trip;
import java.util.Date;

public class TripBooking {
    private String id; 
    private Trip trip;
    private User user;
    private Date date;
    
    public TripBooking(String id, Trip trip, User user) {
        this.id = id;  
        this.trip = trip;
        this.user = user;
        this.date = new Date(); 
    }
    
    public boolean Book() {
        // Book - flight
        // Book - hotel
        // Book - Tour
        // Save to DB ???? --- sammt ves 
        // Send email
        return true;
    }
    
    public void sendEmail() {
        // Senda staðfestingu
    }
    
    // Fá rating ?? 
}

