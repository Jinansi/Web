/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SystemAdmin;

import business.Ecosystem;
import business.Network.Network;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jinansi
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {

    private JPanel container;
    private Ecosystem system;

    /**
     *
     * Creates new form ManageNetworkJPanel
     */
    public ManageNetworkJPanel(JPanel userProcessContainer, Ecosystem system) {
        initComponents();
        this.container = userProcessContainer;
        this.system = system;
        populateNetworkTable();
        populateCountryComboBox();
        btnUpdateCity.setVisible(false);
        btnUpdateState.setVisible(false);
        
        jLabel1.setText("<html><u>Manage Network</u></html>");
    }

    private void populateCountryComboBox(){
        comboBoxCountry1.removeAllItems();
        comboBoxCountry.removeAllItems();
        comboBoxState1.removeAllItems();
        
        for (Network countrynetwork : system.getNetworkDirectory().getNetworkList()){
            comboBoxCountry.addItem(countrynetwork);
            comboBoxCountry1.addItem(countrynetwork);
        }
    }
    
    private void populateStateComboBox(Network network, JComboBox combobox){
        combobox.removeAllItems();
        
        for (Network network1 : network.getNetworkDirectory().getNetworkList()){
            combobox.addItem(network1);
        }
    }

    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) tblNetowrk.getModel();
        model.setRowCount(0);
        for (Network country : system.getNetworkDirectory().getNetworkList()) {
            for (Network state : country.getNetworkDirectory().getNetworkList()) {
                for (Network city : state.getNetworkDirectory().getNetworkList()) {
                    Object[] row = new Object[3];
                    row[0] = country;
                    row[1] = state;
                    row[2] = city;
                    model.addRow(row);
                }
            }

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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNetowrk = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtAddState = new javax.swing.JTextField();
        btnAddState = new javax.swing.JButton();
        comboBoxCountry = new javax.swing.JComboBox();
        btnUpdateState = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtCountry = new javax.swing.JTextField();
        btnAddCountry = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtAddCity = new javax.swing.JTextField();
        btnAddCiy = new javax.swing.JButton();
        comboBoxCountry1 = new javax.swing.JComboBox();
        comboBoxState1 = new javax.swing.JComboBox();
        btnUpdateCity = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 255)));

        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-arrow-icon.png"))); // NOI18N
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        tblNetowrk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Country", "State", "City"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNetowrk);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Add State in the Selected Country"));

        txtAddState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddStateActionPerformed(evt);
            }
        });

        btnAddState.setText("Add");
        btnAddState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStateActionPerformed(evt);
            }
        });

        comboBoxCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnUpdateState.setText("Update");
        btnUpdateState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddState)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAddState)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(btnUpdateState))
                    .addComponent(comboBoxCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(comboBoxCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAddState, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddState)
                    .addComponent(btnUpdateState, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Country"));

        txtCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCountryActionPerformed(evt);
            }
        });

        btnAddCountry.setText("Add");
        btnAddCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCountryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCountry)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAddCountry)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddCountry)
                .addGap(20, 20, 20))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Add City in the Selected State/Country"));

        txtAddCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddCityActionPerformed(evt);
            }
        });

        btnAddCiy.setText("Add");
        btnAddCiy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCiyActionPerformed(evt);
            }
        });

        comboBoxCountry1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCountry1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCountry1ActionPerformed(evt);
            }
        });

        comboBoxState1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnUpdateCity.setText("Update");
        btnUpdateCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddCity)
                    .addComponent(comboBoxCountry1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAddCiy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateCity))
                    .addComponent(comboBoxState1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(comboBoxCountry1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBoxState1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAddCity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCiy)
                    .addComponent(btnUpdateCity, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        btnEdit.setText("Edit Details");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Manage Nework ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backJButton)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(backJButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(205, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        container.remove(this);
        Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void txtCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCountryActionPerformed

    private void txtAddStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddStateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddStateActionPerformed

    private void txtAddCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddCityActionPerformed

    private void btnAddCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCountryActionPerformed
        String countrynetwork = txtCountry.getText();
        
        if(countrynetwork != null && system.getNetworkDirectory().checkNetwork(countrynetwork)){
           Network network = system.getNetworkDirectory().createAndAddNetwork();
           network.setName(countrynetwork);
           populateCountryComboBox();
           txtCountry.setText("");
           populateNetworkTable();
       }else{
            JOptionPane.showMessageDialog(null,"This Country is already Present in our networks", "Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnAddCountryActionPerformed

    private void btnAddStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStateActionPerformed
         
        Network countryNet = (Network)comboBoxCountry.getSelectedItem();
        String statenet = txtAddState.getText();
          if(statenet != null && countryNet.getNetworkDirectory().checkNetwork(statenet)){
           Network network = countryNet.getNetworkDirectory().createAndAddNetwork();
           network.setName(statenet);
           txtAddState.setText("");
           populateNetworkTable();
       }else{
            JOptionPane.showMessageDialog(null,"This State is already Present in our network", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddStateActionPerformed

    private void comboBoxCountry1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCountry1ActionPerformed
         Network network = (Network) comboBoxCountry1.getSelectedItem();
        if (network != null){
            populateStateComboBox(network,comboBoxState1);
        }
    }//GEN-LAST:event_comboBoxCountry1ActionPerformed

    private void btnAddCiyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCiyActionPerformed
        Network statenetwork = (Network) comboBoxState1.getSelectedItem();
        String cityname = txtAddCity.getText();
          if(cityname != null && statenetwork.getNetworkDirectory().checkNetwork(cityname)){
           Network citynetwork = statenetwork.getNetworkDirectory().createAndAddNetwork();
           citynetwork.setName(cityname);
           txtAddCity.setText("");
           populateNetworkTable();
       }else{
            JOptionPane.showMessageDialog(null,"This City is already Present in our network", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddCiyActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        btnUpdateCity.setVisible(true);
        btnUpdateState.setVisible(true);
        comboBoxCountry.setEnabled(false);
        comboBoxCountry1.setEnabled(false);
        comboBoxState1.setEnabled(false);
        int selectedrow = tblNetowrk.getSelectedRow();
        if(selectedrow >=0){
            Network network = (Network)tblNetowrk.getValueAt(selectedrow,0);
            comboBoxCountry.setSelectedItem(network);
            comboBoxCountry1.setSelectedItem(network);
            txtCountry.setText(network.getName());
            Network statenetwork = (Network)tblNetowrk.getValueAt(selectedrow,1);
            comboBoxState1.setSelectedItem(statenetwork);
            txtAddState.setText(statenetwork.getName());
            Network citynetwork = (Network)tblNetowrk.getValueAt(selectedrow,2);
            txtAddCity.setText(citynetwork.getName());
        }
        else{
            JOptionPane.showMessageDialog(null,"Please Select the Row");
        } 
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStateActionPerformed
        int selectedrow = tblNetowrk.getSelectedRow();
        if(selectedrow >=0){
            Network network = (Network)tblNetowrk.getValueAt(selectedrow,1);
            network.setName(txtAddState.getText());
        }
        JOptionPane.showMessageDialog(null,"State Name  edited");
        populateNetworkTable();
    }//GEN-LAST:event_btnUpdateStateActionPerformed

    private void btnUpdateCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCityActionPerformed
        int selectedrow = tblNetowrk.getSelectedRow();
        if(selectedrow >=0){
            Network network = (Network)tblNetowrk.getValueAt(selectedrow,2);
            network.setName(txtAddCity.getText());
        }
        JOptionPane.showMessageDialog(null,"State Name  edited");
        populateNetworkTable();
    }//GEN-LAST:event_btnUpdateCityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAddCiy;
    private javax.swing.JButton btnAddCountry;
    private javax.swing.JButton btnAddState;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdateCity;
    private javax.swing.JButton btnUpdateState;
    private javax.swing.JComboBox comboBoxCountry;
    private javax.swing.JComboBox comboBoxCountry1;
    private javax.swing.JComboBox comboBoxState1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblNetowrk;
    private javax.swing.JTextField txtAddCity;
    private javax.swing.JTextField txtAddState;
    private javax.swing.JTextField txtCountry;
    // End of variables declaration//GEN-END:variables
}