/*
 */
package cmp_303_systems_development_software.views;

import cmp_303_systems_development_software.classes.Log;
import cmp_303_systems_development_software.classes.User;
import cmp_303_systems_development_software.forms.InsertJob;
import cmp_303_systems_development_software.forms.MessageBox;
import cmp_303_systems_development_software.forms.UpdateJob;
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
public class JobsView extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    private final User USER;
    private final ViewHandler VHANDLER;
    /**
     * Creates new view panel (Jobs View)
     * @param user The user that is logged in.
     * @param viewHandler The view handler from the dashboard.
     */
    public JobsView(User user, ViewHandler viewHandler) {
        initComponents();
        this.USER = user;
        this.VHANDLER = viewHandler;
        tableModel = new DefaultTableModel();
        this.jTable1.setModel(tableModel);
        this.jTable1.setBorder(null);
        
        java.util.List<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        
        java.awt.Color btnBg = btnEditJob.getBackground();
        javax.swing.border.Border btnBorder = btnEditJob.getBorder();
        
        buttons.add(btnDeleteJob);
        buttons.add(btnEditJob);
        buttons.add(btnNewJob);
        buttons.add(btnViewTasks);
        
        StyleSetting.applyButtonStyles(buttons, btnBg, btnBorder);
        
        switch(USER.getRoleID()){
            case 3 -> {
                btnNewJob.setEnabled(false);
                btnDeleteJob.setEnabled(false);
            }
            case 4 -> {
                btnDeleteJob.setEnabled(false);
            }
        }
    }
    
    public void populate(){
        java.sql.ResultSet res = DatabaseManager.Query("SELECT * FROM jobs");
        try{
            java.sql.ResultSetMetaData resMd = res.getMetaData();
            for(int i = 0; i < resMd.getColumnCount(); i++){
                tableModel.addColumn(resMd.getColumnLabel(i+1));
                
            }
            while(res.next()){
                tableModel.addRow(new Object[]{res.getInt("job_id"), res.getString("job_description"), res.getString("job_notes"), res.getString("job_status"), res.getString("created_at"), res.getString("last_update"), res.getInt("customer_id")});
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
        btnEditJob = new javax.swing.JButton();
        btnViewTasks = new javax.swing.JButton();
        btnNewJob = new javax.swing.JButton();
        btnDeleteJob = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(876, 367));
        setMinimumSize(new java.awt.Dimension(876, 367));
        setName(""); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setBorder(null);

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnEditJob.setBackground(new java.awt.Color(204, 204, 204));
        btnEditJob.setForeground(new java.awt.Color(102, 102, 102));
        btnEditJob.setText("Edit Job");
        btnEditJob.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnEditJob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditJobActionPerformed(evt);
            }
        });

        btnViewTasks.setBackground(new java.awt.Color(204, 204, 204));
        btnViewTasks.setForeground(new java.awt.Color(102, 102, 102));
        btnViewTasks.setText("View Tasks");
        btnViewTasks.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnViewTasks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTasksActionPerformed(evt);
            }
        });

        btnNewJob.setBackground(new java.awt.Color(204, 204, 204));
        btnNewJob.setForeground(new java.awt.Color(102, 102, 102));
        btnNewJob.setText("Insert Job");
        btnNewJob.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnNewJob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNewJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewJobActionPerformed(evt);
            }
        });

        btnDeleteJob.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteJob.setForeground(new java.awt.Color(102, 102, 102));
        btnDeleteJob.setText("Delete Job");
        btnDeleteJob.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnDeleteJob.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJobActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnEditJob, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteJob, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewJob, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewJob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditJob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteJob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        btnEditJob.getAccessibleContext().setAccessibleName("Edit Job");
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditJobActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() != -1){
            int r = jTable1.getSelectedRow();
            int id = (int) jTable1.getValueAt(r, 0);
            FormHandler.openPopup(new UpdateJob(USER, VHANDLER, (javax.swing.JPanel) this.getParent(), id));
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected a job!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnEditJobActionPerformed

    private void btnViewTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTasksActionPerformed
        // TODO add your handling code here:
        if(this.jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            int id = (int) this.jTable1.getValueAt(r,0);
        
            TasksView tv = new TasksView(USER, VHANDLER);
            VHANDLER.changeView(tv, (javax.swing.JPanel) this.getParent());
            tv.populate(id);
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected a job!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnViewTasksActionPerformed

    private void btnNewJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewJobActionPerformed
        FormHandler.openPopup(new InsertJob(USER, VHANDLER, (javax.swing.JPanel) this.getParent()));
    }//GEN-LAST:event_btnNewJobActionPerformed

    private void btnDeleteJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJobActionPerformed
        if(this.jTable1.getSelectedRow() != -1){
            int r = this.jTable1.getSelectedRow();
            int id = (int) this.jTable1.getValueAt(r,0);
            if(DatabaseManager.Delete("DELETE FROM jobs WHERE job_id = ?", id)){
                java.sql.ResultSet rows = DatabaseManager.Query("SELECT COUNT(*) FROM jobs");
                try {
                    if(rows.next() && DatabaseManager.Execute("ALTER TABLE jobs AUTO_INCREMENT = ?", new Object[]{rows.getInt(1)})){
                        FormHandler.openMessageBox(new MessageBox("Success!", "Successfully deleted job!", javax.swing.JOptionPane.INFORMATION_MESSAGE));
                        JobsView j = new JobsView(USER,VHANDLER);
                        VHANDLER.changeView(j, (javax.swing.JPanel) this.getParent());
                        j.populate();
                    }
                } catch (SQLException ex) {
                    FormHandler.openMessageBox(new MessageBox("Error!", ex.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
                }
                DatabaseManager.Disconnect();
                new Log(Commands.getDateTime(), "Successfully deleted a job", USER.getId()).send();
            }else{
                new Log(Commands.getDateTime(), "Failed to delete a job", USER.getId()).send();
            }
        }else{
            FormHandler.openMessageBox(new MessageBox("Warning!", "You have not selected a job!", javax.swing.JOptionPane.WARNING_MESSAGE));
        }
    }//GEN-LAST:event_btnDeleteJobActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteJob;
    private javax.swing.JButton btnEditJob;
    private javax.swing.JButton btnNewJob;
    private javax.swing.JButton btnViewTasks;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
