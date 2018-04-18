package TripDisplay;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import TripProcess.Trip;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import TripProcess.TripFlight;
import TripProcess.TripHotel;
import TripProcess.Tour;

/**
 * FXML Controller class
 *
 * @author Ísak
 */
public class BookingDisplayController implements Initializable {
    private Trip trip;
    private int adults, childs;

    @FXML
    private Button backButton;
    @FXML
    private Button continueButton;
    @FXML
    private Label flightOut;
    @FXML
    private Label flightHome;
    @FXML
    private Label hotel;
    @FXML
    private Label tour;
    @FXML
    private Label people;
    @FXML
    private Label price;
    
    
    public BookingDisplayController (Trip trip, int adults, int childs) {
        this.trip = trip;
        this.adults = adults;
        this.childs = childs;
    }
    
    public void  showBooking(){
        TripFlight oFl = trip.getOutFlight();
        TripFlight hFl = trip.getHomeFlight();
        TripHotel h = trip.getHotel();
        Tour t = trip.getTour();
        flightOut.setText("Frá : " + oFl.getDepartureLocation() 
                + ", Til : " + oFl.getLocation() 
                + ", Brottför : " + oFl.getShortDate() 
                + ", Flugfélag : " + oFl.getAirline() 
                + ", Flugnúmer : " + oFl.getFlightNumber()
                + ", Heildar verð : " + (oFl.getAdultPrice()*adults + oFl.getChildPrice()*childs) + "kr");
        flightHome.setText("Frá : " + hFl.getDepartureLocation() 
                + ", Til : " + hFl.getLocation() 
                + ", Brottför : " + hFl.getShortDate() 
                + ", Flugfélag : " + hFl.getAirline() 
                + ", Flugnúmer : " + hFl.getFlightNumber()
                + ", Heildar verð : " + (hFl.getAdultPrice()*adults + hFl.getChildPrice()*childs) + "kr");
        hotel.setText("Hótel : " + h.getName() 
                + ", Staðsetning : " + h.getLocation()
                + ", Bókunartími : " + h.getShortDate()
                + ", Heildar verð : " + h.getTotalPrice() + "kr");
        tour.setText("Ferð : " + t.getName()
                + ", Tímasetning : " + t.getShortDate()
                + ", Staðsetning : " + t.getLocation()
                + ", Heildar verð : " + (t.getAdultPrice()*adults + t.getChildPrice()*childs) + "kr");
        people.setText("Fullorðnir : " + adults + ", Börn : " + childs);
        price.setText((trip.getAdultPrice()*adults + trip.getChildPrice()*childs + trip.getHotel().getTotalPrice()) + "kr");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBooking();
    }    
    
    @FXML
    public void tripOK(ActionEvent event) {
        try {
        UserDisplayController userController = new UserDisplayController(trip, adults, childs );
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UserDisplay.fxml"));
        fxmlLoader.setController(userController);
        Parent root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        stage.show();
        } catch (Exception e) {
            System.out.println("error opening booking");
        }
        Stage stage = (Stage) continueButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void goBack(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
