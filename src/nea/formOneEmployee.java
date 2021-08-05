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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Michal
 */
public class formOneEmployee extends javax.swing.JFrame {

    /**
     * Creates new form formOneEmployee
     */
    int EmployeeID = 0;                                             // employee_id of currently loaded employee
    Connection conn = null;                                         // Stores the connection object
    formManageEmployees previousForm = null;                        // Stores the previous Form object

    public formOneEmployee() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btnConfirmEdit.setVisible(false);                           // Makes the Confirm Changes button invisible
        JTextField[] fields = {txtEmployeeID, txtForename, txtSurname, txtAddress1, txtAddress2, txtAddress3, txtCounty, txtPostcode, txtPhoneNumber, txtEmailAddress, txtLastLogin};
        cbAdmin.setEnabled(false);
        setEditable(fields, false);                                 // Makes all the fields uneditable
    }

    public formOneEmployee getFrame() {
        return this;
    }

    // Sets these components to either visible or invisible depending on the boolean state
    public void setEditable(JTextField[] fields, boolean state) {
        for (JTextField field : fields) {
            field.setEditable(state);
        }
    }

    public void loadEmployee() {
        txtEmployeeID.setText(String.valueOf(EmployeeID));

        conn = sqlManager.openConnection();

        String query = "SELECT CONCAT(forename,' ',surname), forename, surname, address1, address2, address3, county, postcode, phone_number, email_address FROM tblEmployees WHERE employee_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, EmployeeID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("-------------------------------");
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));    // For debugging, shows employee data
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));
                System.out.println(rs.getString(7));
                System.out.println(rs.getString(8));
                System.out.println(rs.getString(9));
                System.out.println(rs.getString(10));

                lblFullName.setText(rs.getString(1));
                txtForename.setText(rs.getString(2));
                txtSurname.setText(rs.getString(3));
                txtAddress1.setText(rs.getString(4));
                txtAddress2.setText(rs.getString(5));
                txtAddress3.setText(rs.getString(6));
                txtCounty.setText(rs.getString(7));
                txtPostcode.setText(rs.getString(8));
                txtPhoneNumber.setText(rs.getString(9));
                txtEmailAddress.setText(rs.getString(10));
                txtLastLogin.setText(sqlManager.getLastLogin(conn, EmployeeID));
                cbAdmin.setSelected(sqlManager.isAdmin(conn, EmployeeID));
            } else {
                System.out.println("-------------------------------");
                System.out.println("Error occurred fetching employee data");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlManager.closeConnection(conn);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFullName = new javax.swing.JLabel();
        lblEmployeeID = new javax.swing.JLabel();
        lblForename = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblCounty = new javax.swing.JLabel();
        lblPostcode = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblEmailAddress = new javax.swing.JLabel();
        lblLastLogin = new javax.swing.JLabel();
        lblAdmin = new javax.swing.JLabel();
        txtEmployeeID = new javax.swing.JTextField();
        txtForename = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtAddress1 = new javax.swing.JTextField();
        txtAddress2 = new javax.swing.JTextField();
        txtAddress3 = new javax.swing.JTextField();
        txtCounty = new javax.swing.JTextField();
        txtPostcode = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtEmailAddress = new javax.swing.JTextField();
        txtLastLogin = new javax.swing.JTextField();
        cbAdmin = new javax.swing.JCheckBox();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnConfirmEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Employee");

        lblFullName.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblFullName.setText("Full name here");

        lblEmployeeID.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblEmployeeID.setText("Employee ID:");

        lblForename.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblForename.setText("Forename:");

        lblSurname.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblSurname.setText("Surname:");

        lblAddress.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblAddress.setText("Address:");

        lblCounty.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCounty.setText("County:");

        lblPostcode.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblPostcode.setText("Postcode:");
        lblPostcode.setToolTipText("");

        lblPhoneNumber.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblPhoneNumber.setText("Phone number:");

        lblEmailAddress.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblEmailAddress.setText("Email address:");

        lblLastLogin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblLastLogin.setText("Last Login:");

        lblAdmin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblAdmin.setText("Admin:");

        txtAddress1.setToolTipText("");

        btnRemove.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnEdit.setText("Edit details");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnConfirmEdit.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        btnConfirmEdit.setText("Confirm Edit");
        btnConfirmEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmEditActionPerformed(evt);
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
                        .addGap(52, 52, 52)
                        .addComponent(lblAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress2)
                            .addComponent(txtAddress3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPhoneNumber)
                            .addComponent(lblEmailAddress)
                            .addComponent(lblPostcode)
                            .addComponent(lblCounty)
                            .addComponent(lblLastLogin)
                            .addComponent(lblAdmin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPostcode, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCounty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAdmin)))
                    .addComponent(lblFullName)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblEmployeeID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblForename)
                            .addComponent(lblSurname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtForename, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtSurname))))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                    .addComponent(btnConfirmEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFullName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmployeeID)
                            .addComponent(txtEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblForename)
                            .addComponent(txtForename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSurname)
                            .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCounty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCounty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPostcode)
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneNumber)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmailAddress)
                    .addComponent(txtEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLastLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdmin)
                    .addComponent(cbAdmin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        JTextField[] fields = {txtForename, txtSurname, txtAddress1, txtAddress2, txtAddress3, txtCounty, txtPostcode, txtPhoneNumber, txtEmailAddress};
        setEditable(fields, true);                                  // Makes all the fields editable
        btnConfirmEdit.setVisible(true);                            // Makes the confirm button visible
        txtForename.requestFocus();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        conn = sqlManager.openConnection();
        int NoInvoices = sqlManager.countRecords(conn, "tblInvoices", "employee_id", EmployeeID);        // Counts how many invoices the employee has
        int NoQuotations = sqlManager.countRecords(conn, "tblQuotations", "employee_id", EmployeeID);    // Counts how many quotations the employee has
        System.out.println("-------------------------------");
        System.out.println("Employee ID: " + EmployeeID);
        System.out.println("No. of invoices: " + NoInvoices);
        System.out.println("No. of quotations: " + NoQuotations);
        if (NoInvoices > 0 || NoQuotations > 0) {                   // If the employee has any invoices or quotations associated with them then the user is informed
            JOptionPane.showMessageDialog(null, "This employee has " + NoInvoices + " invoices and " + NoQuotations + " quotations associated with them and therefore cannot be removed.", "Not possible to remove employee", JOptionPane.WARNING_MESSAGE);
        } else {
            // Asks user whether they really want to remove this employee
            int YesNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this employee?", "Remove Employee", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (YesNo == 0) {                                       // If response is yes
                sqlManager.removeRecord(conn, "tblEmployees", "employee_id", EmployeeID);   // Removes the employee
                sqlManager.removeRecord(conn, "tblLogins", "employee_id", EmployeeID);      // Removes the employee's login access
                this.dispose();                                     // Closes this form since the employee no longer exists
                previousForm.loadEmployees();                       // Refreshes the employee table in the previous form since a employee was removed

            }
        }
        sqlManager.closeConnection(conn);
    }//GEN-LAST:event_btnRemoveActionPerformed

    // Counts how many of the input fields is empty and returns the integer value
    public int countEmptyFields(JTextField[] fields) {
        int emptyFields = 0;
        for (JTextField field : fields) {
            if (field.getText().equals("")) {
                emptyFields++;
            }
        }
        return emptyFields;
    }

    private void btnConfirmEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmEditActionPerformed
        JTextField[] inputFields = {txtForename, txtSurname, txtAddress1, txtCounty, txtPostcode, txtPhoneNumber, txtEmailAddress};
        // Checks if any of the input fields are empty
        if (countEmptyFields(inputFields) != 0) {                               // Checks if any of the input fields are empty
            System.out.println("One or more of the input fields is empty");
        } else if (!validInputs()) {                                            // Validates input lengths
            System.out.println("One or more of the inputs' length is too long");
        } else {
            // Asks user whether they really want to edit this employee's details
            int YesNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this employee's details?", "Update employee details", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (YesNo == 0) {                                       // If response is yes
                conn = sqlManager.openConnection();
                String query = "UPDATE tblEmployees SET forename = ?, surname = ?, address1 = ?, address2 = ?, address3 = ?, county = ?, postcode = ?, phone_number = ?, email_address = ? WHERE employee_id = ?";
                PreparedStatement pstmt = null;
                try {
                    pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, txtForename.getText());
                    pstmt.setString(2, txtSurname.getText());
                    pstmt.setString(3, txtAddress1.getText());
                    pstmt.setString(4, (txtAddress2.getText().equals("") ? null : txtAddress2.getText()));  // If the address2 or address3 is empty then it is replaced by null instead of ""
                    pstmt.setString(5, (txtAddress3.getText().equals("") ? null : txtAddress3.getText()));
                    pstmt.setString(6, txtCounty.getText());
                    pstmt.setString(7, txtPostcode.getText());
                    pstmt.setString(8, txtPhoneNumber.getText());
                    pstmt.setString(9, txtEmailAddress.getText());
                    pstmt.setInt(10, EmployeeID);

                    int rowsAffected = pstmt.executeUpdate();
                    System.out.println(rowsAffected + " row updated.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sqlManager.closeConnection(conn);
                setEditable(inputFields, false);                    // Makes all the fields no longer editable
                txtAddress2.setEditable(false);                     // Makes txtAddress2 non editable as the previous line doesnt take care of that
                txtAddress3.setEditable(false);                     // Makes txtAddress3 non editable as the previous line doesnt take care of that
                btnConfirmEdit.setVisible(false);                   // Hides the Confirm details button
                previousForm.loadEmployees();                       // Refreshes the employee table in the previous form since an employee's details were changed
            }
        }
        txtEmployeeID.requestFocus();
    }//GEN-LAST:event_btnConfirmEditActionPerformed

    // Validating input length against the max lengths in the DB
    private boolean validInputs() {
        conn = sqlManager.openConnection();
        if (txtForename.getText().length() > sqlManager.getMaxColumnLength(conn, "tblEmployees", "forename")) {
            System.out.println("Forename too long");
        } else if (txtSurname.getText().length() > sqlManager.getMaxColumnLength(conn, "tblEmployees", "surname")) {
            System.out.println("Surname too long");
        } else if (txtAddress1.getText().length() > sqlManager.getMaxColumnLength(conn, "tblEmployees", "address1")) {
            System.out.println("Address line 1 too long");
        } else if (txtAddress2.getText().length() > sqlManager.getMaxColumnLength(conn, "tblEmployees", "address2")) {
            System.out.println("Address line 2 too long");
        } else if (txtAddress3.getText().length() > sqlManager.getMaxColumnLength(conn, "tblEmployees", "address3")) {
            System.out.println("Address line 3 too long");
        } else if (txtCounty.getText().length() > sqlManager.getMaxColumnLength(conn, "tblEmployees", "county")) {
            System.out.println("County too long");
        } else if (txtPostcode.getText().length() > sqlManager.getMaxColumnLength(conn, "tblEmployees", "postcode")) {
            System.out.println("Postcode too long");
        } else if (txtPhoneNumber.getText().length() > sqlManager.getMaxColumnLength(conn, "tblEmployees", "phone_number")) {
            System.out.println("Phone number too long");
        } else if (txtEmailAddress.getText().length() > sqlManager.getMaxColumnLength(conn, "tblEmployees", "email_address")) {
            System.out.println("Email Address too long");
        } else {
            sqlManager.closeConnection(conn);
            return true;
        }
        sqlManager.closeConnection(conn);
        return false;
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
            java.util.logging.Logger.getLogger(formOneEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formOneEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formOneEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formOneEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formOneEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmEdit;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JCheckBox cbAdmin;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JLabel lblCounty;
    private javax.swing.JLabel lblEmailAddress;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JLabel lblForename;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblLastLogin;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPostcode;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtAddress3;
    private javax.swing.JTextField txtCounty;
    private javax.swing.JTextField txtEmailAddress;
    private javax.swing.JTextField txtEmployeeID;
    private javax.swing.JTextField txtForename;
    private javax.swing.JTextField txtLastLogin;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPostcode;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
