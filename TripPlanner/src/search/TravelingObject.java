package search;
import java.util.Date;

/**
 *
 * @author Ísak
 */
public class TravelingObject {
    private String id;
    private Date startDate, endDate;
    private double lat, lon, price, rating;
    
    public TravelingObject(String ID, Date SD, Date ED, double lat, double lon, double price, double rating) {
        this.id = ID; 
        this.startDate=SD;
        this.endDate=ED;
        this.lat = lat; 
        this.lon = lon; 
        this.price = price; 
        this.rating= rating;
    }
    

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
