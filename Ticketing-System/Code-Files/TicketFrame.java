
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TicketFrame extends javax.swing.JFrame {

    List<Stations> stationses = new ArrayList<>();
    List<Passenger> purchases = new ArrayList<>();
    Double oneWayAdultPrice = 0.0, oneWayChildrenPrice = 0.0, oneWaySeniorPrice = 0.0;
    Double weekylAdultPrice = 0.0, weekylChildrenPrice = 0.0, weekylSeniorPrice = 0.0;
    Double returnAdultPrice = 0.0, returnChildrenPrice = 0.0, returnSeniorPrice = 0.0;
    Double oneWayTicketPrice = 0.0, returnTicketPrice = 0.0, weekylTicketPrice = 0.0;

    public TicketFrame() {
        initComponents();
        setLocation(300, 100);
        fillTicketTypeCombo();
        fillFromCombo();
        fillPassengerTypeCombo();
    }
 // method for filling ticket Types
    public void fillTicketTypeCombo() {
        List<TicketType> ticketTypes = new ArrayList<>();

        TicketType ticketType1 = new TicketType();
        ticketType1.setTicketType("One-way");

        TicketType ticketType2 = new TicketType();
        ticketType2.setTicketType("Return");

        TicketType ticketType3 = new TicketType();
        ticketType3.setTicketType("Weekly");

        ticketTypes.add(ticketType1);
        ticketTypes.add(ticketType2);
        ticketTypes.add(ticketType3);

        for (int i = 0; i < ticketTypes.size(); i++) {
            ticketTypeCombo.addItem(ticketTypes.get(i).getTicketType());
        }
    }
// method for passenger type
    public void fillPassengerTypeCombo() {
        List<Passenger> passengers = new ArrayList<>();

        Passenger passenger1 = new Passenger();
        passenger1.setPassengerType("Adult");

        Passenger passenger2 = new Passenger();
        passenger2.setPassengerType("Children");

        Passenger passenger3 = new Passenger();
        passenger3.setPassengerType("Senior");

        passengers.add(passenger1);
        passengers.add(passenger2);
        passengers.add(passenger3);

        for (int i = 0; i < passengers.size(); i++) {
            passengerTypeCombo.addItem(passengers.get(i).getPassengerType());
        }
    }
// method for filling locations combo
    public void fillFromCombo() {

        Stations stations1 = new Stations();
        stations1.setTo("Kiama");

        Stations stations2 = new Stations();
        stations2.setTo("Shellharbour");

        Stations stations3 = new Stations();
        stations3.setTo("Dapto");

        Stations stations4 = new Stations();
        stations4.setTo("Wollongong");

        Stations stations5 = new Stations();
        stations5.setTo("North Wollongong");

        Stations stations6 = new Stations();
        stations6.setTo("Thirroul");

        Stations stations7 = new Stations();
        stations7.setTo("Sutherland");

        Stations stations8 = new Stations();
        stations8.setTo("Hurstville");

        Stations stations9 = new Stations();
        stations9.setTo("Wolli Creek");

        Stations stations10 = new Stations();
        stations10.setTo("Central");

        stationses.add(stations1);
        stationses.add(stations2);
        stationses.add(stations3);
        stationses.add(stations4);
        stationses.add(stations5);
        stationses.add(stations6);
        stationses.add(stations7);
        stationses.add(stations8);
        stationses.add(stations9);
        stationses.add(stations10);

        for (int i = 0; i < stationses.size(); i++) {
            fromCombo.addItem(stationses.get(i).getTo());
        }
    }
// method for filling to locations combo
    public void fillToCombo(String fromSelected) {
        toCombo.removeAllItems();
        for (int i = 0; i < stationses.size(); i++) {
            if (!(stationses.get(i).getTo().equals(fromSelected))) {
                toCombo.addItem(stationses.get(i).getTo());
            }

        }
    }
// method to write the data in txt file
    public void generateTxtFile(Passenger p, Double totalPrice) {
        try {
            File f = new File(p.getFullName() + "-" + p.getPassengerType() + "-ticket.txt");
            FileWriter fw = new FileWriter(f);
            fw.write("Passenger Name     : " + p.getFullName() + "\n");
            fw.write("Passenger Age      : " + p.getAge() + "\n");
            fw.write("Passenger DOB      : " + p.getDob() + "\n");
            fw.write("Passenger Contact  : " + p.getContact() + "\n");
            fw.write("Ticket Type        : " + p.getTicketType() + "\n");
            fw.write("Passenger Type     : " + p.getPassengerType() + "\n");
            fw.write("Location From      : " + p.getFrom() + "\n");
            fw.write("Location To        : " + p.getTo() + "\n");
            fw.write("Total Ticket Price : " + totalPrice + "\n");
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {

        fromCombo = new javax.swing.JComboBox();
        toCombo = new javax.swing.JComboBox();
        headerLbl = new javax.swing.JLabel();
        fromLbl = new javax.swing.JLabel();
        toLbl = new javax.swing.JLabel();
        ticketTypeLbl = new javax.swing.JLabel();
        ticketTypeCombo = new javax.swing.JComboBox();
        passengerTypeLbl = new javax.swing.JLabel();
        passengerTypeCombo = new javax.swing.JComboBox();
        personInfromationLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        ageLbl = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        dobLbl = new javax.swing.JLabel();
        dobField = new javax.swing.JTextField();
        contactLbl = new javax.swing.JLabel();
        contactField = new javax.swing.JTextField();
        confirmBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fromCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromComboActionPerformed(evt);
            }
        });

        headerLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headerLbl.setText("Ticket Booking");

        fromLbl.setText("From");

        toLbl.setText("To");

        ticketTypeLbl.setText("Ticket Type");

        passengerTypeLbl.setText("Passenger Type");

        personInfromationLbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        personInfromationLbl.setText("Personal Information");

        nameLbl.setText("Full Name");

        ageLbl.setText("Age");

        dobLbl.setText("DOB");

        contactLbl.setText("Contact");

        confirmBtn.setText("Confirm");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(personInfromationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nameLbl)
                        .addGap(24, 24, 24)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(ageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(dobLbl)
                        .addGap(49, 49, 49)
                        .addComponent(dobField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(contactLbl)
                        .addGap(52, 52, 52)
                        .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ticketTypeLbl)
                        .addGap(15, 15, 15)
                        .addComponent(ticketTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passengerTypeLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(passengerTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fromLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(toCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromLbl)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(toLbl)
                        .addComponent(toCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fromCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passengerTypeLbl)
                            .addComponent(passengerTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ticketTypeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ticketTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addComponent(personInfromationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLbl)
                            .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dobField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dobLbl)
                            .addComponent(contactLbl))))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void fromComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromComboActionPerformed
        fillToCombo(fromCombo.getSelectedItem().toString());
    }

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed

        String fullName, dob, contact, ticketType, passengerType, from, to;
        Integer age;
        Double totalPrice = 0.0;
        if (nameField.getText().equals("") || ageField.getText().equals("")
                || dobField.getText().equals("") || contactField.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!!");
            return;
        } else {

            fullName = nameField.getText();
            dob = dobField.getText();
            contact = contactField.getText();
            age = Integer.parseInt(ageField.getText());
            ticketType = ticketTypeCombo.getSelectedItem().toString();
            passengerType = passengerTypeCombo.getSelectedItem().toString();
            from = fromCombo.getSelectedItem().toString();
            to = toCombo.getSelectedItem().toString();

            if (passengerType.equals("Adult")) {
                int fromIndex = 0, toIndex = 0;
                for (int i = 0; i < stationses.size(); i++) {
                    if (stationses.get(i).getTo().equals(from)) {
                        fromIndex = i + 1;
                    }
                    if (stationses.get(i).getTo().equals(to)) {
                        toIndex = i + 1;
                    }
                }
                if ((fromIndex > 0 && fromIndex != 9) && (toIndex > 0 && toIndex != 9)) {
                    oneWayAdultPrice = (fromIndex - toIndex) * 1.2;
                    if (oneWayAdultPrice < 0) {
                        oneWayAdultPrice = -1 * oneWayAdultPrice;
                    }
                    oneWayAdultPrice = Math.round(oneWayAdultPrice * 100.0) / 100.0;
                    System.out.println("Adult One-way Price is : " + oneWayAdultPrice);
                } else if (fromIndex == 9 || toIndex == 9) {
                    fromIndex = 0;
                    toIndex = 0;
                    oneWayAdultPrice = (fromIndex - toIndex) * 1.2 + 15;

                    if (oneWayAdultPrice < 0) {
                        oneWayAdultPrice = -1 * oneWayAdultPrice;
                    }
                    oneWayAdultPrice = Math.round(oneWayAdultPrice * 100.0) / 100.0;
                    System.out.println("Adult One-Way Price is in wadhh : " + oneWayAdultPrice);
                }
                returnAdultPrice = oneWayAdultPrice * 1.8;
                returnAdultPrice = Math.round(returnAdultPrice * 100.0) / 100.0;
                System.out.println("Adult Return Ticket Price is : " + returnAdultPrice);

                weekylAdultPrice = returnAdultPrice * 6;
                weekylAdultPrice = Math.round(weekylAdultPrice * 100.0) / 100.0;
                System.out.println("Adult Weekly Ticket Price is : " + weekylAdultPrice);

                totalPrice = oneWayAdultPrice + returnAdultPrice + weekylAdultPrice;

                System.out.println("Total Price : " + totalPrice);

            }
            if (passengerType.equals("Children")) {
                oneWayChildrenPrice = oneWayAdultPrice * 0.5;
                returnChildrenPrice = returnAdultPrice * 0.5;
                weekylChildrenPrice = weekylAdultPrice * 0.5;

                System.out.println("Children One-Way Price is : " + oneWayChildrenPrice);
                System.out.println("Children Return Price is : " + returnChildrenPrice);
                System.out.println("Children Weekly Price is : " + weekylChildrenPrice);

                totalPrice = oneWayChildrenPrice + returnChildrenPrice + weekylChildrenPrice;

                System.out.println("Total Price : " + totalPrice);
            }
            if (passengerType.equals("Senior")) {

                oneWaySeniorPrice = oneWayAdultPrice * 0.1;
                returnSeniorPrice = returnAdultPrice * 0.1;
                returnSeniorPrice = Math.round(returnSeniorPrice * 100.0) / 100.0;
                weekylSeniorPrice = 0.0;

                System.out.println("Senior One-Way Price is : " + oneWaySeniorPrice);
                System.out.println("Senior Reutrn Price is : " + returnSeniorPrice);
                System.out.println("Senior Weekly Price is : " + weekylSeniorPrice);

                totalPrice = oneWaySeniorPrice + returnSeniorPrice;
                totalPrice = Math.round(totalPrice * 100.0) / 100.0;
                System.out.println("Total Price : " + totalPrice);
            }
        }
        // creating student object and setting values
        Passenger p = new Passenger();
        p.setFullName(fullName);
        p.setAge(age);
        p.setContact(contact);
        p.setDob(dob);
        p.setPassengerType(passengerType);
        p.setFrom(from);
        p.setTo(to);
        p.setTicketType(ticketType);
        generateTxtFile(p, totalPrice);
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLbl;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JTextField contactField;
    private javax.swing.JLabel contactLbl;
    private javax.swing.JTextField dobField;
    private javax.swing.JLabel dobLbl;
    private javax.swing.JComboBox fromCombo;
    private javax.swing.JLabel fromLbl;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JComboBox passengerTypeCombo;
    private javax.swing.JLabel passengerTypeLbl;
    private javax.swing.JLabel personInfromationLbl;
    private javax.swing.JComboBox ticketTypeCombo;
    private javax.swing.JLabel ticketTypeLbl;
    private javax.swing.JComboBox toCombo;
    private javax.swing.JLabel toLbl;
    // End of variables declaration//GEN-END:variables
}
