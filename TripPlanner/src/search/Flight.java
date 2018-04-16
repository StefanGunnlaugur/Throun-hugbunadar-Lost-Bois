package search;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight extends TravelingObject {
    private String seatnr, departureLocation, airline, shortDate;
    private int duration; 

    public Flight(String ID, Date date, String location, 
            double audltPrice, double childPrice, double rating,
            String departureLocation, String  airline, String seatnr, int duration) {
        
        super(ID, date, date, location, audltPrice, childPrice, rating);
        
        this.seatnr = seatnr; 
        this.departureLocation = departureLocation; 
        this.duration = duration; 
        this.airline = airline;
        
        Format formatter = new SimpleDateFormat("dd-MMM HH:mm");
        this.shortDate = formatter.format(date);
    }
        
    // Skilar tíma flugs í ms
    public long getDuration() {
        return duration*(long)60000; 
    }
    
    // Skilar tíma flugs í ms
    public String getSeatnr() {
        return seatnr; 
    }
    
    public String getAirline() {
        return airline;
    }
    
    public String getDepartureLocation() {
        return departureLocation;
    }
    
    public String getShortDate() {
        return shortDate;
    }

}
