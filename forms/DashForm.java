/*
 */
package cmp_303_systems_development_software.forms;

import cmp_303_systems_development_software.classes.Log;
import cmp_303_systems_development_software.classes.User;
import cmp_303_systems_development_software.handlers.FormHandler;
import cmp_303_systems_development_software.handlers.ViewHandler;
import cmp_303_systems_development_software.utils.Commands;
import cmp_303_systems_development_software.utils.DatabaseManager;
import cmp_303_systems_development_software.utils.StyleSetting;
import cmp_303_systems_development_software.views.CustomerView;
import cmp_303_systems_development_software.views.EmployeesView;
import cmp_303_systems_development_software.views.JobsView;

/**
 *
 * @author joe
 */
public class DashForm extends javax.swing.JFrame {
    
    private final User user;
    private static final ViewHandler viewHandler = new ViewHandler();
    
    /**
     * Creates new form DashForm
     * @param user The user that is accessing the dashboard.
     */
    public DashForm(User user) {        
        initComponents();
        this.user = user;
        
        new Log(Commands.getDateTime(), "Logged in. ", user.getId()).send();
        
        this.setIconImage(new javax.swing.ImageIcon("src/cmp_303_systems_development_software/assets/logo.png").getImage());
        this.setTitle("Dashboard");
        this.setLocation(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width / 2 - (this.getWidth() / 2), java.awt.Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (this.getHeight() / 2));
        
        loadMotivationalQuote(this.lblMotivationalQuote);
        
        java.awt.Color btnBg = btnLogout.getBackground();
        javax.swing.border.Border btnBorder = btnLogout.getBorder();
        
        if(user.getRoleID() != 1)
            btnEmployeeView.setEnabled(false);
        
        java.util.List<javax.swing.JButton> buttons = new java.util.ArrayList<>();
        
        buttons.add(btnLogout);
        buttons.add(btnJobsView);
        buttons.add(btnEmployeeView);
        buttons.add(btnViewCustomers);
        
        StyleSetting.applyButtonStyles(buttons, btnBg, btnBorder);
        
        lblLoggedIn.setText("Logged in as: " + user.getName() + " [" + user.getRole() + "]");
    }
    
    private static void loadMotivationalQuote(javax.swing.JLabel label){
        java.time.LocalDate t = java.time.LocalDate.now();
        java.time.DayOfWeek d = t.getDayOfWeek();
        java.sql.ResultSet res = DatabaseManager.Query("SELECT quote_text FROM mv_quotes WHERE quote_id = ?", d.getValue());
        try{
            while(res.next()){
                label.setText("<html><body style=\"text-align: justify; text-justify: inter-word;\">"+ res.getString("quote_text") +"</body></html>");
            }
        }catch(java.sql.SQLException e){
            System.out.println("Dash Form -> Load Motivational Quote");
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        DatabaseManager.Disconnect();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        lblMotivationalQuote = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        dashViewPanel = new javax.swing.JPanel();
        btnJobsView = new javax.swing.JButton();
        btnEmployeeView = new javax.swing.JButton();
        btnViewCustomers = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblLoggedIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 360));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 102, 102));
        jPanel1.setMaximumSize(new java.awt.Dimension(606, 48));
        jPanel1.setMinimumSize(new java.awt.Dimension(508, 54));
        jPanel1.setPreferredSize(new java.awt.Dimension(508, 54));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() & ~java.awt.Font.BOLD, 26));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Red Star Auto Mechanics - Dashboard");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setInheritsPopupMenu(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cmp_303_systems_development_software/assets/logo.png"))); // NOI18N

        btnLogout.setBackground(new java.awt.Color(204, 204, 204));
        btnLogout.setForeground(new java.awt.Color(102, 102, 102));
        btnLogout.setText("Logout");
        btnLogout.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblMotivationalQuote.setForeground(new java.awt.Color(153, 153, 153));
        lblMotivationalQuote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMotivationalQuote.setText("\"Some men want to watch the world burn.\"");
        lblMotivationalQuote.setToolTipText("Daily Motivation");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblMotivationalQuote, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMotivationalQuote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        jPanel4.setMaximumSize(new java.awt.Dimension(606, 346));
        jPanel4.setMinimumSize(new java.awt.Dimension(606, 346));
        jPanel4.setPreferredSize(new java.awt.Dimension(508, 475));

        dashViewPanel.setBackground(new java.awt.Color(204, 204, 204));
        dashViewPanel.setMaximumSize(new java.awt.Dimension(876, 367));
        dashViewPanel.setMinimumSize(new java.awt.Dimension(876, 367));
        dashViewPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dashViewPanelComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                dashViewPanelComponentRemoved(evt);
            }
        });
        dashViewPanel.setLayout(new java.awt.CardLayout());

        btnJobsView.setBackground(new java.awt.Color(204, 204, 204));
        btnJobsView.setForeground(new java.awt.Color(102, 102, 102));
        btnJobsView.setText("View Jobs");
        btnJobsView.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnJobsView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJobsView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJobsViewActionPerformed(evt);
            }
        });

        btnEmployeeView.setBackground(new java.awt.Color(204, 204, 204));
        btnEmployeeView.setForeground(new java.awt.Color(102, 102, 102));
        btnEmployeeView.setText("View Employees");
        btnEmployeeView.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnEmployeeView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeViewActionPerformed(evt);
            }
        });

        btnViewCustomers.setBackground(new java.awt.Color(204, 204, 204));
        btnViewCustomers.setForeground(new java.awt.Color(102, 102, 102));
        btnViewCustomers.setText("View Customers");
        btnViewCustomers.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        btnViewCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCustomersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnJobsView, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(dashViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJobsView, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployeeView, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(508, 16));

        lblLoggedIn.setForeground(new java.awt.Color(102, 102, 102));
        lblLoggedIn.setText("Logged in as:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblLoggedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblLoggedIn)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashViewPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dashViewPanelComponentAdded
        // TODO add your handling code here:
        System.out.println("Component Added.");
    }//GEN-LAST:event_dashViewPanelComponentAdded

    private void dashViewPanelComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dashViewPanelComponentRemoved
        // TODO add your handling code here:
        System.out.println("Component Removed.");
    }//GEN-LAST:event_dashViewPanelComponentRemoved

    private void btnJobsViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJobsViewActionPerformed
        // TODO add your handling code here:
        JobsView jobsView = new JobsView(user, viewHandler);
        viewHandler.changeView(jobsView, dashViewPanel);
        jobsView.populate();
    }//GEN-LAST:event_btnJobsViewActionPerformed

    private void btnEmployeeViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeViewActionPerformed
        // TODO add your handling code here:
        EmployeesView employeeView = new EmployeesView(user, viewHandler);
        viewHandler.changeView(employeeView, dashViewPanel);
        employeeView.populate();
    }//GEN-LAST:event_btnEmployeeViewActionPerformed

    private void btnViewCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCustomersActionPerformed
        CustomerView customerView = new CustomerView(user, viewHandler);
        viewHandler.changeView(customerView, dashViewPanel);
        customerView.populate();
    }//GEN-LAST:event_btnViewCustomersActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        new Log(Commands.getDateTime(), "Logged out. ", user.getId()).send();
        FormHandler.changeForm(new LoginForm());
        viewHandler.dispose();  
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmployeeView;
    private javax.swing.JButton btnJobsView;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnViewCustomers;
    private javax.swing.JPanel dashViewPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblLoggedIn;
    private javax.swing.JLabel lblMotivationalQuote;
    // End of variables declaration//GEN-END:variables
}
