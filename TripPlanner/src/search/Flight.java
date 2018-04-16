package search;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight extends TravelingObject {
    private String flightNr, departureLocation, airline, shortDate;
    private int duration; 

    public Flight(String ID, Date date, String location, 
            double audltPrice, double childPrice, double rating,
            String departureLocation, String  airline, String flightNr, int duration) {
        
        super(ID, date, date, location, audltPrice, childPrice, rating);
        
        this.flightNr = flightNr; 
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
    
    public String getAirline() {
        return airline;
    }
    
    public String getDepartureLocation() {
        return departureLocation;
    }
    
    public String getShortDate() {
        return shortDate;
    }

    public String getFlightNumber() {
        return flightNr;     
    }

}
