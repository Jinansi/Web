/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Customer;

import business.CallCompaint;
import business.Customer.CustomerAccount;
import business.Ecosystem;
import business.Enterprise.EDEnterprise;
import business.Enterprise.Enterprise;
import business.Enterprise.SellerEnterprise;
import business.Inventory.Department;
import business.Inventory.MasterProductCatalog;
import business.Inventory.Product;
import business.Inventory.SKU;
import business.Inventory.SKUHolder;
import business.Network.Network;
import business.Organization.CustomerOrganization;
import business.Organization.InventoryManagementOrganization;
import business.Organization.Organization;
import business.Utils.GIS;
import business.order.Order;
import business.order.OrderItem;
import com.twilio.sdk.TwilioRestException;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Gunjan
 */
public class ShoppingCartJPanel extends javax.swing.JPanel {

    // helper class image renderer for images in table
    private class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel lbl = new JLabel();
            lbl.setIcon((ImageIcon) value);
            return lbl;
        }
    }

    // data members
    private Ecosystem system;
    private JPanel container;
    private Network network;
    private Order order;
    private CustomerAccount customerAccount;
    private EDEnterprise enterprise;
    private boolean isCheckedOut = false;

    // constructor
    public ShoppingCartJPanel(JPanel userProcessContainer, EDEnterprise enterprise, CustomerOrganization custorg, CustomerAccount customerAccount, Ecosystem business, Network network) {
        initComponents();
        this.system = business;
        this.container = userProcessContainer;
        this.network = network;
        this.customerAccount = customerAccount;
        this.enterprise = enterprise;
        order = new Order();

        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();

        populateAwesomeTree(root, system.getDepartmentCatalog().getDepartmentList());

        model.reload();
        btnCheckOut.setEnabled(false);
        
    }

    private void populateAwesomeTree(DefaultMutableTreeNode rootNode, List<Department> departmentList) {

        if (departmentList.isEmpty()) {
            return;
        }

        int j = 0;
        for (Department department : departmentList) {
            DefaultMutableTreeNode departmentNode = new DefaultMutableTreeNode(department);
            rootNode.insert(departmentNode, j++);
            populateAwesomeTree(departmentNode, department.getDepartmentList());
        }
    }

    /**
     * Populates all the products from provided departments and their children departments
     * @param departmentList 
     */
    private void populateTable(String productName, List<Department> departmentList) {

        Set<Product> productSet = new HashSet<>();
        
        for(Department department : departmentList){
            for (Department dep : department.getAllTheChildrenDepartment()) {
                if(productName!=null && !productName.isEmpty()){
                    for(Product product: dep.getProductList()){
                        if(product.getName().equalsIgnoreCase(productName)){
                            productSet.add(product);
                        }
                    }
                }else{
                    productSet.addAll(dep.getProductList());
                }
            }
        }
        
        List<SKUHolder> skuHolders = getSKUs(productSet);
        populateTable(skuHolders);
    }

    private void populateTable(List<SKUHolder> skuHolders) {

        DefaultTableModel model = (DefaultTableModel) tblSkuCatalog.getModel();
        model.setRowCount(0);

        tblSkuCatalog.setRowHeight(100);
        tblSkuCatalog.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
        
        for (SKUHolder skuHolder : skuHolders) {
            SKU sku = skuHolder.sku;
            Object[] row = new Object[tblSkuCatalog.getColumnCount()];
            int i = 0;
            row[i++] = sku.getProduct().getImage();
            row[i++] = skuHolder.seller.getOrganization(Organization.Type.InventoryManagementOrganization).getName();
            row[i++] = skuHolder;
            row[i++] = sku.getProduct().getBrand();
            row[i++] = sku.getProduct().getModelNo();
            row[i++] = sku.getProduct().getPrice();
            double dist = GIS.getDistance(customerAccount.getAddress(),skuHolder.seller.getOrganization(Organization.Type.InventoryManagementOrganization).getAddress());
            if(dist <= 30){
            row[i++] = "Prime Today" ;   
            }else{
            row[i++] = "Prime 2-day" ;  
            }
            model.addRow(row);
        }
    }

    private List<SKUHolder> getSKUs(Set<Product> productSet) {
        List<SKUHolder> retList = new ArrayList<>();
        for (Enterprise sellerEnt : network.getEnterpriseDirectory().getEnterprises(Enterprise.EnterpriseType.SELLERENTERPRISE)) {
            for (Organization org : sellerEnt.getOrganizations(Organization.Type.InventoryManagementOrganization)) {
                for (SKU sku : ((InventoryManagementOrganization) org).getSkuCatalog().getSkuList()) {
                    Iterator iterator = productSet.iterator();
                    while (iterator.hasNext()) {
                        if (((Product) iterator.next()).equals(sku.getProduct())) {
                            retList.add(new SKUHolder(sku, (SellerEnterprise) sellerEnt));
                        }
                    }
                }
            }
        }
        return retList;
    }

    public void populateOrderTable() {
        DefaultTableModel orderTable = (DefaultTableModel) tblOrder.getModel();
        orderTable.setRowCount(0);
        for (OrderItem eachItem : order.getOrderItemList()) {
            Object row[] = new Object[7];
            row[0] = eachItem;
            row[1] = eachItem.getSkuHolder().seller;
            row[2] = eachItem.getProduct();
            row[3] = eachItem.getProduct().getBrand();
            row[4] = eachItem.getQuantity();
            row[5] = eachItem.getProductPrice();
            row[6] = eachItem.getTotalPrice();
            orderTable.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btnManageAccoiunt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSkuCatalog = new javax.swing.JTable();
        btnAddtocart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        productQty = new javax.swing.JSpinner();
        btnCheckOut = new javax.swing.JButton();
        btncomplaint = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnManageAccoiunt.setText("Manage Account! ");
        btnManageAccoiunt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAccoiuntActionPerformed(evt);
            }
        });

        tblSkuCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Image", "Sold By", "Product Name", "Brand", "Model No", "Price", "Tag"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSkuCatalog.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblSkuCatalog);

        btnAddtocart.setText("Add to Cart!");
        btnAddtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtocartActionPerformed(evt);
            }
        });

        jLabel1.setText("Search: ");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Departments");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jTree);

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sr. No", "Sold By", "Product", "Brand", "Quantity", "Price", "Total Price"
            }
        ));
        jScrollPane4.setViewportView(tblOrder);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Your Cart :");

        btnRemove.setText("Remove Items From Cart");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Choose quantity : ");

        btnCheckOut.setText("Proceed to Checkout!");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        btncomplaint.setText("Complaints");
        btncomplaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomplaintActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/happy.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(559, 559, 559)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(productQty, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(btnAddtocart, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(89, 89, 89)
                                                .addComponent(btnManageAccoiunt)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jScrollPane2))
                                                .addGap(38, 38, 38))))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncomplaint, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRemove)
                                .addGap(39, 39, 39)
                                .addComponent(btnCheckOut)))
                        .addGap(9, 9, 9)))
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnManageAccoiunt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productQty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddtocart, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckOut)
                    .addComponent(btnRemove))
                .addGap(35, 35, 35)
                .addComponent(btncomplaint)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtocartActionPerformed
        int selectedRow = tblSkuCatalog.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a product to add to cart", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        SKUHolder skuHolder = (SKUHolder) tblSkuCatalog.getValueAt(selectedRow, 2);
        SKU selectedSku = skuHolder.sku;
        int quantityOrdered = (int) productQty.getValue();

        if (quantityOrdered <= 0) {
            JOptionPane.showMessageDialog(null, "Quantity should not be negative or zero!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (quantityOrdered <= selectedSku.getQuantity()) {
            boolean isPresent = false;
            for (OrderItem eachItem : order.getOrderItemList()) {
                if (eachItem.getProduct() == selectedSku.getProduct()) {
                    int oldAvail = selectedSku.getQuantity();
                    int newAvail = oldAvail - quantityOrdered;
                    selectedSku.setQuantity(newAvail);
                    eachItem.setQuantity(quantityOrdered + eachItem.getQuantity());
                    isPresent = true;
                    populateOrderTable();
                    break;
                }
            }
            if (!isPresent) {
                int oldAvail = selectedSku.getQuantity();
                int newAvail = oldAvail - quantityOrdered;
                selectedSku.setQuantity(newAvail);
                order.addNewOrderItem(skuHolder, quantityOrdered, selectedSku.getProduct().getPrice());
                populateOrderTable();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Qunatity exceeded availability!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (order.getOrderItemList().size() >= 0) {
            btnCheckOut.setEnabled(true);
        }
    }//GEN-LAST:event_btnAddtocartActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
        try {
            if (node.equals("Departments")) {

            } else if (node != null) {
                List<Department> depList = new ArrayList<>();
                depList.add((Department) node.getUserObject());
                populateTable(null, depList);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Select the type of Department", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_jTreeValueChanged

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        int selectedRow = tblOrder.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // get selected item
        OrderItem orderItem = (OrderItem) tblOrder.getValueAt(selectedRow, 0);

        // adjusting quantities
        int oldAvail = orderItem.getSkuHolder().sku.getQuantity();
        int itemQty = orderItem.getQuantity();
        int newAvail = oldAvail + itemQty;
        orderItem.getSkuHolder().sku.setQuantity(newAvail);

        // removing order item
        order.removeOrderItem(orderItem);

        populateOrderTable();

        if (order.getOrderItemList().size() <= 0) {
            btnCheckOut.setEnabled(false);
        }

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed

        if (order.getOrderItemList().size() <= 0) {
            JOptionPane.showMessageDialog(null, "There are no orders to be placed!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        OrderConfirmationPage orderconfirm = new OrderConfirmationPage(container, system, order, customerAccount, network);
        container.add("OrderConfirmationPage", orderconfirm);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnManageAccoiuntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAccoiuntActionPerformed
        ManageAccountJPanel manageAccount = new ManageAccountJPanel(container, system, customerAccount, network);
        container.add("ManageAccoiunt", manageAccount);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }//GEN-LAST:event_btnManageAccoiuntActionPerformed

    private void btncomplaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomplaintActionPerformed
        // TODO add your handling code here:
        CallCompaint cc = new CallCompaint();
        try {
            cc.initiateCall();
        } catch (TwilioRestException ex) {
        }
    }//GEN-LAST:event_btncomplaintActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

        populateTable(txtSearch.getText(), system.getDepartmentCatalog().getDepartmentList());
       
    }//GEN-LAST:event_txtSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddtocart;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnManageAccoiunt;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btncomplaint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTree jTree;
    private javax.swing.JSpinner productQty;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblSkuCatalog;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
