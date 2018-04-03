/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Palli
 */
public class Search {
    private Object[] flights;
    private Object[] hotels;
    private Object[] tours;
    
    private String startDate;
    private String endDate;
    
    private Object location;
    
    private double price;
    private double rating;
    
    private String photo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public Search(Object location, String startDate, String endDate) {
        location.equals("");
        startDate = "April 2, 2018";
        endDate = "April 6, 2018";
    }
    
    public Object getLocation() {
        return location;
    }
    
    public String getStartDate() {
        return startDate;
    }
    
    public String getEndDate() {
        return endDate;
    }
    
    public String FlightSearchMock() {
        // Væri Flight klasi sem sá hópur gerir
        return "Akureyri";
    }
    
    public String HotelSearchMock() {
        // Væri Hotel klasi sem sá hópur gerir
        return "Hotel Borg";
    }
    
    public String TourSearchMock() {
        // Væri Tour klasi sem sá hópur gerir
        return "Reykjavik";
    }
    
/*
    public createTrips(flights[], hotels[], tours[]) {
        
    }
*/
}