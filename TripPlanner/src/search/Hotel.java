package search;

import java.util.Date;

/**
 *
 * @author Ísak
 */
public class Hotel extends TravelingObject {
    private int roomnr;

    public Hotel(String ID, Date SD, Date ED, double lat, double lon, double price, double rating, int roomnr) {
        super(ID, SD, ED, lat, lon, price, rating);
        this.roomnr = roomnr; 
    }

    public int getRoomnr() {
        return roomnr;
    }

    
}
