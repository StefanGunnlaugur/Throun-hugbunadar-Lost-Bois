
import java.util.Date;
import search.Flight;
import search.Hotel;
import search.Tour;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ísak
 */
public class Trip {

    private Date startDate, endDate;
    private Flight flight;
    private Hotel hotel;
    private Tour tour;
    private double price, rating; 
    private String img; 
    
    public Trip (Date SD, Date ED, Flight flight, Hotel hotel,  Tour tour, double price, double rating , String img) {
        this.startDate = SD;
        this.endDate = ED;
        this.flight = flight; 
        this.hotel = hotel; 
        this.tour = tour; 
        this.price = price; 
        this.rating = rating;
        this.img = img; 
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getRating() {
        return rating;
    }
    
}
