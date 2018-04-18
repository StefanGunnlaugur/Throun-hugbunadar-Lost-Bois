package TripProcess;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import TripProcess.TripFlight;
import TripProcess.TripHotel;
import TripProcess.Tour;

public class Trip {

    private Date startDate, endDate;
    private TripFlight outFlight;
    private TripFlight homeFlight;
    private TripHotel hotel;
    private Tour tour;
    private String hotelName, tourName, departure, destination, 
            shortStartDate, shortEndDate, tourDate;
    private double rating; 
    private int adultPrice, childPrice, hotelTotalPrice;
    
    public Trip (TripFlight outFlight, TripFlight homeFlight , TripHotel hotel, Tour tour) {
        
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
                + tour.getAdultPrice();
        this.childPrice = outFlight.getChildPrice() + homeFlight.getChildPrice()
                + tour.getChildPrice();
        this.hotelTotalPrice = hotel.getTotalPrice();
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
    
    public int getAdultPrice() {
        return this.adultPrice;
    }
    
    public int getChildPrice() {
        return childPrice;
    }
    
    public int getHotelTotalPrice() {
        return hotelTotalPrice;
    }
    
    public double getRating() {
        return rating;
    }
    
    public TripFlight getOutFlight() {
        return outFlight;
    }
    
    public TripFlight getHomeFlight() {
        return homeFlight;
    }
    
    public TripHotel getHotel() {
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
