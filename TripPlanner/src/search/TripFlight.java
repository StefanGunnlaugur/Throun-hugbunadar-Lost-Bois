package search;

import flightGroup.hopur9fvinnsla.Flight;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TripFlight extends TravelingObject {
    private String flightNr, departureLocation, airline, shortDate;
    private int duration, luggagePrice, handLuggagePrice;
    private List<String> availableSeatList; 
    private Flight flight;


    public TripFlight(String ID, Date date, String location,
        int audltPrice, int childPrice, double rating,
        String departureLocation, String  airline, String flightNr, int duration) {
        
        super(ID, date, date, location, audltPrice, childPrice, rating);
        
        this.flightNr = flightNr; 
        this.departureLocation = departureLocation; 
        this.duration = duration; 
        this.airline = airline;        
        Format formatter = new SimpleDateFormat("dd-MMM HH:mm");
        this.shortDate = formatter.format(date);
    }

    TripFlight(Flight f, double rating) {
        super( f.getId()+"" , f.getDeparture(), f.getArrival(), f.getDestination(),
                f.getAdultPrice(), f.getChildPrice(), rating);
        this.flight = f;
        this.airline = f.getAirline();
        this.flightNr = f.getFlightNumber();
        this.duration = f.getDuration();
        this.departureLocation = f.getOrigin();
        this.availableSeatList = f.getAvailableSeatList();
        this.handLuggagePrice = f.getHandLuggagePrice();
        this.luggagePrice = f.getLuggagePrice();
        Format formatter = new SimpleDateFormat("dd-MMM HH:mm");
        this.shortDate = formatter.format(f.getDeparture());
    }
        
    // Skilar tíma flugs í ms
    public long getDuration() {
        return duration*(long)60000; 
    }
    
    public Flight getFlight() {
        return flight;
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
    
    public List<String> getAvailableSeatList() {
        return availableSeatList;
    }
    
    public int getHandLuggagePrice(){
        return handLuggagePrice;
    }
    
    public int getLuggagePrice(){
        return luggagePrice;
    }
}
