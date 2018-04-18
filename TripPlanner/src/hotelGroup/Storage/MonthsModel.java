/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGroup.Storage;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Bob
 */
public class MonthsModel extends DefaultComboBoxModel  {
    
    private int[] manudir;
    
    /*
    Smiður
    Tekur inn fylki með mánuðum og uppfærir ComboBoxið með þeim
    */
    public MonthsModel(int[] man){
        this.manudir = man;
        addElement("");
        for(int a=0; a<manudir.length; a++) {
            if(a<9)
                addElement("0"+manudir[a]);
            else
                addElement(manudir[a]);
        }
    }
}
