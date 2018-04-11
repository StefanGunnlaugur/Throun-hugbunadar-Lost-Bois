package search;

import java.util.Date;

/**
 *
 * @author Ísak
 */
public class Tour extends TravelingObject {
   private String img;

    public Tour(String ID, Date SD, Date ED, double lat, double lon, double price, double rating, String img) {
        super(ID, SD, ED, lat, lon, price, rating);
        this.img = img; 
    }

    public String getImg() {
        return img; 
    }
}
