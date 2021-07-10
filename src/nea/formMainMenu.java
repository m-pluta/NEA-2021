/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nea;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static nea.formLogin.conn;

/**
 *
 * @author Michal
 */
public class formMainMenu extends javax.swing.JFrame {

    /**
     * Creates new form formMainMenu
     */
    static int loggedIn_UserID = 0;
    
    
    public formMainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void whoLoggedIn(int UserID) {
        String query = "SELECT title, forename, surname FROM tblEmployees WHERE employee_id = ?";
        Boolean found = false;
        String fetchedTitle = "", fetchedForename = "", fetchedSurname = "";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, UserID);

            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                found = false;
            } else {
                fetchedTitle = rs.getString(1);
                fetchedForename = rs.getString(2);
                fetchedSurname = rs.getString(3);
                found = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (found) {
            System.out.println(UserID);
            System.out.println(fetchedTitle);
            System.out.println(fetchedForename);
            System.out.println(fetchedSurname);
            lblLoggedInAs.setText("Logged in as " + fetchedTitle + ". " + fetchedForename + " " + fetchedSurname);
        } else {
            System.out.println("Error!");
            
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
        jPanel1 = new javax.swing.JPanel();
        btnManageItemCategories = new javax.swing.JButton();
        btnManageEmployees = new javax.swing.JButton();
        btnManageCustomers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");

        lblLoggedInAs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblLoggedInAs.setText("Logged in as");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 24))); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnManageCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageItemCategories, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnManageCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnManageItemCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoggedInAs)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoggedInAs)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCustomersActionPerformed
            formManageCustomers mngCustomersForm = new formManageCustomers().getFrame();
            mngCustomersForm.setVisible(true);
            this.setVisible(false);
            this.dispose();
    }//GEN-LAST:event_btnManageCustomersActionPerformed

    private void btnManageEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmployeesActionPerformed
            formManageEmployees mngEmployeesForm = new formManageEmployees().getFrame();
            mngEmployeesForm.setVisible(true);
            this.setVisible(false);
            this.dispose();
    }//GEN-LAST:event_btnManageEmployeesActionPerformed

    private void btnManageItemCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageItemCategoriesActionPerformed
            formManageItemCategories mngItemCategoriesForm = new formManageItemCategories().getFrame();
            mngItemCategoriesForm.setVisible(true);
            this.setVisible(false);
            this.dispose();
    }//GEN-LAST:event_btnManageItemCategoriesActionPerformed

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
    private javax.swing.JButton btnManageCustomers;
    private javax.swing.JButton btnManageEmployees;
    private javax.swing.JButton btnManageItemCategories;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLoggedInAs;
    // End of variables declaration//GEN-END:variables
}
