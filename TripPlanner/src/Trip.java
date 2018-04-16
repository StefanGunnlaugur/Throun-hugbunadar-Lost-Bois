
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import static jdk.nashorn.internal.objects.NativeMath.round;
import search.Flight;
import search.Hotel;
import search.Tour;

public class Trip {

    private Date startDate, endDate;
    private Flight outFlight;
    private Flight homeFlight;
    private Hotel hotel;
    private Tour tour;
    private String hotelName, tourName, departure, destination, 
            shortStartDate, shortEndDate, tourDate;
    private double adultPrice, childPrice, rating; 
    
    public Trip (Flight outFlight, Flight homeFlight , Hotel hotel, Tour tour) {
        
        this.outFlight = outFlight;
        this.homeFlight = homeFlight; 
        this.hotel = hotel; 
        this.tour = tour; 
        this.tourDate = tour.getShortDate();
        this.hotelName = hotel.getName();
        this.tourName = tour.getName();
        this.departure = outFlight.getDepartureLocation();
        this.destination = outFlight.getLocation();
        this.startDate = Collections.min(Arrays.asList(outFlight.getStartDate(), hotel.getStartDate(), tour.getStartDate()));
        this.endDate = Collections.max(Arrays.asList(homeFlight.getEndDate(), hotel.getEndDate(), tour.getEndDate()));
        
        // Til að fá réttan fjölda aukastafa 
        double avgRating = Math.round((outFlight.getRating() + homeFlight.getRating() 
                + hotel.getRating() + tour.getRating()) / 0.4);
        this.rating = avgRating/10;
        
        this.adultPrice = outFlight.getAdultPrice() + homeFlight.getAdultPrice()
                + hotel.getAdultPrice() + tour.getAdultPrice();
        this.childPrice = outFlight.getChildPrice() + homeFlight.getChildPrice()
                + hotel.getChildPrice() + tour.getChildPrice();
        Format formatter = new SimpleDateFormat("dd-MMM HH:mm");
        this.shortStartDate = formatter.format(startDate);
        this.shortEndDate = formatter.format(endDate);

    }
    
    public Date getStartDate() {
        return this.startDate;
    }
    
    public Date getEndDate() {
        return this.endDate;
    }
    
    public String getTourDate() {
        return this.tourDate;
    }
    
    public String getShortStartDate() {
        return this.shortStartDate;
    }
    
    public String getShortEndDate() {
        return this.shortEndDate;
    }
    
    public String getHotelName() {
        return this.hotelName;
    }
    
    public String getTourName() {
        return this.tourName;
    }
    
    public String getDeparture() {
        return this.departure;
    }
    
    public String getDestination() {
        return this.destination;
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
    
    public Flight getOutFlight() {
        return outFlight;
    }
    
    public Flight getHomeFlight() {
        return homeFlight;
    }
    
    public Hotel getHotel() {
        return hotel;
    }
    
    public Tour getTour() {
        return tour;
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
