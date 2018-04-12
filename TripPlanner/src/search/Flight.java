package search;

import java.util.Date;

public class Flight extends TravelingObject {
    private String seatnr, departure;
    private int duration; 

    public Flight(String ID, Date SD, Date ED, String location, 
            double audltPrice, double childPrice, double rating,
            String departure, String seatnr, int duration) {
        super(ID, SD, ED, location, audltPrice, childPrice, rating);
        this.seatnr = seatnr; 
        this.departure = departure; 
        this.duration = duration; 
    }
        
    // Skilar tíma flugs í ms
    public long getDuration() {
        return duration*(long)60000; 
    }
    
    // Skilar tíma flugs í ms
    public String getSeatnr() {
        return seatnr; 
    }

}
