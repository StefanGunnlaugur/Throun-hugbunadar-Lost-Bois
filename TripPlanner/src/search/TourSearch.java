package search;

import java.util.Date;

public class TourSearch {
    // Talar við db hjá hinum hópunum 
    private Tour[] tours; 
    private Date startDate, enddate;
    
    public TourSearch() {
        
        Date date1 = new Date(1529653000000L);
        Date date2 = new Date(1529683300000L);
        Tour t1 = new Tour("tour-1", date1, date2, "Akureyri", 10500, 3000, 0.4, 30 );
        Tour t2 = new Tour("tour-2", date1, date2, "Reykjavík", 20000, 0 , 4.5, 30 );
        this.tours = new Tour[]{t1, t2};
    }
    
    public Tour[] getTours() {
        return this.tours;
    }
    
}
