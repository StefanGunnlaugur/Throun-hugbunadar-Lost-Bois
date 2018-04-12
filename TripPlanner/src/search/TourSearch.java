package search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TourSearch {
    // Talar við db hjá hinum hópunum 
    private Tour[] tours; 
    private Date startDate, enddate;
    
    public TourSearch() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date d1 = sdf.parse("05-05-2018 12:00:00");
        Date d2 = sdf.parse("04-05-2018 19:30:00");
        Date d3 = sdf.parse("03-05-2018 23:00:00");
        Date d4 = sdf.parse("08-05-2018 10:00:00");
        Date d5 = sdf.parse("10-05-2018 15:40:00");
        Date d6 = sdf.parse("11-05-2018 12:00:00");
        
        Tour t1 = new Tour("tour-1", d1, d1, "Akureyri", 10500, 3000, 0.4, "Skíðaferð", 30 );
        Tour t2 = new Tour("tour-2", d2, d2, "Reykjavík", 20000, 0 , 4.3, "Norðurljósaferð", 30 );
        Tour t3 = new Tour("tour-3", d3, d3, "Akureyri", 10500, 3000, 2.4, "Óvissuferð", 30 );
        Tour t4 = new Tour("tour-4", d3, d4, "Reykjavík", 20000, 0 , 5.0, "Sund", 30 );
        Tour t5 = new Tour("tour-5", d4, d4, "Akureyri", 10500, 3000, 4.4, "Fjallganga", 30 );
        Tour t6 = new Tour("tour-6", d6, d6, "Reykjavík", 20000, 0 , 4.5, "Norðurljósaferð", 30 );
        this.tours = new Tour[]{t1, t2};
    }
    
    public Tour[] getTours() {
        return this.tours;
    }
    
}
