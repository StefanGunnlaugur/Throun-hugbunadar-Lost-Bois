/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGroup.Storage;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bob
 */
public class DaysModel extends DefaultComboBoxModel { 
     
     /*
        Smiður
        Tekur inn ArrayList sem er listi með dögum og uppfærir ComboBox með þessum
        lista
     */
     public DaysModel(ArrayList<Integer> man){
         addElement("");
         for(int a=0; a<man.size(); a++){
            if(a<9)
                addElement("0"+man.get(a));
            else
                addElement(man.get(a));
        }
    }
}
