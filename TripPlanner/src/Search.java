
import java.text.ParseException;
import java.util.ArrayList;
import java.util.*;
import search.*;

public class Search {

    private String location;
    private Date startDate, endDate; 
    
    public Search() {
        // Setjum dagsetningu núna sem SD og eftir viku sem ED -- sem default
        this.startDate = new Date();
        this.endDate = new Date(startDate.getTime() + 7*86400000);
        this.location = "";
    }

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        Date date1 = new Date(1528675200000L);
        Date date2 = new Date(1528695200000L);
        
        // Leitar eftir og býr til ferðrir sem meika sense
        // notum dags. til að sækja í gg. hjá hinum
        ArrayList<Trip> trips = Search(date1, date2);

        // Prófa filteringu á max verði og min einkunn
        Results res = new Results();
      
        System.out.println(res.filter(trips));
        // Velur fjölda einstaklinga til að fá rétt verð
        res.setChilds(2);
        res.setAdults(2);
        res.setMaxPrice(250000);
        System.out.println(res.filter(trips));
        res.setMinRating(3);
        System.out.println(res.filter(trips));
    }
    
    private static ArrayList<Trip> Search(Date startDate, Date endDate) throws ParseException {
        FlightSearch fs = new FlightSearch();
        HotelSearch hs = new HotelSearch();
        TourSearch ts = new TourSearch();
        CreateTrips Create = new CreateTrips(fs.getFlights(), hs.getHotels(), ts.getTours());
        
        ArrayList<Trip> trips = Create.generateTrips();
        
        System.out.println(trips); 
        return trips;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Date getEndDate() {
        return endDate;
    } 
    
    /*
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
    
    public createTrips(Flight[] flights, Hotel[] hotels, Tour[] tours) {
        CreateTrips(flights)
    }*/
   
}