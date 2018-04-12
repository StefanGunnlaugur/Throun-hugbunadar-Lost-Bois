package search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightSearch {
    
    // Talar við db hjá hinum hópunum 
    private Flight[] flights; 
    private Date startDate, enddate;
    
   
    public FlightSearch() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date d1 = sdf.parse("02-05-2018 17:20:00");
        Date d2 = sdf.parse("04-05-2018 12:00:00");
        Date d3 = sdf.parse("03-05-2018 19:20:00");
        Date d4 = sdf.parse("08-05-2018 17:00:00");
        Date d5 = sdf.parse("10-05-2018 10:20:00");
        Date d6 = sdf.parse("02-05-2018 20:20:00");
        
        Flight fl1 = new Flight("id1", d1, d5, "Akureyri", 25000, 15000, 2.4, "Reykjavík", "Air-Iceland", "sæti 10", 30 );
        Flight fl2 = new Flight("id2", d3, d6, "Reykjavík", 29000, 14400, 4.5, "Akureyri", "flugfélag", "sæti 20", 50 );
        Flight fl3 = new Flight("id3", d2, d4, "Akureyri", 25000, 15000, 1.4, "Reykjavík", "Air-Iceland", "sæti 30", 30 );
        Flight fl4 = new Flight("id4", d1, d6, "Reykjavík", 29000, 14400, 4.5, "Akureyri", "flugfélag", "sæti 40", 30 );
        Flight fl5 = new Flight("id5", d3, d4, "Akureyri", 25000, 15000, 3.4, "Reykjavík", "Air-Iceland", "sæti 03", 30 );
        Flight fl6 = new Flight("id6", d3, d5, "Reykjavík", 29000, 14400, 4.2, "Akureyri", "flugfélag", "sæti 1", 30 );
        this.flights = new Flight[]{fl1, fl2, fl3, fl4, fl5, fl6}; 
    }
    
    public Flight[] getFlights() {
        return this.flights;
    }
    
}
