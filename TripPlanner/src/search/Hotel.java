package search;

import java.util.Date;

public class Hotel extends TravelingObject {
    private int roomnr;

    public Hotel(String ID, Date SD, Date ED, String location, 
            double audltPrice, double childPrice, double rating, int roomnr) {
        super(ID, SD, ED, location, audltPrice, childPrice, rating);
        this.roomnr = roomnr; 
    }

    public int getRoomnr() {
        return roomnr;
    }

    
}
