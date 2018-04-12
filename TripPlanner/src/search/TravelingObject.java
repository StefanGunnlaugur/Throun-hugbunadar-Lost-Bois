package search;
import java.util.Date;

public class TravelingObject {
    private String id, location;
    private Date startDate, endDate;
    private double adultPrice, childPrice, rating;
    
    public TravelingObject(String ID, Date SD, Date ED, String location, 
            double audltPrice, double childPrice, double rating) {
        this.id = ID; 
        this.startDate=SD;
        this.endDate=ED;
        this.location = location;
        this.adultPrice = audltPrice;
        this.childPrice = childPrice;
        this.rating = rating;       
    }
    
    // Bara fyrir hnit--- ef við viljum
    public double getLat() {
        double lat = 0; 
        switch(this.location) {
            case "Reykjavík": lat = 64.132716;
            break;
            case "Akureyri": lat = 65.654509;
            break;
        }
        return lat;
    }

    // Bara fyrir hnit--- ef við viljum
    public double getLon() {
        double lon = 0; 
        switch(this.location) {
            case "Reykjavík": lon = -21.946734;
            break;
            case "Akureyri": lon = -18.076340;
            break;
        }
        return lon;
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
    
    public double getAdultPrice() {
        return this.adultPrice;
    }
    
    public double getChildPrice() {
        return this.childPrice;
    }
    
    public double getRating() {
        return this.rating;
    }
    
    public String getLocation() {
        return this.location;
    }

}
