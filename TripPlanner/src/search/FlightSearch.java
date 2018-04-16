package search;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class FlightSearch {
    
    // Talar við db hjá hinum hópunum 
    private ArrayList<Flight> flights; 
    private Date date;
    private String location, departureLocation;
    
   
    public FlightSearch(Date date, String departureLocation, String location ) {
        this.flights = new ArrayList<Flight>();
        this.date = date;
        this.location = location;
        this.departureLocation = departureLocation;
        
        // Sækja flug frá flughóp(startingdate, enddate 
        
        // --------- FAKE DATA FOR TESTING --------

        ArrayList<Flight> testing = new ArrayList<Flight>();

        Date d1 = new Date(1525166100000L);
        Date d2 = new Date(1525177800000L);
        Date d3 = new Date(1525242600000L);
        Date d4 = new Date(1525291200000L);
        Date d5 = new Date(1525303800000L);
        Date d6 = new Date(1525343400000L);
        Date d7 = new Date(1525359600000L);
        Date d8 = new Date(1525384800000L);
        Date d9 = new Date(1525416300000L);
        Date d10 = new Date(1525416600000L);
        Date d11 = new Date(1525464600000L);
        Date d12 = new Date(1525469400000L);
        Date d13 = new Date(1525555800000L);
        Date d14 = new Date(1525501800000L);
        Date d15 = new Date(1525528800000L);
        
        Flight f1 = new Flight("id1", d1, "Akureyri", 15000, 15000, 2.4, "Reykjavík", "Air-Iceland", "sæti 10", 30 );
        Flight f2 = new Flight("id2", d3, "Reykjavík", 8000, 14400, 4.5, "Akureyri", "flugfélag", "sæti 20", 50 );
        Flight f3 = new Flight("id3", d2, "Akureyri", 13000, 15000, 1.4, "Keflavík", "Air-Iceland", "sæti 30", 30 );
        Flight f4 = new Flight("id4", d6, "Reykjavík", 16500, 14400, 4.5, "Akureyri", "flugfélag", "sæti 40", 30 );
        Flight f5 = new Flight("id5", d4, "Akureyri", 12500, 15000, 3.4, "Reykjavík", "Air-Iceland", "sæti 03", 30 );
        Flight f6 = new Flight("id6", d5, "Keflavík", 29000, 14400, 4.2, "Reykjavík", "KefAir", "sæti 1", 30 );
        Flight f7 = new Flight("id7", d7, "Reykjavík", 22000, 14400, 4.5, "Akureyri", "flugfélag", "sæti 1", 30 );
        Flight f8 = new Flight("id8", d8, "Akureyri", 25500, 14400, 4.0, "Keflavík", "flugfélag", "sæti 1", 30 );
        Flight f9 = new Flight("id9", d9, "Reykjavík", 30000, 14400, 3.2, "Akureyri", "KefAir", "sæti 1", 30 );
        Flight f10 = new Flight("id10", d10, "Keflavík", 9000, 14400, 3.3, "Reykjavík", "KefAir", "sæti 1", 30 );
        Flight f11 = new Flight("id11", d11, "Akureyri", 7000, 14400, 2.7, "Reykjavík", "flugfélag", "sæti 1", 30 );
        Flight f12 = new Flight("id12", d12, "Reykjavík", 2500, 14400, 3.8, "Akureyri", "KefAir", "sæti 1", 30 );
        Flight f13 = new Flight("id13", d13, "Keflavík", 9900, 14400, 2.1, "Akureyri", "flugfélag", "sæti 1", 30 );
        Flight f14 = new Flight("id14", d14, "Akureyri", 26000, 14400, 4.9, "Reykjavík", "flugfélag", "sæti 1", 30 );
        Flight f15 = new Flight("id15", d15, "Reykjavík", 8800, 14400, 5, "Akureyri", "flugfélag", "sæti 1", 30 );
        
        testing.addAll(Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15));
        
        for (Flight flight: testing){
             boolean add = true;
             if (date!=null && !isSameDay(flight.getStartDate(), date)){
                 add = false;                
             } 
             if (location!=null && !location.isEmpty() && location!=flight.getLocation()){
                 add = false;
             }
             if (departureLocation!=null && !departureLocation.isEmpty() &&
                     departureLocation!=flight.getDepartureLocation()){
                 add = false;
             }
             if(add){
                this.flights.add(flight);
             }
        }
    }
    
    private boolean isSameDay (Date date1, Date date2) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        return fmt.format(date1).equals(fmt.format(date2));
    }
    
    public ArrayList<Flight> getFlights() {
        return this.flights;
    }
    
}
