
import java.util.ArrayList;
import java.util.Date;
import java.lang.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import search.Flight;
import search.Hotel;
import search.Tour;

/**
 *
 * @author Ísak
 */
public class CreateTrips {
    private final Flight[] flights;
    private final Hotel[] hotels;
    private final Tour[] tours;
    private Date startDate, enddate;
    private ArrayList<Trip> trips;
    private double max; 

    public CreateTrips( Flight[] flights, Hotel[] hotels, Tour[] tours) {
        this.trips = new ArrayList<>();
        this.flights = flights;
        this.hotels = hotels;
        this.tours = tours;
    }
    
    public void setMaxDist(double max) {
        this.max = max;
    }
    
    
    // Athugar fjarlægð milli staða skilar mælingum milli punktanna 3. 
    // hámarks vegalengd  milli staða = max 
    private double[] CheckDistance(double max, double fLat, double fLon, double hLat, double hLon, double tLat, double tLon) {
        double f2h = CalculateDistance( fLat, fLon, hLat, hLon);
        double h2t = CalculateDistance( hLat, hLon, tLat, tLon);
        double f2t = CalculateDistance( fLat, fLon, tLat, tLon);
        
        if (f2h > max || h2t > max || f2t > max ) {
            double[] dist = {f2h, h2t, f2t};
            return dist ;
        }
        return new double[0];
    }
       
    // Reiknar fjarlægð milli 2. punkta 
    private static double CalculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(Math.toRadians(lat1)) 
                * Math.sin(Math.toRadians(lat2)) 
                + Math.cos(Math.toRadians(lat1)) 
                * Math.cos(Math.toRadians(lat2)) 
                * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }
    
    // Ath hvort dagsetningar virka, dist er vegalengir milli staða
    // hægt að ca. út hvað meikar sense sem tími/vegalengd
    private boolean CheckDate(Date fSD, Date fED, Date hSD, Date hED, Date tSD, Date tED, double[] dist ) {
        // útfæra 
        
        
        
        return false;
    }
    
    private Trip CreateTrip(Flight flight, Hotel hotel, Tour tour) {
        Date SD = Collections.min(Arrays.asList(flight.getSD(), hotel.getSD(), tour.getSD()));
        Date ED = Collections.max(Arrays.asList(flight.getED(), hotel.getED(), tour.getED()));
        double price = flight.getPrice() + hotel.getPrice() + tour.getPrice();
        double rating = (flight.getRating() + hotel.getRating() + tour.getRating()) / 3 ;
        String img = tour.getImg();
        
        Trip currTrip = new Trip(SD, ED, flight, hotel, tour, price, rating, img);
        return currTrip; 
    }
        
    public ArrayList<Trip> generateTrips() {
        for(Flight flight:flights ) {
            for (Hotel hotel:hotels) {
                for (Tour tour:tours) {
                    double fLat = flight.getLat(), fLon= flight.getLon();
                    double hLat = hotel.getLat(), hLon= hotel.getLon();
                    double tLat = tour.getLat(), tLon= tour.getLon();
                    double[] dist = CheckDistance(max, fLat, fLon, hLat, hLon, tLat, tLon);
                    
                    if (dist.length > 0) {
                        Date fSD = flight.getSD(), fED= flight.getED();                        
                        Date hSD = hotel.getSD(), hED= hotel.getED();
                        Date tSD = tour.getSD(), tED= tour.getED();
                        
                        if (CheckDate( fSD, fED, hSD, hED, tSD, tED, dist)) {
                            Trip trip = CreateTrip(flight, hotel, tour);
                            trips.add(trip);
                        }                        
                    }
                }
            }
        }
     return null;   
    }

   
    
    
    
    
    
}
