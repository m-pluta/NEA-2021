/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author Michal
 */
public class formMainMenu extends javax.swing.JFrame {

    /**
     * Creates new form formMainMenu
     */
    Connection conn = null;                                         // Stores the connection object
    static int loggedIn_UserID = 0;                                 // id of whoever is currently logged in

    public formMainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);                           // Positions form in the centre of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnManageCustomers.setEnabled(false);
        btnManageEmployees.setEnabled(false);
        btnManageItemCategories.setEnabled(false);
        btnManageCustomerCategories.setEnabled(false);
    }

    // Fetches the full name of whoever is currently logged in and updates label
    public void whoLoggedIn() {
        conn = sqlManager.openConnection();                         // Opens connection to the DB
        String query = "SELECT forename, surname FROM tblEmployees WHERE employee_id = ?";
        Boolean found = false;                                      //
        String fetchedForename = "", fetchedSurname = "";           // Init
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, loggedIn_UserID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {                                        // Once the user under the id is found
                fetchedForename = rs.getString(1);                  //
                fetchedSurname = rs.getString(2);                   // Stores the full name into variables
                found = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlManager.closeConnection(conn);                           // Closes connection to DB

        if (found) {
            System.out.println("-------------------------------");
            System.out.println(loggedIn_UserID);                    // Debug code
            System.out.println(fetchedForename);
            System.out.println(fetchedSurname);
            lblLoggedInAs.setText("Logged in as " + fetchedForename + " " + fetchedSurname);    // Updates label to say who is currently logged in
        } else {
            System.out.println("Error logging in.");
            // This point should theoretically not be reachable as the user would not be able to login if the user's name data didnt exist
        }

    }

    // Checks whether the logged in user is an admin, if they are then they have access to the management section of the program.
    public void checkWhetherAdmin() {
        Connection conn = sqlManager.openConnection();
        if (sqlManager.isAdmin(conn, loggedIn_UserID)) {
            btnManageCustomers.setEnabled(true);
            btnManageEmployees.setEnabled(true);
            btnManageItemCategories.setEnabled(true);
            btnManageCustomerCategories.setEnabled(true);;
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

        lblLoggedInAs = new javax.swing.JLabel();
        pManagement = new javax.swing.JPanel();
        btnManageItemCategories = new javax.swing.JButton();
        btnManageEmployees = new javax.swing.JButton();
        btnManageCustomers = new javax.swing.JButton();
        btnManageCustomerCategories = new javax.swing.JButton();
        btnChangeLoginDetails = new javax.swing.JButton();
        pDocuments = new javax.swing.JPanel();
        btnNewInvoice = new javax.swing.JButton();
        btnNewQuotation = new javax.swing.JButton();
        pReports = new javax.swing.JPanel();
        btnReport3 = new javax.swing.JButton();
        btnReport2 = new javax.swing.JButton();
        btnReport1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");

        lblLoggedInAs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblLoggedInAs.setText("Logged in as");

        pManagement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N

        btnManageItemCategories.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManageItemCategories.setText("Item Categories");
        btnManageItemCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageItemCategoriesActionPerformed(evt);
            }
        });

        btnManageEmployees.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManageEmployees.setText("Employees");
        btnManageEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEmployeesActionPerformed(evt);
            }
        });

        btnManageCustomers.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManageCustomers.setText("Customers");
        btnManageCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomersActionPerformed(evt);
            }
        });

        btnManageCustomerCategories.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManageCustomerCategories.setText("Customer Categories");
        btnManageCustomerCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomerCategoriesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pManagementLayout = new javax.swing.GroupLayout(pManagement);
        pManagement.setLayout(pManagementLayout);
        pManagementLayout.setHorizontalGroup(
            pManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnManageCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageItemCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageCustomerCategories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );
        pManagementLayout.setVerticalGroup(
            pManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnManageCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageItemCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageCustomerCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnChangeLoginDetails.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnChangeLoginDetails.setText("Change Login details");
        btnChangeLoginDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeLoginDetailsActionPerformed(evt);
            }
        });

        pDocuments.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documents", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N

        btnNewInvoice.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnNewInvoice.setText("Set an invoice");
        btnNewInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewInvoiceActionPerformed(evt);
            }
        });

        btnNewQuotation.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnNewQuotation.setText("Set a quotation");
        btnNewQuotation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewQuotationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDocumentsLayout = new javax.swing.GroupLayout(pDocuments);
        pDocuments.setLayout(pDocumentsLayout);
        pDocumentsLayout.setHorizontalGroup(
            pDocumentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDocumentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDocumentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNewInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewQuotation, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );
        pDocumentsLayout.setVerticalGroup(
            pDocumentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDocumentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewQuotation, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pReports.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reports", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N

        btnReport3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReport3.setText("Report 3");
        btnReport3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReport3ActionPerformed(evt);
            }
        });

        btnReport2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReport2.setText("Report 2");
        btnReport2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReport2ActionPerformed(evt);
            }
        });

        btnReport1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReport1.setText("Report 1");
        btnReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReport1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pReportsLayout = new javax.swing.GroupLayout(pReports);
        pReports.setLayout(pReportsLayout);
        pReportsLayout.setHorizontalGroup(
            pReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReport3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnReport1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReport2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pReportsLayout.setVerticalGroup(
            pReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReport1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReport2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReport3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLoggedInAs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChangeLoginDetails))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangeLoginDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoggedInAs))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pDocuments, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pManagement, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomersActionPerformed
        formManageCustomers form = new formManageCustomers().getFrame();                    // Opens new Customer Management form
        form.previousForm = this;                                           // Makes this form the previousForm so the back buttons work
        form.sp = "";                                                       // Empties search parameter in next form
        form.loadCustomers();                                               // Load all the customers into the table
        this.setVisible(false);                                             // Makes main menu invisible
        form.setVisible(true);                                              // makes the next form visible
    }//GEN-LAST:event_btnManageCustomersActionPerformed

    private void btnManageEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmployeesActionPerformed
        formManageEmployees form = new formManageEmployees().getFrame();                    // Opens new Employee Management form
        form.previousForm = this;                                           // Makes this form the previousForm so the back buttons work
        form.sp = "";                                                       // Empties search parameter in next form
        form.loadEmployees();                                               // Load all the employees into the table
        this.setVisible(false);                                             // Makes main menu invisible
        form.setVisible(true);                                              // makes the next form visible
    }//GEN-LAST:event_btnManageEmployeesActionPerformed

    private void btnManageItemCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageItemCategoriesActionPerformed
        formManageItemCategories form = new formManageItemCategories().getFrame();          // Opens new Item Category Management form
        form.previousForm = this;                                           // Makes this form the previousForm so the back buttons work
        this.setVisible(false);                                             // Makes main menu invisible
        form.setVisible(true);                                              // makes the next form visible
    }//GEN-LAST:event_btnManageItemCategoriesActionPerformed

    private void btnManageCustomerCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerCategoriesActionPerformed
        formManageCustomerCategories form = new formManageCustomerCategories().getFrame();  // Opens new Customer Category Management form
        form.previousForm = this;                                           // Makes this form the previousForm so the back buttons work
        this.setVisible(false);                                             // Makes main menu invisible
        form.setVisible(true);                                              // makes the next form visible
    }//GEN-LAST:event_btnManageCustomerCategoriesActionPerformed

    private void btnChangeLoginDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeLoginDetailsActionPerformed
        String[] inputDetails = Utility.JOptionPaneMultiInput(new String[]{"Current username", "Current password", "New username", "Confirm username", "New password", "Confirm password"});
        if (inputDetails != null) {

            Boolean found = false;                                      // Whether a user exists under the given login details
            int fetchedID = -1;                                         // Init

            conn = sqlManager.openConnection();                         // Opens a connection to the DB
            String query = "SELECT employee_id, username, password FROM tblLogins WHERE username = ? AND password = ?";
            try {
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, inputDetails[0]);
                pstmt.setString(2, inputDetails[1]);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {                                        // If any results were fetched from the DB
                    if (inputDetails[0].equals(rs.getString(2)) && inputDetails[1].equals(rs.getString(3))) {   // Secondary check which ensures the username and password are of the same case (capitalisation)

                        fetchedID = rs.getInt(1);                       // Gets the id of whoever logged in
                        found = true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sqlManager.closeConnection(conn);                           // Closes connection to DB

            if (found) {                                               // If a user was not found
                System.out.println("-------------------------------");
                System.out.println("User ID: " + fetchedID);
                if (inputDetails[2].equals(inputDetails[3]) && inputDetails[4].equals(inputDetails[5])) {
                    System.out.println("-------------------------------");
                    System.out.println("User ID: " + fetchedID);
                    updateLoginDetails(fetchedID, inputDetails[2], inputDetails[4]);
                } else {
                    System.out.println("Make sure you have entered your new username and password correctly");
                }
            } else {                                                    // If a user was found with those login details
                System.out.println("Incorrect username and/or password.");
            }
        }
    }//GEN-LAST:event_btnChangeLoginDetailsActionPerformed

    private void btnNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewInvoiceActionPerformed

    private void btnNewQuotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewQuotationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNewQuotationActionPerformed

    private void btnReport3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReport3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReport3ActionPerformed

    private void btnReport2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReport2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReport2ActionPerformed

    private void btnReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReport1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReport1ActionPerformed

    public void updateLoginDetails(int id, String newUsername, String newPassword) {
        conn = sqlManager.openConnection();                 // Opens connection to the DB
        String query = "UPDATE tblLogins SET username = ?, password = ? WHERE employee_id = " + id;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, newUsername);
            pstmt.setString(2, newPassword);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlManager.closeConnection(conn);                   // Closes connection to the DB

    }

    /**
     * @param args the command line arguments
     */
    public formMainMenu getFrame() {
        return this;
    }

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
            java.util.logging.Logger.getLogger(formMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formMainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeLoginDetails;
    private javax.swing.JButton btnManageCustomerCategories;
    private javax.swing.JButton btnManageCustomers;
    private javax.swing.JButton btnManageEmployees;
    private javax.swing.JButton btnManageItemCategories;
    private javax.swing.JButton btnNewInvoice;
    private javax.swing.JButton btnNewQuotation;
    private javax.swing.JButton btnReport1;
    private javax.swing.JButton btnReport2;
    private javax.swing.JButton btnReport3;
    private javax.swing.JLabel lblLoggedInAs;
    private javax.swing.JPanel pDocuments;
    private javax.swing.JPanel pManagement;
    private javax.swing.JPanel pReports;
    // End of variables declaration//GEN-END:variables
}
