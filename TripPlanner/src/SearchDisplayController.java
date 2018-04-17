
import java.net.URL;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import search.TripFlight;
import search.FlightSearch;
import search.Hotel;
import search.HotelSearch;
import search.Tour;
import search.TourSearch;

/**
 * FXML Controller class
 *
 * @author Ísak
 */
public class SearchDisplayController implements Initializable {
    
    private ObservableList<Trip> awailabletrips = FXCollections.observableArrayList();
    private ObservableList<TripFlight> awailableflightsOut = FXCollections.observableArrayList();
    private ObservableList<TripFlight> awailableflightsHome = FXCollections.observableArrayList();
    private ObservableList<Hotel> awailablehotels = FXCollections.observableArrayList();
    private ObservableList<Tour> awailabletours = FXCollections.observableArrayList();
    private Trip selectedTrip = null; 
    private TripFlight selectedOutFlight = null;
    private TripFlight selectedHomeFlight = null;
    private Hotel selectedHotel = null;
    private Tour selectedTour = null;
    private int selectedAdults = 1, selectedChilds = 0; 
    
   
    @FXML
    private Button search;
    @FXML
    private Button book;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private ChoiceBox<String> departure;
    @FXML
    private ChoiceBox<String> destination;
    @FXML
    private Tab generatedTrips;
    @FXML
    private Tab createTrip;
   
    // private BookingDisplayController bookingController;
    
    
    @FXML
    private TableView flightsOut;       
    @FXML
    private TableColumn<TripFlight, String> flOutAirlineColumn;
    @FXML
    private TableColumn<TripFlight, String> flOutOriginColumn;
    @FXML
    private TableColumn<TripFlight, String> flOutDestinationColumn;
     @FXML
    private TableColumn<TripFlight, Date> flOutDateColumn;
     @FXML
    private TableColumn<TripFlight, Double> flOutRatingColumn;
    @FXML
    private TableColumn<TripFlight, Integer> flOutAdultPriceColumn;
    @FXML
    private TableColumn<TripFlight, Integer> flOutChildPriceColumn;
    
    
    @FXML
    private TableView flightsHome;
    @FXML
    private TableColumn<TripFlight, String> flHomeAirlineColumn;
    @FXML
    private TableColumn<TripFlight, String> flHomeOriginColumn;
    @FXML
    private TableColumn<TripFlight, String> flHomeDestinationColumn;
    @FXML
    private TableColumn<TripFlight, Date> flHomeDateColumn;
    @FXML
    private TableColumn<TripFlight, Double> flHomeRatingColumn;
    @FXML
    private TableColumn<TripFlight, Integer> flHomeAdultPriceColumn;
    @FXML
    private TableColumn<TripFlight, Integer> flHomeChildPriceColumn;
    
    @FXML
    private TableView hotels;
    
    @FXML
    private TableColumn<Hotel, String> hotelNameColumn;
    @FXML
    private TableColumn<Hotel, String> hotelDateColumn;
    @FXML
    private TableColumn<Hotel, String> hotelLocationColumn;
    @FXML
    private TableColumn<Hotel, Double> hotelRatingColumn;
    @FXML
    private TableColumn<Hotel, Integer> hotelAdultPriceColumn;
    @FXML
    private TableColumn<Hotel, Integer> hotelChildPriceColumn;
    
    @FXML
    private TableView tours;
    @FXML
    private TableColumn<Tour, String> tourNameColumn;
    @FXML
    private TableColumn<Tour, Double> tourRatingColumn;
    @FXML
    private TableColumn<Tour, Integer> tourAdultPriceColumn;
    @FXML
    private TableColumn<Tour, String> tourDateColumn;
    @FXML
    private TableColumn<Tour, String> tourLocationColumn;
    @FXML
    private TableColumn<Tour, Integer> tourChildPriceColumn;
    
