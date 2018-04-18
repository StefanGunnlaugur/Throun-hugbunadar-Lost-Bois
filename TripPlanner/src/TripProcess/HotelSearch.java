package TripProcess;

import hotelGroup.Model.Hotel;
import hotelGroup.Model.Room;
import hotelGroup.Model.SearchList;
import static hotelGroup.Model.SearchList.getAllHotel;
import static hotelGroup.Model.SearchList.getHotel;
import static hotelGroup.Model.SearchList.getHotel;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class HotelSearch {

    // Talar við db hjá hinum hópunum 
    private ArrayList<TripHotel> hotels;
    private LocalDate startDate, endDate;
    private String location;
    
    public HotelSearch(Date SD, Date ED, String location, int adults, int childs) {
        this.hotels = new ArrayList<TripHotel>();
        this.location = location;
        if (startDate!=null && endDate!=null){
            this.startDate = SD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            this.endDate = ED.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        
        ArrayList<Hotel> searchHotels = getAllHotel();       
        LocalDate[] dates = {startDate, endDate};
        Random r = new Random();
        
        for(Hotel hotel: searchHotels){
            String hotelLocat = hotel.getLocationOfHotel(); 
            if(hotelLocat.equals("Egilsstadir")) { hotelLocat = "Egilsstaðir";}
            if(hotelLocat.equals("Isafjördur")) { hotelLocat = "Ísafjörður";}
            if(hotelLocat.equals("Húsafell")) { hotelLocat = "Húsavík";}
            if(location==null || location.isEmpty() || hotelLocat.equals(location)) {
                double ratingFix = 1 + (5 - 1) * r.nextDouble();
                ratingFix = Math.round(ratingFix*10);
                for( Room room : hotel.rooms){
                    if (room.isAvailable(dates)){
                        TripHotel currHotel = new TripHotel( room.getRoomId()+"", 
                                SD, ED, hotelLocat, 
                                room.getPriceForNight(), room.getPriceForNight(),  
                                ratingFix/10, hotel.getNameOfHotel(), room.getRoomId());
                        hotels.add(currHotel);
                    }
                }
            }
        }
        
        
        
        
        
        
        /*       
        // --------- FAKE DATA FOR TESTING --------
        ArrayList<Hotel> testing = new ArrayList<Hotel>();
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
        
        Hotel h1 = new Hotel("hotel-1", d1, d5, "Akureyri", 10000, 3900, 0.4, "-- Finnum Þetta -- ", 30 );
        Hotel h2 = new Hotel("Hotel-2", d3, d6, "Reykjavík", 26000, 8000, 4.2, "Hotel Örk", 12 );
        Hotel h3 = new Hotel("hotel-3", d2, d10, "Keflavík", 15000, 3800, 1.4, "Hotel Kef", 30 );
        Hotel h4 = new Hotel("Hotel-4", d1, d15, "Reykjavík", 45600, 4500, 4.5, "Hotel Saga", 12 );
        Hotel h5 = new Hotel("hotel-5", d4, d8, "Akureyri", 18000, 3000, 3.0, "Hotel Borg", 30 );
        Hotel h6 = new Hotel("Hotel-6", d4, d9, "Keflavík", 35600, 6000, 4.5, "Hotel Kef", 12 );
        Hotel h7 = new Hotel("hotel-7", d8, d15, "Akureyri", 27600, 3000, 2.4, "Hotel Borg", 30 );
        Hotel h8 = new Hotel("Hotel-8", d3, d13, "Reykjavík", 26000, 1900, 3.7, "Hotel Örk", 12 );
        Hotel h9 = new Hotel("hotel-9", d5, d12, "Keflavík", 16000, 3000, 3.5, "Hotel Kef", 30 );
        Hotel h10 = new Hotel("Hotel-10", d1, d14, "Reykjavík", 9900, 4000, 2.9, "Hotel Saga", 12 );
        Hotel h11 = new Hotel("hotel-11", d4, d5, "Akureyri", 10000, 3900, 0.4, "Hotel Borg", 30 );
        Hotel h12 = new Hotel("Hotel-12", d4, d6, "Reykjavík", 26000, 8000, 4.2, "Hotel Örk", 12 );
        Hotel h13 = new Hotel("hotel-13", d3, d11, "Keflavík", 15000, 3800, 1.4, "Hotel Kef", 30 );
        Hotel h14 = new Hotel("Hotel-14", d1, d15, "Reykjavík", 45600, 4500, 4.5, "Hotel Saga", 12 );
        Hotel h15 = new Hotel("hotel-15", d6, d13, "Akureyri", 18000, 3000, 3.0, "Hotel Borg", 30 );
        Hotel h16 = new Hotel("Hotel-16", d4, d9, "Keflavík", 35600, 6000, 4.5, "Hotel Kef", 12 );
        Hotel h17 = new Hotel("hotel-17", d3, d14, "Akureyri", 27600, 3000, 2.4, "Hotel Borg", 30 );
        Hotel h18 = new Hotel("Hotel-18", d3, d10, "Reykjavík", 26000, 1900, 3.7, "Hotel Örk", 12 );
        Hotel h19 = new Hotel("hotel-19", d5, d11, "Keflavík", 16000, 3000, 3.5, "Hotel Kef", 30 );
        Hotel h20 = new Hotel("Hotel-20", d1, d9, "Reykjavík", 9900, 4000, 2.9, "Hotel Saga", 12 );
        
        
        testing.addAll(Arrays.asList(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10,
                h11, h12, h13, h14, h15, h16, h17, h18, h19, h20));
        
        for (Hotel hotel: testing){
             boolean add = true;
             if (startDate!=null && !isSameDay(startDate, hotel.getStartDate())){
                 add = false;                
             } 
             if (endDate!=null && !isSameDay(endDate, hotel.getEndDate())){
                 add = false;
             }
             if (location!=null && !location.isEmpty() && !location.equals(hotel.getLocation())){
                 add = false;
             }
             if(add){
                 this.hotels.add(hotel);
             }
        }*/
        
        
    }
        
    public ArrayList<TripHotel> getHotels() {
        return this.hotels;
    }
    
}
