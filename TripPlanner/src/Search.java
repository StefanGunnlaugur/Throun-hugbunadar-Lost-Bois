
import java.util.Date;
import search.Flight;
import search.Hotel;
import search.Tour;
/**
 *
 * @author Palli
 */
public class Search {
    private Flight[] flights;
    private Hotel[] hotels;
    private Tour[] tours;
    
    private Date startDate, enddate;   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public Search(Object location, String startDate, String endDate) {
        location.equals("");
        startDate = "April 2, 2018";
        endDate = "April 6, 2018";
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