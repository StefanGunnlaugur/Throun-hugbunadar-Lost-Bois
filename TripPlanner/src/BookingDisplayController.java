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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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
        DialogPane p = new DialogPane();
        nDialog.setVisible(true);
        p.setContent(nDialog);
        Dialog<ButtonType> d = new Dialog();
        d.setDialogPane(p);
        d.showAndWait();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
