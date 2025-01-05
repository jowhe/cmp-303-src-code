/*
 */
package cmp_303_systems_development_software.utils;

import cmp_303_systems_development_software.forms.MessageBox;
import cmp_303_systems_development_software.handlers.FormHandler;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author joe
 */
public class DatabaseManager {
    
    private static final String URL = Variables.URL();
    private static final String USER = Variables.USER();
    private static final String PASS = Variables.PASS();
    
    public static Connection activeConnection;
        
    /**
     * Disconnect from the database.
     */
    public static final void Disconnect(){
        System.out.println("Disconnecting from DB!");
        try{
            if(activeConnection != null){
                activeConnection.close();
                activeConnection = null;
            }
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
    }
    
    /**
     * Get the active connection.
     * @return The active connection.
     */
    public static final Connection getConnection(){
        return activeConnection;
    }
    
    /**
     * Execute method with string options.
     * @param sql The SQL string to execute.
     * @param opts The options to pair with each ? in the SQL string.
     * @return The results.
     */
    public static boolean Execute(String sql, Object[] opts){
        System.out.println("Execute: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement ps = activeConnection.prepareStatement(sql);
            for(int i = 0; i < opts.length; i++){
                if(opts[i] instanceof java.lang.String string)
                    ps.setString(i+1, string);
                if(opts[i] instanceof java.lang.Integer in)
                    ps.setInt(i+1, in);
            }
            boolean rs = ps.execute();
            
            if(!rs)
                return true;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        return false;
    }
    
    /**
     * Simple query method.
     * @param sql The SQL string to query.
     * @return The results.
     */
    public static ResultSet Query(String sql){
        System.out.println("Query: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement ps = activeConnection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
            return null;
        }
    }
    
    /**
     * Query method with string options.
     * @param sql The SQL string to query.
     * @param opts The options to pair with each ? in the SQL string.
     * @return The results.
     */
    public static ResultSet Query(String sql, Object[] opts){
        System.out.println("Query: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement ps = activeConnection.prepareStatement(sql);
            for(int i = 0; i < opts.length; i++){
                if(opts[i] instanceof java.lang.String string)
                    ps.setString(i+1, string);
                if(opts[i] instanceof java.lang.Integer in)
                    ps.setInt(i+1, in);
            }
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
            return null;
        }
    }
    
    /**
     * Query method with integer options.
     * @param sql The SQL string to query.
     * @param opts The options to pair with each ? in the SQL string.
     * @return The results.
     */
    public static ResultSet Query(String sql, Integer[] opts){
        System.out.println("Query: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement ps = activeConnection.prepareStatement(sql);
            for(int i = 0; i<opts.length;i++){
                ps.setInt(i+1, opts[i]);
            }
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
            return null;
        }
    }
    
    /**
     * Query method with an integer option.
     * @param sql The SQL string to query.
     * @param opt The option to pair with each ? in the SQL string.
     * @return The results.
     */
    public static ResultSet Query(String sql, Integer opt){
        System.out.println("Query: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement ps = activeConnection.prepareStatement(sql);
            ps.setInt(1, opt);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
            return null;
        }
    }
    
    /**
     * Simple update method.
     * @param sql The update query.
     * @return Whether the update is successful or not.
     */ 
    public static boolean Update(String sql){
        System.out.println("Update: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
            
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            int res = query.executeUpdate();
            
            if(res == 1)
                return true;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        return false;
    }
    
    /**
    * Update method with string options.
    * @param sql The update query.
    * @param opts The option to pair with each ? in the SQL string.
    * @return Whether the update is successful or not.
    */ 
    public static boolean Update(String sql, Object[] opts){
        System.out.println("Update: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
            
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            for(int i = 0; i < opts.length; i++){
                if(opts[i] instanceof java.lang.String string)
                    query.setString(i+1, string);
                if(opts[i] instanceof java.lang.Integer in)
                    query.setInt(i+1, in);
            }
            
            int res = query.executeUpdate();
            
            if(res == 1)
                return true;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        return false;
    }
    
    /**
    * Update method with string options.
    * @param sql The update query.
    * @param opts The option to pair with each ? in the SQL string.
    * @return Whether the update is successful or not.
    */ 
    public static boolean Insert(String sql, Object[] opts){
        System.out.println("Insert: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
            
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            for(int i = 0; i < opts.length; i++){
                if(opts[i] instanceof java.lang.String string)
                    query.setString(i+1, string);
                if(opts[i] instanceof java.lang.Integer in)
                    query.setInt(i+1, in);
            }
            
            boolean res = query.execute();
            
            if(!res)
                return true;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        return false;
    }
    
    public static boolean Delete(String sql){
        System.out.println("Delete: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            return query.execute(sql);
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        return false;
    }
    
    public static boolean Delete(String sql, Integer opts){
        System.out.println("Delete: " + sql);
        if(getConnection() == null)
            activeConnection = initCon();
        
        try{
            PreparedStatement query = activeConnection.prepareStatement(sql);
            query.setInt(1, opts);
            
            boolean res = query.execute();
            
            if(!res)
                return true;
        }catch(SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
            return false;
        }
        
        return false;
    }
    
    /**
     * Method to initialize a connection to the database.
     * @return The connection.
     */
    private static Connection initCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        }catch(ClassNotFoundException | SQLException e){
            //JOptionPane.showConfirmDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
            return null;
        }
    }
}
