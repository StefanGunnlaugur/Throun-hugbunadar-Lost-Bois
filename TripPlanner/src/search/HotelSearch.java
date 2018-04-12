package search;

import java.util.Date;

public class HotelSearch {

    // Talar við db hjá hinum hópunum 
    private Hotel[] hotels; 
    private Date startDate, enddate;

    
    public HotelSearch() {
        Date date1 = new Date(1529452900000L);
        Date date2 = new Date(1529884300000L);
        Hotel h1 = new Hotel("hotel-1", date1, date2, "Akureyri", 10000, 3000, 3.4, 30 );
        Hotel h2 = new Hotel("Hotel-2", date1, date2, "Reykjavík", 50000, 10000, 4.5, 12 );
        this.hotels = new Hotel[]{h1, h2};
    }
    
    public Hotel[] getHotels() {
        return this.hotels;
    }
    
}
