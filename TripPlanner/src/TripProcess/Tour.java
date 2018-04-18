package TripProcess;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tour extends TravelingObject {
   private String name, shortDate;

    public Tour(String ID, Date date, String location, 
            int price, double rating, String name) {
        
        super(ID, date, date, location, price, price, rating);
        
        this.name = name;
        Format formatter = new SimpleDateFormat("dd-MMM HH:mm");
        this.shortDate = formatter.format(date);
    }
    
    public String getName() {
        return name;
    }
     
    public String getShortDate() {
        return shortDate;
    }
}
