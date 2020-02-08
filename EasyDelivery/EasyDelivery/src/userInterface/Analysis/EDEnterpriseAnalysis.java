/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Analysis;

import business.Ecosystem;
import business.Enterprise.Enterprise;
import business.Enterprise.SellerEnterprise;
import business.Network.Network;
import business.Organization.ShippingOrganization;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Renu
 */
public class EDEnterpriseAnalysis extends javax.swing.JPanel {

    private JPanel container;
    private Ecosystem system;
    private Enterprise enterprise;
    private Network network;
    private ShippingOrganization organization;

    public EDEnterpriseAnalysis(JPanel container, Ecosystem system, Enterprise selectedEnterprise, Network selectedNetwork) {
        initComponents();
        this.container = container;
        this.system = system;
        this.enterprise = selectedEnterprise;
        this.network = selectedNetwork;
        pieChart();
        barChart();
        lineChart();
    }

    private void barChart() {
        DefaultCategoryDataset barData = new DefaultCategoryDataset();

        double total;
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise.getEnterpriseType().getValue().equals("Seller")) {
                SellerEnterprise sellerEnt = (SellerEnterprise) enterprise;

                total = network.getOrderDirectory().calulatecommissiononbasisofseller(sellerEnt);
                barData.setValue(total, sellerEnt.getName(), sellerEnt.getName());

            }
        }

        JFreeChart barChart = ChartFactory.createBarChart3D("Analysis", "Seller", "Total Commission", barData);
        // (, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot categoryPlot = barChart.getCategoryPlot();
        categoryPlot.setRangeGridlinePaint(Color.black);

        ChartPanel chartPanel = new ChartPanel(barChart);
        barChartPanel.removeAll();
        barChartPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        barChartPanel.add(chartPanel);
    }

    private void pieChart() {
        DefaultPieDataset pieData = new DefaultPieDataset();
        double total;
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise.getEnterpriseType().getValue().equals("Seller")) {
                SellerEnterprise sellerEnt = (SellerEnterprise) enterprise;

                total = network.getOrderDirectory().calulatecommissiononbasisofseller(sellerEnt);
                pieData.setValue(sellerEnt.getName(), total);
            }
        }

//        System.out.print("size" + organization.getSkuCatalog().getSkuList().size() + " " + organization.getWorkQueue().getWorkRequestList().size());
//        pieData.setValue("marks", 10);
//        pieData.setValue("fghjk", 20);
//        pieData.setValue("ghj", 30);
        JFreeChart pieChart = ChartFactory.createPieChart("Easy Delivery Analysis", pieData, true, true, false);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        pieChartPanel.removeAll();
        pieChartPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        pieChartPanel.add(chartPanel);

        PiePlot piePlot = (PiePlot) pieChart.getPlot();
        piePlot.setStartAngle(290);
        piePlot.setDirection(Rotation.CLOCKWISE);
        piePlot.setForegroundAlpha(0.5f);
        piePlot.setCircular(true);
        piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator(
                "{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()
        ));
    }

    private void lineChart() {
        DefaultCategoryDataset lineData = new DefaultCategoryDataset();
        double total;
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (enterprise.getEnterpriseType().getValue().equals("Seller")) {
                SellerEnterprise sellerEnt = (SellerEnterprise) enterprise;

                total = network.getOrderDirectory().calulatecommissiononbasisofseller(sellerEnt);
                lineData.setValue(total, "Shipping Data", sellerEnt.getName());
            }
        }

        JFreeChart lineChart = ChartFactory.createLineChart("Analysis", "Seller", "Total Commission", lineData);
        CategoryPlot catPlot = (CategoryPlot) lineChart.getPlot();
        catPlot.getRenderer().setSeriesPaint(0, Color.darkGray);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        lineChartPanel.removeAll();
        lineChartPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lineChartPanel.add(chartPanel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainChartPanel = new javax.swing.JTabbedPane();
        barChartPanel = new javax.swing.JPanel();
        lineChartPanel = new javax.swing.JPanel();
        pieChartPanel = new javax.swing.JPanel();
        btnBack1 = new javax.swing.JButton();

        javax.swing.GroupLayout barChartPanelLayout = new javax.swing.GroupLayout(barChartPanel);
        barChartPanel.setLayout(barChartPanelLayout);
        barChartPanelLayout.setHorizontalGroup(
            barChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        barChartPanelLayout.setVerticalGroup(
            barChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        MainChartPanel.addTab("BarChart", barChartPanel);

        javax.swing.GroupLayout lineChartPanelLayout = new javax.swing.GroupLayout(lineChartPanel);
        lineChartPanel.setLayout(lineChartPanelLayout);
        lineChartPanelLayout.setHorizontalGroup(
            lineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        lineChartPanelLayout.setVerticalGroup(
            lineChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        MainChartPanel.addTab("LineChart", lineChartPanel);

        javax.swing.GroupLayout pieChartPanelLayout = new javax.swing.GroupLayout(pieChartPanel);
        pieChartPanel.setLayout(pieChartPanelLayout);
        pieChartPanelLayout.setHorizontalGroup(
            pieChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        pieChartPanelLayout.setVerticalGroup(
            pieChartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );

        MainChartPanel.addTab("PieChart", pieChartPanel);

        btnBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-arrow-icon.png"))); // NOI18N
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainChartPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack1)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBack1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane MainChartPanel;
    private javax.swing.JPanel barChartPanel;
    private javax.swing.JButton btnBack1;
    private javax.swing.JPanel lineChartPanel;
    private javax.swing.JPanel pieChartPanel;
    // End of variables declaration//GEN-END:variables
}
