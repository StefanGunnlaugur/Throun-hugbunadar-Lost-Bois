/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Palli
 */
public class SearchTest {
    private Search flights, hotels, tours;
    
    public SearchTest() {
    }
    
    @Before
    public void setUp() {
        flights = new Search("Akureyri", "date", "date");
        hotels = new Search("Hotel Borg", "date", "date");
        tours = new Search("Reykjavik", "date", "date");
    }
    
    @After
    public void tearDown() {
        flights = null;
        hotels = null;
        tours = null;
    }

    /**
     * Test of classes
     */
    
    @Test
    public void testSearch() {
        assertEquals("Akureyri", flights.FlightSearchMock());
        assertEquals("Hotel Borg", hotels.HotelSearchMock());
        assertEquals("Reykjavik", tours.TourSearchMock());
    }
  
    @Test
    public void testLocation() {
        assertEquals(null, flights.getLocation());
        assertEquals(null, hotels.getLocation());
        assertEquals(null, tours.getLocation());
    }
    
    @Test
    public void testStartDate() {
        assertEquals(null, flights.getStartDate());
        assertEquals(null, hotels.getStartDate());
        assertEquals(null, tours.getStartDate());
    }
    
    @Test
    public void testEndDate() {
        assertEquals(null, flights.getEndDate());
        assertEquals(null, hotels.getEndDate());
        assertEquals(null, tours.getEndDate());
    }
    
}
   