    @FXML
    private TableView trips;
    @FXML
    private TableColumn<Trip, String> tripsSDcolumn;
    @FXML
    private TableColumn<Trip, String> tripsEDcolumn;
    @FXML
    private TableColumn<Trip, String> tripsDeparturecolumn;
    @FXML
    private TableColumn<Trip, String> tripsDestinationcolumn;
    @FXML
    private TableColumn<Trip, String> tripsHotelcolumn;
    @FXML
    private TableColumn<Trip, String> tripsTourcolumn;
    @FXML
    private TableColumn<Trip, String> tripsTourDatecolumn;
    @FXML
    private TableColumn<Trip, Double> tripsRatingcolumn;
    @FXML
    private TableColumn<Trip, Integer> tripsAdultPricecolumn;
    @FXML
    private TableColumn<Trip, Integer> tripsChildPricecolumn;
   
    
    @FXML
    private TextField minRating;
    @FXML
    private TextField maxPrice;
    @FXML
    private Button filterTrips;
    @FXML
    private TextField adults;
    @FXML
    private TextField childs;
    @FXML
    private Label totalPrice;
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTables(null, null, null, null);
        setDepartAndDest();
        fixDatePickers();        
    }
    
    public void loadTables(Date SD, Date ED, String depart, String dest) {
        FlightSearch fsOut = new FlightSearch(SD, depart, dest);
        FlightSearch fsHome = new FlightSearch(ED, dest, depart);
        HotelSearch hs = new HotelSearch(SD, ED, dest);
        TourSearch ts = new TourSearch(SD, ED, dest);
         
        ArrayList<TripFlight> searchFlightsOut = fsOut.returnFlights();
        awailableflightsOut = FXCollections.observableArrayList(searchFlightsOut);
        showOutFlights(awailableflightsOut);
                
        ArrayList<TripFlight> searchFlightsHome = fsHome.returnFlights();
        awailableflightsHome = FXCollections.observableArrayList(searchFlightsHome);
        showHomeFlights(awailableflightsHome);
        
        ArrayList<Hotel> searchHotels = hs.getHotels();
        awailablehotels = FXCollections.observableArrayList(searchHotels);
        showHotels(awailablehotels);
              
        ArrayList<Tour> searchTours = ts.getTours();
        awailabletours = FXCollections.observableArrayList(searchTours);
        showTours(awailabletours);               
        
        CreateTrips Create = new CreateTrips(searchFlightsOut, searchFlightsHome, searchHotels, searchTours);
        awailabletrips = FXCollections.observableArrayList(Create.generateTrips());
        showTrips(awailabletrips);       
    }
    
    @FXML
    public void search(ActionEvent event){
        Date SD = null, ED = null;
        String depart = null, dest = null;
        if (startDate.getValue()==null){
            startDate.setValue(now());
        }
        SD = Date.from(startDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                
        if(endDate.getValue()==null){
            endDate.setValue(now().plusWeeks(1));
        }
        ED = Date.from(endDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        if(departure.getSelectionModel().getSelectedItem()!=null){
            depart = departure.getSelectionModel().getSelectedItem();
        }
        if(destination.getSelectionModel().getSelectedItem()!=null){
            dest = destination.getSelectionModel().getSelectedItem();
        }
        loadTables(SD, ED, depart, dest);
    }
    
    @FXML
    public void selectedTrip(MouseEvent event){
        this.selectedTrip = (Trip) trips.getSelectionModel().getSelectedItem();
        updatePrice();
        book.setDisable(false);
    }
    
    @FXML
    public void selectedOutFlight(MouseEvent event){
        this.selectedTrip = null;
        this.selectedOutFlight = (TripFlight) flightsOut.getSelectionModel().getSelectedItem();
        updatePrice();
        tryMakingTrip();
    }
    
    @FXML
    public void selectedHomeFlight(MouseEvent event){
        this.selectedTrip = null;
        this.selectedHomeFlight = (TripFlight) flightsHome.getSelectionModel().getSelectedItem();
        updatePrice();
        tryMakingTrip();
    }
    
    @FXML
    public void selectedHotel(MouseEvent event){
        this.selectedTrip = null;
        this.selectedHotel = (Hotel) hotels.getSelectionModel().getSelectedItem();
        updatePrice();
        tryMakingTrip();
    }
    
    @FXML
    public void selectedTour(MouseEvent event){
        this.selectedTrip = null;
        this.selectedTour = (Tour) tours.getSelectionModel().getSelectedItem();
        updatePrice();
        tryMakingTrip();
    }
    
    public void tryMakingTrip(){
        if(selectedOutFlight!=null && selectedHomeFlight!=null &&
                selectedHotel!=null && selectedTour!=null) {
            this.selectedTrip = new Trip(selectedOutFlight, selectedHomeFlight, selectedHotel, selectedTour);
            book.setDisable(false);
        }else {
            book.setDisable(true);            
        }     
    }
    
    @FXML
    public void bookTrip(ActionEvent event) {
        updatePrice();
        try {
        BookingDisplayController bookingController = new BookingDisplayController(selectedTrip, selectedAdults, selectedChilds );
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BookingDisplay.fxml"));
        fxmlLoader.setController(bookingController);
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
        } catch (Exception e) {
            System.out.println("error opening booking");
        }       
    }
    
    
    @FXML
    public void filterTrips(ActionEvent event) {
        Results res = new Results();        
        if(!minRating.getText().trim().isEmpty()) {
            double filterRating  = Double.parseDouble(minRating.getText().trim());
            res.setMinRating(filterRating);
        }
        if(!maxPrice.getText().trim().isEmpty()){
            double filterPrice  = Double.parseDouble(maxPrice.getText().trim());
            res.setMaxPrice(filterPrice);
        }
        if(!adults.getText().trim().isEmpty()){
            int filterAdults = Integer.parseInt(adults.getText().trim());
            res.setAdults(filterAdults);
        }else {
            adults.setText("1");
        }
        if(!childs.getText().trim().isEmpty()){
            int filterChilds = Integer.parseInt(childs.getText().trim());
            res.setChilds(filterChilds);
        }else {
            childs.setText("0");
        }
        showTrips(res.filter(awailabletrips));
    }
    
    @FXML
    public void peopleChanged() {
        updatePrice();        
    }
    
    public void showTrips(ObservableList<Trip> showTrips) {
        trips.setItems(showTrips);
        tripsSDcolumn.setCellValueFactory(new PropertyValueFactory<>("shortStartDate"));
        tripsEDcolumn.setCellValueFactory(new PropertyValueFactory<>("shortEndDate"));
        tripsDeparturecolumn.setCellValueFactory(new PropertyValueFactory<>("departure"));
        tripsDestinationcolumn.setCellValueFactory(new PropertyValueFactory<>("destination"));
        tripsHotelcolumn.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
        tripsTourcolumn.setCellValueFactory(new PropertyValueFactory<>("tourName"));       
        tripsTourDatecolumn.setCellValueFactory(new PropertyValueFactory<>("tourDate"));
        tripsRatingcolumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        tripsAdultPricecolumn.setCellValueFactory(new PropertyValueFactory<>("adultPrice"));
        tripsChildPricecolumn.setCellValueFactory(new PropertyValueFactory<>("childPrice"));        
    }
    
    public void showOutFlights(ObservableList<TripFlight> showFlights) {
        flightsOut.setItems(showFlights);
        flOutAirlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));
        flOutOriginColumn.setCellValueFactory(new PropertyValueFactory<>("departureLocation"));
        flOutDestinationColumn.setCellValueFactory(new PropertyValueFactory<>("Location"));
        flOutDateColumn.setCellValueFactory(new PropertyValueFactory<>("shortDate"));
        flOutRatingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        flOutAdultPriceColumn.setCellValueFactory(new PropertyValueFactory<>("adultPrice"));
        flOutChildPriceColumn.setCellValueFactory(new PropertyValueFactory<>("childPrice"));
    }
    
    public void showHomeFlights(ObservableList<TripFlight> showFlights) {
        flightsHome.setItems(showFlights);
        flHomeAirlineColumn.setCellValueFactory(new PropertyValueFactory<>("airline"));
        flHomeOriginColumn.setCellValueFactory(new PropertyValueFactory<>("departureLocation"));
        flHomeDestinationColumn.setCellValueFactory(new PropertyValueFactory<>("Location"));
        flHomeDateColumn.setCellValueFactory(new PropertyValueFactory<>("shortDate"));
        flHomeRatingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        flHomeAdultPriceColumn.setCellValueFactory(new PropertyValueFactory<>("adultPrice"));
        flHomeChildPriceColumn.setCellValueFactory(new PropertyValueFactory<>("childPrice"));
    }
    
    public void showHotels(ObservableList<Hotel> showHotels) {
        hotels.setItems(showHotels);
        hotelNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        hotelAdultPriceColumn.setCellValueFactory(new PropertyValueFactory<>("adultPrice"));
        hotelChildPriceColumn.setCellValueFactory(new PropertyValueFactory<>("childPrice"));
        hotelDateColumn.setCellValueFactory(new PropertyValueFactory<>("shortDate"));
        hotelLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        hotelRatingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
    }
     
    public void showTours(ObservableList<Tour> showTours) {
        tours.setItems(showTours);
        tourNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tourRatingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));
        tourAdultPriceColumn.setCellValueFactory(new PropertyValueFactory<>("adultPrice"));
        tourChildPriceColumn.setCellValueFactory(new PropertyValueFactory<>("childPrice"));
        tourDateColumn.setCellValueFactory(new PropertyValueFactory<>("shortDate"));
        tourLocationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
    }

    private void updatePrice() {
        double totPrice = 0;
        if(!adults.getText().trim().isEmpty()) {
          this.selectedAdults = Integer.parseInt(adults.getText().trim());
        } 
        if(!childs.getText().trim().isEmpty()) {
          this.selectedChilds = Integer.parseInt(childs.getText().trim());
        } 
        if(this.selectedTrip!=null){
            totPrice = selectedTrip.getAdultPrice()*selectedAdults +
                    selectedTrip.getChildPrice()*selectedChilds;
        }else {
            if(this.selectedOutFlight!=null){
                totPrice = totPrice + selectedOutFlight.getAdultPrice()*selectedAdults +
                    selectedOutFlight.getChildPrice()*selectedChilds;
            }
            if(this.selectedHomeFlight!=null){
                totPrice = totPrice + selectedHomeFlight.getAdultPrice()*selectedAdults +
                    selectedHomeFlight.getChildPrice()*selectedChilds;
            }
            if(this.selectedHotel!=null){
                totPrice = totPrice + selectedHotel.getAdultPrice()*selectedAdults +
                    selectedHotel.getChildPrice()*selectedChilds;
            }
            if(this.selectedTour!=null){
                totPrice = totPrice + selectedTour.getAdultPrice()*selectedAdults +
                    selectedTour.getChildPrice()*selectedChilds;
            }
        }
        totalPrice.setText("Heildarverð : " + totPrice + "kr");
    }

    private void setDepartAndDest() {
        ObservableList<String> depart = FXCollections.observableArrayList();
        ObservableList<String> dest = FXCollections.observableArrayList();
        
        for(TripFlight fl: awailableflightsOut){
            if(!depart.contains(fl.getDepartureLocation())){
                depart.add(fl.getDepartureLocation());
            }
            if(!dest.contains(fl.getLocation())){
                dest.add(fl.getLocation());
            }
        }
        depart.add("");
        dest.add("");
        departure.setItems(depart);
        destination.setItems(dest);
    }
    
    private void fixDatePickers() {
        String pattern = "dd-MM-yyyy";
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = 
                DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };             
        startDate.setConverter(converter);
        startDate.setValue(now());
        startDate.setPromptText(pattern.toLowerCase());
        startDate.requestFocus();
        endDate.setConverter(converter);
        endDate.setValue(now().plusWeeks(1));
        endDate.setPromptText(pattern.toLowerCase());
        endDate.requestFocus();
    } 
}
