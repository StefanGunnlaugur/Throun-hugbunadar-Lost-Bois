/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGroup.Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author marinmcginley
 */
public class Booking {
    
    private String nameOfHotel;
    private String locationOfHotel;
    private int price;
    private int numberOfAdults;
    private int numberOfChildren;
    private boolean availableForHandic;
    private boolean gym;
    private boolean swimmingPool;
    private boolean wifi;
    private boolean pickUp;
    private boolean breakfastIncluded;
    private String firstDate;
    private String lastDate;
    
    public Booking(String nameOfHotel, String locationOfHotel, int price,
             String firstDate, String lastDate) {
        
        this.nameOfHotel = nameOfHotel;
        this.locationOfHotel = locationOfHotel;
        this.price = price;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }
    
    public String getFirstDate() {
        return firstDate;
    }
    
    public String getLastDate() {
        return lastDate;
    }
    
    public String getNameOfHotel() {
        return nameOfHotel;
    }
    
    public String getLocationOfHotel() {
        return locationOfHotel;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getNumberOfAdults() {
        return numberOfAdults;
    }
    
    public int getNumberOfChildren() {
        return numberOfChildren;
    }
    
    public boolean getHandicapped() {
        return availableForHandic;
    }
    
    public boolean getGym() {
        return gym;
    }
    
    public boolean getSwimmingPool() {
        return swimmingPool;
    }
    
    public boolean getWifi() {
        return wifi;
    }
    
    public boolean getPickUp() {
        return pickUp;
    }
    
    public boolean getBreakfast() {
        return breakfastIncluded;
    }
    
}
