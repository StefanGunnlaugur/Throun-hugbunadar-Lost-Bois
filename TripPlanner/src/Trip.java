
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import search.Flight;
import search.Hotel;
import search.Tour;

public class Trip {

    private Date startDate, endDate;
    private Flight outFlight;
    private Flight homeFlight;
    private Hotel hotel;
    private Tour tour;
    private double adultPrice, childPrice, rating; 
    
    public Trip (Flight outFlight, Flight homeFlight , Hotel hotel, Tour tour) {
        
        this.outFlight = outFlight;
        this.homeFlight = homeFlight; 
        this.hotel = hotel; 
        this.tour = tour; 
        this.startDate = Collections.min(Arrays.asList(outFlight.getSD(), hotel.getSD(), tour.getSD()));
        this.endDate = Collections.max(Arrays.asList(homeFlight.getED(), hotel.getED(), tour.getED()));
        
        this.rating = ( outFlight.getRating() + homeFlight.getRating() 
                + hotel.getRating() + tour.getRating()) / 4;
        
        this.adultPrice = outFlight.getAdultPrice() + homeFlight.getAdultPrice()
                + hotel.getAdultPrice() + tour.getAdultPrice();
        this.childPrice = outFlight.getChildPrice() + homeFlight.getChildPrice()
                + hotel.getChildPrice() + tour.getChildPrice();
    }
    
    public double getAdultPrice() {
        return this.adultPrice;
    }
    
    public double getChildPrice() {
        return this.childPrice;
    }
    
    public double getRating() {
        return rating;
    }
    
    public String toString() {
        return ( "Flug með: " + outFlight.getAirline() + " til " + outFlight.getLocation() 
                + ", Gisting: " + hotel.getName() + ", Daytour : " + tour.getName() 
                + "Flug tilbaka með: " + homeFlight.getAirline() + " til " 
                + homeFlight.getLocation() + " --- startDate: " + startDate 
                + ", endDate: " + endDate + ", adultPrice: " + adultPrice 
                + ", childPrice: " + childPrice +  ", rating: " + rating);
    }
    
}
