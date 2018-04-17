/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import flightGroup.hopur9fvinnsla.Booking;
import flightGroup.hopur9fvinnsla.BookingService;
import flightGroup.hopur9fvinnsla.FlightService;
import flightGroup.hopur9fvinnsla.Passenger;
import flightGroup.hopur9fvinnsla.PassengerService;
import java.io.IOException;
import static java.lang.Math.toIntExact;
import static java.lang.StrictMath.round;
import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import search.TripFlight;

/**
 * FXML Controller class
 *
 * @author Ísak
 */
public class UserDisplayController implements Initializable {
    
    private Trip trip;
    private int adults, childs, passengerCount,
            currPassenger, luggagePrice, handLuggagePrice;
    private Long  bookingNumberOut, bookingNumberHome;
    private List<String> availableSeatListOut, availableSeatListHome;
    private TripFlight flightOut, flightHome;
    List<Passenger> passengersOut = new ArrayList<>();
    List<Passenger> passengersHome = new ArrayList<>();

    List<Passenger> passengersWithIdOut = new ArrayList<>();
    List<Passenger> passengersWithIdHome = new ArrayList<>();

    List<String> seatsToRemoveOut = new ArrayList<>();
    List<String> seatsToRemoveHome = new ArrayList<>();

    List<String> takenSeatsOut = new ArrayList<>();
    List<String> takenSeatsHome = new ArrayList<>();

    

    @FXML
    private TextField cardholder;
    @FXML
    private TextField cardnumber;
    @FXML
    private TextField lastName;
    @FXML
    private TextField firstName;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private TextField email;
    @FXML
    private DatePicker birthday;
    @FXML
    private ChoiceBox<String> nationality;
    @FXML
    private TextField bagsNr;
    @FXML
    private TextField handbagsNr;
    @FXML
    private Label bagPrice;
    @FXML
    private Label handbagPrice;
    @FXML
    private Label progressLable;
    @FXML
    private Button confirmPassenger;
    @FXML
    private ChoiceBox<String> experationMonth;
    @FXML
    private ChoiceBox<String> experationYear;
    @FXML
    private TextField ccvNumber;
    @FXML
    private Label flightPrice;
    @FXML
    private Label hotelPrice;
    @FXML
    private Label tourPrice;
    @FXML
    private Label tripPrice;
    @FXML
    private Button confirmBooking;
    @FXML
    private ChoiceBox<String> seatOut;
    @FXML
    private ChoiceBox<String> seatHome;
   

    UserDisplayController(Trip trip, int adults, int childs) {
        this.trip = trip;
        this.adults = adults;
        this.childs = childs;  
        this.passengerCount = adults + childs;
        this.flightOut = trip.getOutFlight();
        this.flightHome = trip.getHomeFlight();
        this.availableSeatListOut = flightOut.getAvailableSeatList();
        this.availableSeatListHome = flightHome.getAvailableSeatList();
        this.handLuggagePrice = flightOut.getHandLuggagePrice() + flightHome.getHandLuggagePrice() ;
        this.luggagePrice = flightOut.getLuggagePrice() + flightHome.getLuggagePrice();
        this.currPassenger = 1;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setInputs();
    }  
    
    @FXML
    public void completeBooking(ActionEvent event) {
        String cardHolder = cardholder.getText().trim();
        String cardNumber = cardnumber.getText().trim();
        String expMonth = experationMonth.getSelectionModel().getSelectedItem().trim();
        String expYear = experationYear.getSelectionModel().getSelectedItem().trim();
        LocalDate expDay = getExpDay(expMonth, expYear);
        String csv = ccvNumber.getText();
        
        Booking booingOut = new Booking(flightOut.getFlight(), passengersOut, cardHolder, cardNumber, expDay, csv);
        bookOut(passengersOut, booingOut);
        Booking booingHome = new Booking(flightHome.getFlight(), passengersHome, cardHolder, cardNumber, expDay, csv);
        bookOut(passengersOut, booingHome);
    }

    public void setInputs() {
        updateProgress();
        bagPrice.setText("Verð tösku: " + luggagePrice + "kr");
        handbagPrice.setText("Verð handfarangurs: " + handLuggagePrice + "kr");
        experationMonth.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
        experationMonth.setValue("Mánuður");
        experationYear.getItems().addAll("2018", "2019", "2020", "2022", "2023", "2024", "2025");
        seatOut.getItems().addAll(availableSeatListOut);
        seatHome.getItems().addAll(availableSeatListHome);
        nationality.getItems().addAll("Ísland", "Noregur", "Danmörk", "Svíþjóð", "Færeyjar", "Grænland");
        nationality.setValue("Þjóðerni");
    }   
    
    public LocalDate getExpDay(String expMonth, String expYear) {
        int year = Integer.valueOf(expYear);
        int month = Integer.valueOf(expMonth);
        int day;
        if (expMonth == "02") {
            day = 28;
        } else if (expMonth == "04" || expMonth == "06" || expMonth == "09" || expMonth == "10") {
            day = 30;
        } else {
            day = 31;
        }
        LocalDate expDay = LocalDate.of(year, month, day);
        return expDay;
    }

