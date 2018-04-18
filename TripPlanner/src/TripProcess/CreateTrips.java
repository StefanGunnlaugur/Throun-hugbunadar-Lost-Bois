package TripProcess;


import TripProcess.Trip;
import TripProcess.TripFlight;
import TripProcess.TripHotel;
import TripProcess.Tour;
import java.util.*;
import java.text.SimpleDateFormat;


public class CreateTrips {
    private final ArrayList<TripFlight> outFlights;
    private final ArrayList<TripFlight> homeFlights;
    private final ArrayList<TripHotel> hotels;
    private final ArrayList<Tour> tours;
    private ArrayList<Trip> trips;

    public CreateTrips( ArrayList<TripFlight> outFlights, ArrayList<TripFlight> homeFlights, ArrayList<TripHotel> hotels, ArrayList<Tour> tours) {
        this.trips = new ArrayList<>();
        this.outFlights = outFlights;
        this.homeFlights = homeFlights;
        this.hotels = hotels;
        this.tours = tours;
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
    private double CalculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) 
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) 
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515 * 1.609344;
        return dist;
    }
  
    private double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
      return (rad * 180.0 / Math.PI);
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
    private boolean CheckDate(Date fSD, Date fED, Date hSD, Date hED, Date tSD, Date tED, long fDuration ) {
        // útfæra 
        // Ath - flug + tími flugs < hótel, ferð < brottför
        long mis = 1800000L; // 30 min
        Date fArrival = new Date(fSD.getTime() + fDuration + mis);
              
        // Tour er á milli flugtíma, og hotel er +-1 dag í kringum flug
        if ( tSD.after(fArrival) && tED.before(fED) 
                && isSameDay(fArrival, hSD, 1) && isSameDay(fED, hED, 1)) {
            return true;
        }        
        return false;
    }
    
    // Ath hvort flugin séu pör 
    private boolean CheckFlights(TripFlight outFlight, TripFlight homeFlight) {
        return (outFlight.getLocation().equals(homeFlight.getDepartureLocation()) 
            && outFlight.getDepartureLocation().equals(homeFlight.getLocation())
            && !outFlight.getLocation().equals(homeFlight.getLocation())
            && !outFlight.getDepartureLocation().equals(homeFlight.getDepartureLocation()));
    }
    
    // Ath hvort flugin séu pör 
    private boolean CheckLocations(TripFlight f, TripHotel h, Tour t) {
        return (f.getLocation().equals(h.getLocation()) 
            && h.getLocation().equals(t.getLocation()));
    }
       
    
    public ArrayList<Trip> generateTrips() {
        for(TripFlight outFlight:outFlights ) {
            for (TripHotel hotel:hotels) {
                for (Tour tour:tours) {
                    for (TripFlight homeFlight:homeFlights) {
                        
                        if ( CheckFlights(outFlight, homeFlight)) {
                            /*
                            double fLat = outFlight.getLat(), fLon= outFlight.getLon();
                            double hLat = hotel.getLat(), hLon= hotel.getLon();
                            double tLat = tour.getLat(), tLon= tour.getLon();
                            double[] dist = CheckDistance(100, fLat, fLon, hLat, hLon, tLat, tLon);*/
                            //System.out.println("---------");
                            //dist.length > 0
                            if (CheckLocations(outFlight, hotel, tour)) {
                                //System.out.println("Distance ok");
                                Date fSD = outFlight.getStartDate(), fED= homeFlight.getEndDate();                        
                                Date hSD = hotel.getStartDate(), hED= hotel.getEndDate();
                                Date tSD = tour.getStartDate(), tED= tour.getEndDate();
                                long fDuration = outFlight.getDuration(); 
                                if (CheckDate( fSD, fED, hSD, hED, tSD, tED, fDuration)) {
                                    Trip trip = new Trip(outFlight, homeFlight, hotel, tour);
                                    trips.add(trip);
                                }                        
                            }
                        }
                        
                    }
                }
            }
        }
     return trips;   
    }

    
}
