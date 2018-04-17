package search;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hotel extends TravelingObject {
    private int roomnr;
    private String name, shortDate;

    public Hotel(String ID, Date SD, Date ED, String location, 
            int audltPrice, int childPrice, double rating, String name, int roomnr) {
        
        super(ID, SD, ED, location, audltPrice, childPrice, rating);
        
        this.name = name;
        this.roomnr = roomnr;
        
        Format formatter = new SimpleDateFormat("dd-MM");
        this.shortDate = " Frá: " + formatter.format(SD) +  " til: " + formatter.format(ED) ;
    }

    public int getRoomnr() {
        return roomnr;
    }
    
    public String getName() {
        return name;
    }
     
    public String getShortDate() {
        return shortDate;
    }

    
}