    private void updateProgress() {
        if (currPassenger <= passengerCount) {
            progressLable.setText("Farþegi " + currPassenger + " af " + passengerCount);
            progressBar.setProgress(currPassenger/(passengerCount*1.0));
        } else {
            confirmBooking.setDisable(false);
        }
    }
    
    @FXML
    public void setPassenger(ActionEvent event) {
        String fname = firstName.getText().trim();
        String lname = lastName.getText().trim();
        String mail = email.getText().trim();
        String nat = nationality.getSelectionModel().getSelectedItem().trim();
        String seatO = seatOut.getSelectionModel().getSelectedItem().trim();
        String seatH = seatHome.getSelectionModel().getSelectedItem().trim();
        LocalDate bd = birthday.getValue();
        int handLuggage = Integer.parseInt(handbagsNr.getText().trim());
        int luggage = Integer.parseInt(bagsNr.getText().trim());
        Passenger passOut = new Passenger(fname, lname, mail, bd, nat, handLuggage, luggage, seatO );
        takenSeatsOut.add(seatO);
        passengersOut.add(passOut);
        Passenger passHome = new Passenger(fname, lname, mail, bd, nat, handLuggage, luggage, seatH );
        takenSeatsHome.add(seatH);
        passengersHome.add(passHome);
        
        currPassenger++;
        updateProgress();
        clearInputs();
    }
    
    public void clearInputs(){
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        nationality.getSelectionModel().clearSelection();
        seatOut.getSelectionModel().clearSelection();
        seatHome.getSelectionModel().clearSelection();
        birthday.getEditor().clear();
        handbagsNr.setText("1");
        bagsNr.setText("1");
    }
    
    /**
     * Calls a function in the flightService class that inserts Passenger into
     * the DB. After passenger have been added to the DB the method adds the id
     * of that passenger into the global passengersWithId variable.
     *
     * @param passenger Passenger to include into the DB.
     */
    private void addPassengerOut(Passenger passenger) {
        PassengerService ps = new PassengerService();
        long id = ps.insertPassenger(passenger);
        passenger.setId(toIntExact(id));
        passengersWithIdOut.add(passenger);
    }
    
    private void addPassengerHome(Passenger passenger) {
        PassengerService ps = new PassengerService();
        long id = ps.insertPassenger(passenger);
        passenger.setId(toIntExact(id));
        passengersWithIdHome.add(passenger);
    }
    
    /**
     * Calls a function in the bookingService class that inserts Booking into
     * the DB. After the booking have been added the availableSeatList in the
     * flight that was booked is updated, by removing the booked seat.
     *
     * @param booking
     */
    private void addBooking(Booking booking) {
        BookingService bs = new BookingService();
        int[] passengersIntArrayOut = generatePassengersIdArray(passengersWithIdOut);
        int[] passengersIntArrayHome = generatePassengersIdArray(passengersWithIdHome);
        bookingNumberOut = bs.insertBooking(booking, flightOut.getFlight(), passengersIntArrayOut, adults, childs);
        bookingNumberHome = bs.insertBooking(booking, flightHome.getFlight(), passengersIntArrayHome, adults, childs);
        updateAvailableSeatList();
    }
    
    /**
     * Calls a function in the FlightService class that updates the
     * availableSeatList for the corresponding flight. Updates the
     * availableSeatList field in the flight by removing the booked seats. Uses
     * the global removeFromSeatList variable.
     */
    private void updateAvailableSeatList() {
        FlightService fs = new FlightService();
        seatsToRemoveOut.forEach(s -> {
            flightOut.getFlight().removeFromSeatList(s);
        });
        seatsToRemoveHome.forEach(s -> {
            flightHome.getFlight().removeFromSeatList(s);
        });
        fs.updateAvailableSeatList(flightOut.getFlight(), flightOut.getAvailableSeatList());
        fs.updateAvailableSeatList(flightHome.getFlight(), flightHome.getAvailableSeatList());
    }
    
    /**
     * Generates array that includes id of passengers. Uses the global variable
     * passengersWithId.
     *
     * @return int[] array with id of passengers.
     */
    private int[] generatePassengersIdArray(List<Passenger> passWithId) {
        int[] passengersIntArray = new int[passWithId.size()];
        int counter = 0;
        for (Passenger p : passWithId) {
            passengersIntArray[counter] = p.getId();
            counter++;
        }
        return passengersIntArray;
    }
    
    private void bookOut(List<Passenger> passengers, Booking booking){
        //add every passenger into DB and generate passenger id.
        passengers.forEach(p -> {
            addPassengerOut(p);
        });
        addBooking(booking);
    } 
    private void bookHome(List<Passenger> passengers, Booking booking){
        //add every passenger into DB and generate passenger id.
        passengers.forEach(p -> {
            addPassengerHome(p);
        });
        addBooking(booking);
    }    
}
