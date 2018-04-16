
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import search.*;

public class Search extends Application{

    private String location, departureLocation;
    private Date startDate, endDate; 
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SearchDisplay.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public Search() {
        // Setjum dagsetningu núna sem SD og eftir viku sem ED -- sem default
        this.startDate = new Date();
        this.endDate = new Date(startDate.getTime() + 7*86400000);
        this.location = "";
        this.departureLocation = ""; 
    }

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        Date date1 = new Date(1528675200000L);
        Date date2 = new Date(1528695200000L);
        Search search = new Search();
        
        search.setStartDate(date1);
        search.setEndDate(date2);
        search.setLocation("Reykjavík");
        launch(args); 
        /*
        // Leitar eftir og býr til ferðrir sem meika sense
        // notum dags. til að sækja í gg. hjá hinum
        ArrayList<Trip> trips = search.findTrips();

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
        
             */   
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
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