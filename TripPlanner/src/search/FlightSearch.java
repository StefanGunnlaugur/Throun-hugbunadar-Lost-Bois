package search;

import java.util.Date;

public class FlightSearch {
    
    // Talar við db hjá hinum hópunum 
    private Flight[] flights; 
    private Date startDate, enddate;
    
   
    public FlightSearch() {
        Date date1 = new Date(1529452800000L);
        Date date2 = new Date(1529884800000L);
        Flight fl1 = new Flight("id1", date1, date2, "Akureyri", 25000, 15000, 3.4, "Reykjavík", "sæti 3", 30 );
        Flight fl2 = new Flight("þetternæs", date1, date2, "Reykjavík", 29000, 14400, 4.5, "Akureyri", "sæti 100", 30 );
        this.flights = new Flight[]{fl1, fl2}; 
    }
    
    public Flight[] getFlights() {
        return this.flights;
    }
    
}
