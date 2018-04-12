package search;

import java.util.Date;

public class Tour extends TravelingObject {
   private int duration; 
   private String name;

    public Tour(String ID, Date SD, Date ED, String location, 
            double audltPrice, double childPrice, double rating,
            String name, int duration) {
        
        super(ID, SD, ED, location, audltPrice, childPrice, rating);
        
        this.duration = duration; 
        this.name = name;
    }

    public int getDuration() {
        return duration; 
    }
    
    public String getName() {
        return name;
    }
}
