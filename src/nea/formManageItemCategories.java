/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nea;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Michal
 */
public class formManageItemCategories extends javax.swing.JFrame {

    private static final Logger logger = Logger.getLogger(formManageItemCategories.class.getName());
    formMainMenu previousForm = null;
    Connection conn = null;

    // Init
    DefaultTableModel model = null;
    public static String sp = "";

    public formManageItemCategories() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = (DefaultTableModel) jTable_ItemCategories.getModel();

        // Sets up the table header to be a bit larger
        JTableHeader header = jTable_ItemCategories.getTableHeader();
        header.setFont(new Font("Dialog", Font.PLAIN, 14));

        // When the user changes their search in the search box
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Updates the search parameter and refreshes the table
                sp = txtSearch.getText();
                loadCategories();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Updates the search parameter and refreshes the table
                sp = txtSearch.getText();
                loadCategories();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        });

        // Adjusting the header widths
        jTable_ItemCategories = Utility.setColumnWidths(jTable_ItemCategories, new int[]{40, 130, 130});
    }

    // Used when the form is opened from within another form
    public formManageItemCategories getFrame() {
        return this;
    }

    public void loadCategories() {
        conn = sqlManager.openConnection();

        // Empties the table
        model.setRowCount(0);

        String query = "SELECT category_id, category_name, date_created FROM tblItemCategory";
        // If the user entered a search into the search box, the WHERE clause is adjusted
        if (!sp.isEmpty()) {
            query += " WHERE";
            query += " category_id LIKE '%" + sp + "%'";
            query += " OR category_name LIKE '%" + sp + "%'";
            query += " OR date_created LIKE '%" + sp + "%'";
        }

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Counts the amount of categories which are being shown
            int categoryCounter = 0;
            while (rs.next()) {

                // Adds the category from the DB to the table
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
                categoryCounter++;
            }

            // Updates category counter label
            lblCategoryCount.setText("Number of categories: " + String.valueOf(categoryCounter));
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException");
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

        lblManageItemCategories = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ItemCategories = new javax.swing.JTable();
        btnAddNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblCategoryCount = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Item Category Management");

        lblManageItemCategories.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblManageItemCategories.setText("Manage Item Categories");

        jTable_ItemCategories.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable_ItemCategories.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category name", "Date created"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_ItemCategories);

        btnAddNew.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAddNew.setText("Add New");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblCategoryCount.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblCategoryCount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCategoryCount.setText("Number of categories:");

        txtSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSearch.setName(""); // NOI18N

        lblSearch.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblSearch.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSearch)
                            .addComponent(btnBack))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCategoryCount, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(lblManageItemCategories)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManageItemCategories)
                    .addComponent(btnBack))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategoryCount)
                    .addComponent(lblSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        conn = sqlManager.openConnection();
        String addedCategory = sqlManager.addNewItemCategory(conn);
        sqlManager.closeConnection(conn);

        if (addedCategory != null) {
            // Refreshes Combo box so the new category is visible
            loadCategories();
        }
    }//GEN-LAST:event_btnAddNewActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // Gets the currently selected row in the table
        int row = jTable_ItemCategories.getSelectedRow();

        if (row == -1) {
            // If no row is selected
            ErrorMsg.throwError(ErrorMsg.NOTHING_SELECTED_ERROR);

        } else {
            // Gets the values from the selected row in the table
            String string_id = model.getValueAt(row, 0).toString();
            String category = model.getValueAt(row, 1).toString();
            int id = Utility.StringToInt(string_id);

            if (id == 1) {
                // Checks if the user is trying to remove the first row which is the default row
                ErrorMsg.throwError(ErrorMsg.CANNOT_REMOVE_ERROR);

            } else {
                conn = sqlManager.openConnection();

                // Invoice Rows with the selected category
                int iRows = sqlManager.countRecords(conn, "tblInvoiceDetail", "category_id", id);
                // Quotation Rows with the selected category
                int qRows = sqlManager.countRecords(conn, "tblQuotationDetail", "category_id", id);

                if (iRows == -1 || qRows == -1) {
                    logger.log(Level.WARNING, "Error fetching receipt rows with this category");

                } else if (iRows > 0 || qRows > 0) {
                    // Ensures the user can't remove a category that is being used in a certain receipt
                    // The ternary operators are used for grammar in the error message
                    ErrorMsg.throwError(ErrorMsg.CANNOT_REMOVE_ERROR, "Cannot remove category since "
                            + (iRows > 0 ? iRows + " invoice row" : "") + (iRows > 1 ? "s" : "")
                            + (iRows > 0 && qRows > 0 ? " and " : "") + (qRows > 0 ? qRows + " quotation row" : "")
                            + (qRows > 1 ? "s" : "") + " are under this category");
                    // #TODO find a nicer way to write this

                } else {
                    // Asks user whether they really want to remove the category
                    int YesNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the category - '"
                            + category + "'?", "Remove Category", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);

                    // If response is yes
                    if (YesNo == 0) {
                        logger.log(Level.INFO, "Removing category " + string_id + " - " + category);

                        // Removes the selected category and refreshes the table
                        sqlManager.removeRecord(conn, "tblItemCategory", "category_id", id);
                        loadCategories();
                    }
                }

                sqlManager.closeConnection(conn);
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Gets the currently selected row in the table
        int row = jTable_ItemCategories.getSelectedRow();

        if (row == -1) {
            // If no row is selected
            ErrorMsg.throwError(ErrorMsg.NOTHING_SELECTED_ERROR);

        } else {
            // Gets the values from the selected row in the table
            String string_id = model.getValueAt(row, 0).toString();
            String category = model.getValueAt(row, 1).toString();
            int id = Utility.StringToInt(string_id);

            if (id == 1) {
                // Checks if the user is trying to edit the first row which is the default row
                ErrorMsg.throwError(ErrorMsg.CANNOT_EDIT_ERROR);

            } else {
                conn = sqlManager.openConnection();
                boolean picked = false;

                while (!picked) {
                    // Asks user what the new name of the category should be
                    String inputCategory = Utility.StringInputDialog("Current name:  '" + category + "'", "Edit category name");

                    if (inputCategory != null) {

                        // Removes all leading and trailing whitespace characters
                        inputCategory = inputCategory.trim();

                        if (inputCategory.length() > sqlManager.getMaxColumnLength(conn, "tblItemCategory", "category_name")) {
                            // Checks if the entered category name is valid
                            ErrorMsg.throwError(ErrorMsg.INPUT_LENGTH_ERROR_LONG, "category name");

                        } else if (sqlManager.RecordExists(conn, "tblItemCategory", "category_name", inputCategory)) {
                            // Checks if category already exists in DB
                            ErrorMsg.throwError(ErrorMsg.ALREADY_EXISTS_ERROR, "Category");
                            // # TODO Allow the user to merge the two categories together under the requested name

                        } else {
                            try {
                                // Query Setup & Execution
                                String query = "UPDATE tblItemCategory SET category_name = ? WHERE category_id = ?";
                                PreparedStatement pstmt = conn.prepareStatement(query);
                                pstmt.setString(1, inputCategory);
                                pstmt.setInt(2, id);

                                pstmt.executeUpdate();
                                logger.log(Level.INFO, "Category name updated to " + inputCategory);

                                // Refreshes table since category name was updated
                                loadCategories();
                            } catch (SQLException e) {
                                logger.log(Level.SEVERE, "SQLException");
                            }

                            // Exits while loop
                            picked = true;
                        }
                    }
                }

                sqlManager.closeConnection(conn);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Makes previous form visible and closes current form
        previousForm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(formManageItemCategories.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formManageItemCategories.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formManageItemCategories.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formManageItemCategories.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formManageItemCategories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ItemCategories;
    private javax.swing.JLabel lblCategoryCount;
    private javax.swing.JLabel lblManageItemCategories;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
