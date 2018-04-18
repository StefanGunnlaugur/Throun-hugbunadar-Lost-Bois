/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGroup.JFrame;

import hotelGroup.Storage.DaysModel;
import hotelGroup.Storage.MonthsModel;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author marinmcginley
 */
public class Search extends javax.swing.JDialog {

    private DaysModel days;
    private MonthsModel monthFrom;
    private MonthsModel monthTo;
    private Boolean save;
    private String userName;

    
    
    /**
     * Creates new form Search
     */
    public Search(java.awt.Frame parent, boolean modal, String userName) {
        super(parent, modal);
        initComponents();
        
        this.userName = userName;
        setUserName();
        initializeOnStart();
        save = false;
        
    }
    
    private void setUserName() {
        if (!userName.equals("")) {
            jUserName.setText(userName);
        }   
    }
    
    private void initializeOnStart() {
        initializeCombo();
    }
    
    /*
    Setur gildi 1-12 í ComboBox sem er skilgreint fyrir box með mánuðum 
    */
    private void initializeCombo(){
       int[]  months = {1,2,3,4,5,6,7,8,9,10,11,12}; // mánuðir 1-12
       
       monthFrom = new MonthsModel(months);
       monthTo = new MonthsModel(months);
       jMonthFrom.setModel(monthFrom);
       jMonthTo.setModel(monthTo);
    }
    
        /*
       Fallið skilar boolean breytu hvort það er búið að ýta á Vista (og engar villur eru í validation) eða ekki.
    */
    public Boolean isVista(){
        return save;
    }
    public String searchGetHotelName(){
        if(jNameOfHotel.getText().toLowerCase() != " "){
            return jNameOfHotel.getText().toLowerCase();
        }
        return "";
    }
    
