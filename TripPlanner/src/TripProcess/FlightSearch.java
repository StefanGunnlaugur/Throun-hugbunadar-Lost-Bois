package TripProcess;

import flightGroup.hopur9fvinnsla.Flight;
import flightGroup.hopur9fvinnsla.FlightService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FlightSearch {
    
    // Talar við db hjá hinum hópunum 
    private ArrayList<TripFlight> flights; 
    private LocalDate date;
    private String destination, origin;
       
    public FlightSearch(Date inputdate, String departureLocation, String location ) {
        this.flights = new ArrayList<TripFlight>();
        FlightService fs = new FlightService();
        List<Flight> searchFlights;
        
        if(inputdate==null && departureLocation == null && location == null){
             searchFlights= fs.getAllFlights(LocalDate.of(2018,05,1), LocalDate.of(2018,05,1).plusWeeks(1));
        }else {
            
        this.flights = new ArrayList<TripFlight>();
        
        if(inputdate!=null){
            this.date = inputdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }else {
            this.date = LocalDate.of(2018,05,1);
        }
        this.destination = location;
        this.origin = departureLocation;
        searchFlights = fs.alternetiveGetFlights(origin, destination, date);
        }
        Random r = new Random();
        for(Flight flight : searchFlights){
            double ratingFix = 1 + (5 - 1) * r.nextDouble();
            ratingFix = Math.round(ratingFix*10);
            flights.add(new TripFlight(flight, ratingFix/10));
        }
        // Sækja flug frá flughóp(startingdate, enddate 
        
        // --------- FAKE DATA FOR TESTING --------
        /*
        ArrayList<TripFlight> testing = new ArrayList<TripFlight>();

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
        
        TripFlight f1 = new TripFlight("id1", d1, "Akureyri", 15000, 15000, 2.4, "Reykjavík", "Air-Iceland", "sæti 10", 30 );
        TripFlight f2 = new TripFlight("id2", d3, "Reykjavík", 8000, 14400, 4.5, "Akureyri", "flugfélag", "sæti 20", 50 );
        TripFlight f3 = new TripFlight("id3", d2, "Akureyri", 13000, 15000, 1.4, "Keflavík", "Air-Iceland", "sæti 30", 30 );
        TripFlight f4 = new TripFlight("id4", d6, "Reykjavík", 16500, 14400, 4.5, "Akureyri", "flugfélag", "sæti 40", 30 );
        TripFlight f5 = new TripFlight("id5", d4, "Akureyri", 12500, 15000, 3.4, "Reykjavík", "Air-Iceland", "sæti 03", 30 );
        TripFlight f6 = new TripFlight("id6", d5, "Keflavík", 29000, 14400, 4.2, "Reykjavík", "KefAir", "sæti 1", 30 );
        TripFlight f7 = new TripFlight("id7", d7, "Reykjavík", 22000, 14400, 4.5, "Akureyri", "flugfélag", "sæti 1", 30 );
        TripFlight f8 = new TripFlight("id8", d8, "Akureyri", 25500, 14400, 4.0, "Keflavík", "flugfélag", "sæti 1", 30 );
        TripFlight f9 = new TripFlight("id9", d9, "Reykjavík", 30000, 14400, 3.2, "Akureyri", "KefAir", "sæti 1", 30 );
        TripFlight f10 = new TripFlight("id10", d10, "Keflavík", 9000, 14400, 3.3, "Reykjavík", "KefAir", "sæti 1", 30 );
        TripFlight f11 = new TripFlight("id11", d11, "Akureyri", 7000, 14400, 2.7, "Reykjavík", "flugfélag", "sæti 1", 30 );
        TripFlight f12 = new TripFlight("id12", d12, "Reykjavík", 2500, 14400, 3.8, "Akureyri", "KefAir", "sæti 1", 30 );
        TripFlight f13 = new TripFlight("id13", d13, "Keflavík", 9900, 14400, 2.1, "Akureyri", "flugfélag", "sæti 1", 30 );
        TripFlight f14 = new TripFlight("id14", d14, "Akureyri", 26000, 14400, 4.9, "Reykjavík", "flugfélag", "sæti 1", 30 );
        TripFlight f15 = new TripFlight("id15", d15, "Reykjavík", 8800, 14400, 5, "Akureyri", "flugfélag", "sæti 1", 30 );
        
        testing.addAll(Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15));
        
        for (TripFlight flight: testing){
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
        }*/
    }
    
    public ArrayList<TripFlight> returnFlights() {
        return this.flights;
    }
    
}
