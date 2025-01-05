/*
 */
package cmp_303_systems_development_software.views;

import cmp_303_systems_development_software.classes.Log;
import cmp_303_systems_development_software.classes.User;
import cmp_303_systems_development_software.forms.MessageBox;
import cmp_303_systems_development_software.forms.InsertEmployee;
import cmp_303_systems_development_software.forms.UpdateEmployee;
import cmp_303_systems_development_software.handlers.FormHandler;
import cmp_303_systems_development_software.handlers.ViewHandler;
import cmp_303_systems_development_software.utils.Commands;
import cmp_303_systems_development_software.utils.DatabaseManager;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joe
 */
public class EmployeesView extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    private final User USER;
    private final ViewHandler VHANDLER;
    /**
     * Creates new view panel (Employees View)
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     */
    public EmployeesView(User user, ViewHandler viewHandler) {
        initComponents();
        this.USER = user;
        this.VHANDLER = viewHandler;
        tableModel = new DefaultTableModel();
        this.jTable1.setModel(tableModel);
    }
    
    public void populate(){
        java.sql.ResultSet res = DatabaseManager.Query("SELECT * FROM employees");
        try{
            java.sql.ResultSetMetaData resMd = res.getMetaData();
            if(USER.getRoleID() != 1 || USER.getRoleID() != 4){
                for(int i = 0; i < resMd.getColumnCount(); i++){
                    tableModel.addColumn(resMd.getColumnLabel(i+1));                        
                }
            }else{
                for(int i = 0; i < resMd.getColumnCount(); i++){
                    if(!resMd.getColumnLabel(i + 1).equals("employee_password"))
                        tableModel.addColumn(resMd.getColumnLabel(i+1));
                }
            }
            while(res.next()){
                
                if(USER.getRoleID() != 1 || USER.getRoleID() != 4)
                    tableModel.addRow(new Object[]{res.getInt("employee_id"), res.getString("employee_forename"), res.getString("employee_surname"), res.getString("employee_email"), res.getString("employee_password"), res.getString("created_at"), res.getString("last_accessed")});
                else
                    tableModel.addRow(new Object[]{res.getInt("employee_id"), res.getString("employee_forename"), res.getString("employee_surname"), res.getString("employee_email"), res.getString("created_at"), res.getString("last_accessed")});
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
        btnDeleteEmployee = new javax.swing.JButton();
        btnUpdateEmployee = new javax.swing.JButton();
        btnInsertEmployee = new javax.swing.JButton();

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

        btnDeleteEmployee.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteEmployee.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteEmployee.setText("Delete Employee");
        btnDeleteEmployee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnDeleteEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEmployeeActionPerformed(evt);
            }
        });

        btnUpdateEmployee.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdateEmployee.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdateEmployee.setText("Edit Employee");
        btnUpdateEmployee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnUpdateEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateEmployeeActionPerformed(evt);
            }
        });

        btnInsertEmployee.setBackground(new java.awt.Color(204, 204, 204));
        btnInsertEmployee.setForeground(new java.awt.Color(102, 102, 102));
        btnInsertEmployee.setText("Insert Employee");
        btnInsertEmployee.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnInsertEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnUpdateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsertEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEmployeeActionPerformed
        if(jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            Integer id = (int) this.jTable1.getValueAt(r,0);
            
            System.out.println("Selected Employee: " + id);
            
            if(DatabaseManager.Delete("DELETE FROM employees WHERE employee_id = ?", id) == true){
                java.sql.ResultSet rows = DatabaseManager.Query("SELECT COUNT(*) FROM employees");
                try {
                    if(rows.next() && DatabaseManager.Execute("ALTER TABLE employees AUTO_INCREMENT = ?", new Object[]{rows.getInt(1)})){
                        FormHandler.openMessageBox(new MessageBox("Success!", "Employee successfully deleted!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                        EmployeesView e = new EmployeesView(USER, VHANDLER);
                        VHANDLER.changeView(e, (javax.swing.JPanel) this.getParent());
                        e.populate();
                    }
                } catch (SQLException ex) {
                    FormHandler.openMessageBox(new MessageBox("Error!", ex.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
                }
                DatabaseManager.Disconnect();
                new Log(Commands.getDateTime(), "Successfully deleted an employee", USER.getId()).send();
            }else{
                new Log(Commands.getDateTime(), "Failed to delete an employee", USER.getId()).send();
            }
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected an employee!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnDeleteEmployeeActionPerformed

    private void btnUpdateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateEmployeeActionPerformed
        if(jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            int id = (int) this.jTable1.getValueAt(r, 0);
            FormHandler.openPopup(new UpdateEmployee(USER, VHANDLER, (javax.swing.JPanel) this.getParent(), id));
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected an employee!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnUpdateEmployeeActionPerformed

    private void btnInsertEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertEmployeeActionPerformed
        FormHandler.openPopup(new InsertEmployee(USER, VHANDLER, (javax.swing.JPanel) this.getParent()));
    }//GEN-LAST:event_btnInsertEmployeeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteEmployee;
    private javax.swing.JButton btnInsertEmployee;
    private javax.swing.JButton btnUpdateEmployee;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
