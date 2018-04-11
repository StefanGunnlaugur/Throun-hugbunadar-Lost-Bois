
import java.util.ArrayList;
import java.util.Date;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
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
    
    // Ath hvort dagsetningar eru sama dag, diff er skekkuumörk á deinni degi
    private boolean isSameDay (Date date1, Date date2, int diff) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        
        for (int i = 0; i <= diff; i++) {
            Date datePlus = new Date( date2.getTime() + diff*86400000);
            Date dateMinus = new Date( date2.getTime() - diff*86400000);
            // Ath með skekkjumörkum, annars ekki 
            if (fmt.format(date1).equals(fmt.format(datePlus))) {
                return true;
            }
            if (fmt.format(date1).equals(fmt.format(dateMinus))) {
                return true;
            }
        }
        
        return fmt.format(date1).equals(fmt.format(date2));
    }
    
    // Ath hvort dagsetningar virka, dist er vegalengir milli staða
    // hægt að ca. út hvað meikar sense sem tími/vegalengd
    private boolean CheckDate(Date fSD, Date fED, Date hSD, Date hED, Date tSD, Date tED, double[] dist, long fDuration ) {
        // útfæra 
        // Ath - flug + tími flugs < hótel, ferð < brottför
        long mis = 1800000L; // 30 min
        Date fArrival = new Date(fSD.getTime() + fDuration + mis + (long)dist[2]*60000);
        
        // Tour er á milli flugtíma, og hotel er +-1 dag í kringum flug
        if ( tSD.after(fArrival) && tED.before(fED) 
                && isSameDay(fArrival, hSD, 1) && isSameDay(fED, hED, 1)) {
            return true;
        }        
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
                        long fDuration = flight.getDuration(); 
                        
                        if (CheckDate( fSD, fED, hSD, hED, tSD, tED, dist, fDuration)) {
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
