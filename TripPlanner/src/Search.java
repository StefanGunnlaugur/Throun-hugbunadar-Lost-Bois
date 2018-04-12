
import java.util.ArrayList;
import java.util.*;
import search.*;

public class Search {

    private Flight[] flights;
    private Hotel[] hotels;
    private Tour[] tours;
    
    private Date startDate, enddate;   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date date1 = new Date(1528675200000L);
        Date date2 = new Date(1528695200000L);
        
        // Leitar eftir og býr til ferðrir sem meika sense
        // notum dags. til að sækja í gg. hjá hinum
        ArrayList<Trip> trips = Search(date1, date2);


        // Prófa filteringu á max verði og min einkunn
        Results res = new Results();
      
        System.out.println(res.get(trips));
        // Velur fjölda einstaklinga til að fá rétt verð
        res.setChilds(2);
        res.setAdults(2);
        res.setMaxPrice(150000);
        System.out.println(res.get(trips));
        res.setMinRating(3);
        System.out.println(res.get(trips));


        
        
    }
    
    private static ArrayList<Trip> Search(Date startDate, Date endDate) {
        FlightSearch fs = new FlightSearch();
        HotelSearch hs = new HotelSearch();
        TourSearch ts = new TourSearch();
        CreateTrips Create = new CreateTrips(fs.getFlights(), hs.getHotels(), ts.getTours());
        
        ArrayList<Trip> trips = Create.generateTrips();
        
        System.out.println(trips); 
        return trips;
    }
    
    /*
    public Object getLocation() {
        return location;
    }
    
    public String getStartDate() {
        return startDate;
    }
    
    public String getEndDate() {
        return endDate;
    } */
    
    public String FlightSearchMock() {
        // Væri Flight klasi sem sá hópur gerir
        return "Akureyri";
    }
    
    public String HotelSearchMock() {
        // Væri Hotel klasi sem sá hópur gerir
        return "Hotel Borg";
    }
    
    public String TourSearchMock() {
        // Væri Tour klasi sem sá hópur gerir
        return "Reykjavik";
    }
    
    /*
    public createTrips(Flight[] flights, Hotel[] hotels, Tour[] tours) {
        CreateTrips(flights)
    }*/
   
}