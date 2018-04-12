
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import search.Flight;
import search.Hotel;
import search.Tour;

public class Trip {

    private Date startDate, endDate;
    private Flight flight;
    private Hotel hotel;
    private Tour tour;
    private double adultPrice, childPrice, rating; 
    
    public Trip (Flight flight, Hotel hotel, Tour tour) {
        
        this.flight = flight; 
        this.hotel = hotel; 
        this.tour = tour; 
        this.startDate = Collections.min(Arrays.asList(flight.getSD(), hotel.getSD(), tour.getSD()));
        this.endDate = Collections.max(Arrays.asList(flight.getED(), hotel.getED(), tour.getED()));
        
        this.rating = (flight.getRating() + hotel.getRating() + tour.getRating()) / 3;
        
        this.adultPrice = flight.getAdultPrice() + hotel.getAdultPrice() + tour.getAdultPrice();
        this.childPrice = flight.getChildPrice() + hotel.getChildPrice() + tour.getChildPrice();
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
        return ("startDate: " + startDate + ", endDate: " + endDate 
                + ", adultPrice: " + adultPrice + ", childPrice: " 
                + childPrice +  ", rating: " + rating);
    }
    
}
