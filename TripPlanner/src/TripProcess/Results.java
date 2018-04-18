package TripProcess;


import TripProcess.Trip;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Results {
    
    private ArrayList<Trip> resultTrips;
    private double maxPrice , minRating;
    private int adults, childs;
    
    public Results() {
        this.maxPrice = Double.POSITIVE_INFINITY;
        this.minRating = 0;
        this.adults = 1;
        this.childs = 0;
    }
    
    public void setMaxPrice(double price) {
        this.maxPrice = price;
    }
    
    public void setMinRating(double rating) {
        this.minRating = rating;
    }
    
    public void setAdults(int adults) {
        this.adults = adults; 
    }
    
    public void setChilds(int childs) {
        this.childs = childs; 
    }
    
    public ObservableList<Trip> filter(ObservableList<Trip> trips) {
        resultTrips = new ArrayList<>();
        for (Trip currTrip:trips) {
            double price = adults*currTrip.getAdultPrice() + childs*currTrip.getChildPrice() + currTrip.getHotel().getTotalPrice();

            if (minRating <= currTrip.getRating() && maxPrice >= price) {
                resultTrips.add(currTrip);
            }
        } 
        return FXCollections.observableArrayList(resultTrips);
    }    
}
