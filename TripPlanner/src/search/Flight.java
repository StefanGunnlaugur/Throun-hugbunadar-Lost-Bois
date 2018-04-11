package search;

import java.util.Date;

/**
 *
 * @author Ísak
 */
public class Flight extends TravelingObject {
    private String seatnr;
    private long duration;  

    public Flight(String ID, Date SD, Date ED, double lat, double lon, double price, double rating, String seatnr, long duration) {
        super(ID, SD, ED, lat, lon, price, rating);
        this.seatnr = seatnr; 
        this.duration = duration; 
    }
        
    // Skilar tíma flugs í ms
    public long getDuration() {
        return duration; 
    }
    
    // Skilar tíma flugs í ms
    public String getSeatnr() {
        return seatnr; 
    }

}
