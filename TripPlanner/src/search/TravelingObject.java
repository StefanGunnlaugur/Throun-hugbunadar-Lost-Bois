package search;
import java.util.Date;

/**
 *
 * @author Ísak
 */
public class TravelingObject {
    private Date startDate, endDate;
    private double lat, lon, price, rating;
    private String id;
    

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lat;
    }
    
    public Date getSD() {
        return this.startDate;
    }
    
    public Date getED() {
        return this.endDate;
    }
    
    public String getID() {
        return this.id;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public double getRating() {
        return this.rating;
    }

}
