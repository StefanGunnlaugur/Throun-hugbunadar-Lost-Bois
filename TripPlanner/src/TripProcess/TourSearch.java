package TripProcess;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import daytourGroup.database.Gagnagrunnur;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TourSearch {
    // Talar við db hjá hinum hópunum 
    private ArrayList<Tour> tours; 
    private Date startDate, enddate;
    private String location;
    
    public TourSearch(Date startDate, Date endDate, String location){
        
        this.tours = new ArrayList<Tour>();
        this.startDate = startDate;
        this.enddate = endDate;
        this.location = location;

        
        Random r = new Random();
   
        Gagnagrunnur gagnagrunnur = new Gagnagrunnur();
        try {
            ResultSet rs = gagnagrunnur.getTrips();
            while (rs.next()) {
                String loc = rs.getString("departures");
                if(location==null || loc==location){
                    String id = rs.getInt("Id")+"";
                    String title = rs.getString("title");
                    int price = rs.getInt("price");
                    long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
                    Date date = new Date(random);  
                    double ratingFix = 1 + (5 - 1) * r.nextDouble();
                    ratingFix = Math.round(ratingFix*10);

                    Tour tour = new Tour(id, date, loc, price, ratingFix/10, title);
                    tours.add(tour);
                    
                }
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TourSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            
            /*
            // --------- FAKE DATA FOR TESTING --------
            ArrayList<Tour> testing = new ArrayList<Tour>();
            Date d1 = new Date(1525166100000L);
            Date d2 = new Date(1525177800000L);
            Date d3 = new Date(1525242600000L);
            Date d4 = new Date(1525291200000L);
            Date d5 = new Date(1525303800000L);
            Date d6 = new Date(1525343400000L);
            Date d7 = new Date(1525359600000L);
            Date d8 = new Date(1525384800000L);
            Date d9 = new Date(1525416300000L);
            Date d10 = new Date(1525416600000L);
            Date d11 = new Date(1525464600000L);
            Date d12 = new Date(1525469400000L);
            Date d13 = new Date(1525555800000L);
            Date d14 = new Date(1525501800000L);
            Date d15 = new Date(1525528800000L);
            
            Tour t1 = new Tour("tour-1", d1, "Akureyri", 10500, 3000, 2.4, "Skíðaferð", 30 );
            Tour t2 = new Tour("tour-2", d2, "Reykjavík", 20000, 0 , 4.1, "Norðurljósaferð", 30 );
            Tour t3 = new Tour("tour-3", d3, "Akureyri", 10500, 3000, 2.4, "Óvissuferð", 30 );
            Tour t4 = new Tour("tour-4", d4, "Keflvík", 20000, 0 , 3.0, "Sund", 30 );
            Tour t5 = new Tour("tour-5", d5, "Akureyri", 10500, 3000, 4.4, "Fjallganga", 30 );
            Tour t6 = new Tour("tour-6", d6, "Reykjavík", 20000, 0 , 4.9, "Norðurljósaferð", 30 );
            Tour t7 = new Tour("tour-7", d7, "Keflvík", 20000, 0 , 4.3, "Norðurljósaferð", 30 );
            Tour t8 = new Tour("tour-8", d8, "Akureyri", 10500, 3000, 2.4, "Óvissuferð", 30 );
            Tour t9 = new Tour("tour-9", d9, "Reykjavík", 20000, 0 , 5.0, "Sund", 30 );
            Tour t10 = new Tour("tour-10", d10, "Keflvík", 10500, 3000, 2.1, "Fjallganga", 30 );
            Tour t11 = new Tour("tour-11", d11, "Akureyri", 10500, 3000, 2.4, "Skíðaferð", 30 );
            Tour t12 = new Tour("tour-12", d12, "Keflvík", 20000, 0 , 4.1, "Norðurljósaferð", 30 );
            Tour t13 = new Tour("tour-13", d13, "Reykjavík", 10500, 3000, 2.4, "Óvissuferð", 30 );
            Tour t14 = new Tour("tour-14", d14, "Keflvík", 20000, 0 , 3.0, "Sund", 30 );
            Tour t15 = new Tour("tour-15", d15, "Akureyri", 10500, 3000, 4.4, "Fjallganga", 30 );
            Tour t16 = new Tour("tour-16", d6, "Reykjavík", 20000, 0 , 4.9, "Norðurljósaferð", 30 );
            Tour t17 = new Tour("tour-17", d4, "Keflvík", 20000, 0 , 4.3, "Norðurljósaferð", 30 );
            Tour t18 = new Tour("tour-18", d10, "Akureyri", 10500, 3000, 2.4, "Óvissuferð", 30 );
            Tour t19 = new Tour("tour-19", d14, "Keflvík", 20000, 0 , 5.0, "Sund", 30 );
            Tour t20 = new Tour("tour-20", d8, "Akureyri", 10500, 3000, 2.1, "Fjallganga", 30 );
            
            testing.addAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9 ,t10,
            t11, t12, t13, t14, t15, t16, t17, t18, t19, t20));
            
            for (Tour tour: testing){
            boolean add = true;
            if (startDate!=null && !tour.getStartDate().after(startDate)){
            add = false;
            } 
            if (endDate!=null && !tour.getEndDate().before(endDate)){
            add = false;
            }
            if (location!=null && !location.isEmpty() && !location.equals(tour.getLocation())){
            add = false;
            }
            if(add){
            this.tours.add(tour);
            }
            }*/        
        
    }
    
    public ArrayList<Tour> getTours() {
        return this.tours;
    }
    
}
