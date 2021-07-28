/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.LinkedHashMap;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Michal
 */
public class formReportOne extends javax.swing.JFrame {

    /**
     * Creates new form formReportOne
     */
    Connection conn = null;
    formMainMenu previousForm = null;
    int EmployeeID = 1;

    public formReportOne() {
        initComponents();
        this.setLocationRelativeTo(null);

        lblStart.setVisible(false);
        dcStart.setVisible(false);
        lblEnd.setVisible(false);
        dcEnd.setVisible(false);

        cbTime.addActionListener(new ActionListener() {        // When an action happens within the combo box - e.g. the selectedIndex changed
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbTime.getSelectedIndex() == cbTime.getItemCount() - 1) {   // If the user selected the last item ('Other')
                    lblStart.setVisible(true);
                    dcStart.setVisible(true);
                    lblEnd.setVisible(true);
                    dcEnd.setVisible(true);
                } else {
                    lblStart.setVisible(false);
                    dcStart.setVisible(false);
                    lblEnd.setVisible(false);
                    dcEnd.setVisible(false);
                }
            }
        });
    }

    private CategoryDataset getData(boolean getInvoices, boolean getQuotations, LocalDateTime start, LocalDateTime end, int barSpacing) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT invoice_id, payments, date_created FROM tblInvoices WHERE date_created BETWEEN ? AND ? ORDER BY date_created";
        conn = sqlManager.openConnection();

        LinkedHashMap<String, Double> dataArr = generateEmptyDict(start, end, barSpacing);
        System.out.println(dataArr.toString());
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setObject(1, start);
            pstmt.setObject(2, end);

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM");
            ResultSet rs = null;
            rs = pstmt.executeQuery();
            while (rs.next()) {
                if (barSpacing == 0) {
                    dataset.addValue(sqlManager.totalDocument(conn, "tblInvoiceDetails", "invoice_id", rs.getInt(1)) - rs.getDouble(2), "Invoice", rs.getDate(3).toLocalDate().format(fmt));
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL exception: " + e);
        }

        return dataset;
    }

    public LinkedHashMap<String, Double> generateEmptyDict(LocalDateTime start, LocalDateTime end, int barSpacing) {
        LinkedHashMap<String, Double> output = new LinkedHashMap<String, Double>();
        DateTimeFormatter daymonth = DateTimeFormatter.ofPattern("dd/MM");
        DateTimeFormatter year = DateTimeFormatter.ofPattern("yy");

        System.out.println(start.format(DateTimeFormatter.ISO_DATE));
        System.out.println(end.format(DateTimeFormatter.ISO_DATE));

        if (barSpacing == 0) {

            LocalDateTime counter = start;
            output.put(counter.format(daymonth), 0.00);

            while (!counter.toLocalDate().isEqual(end.toLocalDate())) {
                counter = counter.plusDays(1);
                output.put(counter.format(daymonth), 0.00);
            }
        } else if (barSpacing == 1) {
            LocalDateTime counter = start;

            while (counter.toLocalDate().isBefore(end.toLocalDate()) || counter.toLocalDate().isEqual(end.toLocalDate())) {
                output.put(counter.format(daymonth), 0.00);
                counter = counter.plusWeeks(1);
            }
        } else if (barSpacing == 2) {
            LocalDateTime counter = start;

            while (counter.toLocalDate().isBefore(end.toLocalDate())) {
                output.put(counter.toLocalDate().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + "-" + counter.format(year), 0.00);
                counter = counter.plusMonths(1);
            }
            output.put(end.toLocalDate().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + "-" + end.format(year), 0.00);
        } else if (barSpacing == 3) {
            LocalDateTime counter = start;

            while (counter.toLocalDate().isBefore(end.toLocalDate())) {
                output.put(Utility.getQuarter(counter.toLocalDate()) + "-" + counter.format(year), 0.00);
                counter = counter.plusMonths(3);
            }
            output.put(Utility.getQuarter(end.toLocalDate()) + "-" + end.format(year), 0.00);
        }

        return output;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSalesAnalysis = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        pParam = new javax.swing.JPanel();
        btnAnalyze = new javax.swing.JButton();
        lblDataToAnalyse = new javax.swing.JLabel();
        cbData = new javax.swing.JComboBox<>();
        cbTime = new javax.swing.JComboBox<>();
        cbTimePeriod = new javax.swing.JLabel();
        lblStart = new javax.swing.JLabel();
        dcStart = new com.toedter.calendar.JDateChooser();
        dcEnd = new com.toedter.calendar.JDateChooser();
        lblEnd = new javax.swing.JLabel();
        pOutput = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSalesAnalysis.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblSalesAnalysis.setText("Sales Analysis");

        btnBack.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        pParam.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pParam.setMinimumSize(new java.awt.Dimension(0, 200));

        btnAnalyze.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAnalyze.setText("Analyze");
        btnAnalyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalyzeActionPerformed(evt);
            }
        });

        lblDataToAnalyse.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblDataToAnalyse.setText("Data to analyse:");

        cbData.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbData.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Invoices", "Quotations", "Both" }));

        cbTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Past month", "Past year", "This month", "This quarter", "This year", "This financial year", "All Time", "Other" }));

        cbTimePeriod.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cbTimePeriod.setText("Time Period:");

        lblStart.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblStart.setText("Start Date: ");

        lblEnd.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblEnd.setText("End Date: ");

        javax.swing.GroupLayout pParamLayout = new javax.swing.GroupLayout(pParam);
        pParam.setLayout(pParamLayout);
        pParamLayout.setHorizontalGroup(
            pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pParamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pParamLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAnalyze))
                    .addGroup(pParamLayout.createSequentialGroup()
                        .addGroup(pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDataToAnalyse)
                            .addComponent(cbTimePeriod))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbData, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTime, 0, 150, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pParamLayout.createSequentialGroup()
                        .addComponent(lblStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(lblEnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pParamLayout.setVerticalGroup(
            pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pParamLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataToAnalyse)
                    .addComponent(cbData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTimePeriod))
                .addGap(10, 10, 10)
                .addGroup(pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dcStart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(lblStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pParamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(lblEnd)))
                .addGap(18, 18, 18)
                .addComponent(btnAnalyze)
                .addContainerGap())
        );

        pOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pOutput.setMinimumSize(new java.awt.Dimension(0, 0));
        pOutput.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pParam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(151, 151, 151)
                        .addComponent(lblSalesAnalysis)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSalesAnalysis)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        previousForm.setVisible(true);                              // Makes main previous form visible
        this.dispose();                                             // Closes the customer management form (current form)

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAnalyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalyzeActionPerformed
        CategoryDataset data = null;
        boolean getInvoices = false;
        boolean getQuotations = false;
        LocalDateTime start = null;
        LocalDateTime end = LocalDateTime.now();
        // Sets the boolean for whether to load invoices, quotations or both
        if (cbData.getSelectedIndex() == 0) {
            getInvoices = true;
        } else if (cbData.getSelectedIndex() == 1) {
            getQuotations = true;
        } else if (cbData.getSelectedIndex() == 2) {
            getInvoices = true;
            getQuotations = true;
        }

        boolean valid = true;                                       // If the input is valid
        if (cbTime.getSelectedIndex() == 0) {                                           // Past month
            start = LocalDate.now().minusMonths(1).atTime(0, 0, 0);
        } else if (cbTime.getSelectedIndex() == 1) {                                    // Past year
            start = LocalDate.now().minusMonths(12).atTime(0, 0, 0);
        } else if (cbTime.getSelectedIndex() == 2) {                                    // This month
            start = LocalDate.now().withDayOfMonth(1).atTime(0, 0, 0);
        } else if (cbTime.getSelectedIndex() == 3) {                                    // This quarter
            start = Utility.getQuarterStart(LocalDate.now()).atTime(0, 0, 0);
        } else if (cbTime.getSelectedIndex() == 4) {                                    // This year
            start = LocalDate.now().withDayOfYear(1).atTime(0, 0, 0);
        } else if (cbTime.getSelectedIndex() == 5) {                                    // This financial year
            start = Utility.getFinancialYear(LocalDate.now()).atTime(0, 0, 0);
        } else if (cbTime.getSelectedIndex() == 6) {                                    // All time
            start = LocalDate.of(1970, 1, 1).atTime(0, 0, 0);
        } else if (cbTime.getSelectedIndex() == 7) {                                    // Other
            if (dcStart.getDate() == null || dcEnd.getDate() == null || dcEnd.getDate().before(dcStart.getDate())) {
                valid = false;
                System.out.println("Start date or end date missing or end date is after start date");
            } else {
                start = dcStart.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atTime(0, 0, 0); // Start of first date selected
                end = dcEnd.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atTime(23, 59, 59);  // End of second date selected
            }
        }
        if (valid) {
            Duration dr = Duration.between(start, end);
            int daysBetweenDates = (int) dr.toDays();

            int barSpacing = 1;                                     // Sets the spacing of the bars in the bar chart
            if (daysBetweenDates < 7) {                             // 0 - max 7 bars, one per day, shows the day and month dd/mm
                barSpacing = 0;                                     // 1 - max 12 bars, one per week, shows the w/c day of each month
            } else if (daysBetweenDates < 84) {                     // 2 - max 12 bars, one per month, shown the month name
                barSpacing = 1;                                     // 3 - max 12 bars, one per quarter, shows the quarter and year
            } else if (daysBetweenDates < 366) {                    // 4 - no maximum, one per year
                barSpacing = 2;
            } else if (daysBetweenDates < 365 * 3) {
                barSpacing = 3;
            } else if (daysBetweenDates >= 365 * 3) {
                barSpacing = 4;
            }

            data = getData(getInvoices, getQuotations, start, end, barSpacing);
            JFreeChart barChart = ChartFactory.createBarChart(
                    "Value invoiced/quoted vs. time",
                    "Date",
                    "Value invoiced/quoted",
                    data,
                    PlotOrientation.VERTICAL,
                    cbData.getSelectedIndex() == 2, // only shows legend if the user wanted both types of data 
                    true,
                    false);

            CategoryPlot p = barChart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);

            ChartPanel barPanel = new ChartPanel(barChart);
            pOutput.removeAll();
            pOutput.add(barPanel, BorderLayout.CENTER);
            pOutput.validate();
        }

//        To open a new form with the report
//        CategoryPlot p = barChart.getCategoryPlot();
//        p.setRangeGridlinePaint(Color.black);
//        ChartFrame frame = new ChartFrame("Bar chart", barChart);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        frame.setSize(450, 350);
    }//GEN-LAST:event_btnAnalyzeActionPerformed

    /**
     * @param args the command line arguments
     */
    public formReportOne getFrame() {
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
            java.util.logging.Logger.getLogger(formReportOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formReportOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formReportOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formReportOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formReportOne().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalyze;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cbData;
    private javax.swing.JComboBox<String> cbTime;
    private javax.swing.JLabel cbTimePeriod;
    private com.toedter.calendar.JDateChooser dcEnd;
    private com.toedter.calendar.JDateChooser dcStart;
    private javax.swing.JLabel lblDataToAnalyse;
    private javax.swing.JLabel lblEnd;
    private javax.swing.JLabel lblSalesAnalysis;
    private javax.swing.JLabel lblStart;
    private javax.swing.JPanel pOutput;
    private javax.swing.JPanel pParam;
    // End of variables declaration//GEN-END:variables
}
