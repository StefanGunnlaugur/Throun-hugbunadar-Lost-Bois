package search;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tour extends TravelingObject {
   private int duration; 
   private String name, shortDate;

    public Tour(String ID, Date date, String location, 
            int audltPrice, int childPrice, double rating,
            String name, int duration) {
        
        super(ID, date, date, location, audltPrice, childPrice, rating);
        
        this.duration = duration; 
        this.name = name;
        Format formatter = new SimpleDateFormat("dd-MMM HH:mm");
        this.shortDate = formatter.format(date);
    }

    public int getDuration() {
        return duration; 
    }
    
    public String getName() {
        return name;
    }
     
    public String getShortDate() {
        return shortDate;
    }
}
