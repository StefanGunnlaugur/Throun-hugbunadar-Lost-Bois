/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.util.Date;

/**
 *
 * @author Ísak
 */
public class FlightSearch {
    
    // Talar við db hjá hinum hópunum 
    private Flight[] flights; 
    private Date startDate, enddate;
   
    public FlightSearch() {
        Date date1 = new Date(1528675200000L);
        Date date2 = new Date(1528695200000L);
        Flight fl1 = new Flight("id1", date1, date2, 65.654509, -18.076340, 10000, 3.4, "sæti 3", 60000L );
        Flight fl2 = new Flight("þetternæs", date1, date2, 65.654509, -18.076340, 50000, 4.5, "sæti 100", 60000L );
        this.flights = new Flight[]{fl1, fl2}; 
    }
    
}
