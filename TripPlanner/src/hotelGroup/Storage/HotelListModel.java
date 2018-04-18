/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGroup.Storage;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import hotelGroup.Model.Hotel;

/**
 *
 * @author Bob
 */
public class HotelListModel extends DefaultListModel {
    
    public HotelListModel(ArrayList<Hotel> hotelList) {
        for(Hotel a : hotelList){
            addElement(a.getNameOfHotel());
        }
    }
    
}
