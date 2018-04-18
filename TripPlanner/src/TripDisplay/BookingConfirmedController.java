package TripDisplay;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ísak
 */
public class BookingConfirmedController implements Initializable {
    Long flightOutBookingID,flightHomeBookingID;
    int price, bookingNumberHotel, bookingNumberTour;
    
    @FXML
    private Button close;
    @FXML
    private Label flightOutID;
    @FXML
    private Label flightHomeID;
    @FXML
    private Label hotelId;
    @FXML
    private Label tourId;
    @FXML
    private Label totalPrice;

    BookingConfirmedController(Long flOutBookingID, Long flHomeBookingID, int hBookingID, int tBookingID, int price ) {
        this.flightOutBookingID = flOutBookingID;
        this.flightHomeBookingID = flHomeBookingID;
        this.bookingNumberHotel = hBookingID;
        this.bookingNumberTour = tBookingID;
        this.price = price;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flightOutID.setText(flightOutID.getText() + flightOutBookingID);
        flightHomeID.setText(flightHomeID.getText() + flightHomeBookingID);
        hotelId.setText(hotelId.getText() + bookingNumberHotel);
        tourId.setText(tourId.getText() + bookingNumberTour);
        totalPrice.setText(totalPrice.getText() + price + "kr");
    }
    
    @FXML
    public void ok(ActionEvent event) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}
