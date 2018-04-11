
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Palli
 */
class Results {
    
    private ArrayList<Trip> trips;
    private double maxPrice = Double.POSITIVE_INFINITY, minRating = 0;
    
    public void setMaxPrice(double price) {
        this.maxPrice = price;
    }
    
    public void setMinRating(double rating) {
        this.minRating = rating;
    }
    
    public ArrayList<Trip> Results() {
        ArrayList<Trip> output = new ArrayList<>();
        for (Trip currTrip:trips) {
            if (minRating <= currTrip.getRating() && maxPrice >= currTrip.getPrice()) {
                output.add(currTrip);
            }
        }
        return output;
    }

       
    
    
    
    
}
