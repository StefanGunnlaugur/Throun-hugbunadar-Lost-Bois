package TripProcess;
import java.util.Date;

public class TravelingObject {
    private String id, location;
    private Date startDate, endDate;
    private double rating;
    private int adultPrice, childPrice;
    
    public TravelingObject(String ID, Date SD, Date ED, String location, 
        int audltPrice, int childPrice, double rating) {
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
            case "Akureyri": lat = 65.683530;
            break;
            case "Nuuk": lat = 64.18347;
            break;
            case "Vestmannaeyjar": lat = 63.437679;
            break;
            case "Höfn": lat = 64.249703;
            break;
            case "Húsavík": lat = 66.044971;
            break;
            case "Ísafjörður": lat = 66.061106;
            break;
            case "Isafjörður": lat = 66.061106;
            break;
            case "Egilsstaðir": lat = 65.266874;
            break;
            case "Egilsstadir": lat = 65.266874;
            break;
            case "Kulusuk": lat = 65.568090;
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
            case "Nuuk": lon = -51.72157;
            break;
            case "Vestmannaeyjar": lon = -20.267321;
            break;
            case "Höfn": lon = -15.202008;
            break;
            case "Húsavík": lon = -17.338344;
            break;
            case "Ísafjörður": lon = -23.188860;
            break;
            case "Isafjörður": lon = -23.188860;
            break;
            case "Egilsstaðir": lon = -14.394847;
            break;
            case "Egilsstadir": lon = -14.394847;
            break;
            case "Kulusuk": lon = -37.187300;
            break;
        }
        return lon;
    }
    
    public Date getStartDate() {
        return this.startDate;
    }
    
    public Date getEndDate() {
        return this.endDate;
    }
    
    public String getID() {
        return this.id;
    }
    
    public int getAdultPrice() {
        return this.adultPrice;
    }
    
    public int getChildPrice() {
        return this.childPrice;
    }
    
    public double getRating() {
        return this.rating;
    }
    
    public String getLocation() {
        return this.location;
    }

}
