package search;

import java.util.Date;

public class Hotel extends TravelingObject {
    private int roomnr;
    private String name;

    public Hotel(String ID, Date SD, Date ED, String location, 
            double audltPrice, double childPrice, double rating, String name, int roomnr) {
        
        super(ID, SD, ED, location, audltPrice, childPrice, rating);
        
        this.name = name;
        this.roomnr = roomnr; 
    }

    public int getRoomnr() {
        return roomnr;
    }
    
    public String getName() {
        return name;
    }

    
}