    public String searchGetLocation(){
        if(jLocation.getText().toLowerCase() != " ") {
            return jLocation.getText().toLowerCase();
        }
        return "";
    }
    public int searchGetGradeFrom(){
        if(String.valueOf(jGradeFrom.getSelectedItem()) != " "){
            return Integer.valueOf(String.valueOf(jGradeFrom.getSelectedItem()));
        }
        return -1;
    }
    public int searchGetGradeTo(){
        if(String.valueOf(jGradeTo.getSelectedItem()) != " "){
            return Integer.valueOf(String.valueOf(jGradeTo.getSelectedItem()));
        }
        return -1;
    }
    public String searchGetWifi(){
        if(jWifi.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetHandic(){
        if(jAviableForHandic.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetPickup(){
        if(jPickUp.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetBreakfast(){
        if(jBreakfastIncluded.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetSwimmingpool(){
        if(jPool.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetGym(){
        if(jGym.isSelected()){
            return "1";
        }
        return "";
    }
    public String searchGetDateFrom() {
        int dayFrom = 0;
        if(jDayFrom.getSelectedItem() != null){
            dayFrom = Integer.parseInt(jDayFrom.getSelectedItem().toString());
        }
        int monthFrom = 0;
        if(jMonthFrom.getSelectedItem().toString() != ""){
            monthFrom = Integer.parseInt(jMonthFrom.getSelectedItem().toString());
        }
        if(monthFrom != 0 && dayFrom != 0){
            return dayFrom+ "/" + monthFrom + "/2018";
        }
        
        return "";
    }
    public String searchGetDateTo(){
        int dayTo = 0;
        if(jDayTo.getSelectedItem() != null){
            dayTo = Integer.parseInt(jDayTo.getSelectedItem().toString());
        }
        int monthTo = 0;
        if(jMonthTo.getSelectedItem().toString() != ""){
            monthTo = Integer.parseInt(jMonthTo.getSelectedItem().toString());
        }
        if(monthTo != 0 && dayTo != 0){
            return dayTo + "/" + monthTo + "/2018";
        }
        
        return "";
    }
    public String searchGetPriceFrom(){
        if(String.valueOf(jPriceFrom.getSelectedItem()) != " ") {
            return jPriceFrom.getSelectedItem().toString();
        }
        return "0";
    }
    public String searchGetPriceTo(){
        if(String.valueOf(jPriceTo.getSelectedItem()) != " ") {
            return jPriceTo.getSelectedItem().toString();
        }
        return "300000";
    }
    public String searchGetGrownUp(){
        return jGrownUp.getSelectedItem().toString();
    }
    public String searchGetChildren(){
        if(jChildren.getSelectedItem().toString() != " "){
            return jChildren.getSelectedItem().toString();
        }
        return "";
    }
    
    
    
    
    private void showValidationMessage(String errorInformation) {
        String[] options = {"Ok", "Hætta við"};
        
            int n = JOptionPane.showOptionDialog(this,
                errorInformation,
                "Villa við leið",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
            
            if(n == 1) {
                setVisible(false);
            }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jNameOfHotel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLocation = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSearch = new javax.swing.JButton();
        jMonthFrom = new javax.swing.JComboBox<>();
        jDayFrom = new javax.swing.JComboBox<>();
        jMonthTo = new javax.swing.JComboBox<>();
        jDayTo = new javax.swing.JComboBox<>();
        jPriceFrom = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPriceTo = new javax.swing.JComboBox<>();
        jGradeFrom = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jGradeTo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jWifi = new javax.swing.JCheckBox();
        jPool = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jGym = new javax.swing.JCheckBox();
        jAviableForHandic = new javax.swing.JCheckBox();
        jPickUp = new javax.swing.JCheckBox();
        jBreakfastIncluded = new javax.swing.JCheckBox();
        jUserName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jGrownUp = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jChildren = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Hótel:");

        jLabel2.setText("Staðsetning:");

        jLabel3.setText("Frá:");

        jLabel4.setText("Til:");

        jLabel5.setText("Verð per. nótt :");

        jLabel6.setText("Vil skoða hotel sem er með einkunn á bilinu : ");

        jSearch.setText("Leita");
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });

        jMonthFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMonthFromActionPerformed(evt);
            }
        });

        jMonthTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMonthToActionPerformed(evt);
            }
        });

        jPriceFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "5000", "10000", "15000", "20000", "25000", "30000" }));

        jLabel7.setText("þús. -");

        jPriceTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "5000", "10000", "15000", "20000", "25000", "30000" }));

        jGradeFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel8.setText("-");

        jGradeTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel9.setText("þús.");

        jLabel10.setText("2018");

        jLabel11.setText("2018");

        jWifi.setText("WIFI");

        jPool.setText("Sundlaug");

        jLabel12.setText("<html>Ef þú óskar eftir að eftirfarandi sé til á hóteli sem þú ert að leita að, <br> endilega hakaðu þá í það </html>");

        jGym.setText("Ræktin");

        jAviableForHandic.setText("Aðgengi fyrir hreyfihamlaða");

        jPickUp.setText("Akstursþjónusta");

        jBreakfastIncluded.setText("Morgunmatur innifalinn");

        jLabel13.setText("Endilega fylltu út eftir hvaða upplýsingum þú vilt leita að hóteli");

        jLabel14.setText("mán.");

        jLabel15.setText("dag.");

        jLabel16.setText("mán.");

        jLabel17.setText("dag.");

        jLabel18.setText("Fjöldi fullorðna : ");

        jGrownUp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jLabel19.setText("Fjöldi barna : ");

        jChildren.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSearch)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jGrownUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jChildren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUserName)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(jNameOfHotel)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jGradeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jGradeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10)
                                                .addGap(116, 116, 116)
                                                .addComponent(jLabel4)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jMonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel11))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(308, 308, 308)
                                        .addComponent(jBreakfastIncluded)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPickUp)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jWifi)
                                        .addGap(105, 105, 105)
                                        .addComponent(jGym)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPool)
                                .addGap(59, 59, 59)))
                        .addComponent(jAviableForHandic)
                        .addGap(40, 40, 40))))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jNameOfHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jMonthTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDayTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jDayFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMonthFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jGrownUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jChildren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jGradeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jGradeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jWifi)
                    .addComponent(jGym)
                    .addComponent(jAviableForHandic)
                    .addComponent(jPool))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPickUp)
                    .addComponent(jBreakfastIncluded))
                .addGap(15, 15, 15)
                .addComponent(jSearch)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        // hér fer fram validation ! 
        
        int dayFrom = 0;
        if(jDayFrom.getSelectedItem() != null){
            dayFrom = Integer.parseInt(jDayFrom.getSelectedItem().toString());
        }
        int dayTo = 0;
        if(jDayTo.getSelectedItem() != null){
            dayTo = Integer.parseInt(jDayTo.getSelectedItem().toString());
        }
        int monthFrom = 0;
        if(jMonthFrom.getSelectedItem().toString() != ""){
            monthFrom = Integer.parseInt(jMonthFrom.getSelectedItem().toString());
        }
        int monthTo = 0;
        if(jMonthTo.getSelectedItem().toString() != ""){
            monthTo = Integer.parseInt(jMonthTo.getSelectedItem().toString());
        }
        
        int priceFrom = 0;
        if(jPriceFrom.getSelectedItem().toString() != " "){
            priceFrom = Integer.parseInt(jPriceFrom.getSelectedItem().toString());
        }
        int priceTo = 100000; // frumstilli það sem eitthvað mjög hátt
        if(jPriceTo.getSelectedItem().toString() != " "){
            priceTo = Integer.parseInt(jPriceTo.getSelectedItem().toString());
        }
        
        int gradeFrom = 0;
        if(jGradeFrom.getSelectedItem().toString() != " "){
            gradeFrom = Integer.parseInt(jGradeFrom.getSelectedItem().toString());
        }
        int gradeTo = 10; // frumstilli sem hæsta
        if(jGradeTo.getSelectedItem().toString() != " "){
            gradeTo = Integer.parseInt(jGradeTo.getSelectedItem().toString());
        }
        
        
        if((monthTo < monthFrom) && monthTo != 0 && monthFrom != 0) {
            showValidationMessage("Ekki er hægt að skrá sig út áður en það er innritað.");
        } else if(monthTo == monthFrom & dayTo <= dayFrom && monthTo != 0 && monthFrom != 0) {
            showValidationMessage("Ekki er hægt að skrá sig út áður en það er innritað");
        } else if(priceTo < priceFrom) {
            showValidationMessage("Verðbil er ekki rétt valið");
        } else if(gradeTo < gradeFrom) {
            showValidationMessage("Einkunnar-bil er ekki rétt valið");
        } else if (dayFrom == 0 || dayTo == 0 || monthFrom == 0 || monthTo == 0) {
            showValidationMessage("Vinsamlegast fylltu út dagsetningu frá og til");
        } else {
            save = true;
            setVisible(false);
        }
        
        
        
        // þurfum svo að gera eitthvað með það :) 
    }//GEN-LAST:event_jSearchActionPerformed

    private void jMonthFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMonthFromActionPerformed
        JComboBox cb1 = (JComboBox)evt.getSource();
        String manFra = String.valueOf(cb1.getSelectedItem());
        
        if(manFra.equals(" ")){
        }
        else {
            int man = Integer.valueOf(manFra);
            setMonths(man, "jManFra");
        }
    }//GEN-LAST:event_jMonthFromActionPerformed

    private void jMonthToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMonthToActionPerformed
        JComboBox cb2 = (JComboBox)evt.getSource();
        String monthsTo = String.valueOf(cb2.getSelectedItem());
        
        if(monthsTo.equals(" ")){
        }
        else {
            int man = Integer.valueOf(monthsTo);
            setMonths(man, "jManTil");
        }
    }//GEN-LAST:event_jMonthToActionPerformed

    
    /*
    Fallið tekur inn töluna man sem er mánuður sem var valinn, og býr til ArrayList með fjölda daga í þeim mánuði
    Uppfærir svo ComboBoxið sem sýnir þessa daga
    */
    public void setMonths(int man, String whichComboBox){
        ArrayList<Integer>  days = new ArrayList<>();
        
        switch(man) {
            case 1: case 3: case 5: case 7: case 8: case 10:  case 12:
                for(int i=1; i<32; i++){
                    days.add(i);
                }
                break;
            case 4: case 6: case 9: case 11:
                for(int i=1; i<31; i++){
                    days.add(i);
                }
                break;
            case 2:
                for(int i=1; i<29; i++){
                    days.add(i);
                }
                break;
        }
        setDays(days, whichComboBox);
    }
    
    /*
    Tekur inn listan með dögum í mánuðinum og lætur setja þessi stök í ComboBox fyrir daga 
    */
    private void setDays(ArrayList<Integer> m, String whichComboBox){
        days = new DaysModel(m);
        if(whichComboBox == "jManFra") {
            jDayFrom.setModel(days);
        } else if(whichComboBox == "jManTil") {
            jDayTo.setModel(days);
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Search dialog = new Search(new javax.swing.JFrame(), true, new String());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jAviableForHandic;
    private javax.swing.JCheckBox jBreakfastIncluded;
    private javax.swing.JComboBox<String> jChildren;
    private javax.swing.JComboBox<String> jDayFrom;
    private javax.swing.JComboBox<String> jDayTo;
    private javax.swing.JComboBox<String> jGradeFrom;
    private javax.swing.JComboBox<String> jGradeTo;
    private javax.swing.JComboBox<String> jGrownUp;
    private javax.swing.JCheckBox jGym;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLocation;
    private javax.swing.JComboBox<String> jMonthFrom;
    private javax.swing.JComboBox<String> jMonthTo;
    private javax.swing.JTextField jNameOfHotel;
    private javax.swing.JCheckBox jPickUp;
    private javax.swing.JCheckBox jPool;
    private javax.swing.JComboBox<String> jPriceFrom;
    private javax.swing.JComboBox<String> jPriceTo;
    private javax.swing.JButton jSearch;
    private javax.swing.JLabel jUserName;
    private javax.swing.JCheckBox jWifi;
    // End of variables declaration//GEN-END:variables
}
