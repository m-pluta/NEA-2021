/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nea;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

/**
 *
 * @author Michal
 */
public class formFormatIntoWord extends javax.swing.JFrame {

    /**
     * Creates new form formFormatIntoWord
     */
    static Connection conn = null;
    formOneInvoice previousForm = null;
    static int InvoiceID = 0;

    static String templateFilePath = null;
    static String outputFilePath = null;

    public formFormatIntoWord() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public formFormatIntoWord getFrame() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTemplate = new javax.swing.JLabel();
        lblOutput = new javax.swing.JLabel();
        btnChooseTemplate = new javax.swing.JButton();
        btnChooseOutput = new javax.swing.JButton();
        txtTemplate = new javax.swing.JTextField();
        txtOutput = new javax.swing.JTextField();
        btnGenerateDocument = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTemplate.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTemplate.setText("Template Location:");

        lblOutput.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblOutput.setText("Output Location:");

        btnChooseTemplate.setText("#");
        btnChooseTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseTemplateActionPerformed(evt);
            }
        });

        btnChooseOutput.setText("#");
        btnChooseOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseOutputActionPerformed(evt);
            }
        });

        txtTemplate.setEditable(false);

        txtOutput.setEditable(false);

        btnGenerateDocument.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnGenerateDocument.setText("Generate Document");
        btnGenerateDocument.setToolTipText("");
        btnGenerateDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateDocumentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTemplate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChooseTemplate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTemplate))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnChooseOutput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerateDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTemplate)
                    .addComponent(btnChooseTemplate)
                    .addComponent(txtTemplate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutput)
                    .addComponent(btnChooseOutput)
                    .addComponent(txtOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnGenerateDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseTemplateActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int option = fileChooser.showOpenDialog(new JFrame());
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            txtTemplate.setText(file.getName());
            templateFilePath = file.getAbsolutePath();
            System.out.println(templateFilePath);
        } else {
            System.out.println("Open command canceled");
        }
    }//GEN-LAST:event_btnChooseTemplateActionPerformed

    private void btnChooseOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseOutputActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(new JFrame());
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            txtOutput.setText(file.getName());
            outputFilePath = file.getAbsolutePath();
            System.out.println(outputFilePath);
        } else {
            System.out.println("Open command canceled");
        }
    }//GEN-LAST:event_btnChooseOutputActionPerformed

    private void btnGenerateDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateDocumentActionPerformed
        DateTimeFormatter year_short = DateTimeFormatter.ofPattern("yy");
        DateTimeFormatter full_short = DateTimeFormatter.ofPattern("dd/MM/yy");
        if (templateFilePath != null && outputFilePath != null) {
            File f = new File(templateFilePath);
            if (f.exists()) {

                ArrayList<tableRow> invoiceRows = new ArrayList<tableRow>();
                double invoiceSubtotal = 0.0;
                //<editor-fold defaultstate="collapsed" desc="Gets the table rows of the invoice and calculates the subtotal of the invoice">
                conn = sqlManager.openConnection();
                try {
                    String query = "SELECT description, quantity, unit_price, unit_price * quantity as itemCost FROM tblInvoiceDetails WHERE invoice_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, InvoiceID);
                    ResultSet rs = pstmt.executeQuery();

                    while (rs.next()) {
                        tableRow row = new tableRow(rs.getString(1), rs.getString(2), Utility.formatCurrency(rs.getDouble(3)), Utility.formatCurrency(rs.getDouble(4)));
                        invoiceSubtotal += rs.getDouble(4);
                        invoiceRows.add(row);
                    }
                } catch (SQLException e) {
                    System.out.println("SQLException");
                    e.printStackTrace();
                }
                sqlManager.closeConnection(conn);
                //</editor-fold>

                LinkedHashMap<String, String> invoiceMetaData = new LinkedHashMap<>();
                //<editor-fold defaultstate="collapsed" desc="Gets metadata about the specific invoice and puts it in the hashmap">
                conn = sqlManager.openConnection();
                try {
                    String query = "SELECT payments, date_created FROM tblInvoices WHERE invoice_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, InvoiceID);
                    ResultSet rs = pstmt.executeQuery();

                    invoiceMetaData.put("$subtotal", Utility.formatCurrency(invoiceSubtotal));
                    if (rs.next()) {
                        invoiceMetaData.put("$payments", Utility.formatCurrency(rs.getDouble(1)));
                        invoiceMetaData.put("$total", Utility.formatCurrency(invoiceSubtotal - rs.getDouble(1)));
                        invoiceMetaData.put("$date", rs.getDate(2).toLocalDate().format(full_short));
                        invoiceMetaData.put("$InvoiceNo", InvoiceID + "/" + rs.getDate(2).toLocalDate().format(year_short)); // #TODO make it change this depending on financial year
                    }
                } catch (SQLException e) {
                    System.out.println("SQLException");
                    e.printStackTrace();
                }
                sqlManager.closeConnection(conn);
                //</editor-fold>

                LinkedHashMap<String, String> customerData = new LinkedHashMap<>();
                //<editor-fold defaultstate="collapsed" desc="Gets data about the customer and puts it in the hashmap">
                conn = sqlManager.openConnection();
                try {
                    String query = "SELECT CONCAT(c.forename, ' ', c.surname) AS customerFullName,"
                            + " COALESCE(c.address1, '') AS address1,"
                            + " COALESCE(c.address2, '') AS address2,"
                            + " COALESCE(c.address3, '') AS address3,"
                            + " COALESCE(c.county, '') AS county,"
                            + " COALESCE(c.postcode, '') AS postcode"
                            + " FROM tblInvoices AS i"
                            + " INNER JOIN tblCustomers AS c ON i.customer_id = c.customer_id"
                            + " WHERE invoice_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, InvoiceID);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        customerData.put("$customerFullName", rs.getString(1));
                        customerData.put("$address1", rs.getString(2));
                        customerData.put("$address2", rs.getString(3));
                        customerData.put("$address3", rs.getString(4));
                        customerData.put("$county", rs.getString(5));
                        customerData.put("$postcode", rs.getString(6));
                    }
                } catch (SQLException e) {
                    System.out.println("SQLException");
                    e.printStackTrace();
                }
                sqlManager.closeConnection(conn);
                //</editor-fold>

                //<editor-fold defaultstate="collapsed" desc="Debug">
                System.out.println("invoiceRows: ");
                for (tableRow row : invoiceRows) {
                    System.out.println(row.toString());
                }
                System.out.println("invoiceMetaData"
                        + ": ");
                System.out.println(invoiceMetaData);
                System.out.println("customerData: ");
                System.out.println(customerData);
                //</editor-fold>

                // System.out.println(saveDocument(new XWPFDocument(), outputFilePath, "Output", true));
                XWPFDocument doc = null;
                try {
                    doc = new XWPFDocument(OPCPackage.open(templateFilePath));
                    doc = resizeDocumentTable(doc, invoiceRows.size());
                    saveDocument(doc, outputFilePath, "Temp", false);
                    doc = new XWPFDocument(OPCPackage.open(outputFilePath + "\\Temp.docx"));
                    doc = insertIntoTable(doc, invoiceRows);
                    saveDocument(doc, outputFilePath, "Output", true);
                } catch (InvalidFormatException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            } else {
                System.out.println("File does not exist.");
            }
        } else {
            System.out.println("One of the filepath requirements was not satisfied.");
        }
    }//GEN-LAST:event_btnGenerateDocumentActionPerformed

    public static XWPFDocument insertIntoTable(XWPFDocument document, ArrayList<tableRow> data) {

        List<XWPFTable> tables = document.getTables();

        XWPFTable table = tables.get(0);

        for (int i = 0; i < data.size(); i++) {
            int j = 0;
            for (XWPFTableCell cell : table.getRows().get(i + 1).getTableCells()) {
                if (cell.getParagraphs().size() == 0) {
                    cell.addParagraph();
                }
                for (XWPFParagraph p : cell.getParagraphs()) {
                    XWPFRun tempRun = p.createRun();
                    tempRun.setText(data.get(i).data[j++]);
                }
            }
            j = 0;
        }

        return document;
    }

    public static XWPFDocument resizeDocumentTable(XWPFDocument document, int amtRows) {

        List<XWPFTable> tables = document.getTables();
        XWPFTable table = tables.get(0);

        XWPFTableRow blankRow = table.getRows().get(2);             // The third row in the invoice template is the blank row
        if (amtRows == 0) {
            table.removeRow(2);
            table.removeRow(1);

        } else if (amtRows == 1) {
            table.removeRow(2);

        } else if (amtRows > 2) {
            int newRowsNeeded = amtRows - 2;
            int startRowInsert = 2;
            try {
                for (int i = 2; i < newRowsNeeded + 2; i++) {
                    CTRow ctrow = CTRow.Factory.parse(blankRow.getCtRow().newInputStream());
                    XWPFTableRow newRow = new XWPFTableRow(ctrow, table);
                    table.addRow(newRow, startRowInsert++);
                }
            } catch (XmlException xe) {
                xe.printStackTrace();
            } catch (IOException Ie) {
                Ie.printStackTrace();
            }
        } else {
            System.out.println("Not a valid amount of rows specified");
        }

        return document;
    }

    public static String saveDocument(XWPFDocument document, String destination, String fileName, boolean withCounter) {

        String savingDestination = destination + "\\" + fileName + ".docx";
        if (withCounter) {
            File f = new File(savingDestination);
            if (f.exists()) {
                System.out.println("File already exists under " + f.toPath().toString());

                boolean found = false;
                int counter = 1;
                while (!found) {
                    savingDestination = destination + "\\" + fileName + counter + ".docx";
                    File t = new File(savingDestination);
                    if (t.exists()) {
                        counter++;
                    } else {
                        found = true;
                    }
                }
            }
        }

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(savingDestination);
            document.write(out);
            out.close();

        } catch (IOException e) {
            System.out.println("Error saving file");
            e.printStackTrace();
        }
        return savingDestination;
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
            java.util.logging.Logger.getLogger(formFormatIntoWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formFormatIntoWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formFormatIntoWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formFormatIntoWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formFormatIntoWord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChooseOutput;
    private javax.swing.JButton btnChooseTemplate;
    private javax.swing.JButton btnGenerateDocument;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblTemplate;
    private javax.swing.JTextField txtOutput;
    private javax.swing.JTextField txtTemplate;
    // End of variables declaration//GEN-END:variables
}
