/*
 */
package cmp_303_systems_development_software.views;

import cmp_303_systems_development_software.classes.Log;
import cmp_303_systems_development_software.classes.User;
import cmp_303_systems_development_software.forms.InsertTask;
import cmp_303_systems_development_software.forms.MessageBox;
import cmp_303_systems_development_software.forms.UpdateTask;
import cmp_303_systems_development_software.handlers.FormHandler;
import cmp_303_systems_development_software.handlers.ViewHandler;
import cmp_303_systems_development_software.utils.Commands;
import cmp_303_systems_development_software.utils.DatabaseManager;
import cmp_303_systems_development_software.utils.StyleSetting;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joe
 */
public class TasksView extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    private final ViewHandler VHANDLER;
    private final User USER;
    
    private int jobID;
    /**
     * Creates new view panel (Tasks View)
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     */
    public TasksView(User user, ViewHandler viewHandler) {
        this.VHANDLER = viewHandler;
        this.USER = user;
        initComponents();
        tableModel = new DefaultTableModel();
        this.jTable1.setModel(tableModel);
        
        java.awt.Color btnBg = btnDeleteTask.getBackground();
        javax.swing.border.Border btnBorder = btnDeleteTask.getBorder();
        
        java.util.List<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        
        buttons.add(btnDeleteTask);
        buttons.add(btnInsertTask);
        buttons.add(btnUpdateTask);
        
        StyleSetting.applyButtonStyles(buttons, btnBg, btnBorder);
        switch(USER.getRoleID()){
            case 3 -> {
                btnDeleteTask.setEnabled(false);
                btnInsertTask.setEnabled(false);
                btnUpdateTask.setEnabled(false);
            }
            case 4 -> {
                btnDeleteTask.setEnabled(false);
                btnInsertTask.setEnabled(false);
                btnUpdateTask.setEnabled(false);
            }
        }
    }
    
    public void populate(int job){
        this.jobID = job;
        java.sql.ResultSet res = DatabaseManager.Query("SELECT * FROM tasks WHERE job_id = ?", job);
        try{
            java.sql.ResultSetMetaData resMd = res.getMetaData();
            for(int i = 0; i < resMd.getColumnCount(); i++){
                tableModel.addColumn(resMd.getColumnLabel(i+1));
            }
            while(res.next()){
                java.sql.ResultSet e = DatabaseManager.Query("SELECT employee_forename, employee_surname FROM employees WHERE employee_id = ?", res.getInt("employee_id"));
                String employeeName = new String();
                if(e.next()){
                    employeeName = e.getString("employee_forename") + " " + e.getString("employee_surname");
                }
                Object[] row = new Object[]{res.getInt("task_id"), res.getString("task_description"), res.getString("task_status"), res.getInt("job_id"), res.getInt("employee_id") + " (" + employeeName + ")", res.getString("created_at")};
                tableModel.addRow(row);                        
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
        btnDeleteTask = new javax.swing.JButton();
        btnUpdateTask = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        btnInsertTask = new javax.swing.JButton();

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

        btnDeleteTask.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteTask.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteTask.setText("Delete Task");
        btnDeleteTask.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnDeleteTask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTaskActionPerformed(evt);
            }
        });

        btnUpdateTask.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdateTask.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdateTask.setText("Edit Task");
        btnUpdateTask.setActionCommand("Edit Task");
        btnUpdateTask.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnUpdateTask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTaskActionPerformed(evt);
            }
        });

        btnReturn.setBackground(new java.awt.Color(204, 204, 204));
        btnReturn.setForeground(new java.awt.Color(102, 102, 102));
        btnReturn.setText("Return");
        btnReturn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnInsertTask.setBackground(new java.awt.Color(204, 204, 204));
        btnInsertTask.setForeground(new java.awt.Color(102, 102, 102));
        btnInsertTask.setText("Insert Task");
        btnInsertTask.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnInsertTask.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertTaskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteTask, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsertTask, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteTask, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateTask, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertTask, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTaskActionPerformed
        // TODO add your handling code here:
        if(this.jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            int id = (int) this.jTable1.getValueAt(r, 0);
            if(DatabaseManager.Delete("DELETE FROM tasks WHERE task_id = ?", id)){
                java.sql.ResultSet rows = DatabaseManager.Query("SELECT COUNT(*) FROM tasks");
                try {
                    if(rows.next() && DatabaseManager.Execute("ALTER TABLE tasks AUTO_INCREMENT = ?", new Object[]{rows.getInt(1)})){
                        FormHandler.openMessageBox(new MessageBox("Success!", "Successfully deleted task!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                        TasksView t = new TasksView(USER,VHANDLER);
                        VHANDLER.changeView(t, (javax.swing.JPanel) this.getParent());
                        t.populate(this.jobID);
                    }
                } catch (SQLException ex) {
                    FormHandler.openMessageBox(new MessageBox("Error!", ex.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
                }
                DatabaseManager.Disconnect();
                new Log(Commands.getDateTime(), "Successfully deleted a task", USER.getId()).send();
            }else{
                new Log(Commands.getDateTime(), "Failed to delete a task", USER.getId()).send();
            }
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected a task!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnDeleteTaskActionPerformed

    private void btnUpdateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTaskActionPerformed
        // TODO add your handling code here:
        if(this.jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            int id = (int) this.jTable1.getValueAt(r, 0);
            FormHandler.openPopup(new UpdateTask(USER, VHANDLER, (javax.swing.JPanel) this.getParent(), id));
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected a task!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnUpdateTaskActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        JobsView j = new JobsView(USER,VHANDLER);
        VHANDLER.changeView(j, (javax.swing.JPanel) this.getParent());
        j.populate();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnInsertTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertTaskActionPerformed
        FormHandler.openPopup(new InsertTask(USER, VHANDLER, (javax.swing.JPanel) this.getParent(), jobID));
    }//GEN-LAST:event_btnInsertTaskActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteTask;
    private javax.swing.JButton btnInsertTask;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnUpdateTask;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
