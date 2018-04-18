/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelGroup.JFrame;

import hotelGroup.Model.SearchList;
import java.util.ArrayList;
import hotelGroup.Model.Hotel;
import hotelGroup.Model.Room;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author marinmcginley
 */
public class Index extends javax.swing.JFrame {


    private LogIn logIn;
    DefaultTableModel model;
    
    private Search search;
    
    public String listHotelName;
    public String lsitLocation;
    public String listPrice;
    public String listGrownUp;
    public String listChildren;
    public ArrayList<Integer> roomIdTableList;
    public int selectedRoomId;
    
    
    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
        

        
        jTable.getTableHeader().setPreferredSize(new Dimension(10,35)); // stilli breidd og hæð á column head
        model = (DefaultTableModel) jTable.getModel();
        roomIdTableList = new ArrayList<>();
        
        // Gera hnapp ósýnilega
        jLogOut.setVisible(false);
        //initializeTableInStart();
        
        jBook.setVisible(false);
        jScrollPanel2.setVisible(false);
        
        
        
    }
    
    /*private void initializeTableInStart(){
        SearchList s = new SearchList();
        jBook.setVisible(true);
        jScrollPanel2.setVisible(true);
        ArrayList<Hotel> allHotel = s.getAllHotel();
        putListInTable(allHotel, "", "");
    }*/
    
    public void putListInTable(ArrayList<Hotel> hotelList, String dateFrom, String dateTo) {
        //Object[] row = new Object[11];
        
        for(int i=0; i<hotelList.size(); i++) {
            ArrayList<Room> hotelsRooms = hotelList.get(i).viewRooms();
            for(int j=0; j<hotelsRooms.size(); j++) {
                    String hotelName = hotelList.get(i).getNameOfHotel();
                    String location = hotelList.get(i).getLocationOfHotel();
                    int price = hotelsRooms.get(j).getPriceForNight();
                    int grade = 0;
                    int NumberOfGrownup = hotelsRooms.get(j).getNumberOfAdults();
                    int numberOfChildren = hotelsRooms.get(j).getNumberOfChildren();
                    boolean handic = hotelList.get(i).getAviableForHandic();
                    boolean gym = hotelList.get(i).getGym();
                    boolean swimmingpool = hotelList.get(i).getSwimmingPool();
                    boolean wifi = hotelList.get(i).getWifi();
                    boolean pickup = hotelList.get(i).getPickUp();
                    boolean breakfast = hotelList.get(i).getBreakfastIncluded();
                if(dateFrom.isEmpty() || dateTo.isEmpty()) {
                    model.addRow(new Object[]{hotelName,location,price,grade,NumberOfGrownup,numberOfChildren,handic,gym,swimmingpool,wifi,pickup,breakfast});
                } else {
                    boolean isBooked = checkIfBooked(hotelsRooms.get(j), dateFrom, dateTo);
                    if(!isBooked){
                        roomIdTableList.add(hotelsRooms.get(j).getRoomId());
                        model.addRow(new Object[]{hotelName,location,price,grade,NumberOfGrownup,numberOfChildren,handic,gym,swimmingpool,wifi,pickup,breakfast});
                    }
                }
            }
        }
    }
    
    // Skilar true ef það herbergi er bókað á þessu tímabili. annars false
    private Boolean checkIfBooked(Room room, String dateFrom, String dateTo) {
        ArrayList<Date> bookedDates = room.getBookedDates();
        Date date1 = null;
        Date date2 = null;
        try { 
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateFrom);
            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateTo);
        } catch (ParseException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
         for(int k = 0; k<bookedDates.size(); k++) {
            //System.out.println(bookedDates.get(k) + " skoða : " + dateFrom + "after : " + bookedDates.get(k).compareTo(date1) + " " + dateTo + " before : " + bookedDates.get(k).compareTo(date2));
            if(bookedDates.get(k).compareTo(date1) >= 0 && bookedDates.get(k).compareTo(date2) < 0){
                return true;
            }
        }
        return false;
    }


    public void initializeAfterLogIn() {

        jLogIn.setVisible(false);
        jRegister.setVisible(false);
        
        jLogOut.setVisible(true);
        jUserName.setText(logIn.getUserName());
        

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jText = new javax.swing.JLabel();
        jLogIn = new javax.swing.JButton();
        jRegister = new javax.swing.JButton();
        jSearch = new javax.swing.JButton();
        jScrollPanel2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLogOut = new javax.swing.JButton();
        jUserName = new javax.swing.JLabel();
        jBook = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jText.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jText.setText("Velkomin inná forritið okkar.  Hér getur þú leita að hóteli á Íslandi :");

        jLogIn.setText("Innskráning");
        jLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogInActionPerformed(evt);
            }
        });

        jRegister.setText("Nýskráning");
        jRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterActionPerformed(evt);
            }
        });

        jSearch.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jSearch.setText("Byrja leit");
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });

        jTable.setBorder(new javax.swing.border.MatteBorder(null));
        jTable.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hotel", "Staðsetning", "Verð", "Einkunn", "<html>Fjöldi<br>fullorðna</html>", "Fjöldi barna", "<html>Aðfengi fyrir<br> hreyfihamlaða</html>", "Ræktin", "Sundlaug", "WIFI", "<html>Aksturs-<br>þjónusta</btml>", "<html> Morgunmatur<br> innifalinn</html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setRowHeight(20);
        jTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable.setSelectionForeground(new java.awt.Color(0, 51, 255));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPanel2.setViewportView(jTable);
        jTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLogOut.setText("Útskráning");
        jLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogOutActionPerformed(evt);
            }
        });

        jBook.setText("Bóka");
        jBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLogIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRegister))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPanel2)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(jSearch)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jText)
                        .addGap(104, 104, 104)
                        .addComponent(jUserName)
                        .addGap(63, 63, 63)
                        .addComponent(jLogOut))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBook, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogIn)
                    .addComponent(jRegister))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogOut)
                    .addComponent(jUserName)
                    .addComponent(jText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSearch)
                .addGap(25, 25, 25)
                .addComponent(jScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBook, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        model.setRowCount(0); // hreinsum töfluna
        jScrollPanel2.setVisible(true);
        search = null;
        
        if (logIn == null) {
            search = new Search(this, true, "");
        } else {
            search = new Search(this, true, logIn.getUserName());
        }

        search.setVisible(true);
        
        if(search.isVista() == true) {
            SearchList s = new SearchList();
            
            String nafnHotel = search.searchGetHotelName();
            String location = search.searchGetLocation();
            int gradeFrom = search.searchGetGradeFrom();
            int gradeTo = search.searchGetGradeTo();
            if(gradeTo == -1) {
                gradeTo = 1000000; // stilli sem eitthvað mjög stórt;
            }
            String wifi = search.searchGetWifi();
            String handic = search.searchGetHandic();
            String pickUp = search.searchGetPickup();
            String breakfast =search.searchGetBreakfast();
            String swimming = search.searchGetSwimmingpool();
            String gym = search.searchGetGym();
            
            
            String dateFrom = search.searchGetDateFrom();
            String dateTo = search.searchGetDateTo();
            String priceFrom = search.searchGetPriceFrom();
            String priceTo = search.searchGetPriceTo();
            String grownUp = search.searchGetGrownUp();
            String children = search.searchGetChildren();
            

            ArrayList<hotelGroup.Model.Hotel> hotelList = SearchList.getHotel("SELECT * FROM Hotel WHERE nameOfHotel LIKE '%" + nafnHotel + "%'"
                    + " AND location LIKE '%" + location +"%'"
                    + " AND aviableForHandic LIKE '%" + handic + "%'"
                    + " AND gym LIKE '%" + gym + "%'"    
                    + " AND swimmingPool LIKE '%" + swimming + "%'"
                    + " AND wifi LIKE '%" + wifi + "%'"
                    + " AND pickUp LIKE '%" + pickUp + "%'"
                    + " AND breakfastIncluded LIKE '%" + breakfast + "%'"        
                    + " AND grade > " + gradeFrom + " AND grade < " + gradeTo,
                    dateFrom, dateTo, priceFrom, priceTo, grownUp, children);
            
            putListInTable(hotelList, dateFrom, dateTo);
        }
        jBook.setVisible(true);
    }//GEN-LAST:event_jSearchActionPerformed

    private void jLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogInActionPerformed
        logIn = new LogIn(this, true);  
        logIn.setVisible(true);
        if (logIn.getUserName() != null) {
            initializeAfterLogIn();
        }
        //jBook.setVisible(true);
    }//GEN-LAST:event_jLogInActionPerformed

    private void jRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterActionPerformed
        Register nyskraning = null;
        
        nyskraning = new Register(this, true);
        
        nyskraning.setVisible(true);
    }//GEN-LAST:event_jRegisterActionPerformed

    private void jLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogOutActionPerformed
        logIn = null;
        jLogOut.setVisible(false);
        jUserName.setText(null);
        
        jLogIn.setVisible(true);
        jRegister.setVisible(true);
        jBook.setVisible(false);
    }//GEN-LAST:event_jLogOutActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        
        int row = jTable.getSelectedRow();
        
        selectedRoomId = roomIdTableList.get(row);
        
        listHotelName = model.getValueAt(row,0).toString();
        lsitLocation = model.getValueAt(row,1).toString();
        listPrice = model.getValueAt(row,2).toString();
        listGrownUp = model.getValueAt(row,4).toString();
        listChildren = model.getValueAt(row,5).toString();
        
    }//GEN-LAST:event_jTableMouseClicked

    private void jBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBookActionPerformed
        BookingFrame newBooking = new BookingFrame(this, true, this, logIn.getUserName(), search.searchGetDateFrom(), search.searchGetDateTo());
        newBooking.setVisible(true);
    }//GEN-LAST:event_jBookActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*DatabaseConnection connection = new DatabaseConnection();
        connection.connect();*/

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBook;
    private javax.swing.JButton jLogIn;
    private javax.swing.JButton jLogOut;
    private javax.swing.JButton jRegister;
    private javax.swing.JScrollPane jScrollPanel2;
    private javax.swing.JButton jSearch;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel jText;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jUserName;
    // End of variables declaration//GEN-END:variables
}