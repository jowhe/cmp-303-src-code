/*
 */
package cmp_303_systems_development_software.views;

import cmp_303_systems_development_software.classes.Log;
import cmp_303_systems_development_software.classes.User;
import cmp_303_systems_development_software.forms.MessageBox;
import cmp_303_systems_development_software.forms.InsertCustomer;
import cmp_303_systems_development_software.forms.UpdateCustomer;
import cmp_303_systems_development_software.handlers.FormHandler;
import cmp_303_systems_development_software.handlers.ViewHandler;
import cmp_303_systems_development_software.utils.Commands;
import cmp_303_systems_development_software.utils.DatabaseManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joe
 */
public class CustomerView extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    private final User USER;
    private final ViewHandler VHANDLER;
    /**
     * Creates new view panel (Customers View)
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     */
    public CustomerView(User user, ViewHandler viewHandler) {
        initComponents();
        this.USER = user;
        this.VHANDLER = viewHandler;
        tableModel = new DefaultTableModel();
        this.jTable1.setModel(tableModel);
    }
    
    public void populate(){
        java.sql.ResultSet res = DatabaseManager.Query("SELECT * FROM customers");
        try{
            java.sql.ResultSetMetaData resMd = res.getMetaData();
            for(int i = 0; i < resMd.getColumnCount(); i++){
                tableModel.addColumn(resMd.getColumnLabel(i+1));
            }
            while(res.next()){
                tableModel.addRow(new Object[]{res.getInt("customer_id"), res.getString("customer_surname"), res.getString("customer_email"), res.getString("customer_tel")});
            }
            
            DatabaseManager.Disconnect();
        }catch(java.sql.SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDeleteCustomer = new javax.swing.JButton();
        btnEditCustomer = new javax.swing.JButton();
        btnInsertCustomer = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(876, 367));
        setMinimumSize(new java.awt.Dimension(876, 367));
        setName(""); // NOI18N

        jScrollPane1.setBorder(null);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(450, 400));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(450, 400));

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnDeleteCustomer.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteCustomer.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteCustomer.setText("Delete Customer");
        btnDeleteCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnDeleteCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });

        btnEditCustomer.setBackground(new java.awt.Color(204, 204, 204));
        btnEditCustomer.setForeground(new java.awt.Color(102, 102, 102));
        btnEditCustomer.setText("Edit Customer");
        btnEditCustomer.setToolTipText("");
        btnEditCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnEditCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });

        btnInsertCustomer.setBackground(new java.awt.Color(204, 204, 204));
        btnInsertCustomer.setForeground(new java.awt.Color(102, 102, 102));
        btnInsertCustomer.setText("Insert Customer");
        btnInsertCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnInsertCustomer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnEditCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsertCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        if(jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            Integer id = (int) this.jTable1.getValueAt(r,0);
            
            System.out.println("Selected Employee: " + id);
            
            if(DatabaseManager.Delete("DELETE FROM customers WHERE customer_id = ?", id)){
                java.sql.ResultSet rows = DatabaseManager.Query("SELECT COUNT(*) FROM customers");
                try {
                    if(rows.next() && DatabaseManager.Execute("ALTER TABLE customers AUTO_INCREMENT = ?", new Object[]{rows.getInt(1)})){
                        FormHandler.openMessageBox(new MessageBox("Success!", "Customer successfully deleted!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                        CustomerView cView = new CustomerView(USER, VHANDLER);
                        VHANDLER.changeView(cView, this);
                        cView.populate();
                    }
                } catch (SQLException e) {
                    FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
                }
                DatabaseManager.Disconnect();
                new Log(Commands.getDateTime(), "Successfully deleted a customer", USER.getId()).send();
            }else{
                new Log(Commands.getDateTime(), "Failed to delete a customer", USER.getId()).send();
            }
        }
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed
        if(jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            Integer id = (int) this.jTable1.getValueAt(r,0);
            
            System.out.println("Selected Employee: " + id);
            
            FormHandler.openPopup(new UpdateCustomer(USER, VHANDLER, (javax.swing.JPanel) this.getParent(), id));
        }
    }//GEN-LAST:event_btnEditCustomerActionPerformed

    private void btnInsertCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertCustomerActionPerformed
        FormHandler.openPopup(new InsertCustomer(USER, VHANDLER, this));
    }//GEN-LAST:event_btnInsertCustomerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnInsertCustomer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
