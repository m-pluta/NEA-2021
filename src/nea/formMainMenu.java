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
        String employeeFullName = sqlManager.getEmployeeFullName(conn, loggedIn_UserID);
        sqlManager.closeConnection(conn);                           // Closes connection to DB

        if (employeeFullName != null) {
            System.out.println("-------------------------------");
            System.out.println(loggedIn_UserID);                    // Debug code
            System.out.println(employeeFullName);
            lblLoggedInAs.setText("Logged in as " + employeeFullName);    // Updates label to say who is currently logged in
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
            btnManageCustomerCategories.setEnabled(true);
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
        btnManageCustomers = new javax.swing.JButton();
        btnManageEmployees = new javax.swing.JButton();
        btnManageItemCategories = new javax.swing.JButton();
        btnManageCustomerCategories = new javax.swing.JButton();
        pDocuments = new javax.swing.JPanel();
        btnManageInvoices = new javax.swing.JButton();
        btnManageQuotations = new javax.swing.JButton();
        btnNewInvoice = new javax.swing.JButton();
        btnNewQuotation = new javax.swing.JButton();
        pReports = new javax.swing.JPanel();
        btnReport1 = new javax.swing.JButton();
        btnReport2 = new javax.swing.JButton();
        btnReport3 = new javax.swing.JButton();
        btnChangeLoginDetails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");

        lblLoggedInAs.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblLoggedInAs.setText("Logged in as");

        pManagement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N

        btnManageCustomers.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManageCustomers.setText("Customers");
        btnManageCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCustomersActionPerformed(evt);
            }
        });

        btnManageEmployees.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManageEmployees.setText("Employees");
        btnManageEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEmployeesActionPerformed(evt);
            }
        });

        btnManageItemCategories.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManageItemCategories.setText("Item Categories");
        btnManageItemCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageItemCategoriesActionPerformed(evt);
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
                    .addComponent(btnManageCustomerCategories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnManageItemCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        pDocuments.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documents", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N

        btnManageInvoices.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManageInvoices.setText("Manage Invoices");
        btnManageInvoices.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageInvoicesActionPerformed(evt);
            }
        });

        btnManageQuotations.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnManageQuotations.setText("Manage Quotations");
        btnManageQuotations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageQuotationsActionPerformed(evt);
            }
        });

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
            .addGroup(pDocumentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDocumentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewQuotation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnManageInvoices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageQuotations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNewInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pDocumentsLayout.setVerticalGroup(
            pDocumentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDocumentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnManageInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageQuotations, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewQuotation, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pReports.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reports", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N

        btnReport1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReport1.setText("Sales Analysis");
        btnReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReport1ActionPerformed(evt);
            }
        });

        btnReport2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReport2.setText("Item Category Analysis");
        btnReport2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReport2ActionPerformed(evt);
            }
        });

        btnReport3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReport3.setText("Report 3");
        btnReport3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReport3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pReportsLayout = new javax.swing.GroupLayout(pReports);
        pReports.setLayout(pReportsLayout);
        pReportsLayout.setHorizontalGroup(
            pReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnReport1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnReport2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnReport3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btnChangeLoginDetails.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnChangeLoginDetails.setText("Change Login details");
        btnChangeLoginDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeLoginDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pDocuments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLoggedInAs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChangeLoginDetails)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangeLoginDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoggedInAs))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pDocuments, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pManagement, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomersActionPerformed
        formManageCustomers form = new formManageCustomers().getFrame();        // Opens new Customer Management form
        form.previousForm = this;                                   // Makes this form the previousForm so the back buttons work
        form.sp = "";                                               // Empties search parameter in next form
        form.EmployeeID = loggedIn_UserID;
        form.loadCustomers();                                       // Load all the customers into the table
        this.setVisible(false);                                     // Makes main menu invisible
        form.setVisible(true);                                      // makes the next form visible
    }//GEN-LAST:event_btnManageCustomersActionPerformed

    private void btnManageEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmployeesActionPerformed
        formManageEmployees form = new formManageEmployees().getFrame();                    // Opens new Employee Management form
        form.previousForm = this;                                   // Makes this form the previousForm so the back buttons work
        form.sp = "";                                               // Empties search parameter in next form
        form.loadEmployees();                                       // Load all the employees into the table
        this.setVisible(false);                                     // Makes main menu invisible
        form.setVisible(true);                                      // makes the next form visible
    }//GEN-LAST:event_btnManageEmployeesActionPerformed

    private void btnManageItemCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageItemCategoriesActionPerformed
        formManageItemCategories form = new formManageItemCategories().getFrame();          // Opens new Item Category Management form
        form.previousForm = this;                                   // Makes this form the previousForm so the back buttons work
        form.sp = "";                                               // Empties search parameter in next form
        form.loadCategories();                                      // Load all the categories into the table
        this.setVisible(false);                                     // Makes main menu invisible
        form.setVisible(true);                                      // makes the next form visible
    }//GEN-LAST:event_btnManageItemCategoriesActionPerformed

    private void btnManageCustomerCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomerCategoriesActionPerformed
        formManageCustomerCategories form = new formManageCustomerCategories().getFrame();  // Opens new Customer Category Management form
        form.previousForm = this;                                   // Makes this form the previousForm so the back buttons work
        form.sp = "";                                               // Empties search parameter in next form
        form.loadCategories();                                      // Load all the categories into the table
        this.setVisible(false);                                     // Makes main menu invisible
        form.setVisible(true);                                      // makes the next form visible
    }//GEN-LAST:event_btnManageCustomerCategoriesActionPerformed

    private void btnChangeLoginDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeLoginDetailsActionPerformed
        boolean changingDetails = true;
        while (changingDetails) {
            String[] inputDetails = Utility.JOptionPaneMultiInput("Change login details", new String[]{"Current username", "Current password", "New username", "Confirm username", "New password", "Confirm password"});
            if (inputDetails == null) {                             // If the user closed the input window
                changingDetails = false;
            } else {

                Boolean found = false;                              // Whether a user exists under the given login details
                int fetchedID = -1;                                 // Init

                conn = sqlManager.openConnection();                 // Opens a connection to the DB
                String query = "SELECT employee_id, username, password FROM tblLogins WHERE username = ? AND password = ?";
                try {
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, inputDetails[0]);
                    pstmt.setString(2, inputDetails[1]);

                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {                                // If any results were fetched from the DB
                        if (inputDetails[0].equals(rs.getString(2)) && inputDetails[1].equals(rs.getString(3))) {   // Secondary check which ensures the username and password are of the same case (capitalisation)

                            fetchedID = rs.getInt(1);               // Gets the id of whoever logged in
                            found = true;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sqlManager.closeConnection(conn);                   // Closes connection to DB

                if (found) {                                        // If a user was not found
                    System.out.println("-------------------------------");
                    System.out.println("User ID: " + fetchedID);
                    if (inputDetails[2].equals(inputDetails[3]) && inputDetails[4].equals(inputDetails[5])) {
                        if (inputDetails[2].length() >= 4 && inputDetails[4].length() >= 4) {   // Checks if the new username and password are of minimum length (4)
                            conn = sqlManager.openConnection();
                            if (sqlManager.RecordExists(conn, "tblLogins", "username", inputDetails[2])) {  // Checks if a login with that username already exists
                                System.out.println("User with this username already exists");
                            } else {
                                sqlManager.closeConnection(conn);
                                System.out.println("-------------------------------");
                                System.out.println("User ID: " + fetchedID);
                                updateLoginDetails(fetchedID, inputDetails[2], inputDetails[4]);
                                changingDetails = false;
                            }
                        } else {
                            System.out.println("The username and password need to be at least 4 characters long for improved security");
                        }
                    } else {
                        System.out.println("Make sure you have entered your new username and password correctly");
                    }
                } else {                                            // If a user was found with those login details
                    System.out.println("Incorrect username and/or password.");
                }
            }
        }
    }//GEN-LAST:event_btnChangeLoginDetailsActionPerformed

    private void btnNewInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewInvoiceActionPerformed
        formNewInvoice form = new formNewInvoice().getFrame();
        form.previousForm1 = this;                                  // Makes this form the previousForm so the back buttons work
        form.EmployeeID = loggedIn_UserID;
        this.setVisible(false);                                     // Makes main menu invisible
        form.setVisible(true);                                      // makes the next form visible
    }//GEN-LAST:event_btnNewInvoiceActionPerformed

    private void btnNewQuotationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewQuotationActionPerformed
        formNewQuotation form = new formNewQuotation().getFrame();  // Opens new NewQuotation form
        form.previousForm1 = this;                                   // Makes this form the previousForm so the back buttons work
        form.EmployeeID = loggedIn_UserID;
        this.setVisible(false);                                     // Makes main menu invisible
        form.setVisible(true);                                      // makes the next form visible
    }//GEN-LAST:event_btnNewQuotationActionPerformed

    private void btnManageInvoicesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageInvoicesActionPerformed
        formManageInvoices form = new formManageInvoices().getFrame();      // Opens new Invoice Management form
        form.previousForm = this;                                   // Makes this form the previousForm so the back buttons work
        form.sp = "";                                               // Empties search parameter in next form
        form.EmployeeID = loggedIn_UserID;
        form.loadInvoices();                                        // Load all the invoices into the table
        this.setVisible(false);                                     // Makes main menu invisible
        form.setVisible(true);                                      // makes the next form visible
    }//GEN-LAST:event_btnManageInvoicesActionPerformed

    private void btnManageQuotationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageQuotationsActionPerformed
        formManageQuotations form = new formManageQuotations().getFrame();  // Opens new Quotations Management form
        form.previousForm = this;                                   // Makes this form the previousForm so the back buttons work
        form.sp = "";                                               // Empties search parameter in next form
        form.EmployeeID = loggedIn_UserID;
        form.loadQuotations();                                      // Load all the quotations into the table
        this.setVisible(false);                                     // Makes main menu invisible
        form.setVisible(true);                                      // makes the next form visible
    }//GEN-LAST:event_btnManageQuotationsActionPerformed

    private void btnReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReport1ActionPerformed
        formReportOne form = new formReportOne().getFrame();
        form.previousForm = this;
        form.EmployeeID = loggedIn_UserID;
        this.setVisible(false);
        form.setVisible(true);
    }//GEN-LAST:event_btnReport1ActionPerformed

    private void btnReport2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReport2ActionPerformed
        formReportTwo form = new formReportTwo().getFrame();
        form.previousForm = this;
        form.EmployeeID = loggedIn_UserID;
        this.setVisible(false);
        form.setVisible(true);
    }//GEN-LAST:event_btnReport2ActionPerformed

    private void btnReport3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReport3ActionPerformed
        formReportThree form = new formReportThree().getFrame();
        form.previousForm = this;
        form.EmployeeID = loggedIn_UserID;
        this.setVisible(false);
        form.setVisible(true);
    }//GEN-LAST:event_btnReport3ActionPerformed

    public void updateLoginDetails(int id, String newUsername, String newPassword) {
        conn = sqlManager.openConnection();                         // Opens connection to the DB
        String query = "UPDATE tblLogins SET username = ?, password = ? WHERE employee_id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, newUsername);
            pstmt.setString(2, newPassword);
            pstmt.setInt(3, id);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlManager.closeConnection(conn);                           // Closes connection to the DB

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
    private javax.swing.JButton btnManageInvoices;
    private javax.swing.JButton btnManageItemCategories;
    private javax.swing.JButton btnManageQuotations;
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
