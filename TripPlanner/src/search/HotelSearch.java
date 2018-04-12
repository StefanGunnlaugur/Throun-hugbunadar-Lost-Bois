package search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HotelSearch {

    // Talar við db hjá hinum hópunum 
    private Hotel[] hotels; 
    private Date startDate, enddate;

    
    public HotelSearch() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date d1 = sdf.parse("02-05-2018 12:00:00");
        Date d2 = sdf.parse("04-05-2018 12:00:00");
        Date d3 = sdf.parse("03-05-2018 12:00:00");
        Date d4 = sdf.parse("08-05-2018 12:00:00");
        Date d5 = sdf.parse("10-05-2018 12:00:00");
        Date d6 = sdf.parse("11-05-2018 12:00:00");
        
        Hotel h1 = new Hotel("hotel-1", d1, d2, "Akureyri", 10000, 3000, 0.4, "Hotel Borg", 30 );
        Hotel h2 = new Hotel("Hotel-2", d3, d6, "Reykjavík", 50000, 10000, 4.2, "Hotel Örk", 12 );
        Hotel h3 = new Hotel("hotel-3", d2, d5, "Akureyri", 10000, 3000, 1.4, "Hotel Kea", 30 );
        Hotel h4 = new Hotel("Hotel-4", d1, d3, "Reykjavík", 50000, 10000, 4.5, "Hotel Saga", 12 );
        Hotel h5 = new Hotel("hotel-5", d2, d5, "Akureyri", 10000, 3000, 3.0, "Hotel Borg", 30 );
        Hotel h6 = new Hotel("Hotel-6", d4, d6, "Reykjavík", 50000, 10000, 4.5, "Hotel Örk", 12 );
        this.hotels = new Hotel[]{h1, h2, h3, h4, h5, h6};
    }
    
    public Hotel[] getHotels() {
        return this.hotels;
    }
    
}
