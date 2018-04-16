/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import search.Flight;
import search.Hotel;
import search.Tour;

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
    @FXML
    private AnchorPane nDialog;
    
    
    public BookingDisplayController (Trip trip, int adults, int childs) {
        this.trip = trip;
        this.adults = adults;
        this.childs = childs;
    }
    
    public void  showBooking(){
        Flight oFl = trip.getOutFlight();
        Flight hFl = trip.getHomeFlight();
        Hotel h = trip.getHotel();
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
                + ", Heildar verð : " + (h.getAdultPrice()*adults + h.getChildPrice()*childs) + "kr");
        tour.setText("Ferð : " + t.getName()
                + ", Tímasetning : " + t.getShortDate()
                + ", Staðsetning : " + t.getLocation()
                + ", Heildar verð : " + (t.getAdultPrice()*adults + t.getChildPrice()*childs) + "kr");
        people.setText("Fullorðnir : " + adults + ", Börn : " + childs);
        price.setText((trip.getAdultPrice()*adults + trip.getChildPrice()*childs) + "kr");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBooking();
    }    
    
}
