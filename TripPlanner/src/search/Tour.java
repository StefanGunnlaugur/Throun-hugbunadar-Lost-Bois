package search;

import java.util.Date;

public class Tour extends TravelingObject {
   private int duration; 

    public Tour(String ID, Date SD, Date ED, String location, 
            double audltPrice, double childPrice, double rating, int duration) {
        super(ID, SD, ED, location, audltPrice, childPrice, rating);
        this.duration = duration; 
    }

    public int getDuration() {
        return duration; 
    }
}
