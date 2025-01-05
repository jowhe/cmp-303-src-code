/*
 */
package cmp_303_systems_development_software.handlers;

import cmp_303_systems_development_software.forms.MessageBox;
import cmp_303_systems_development_software.utils.DatabaseManager;

/**
 *
 * @author joe
 */
public class LoginHandler{    
    public LoginHandler(){
        super();
    }
    
    public static boolean matchLogin(String user, char[] pass){
        
        java.sql.ResultSet res = DatabaseManager.Query("SELECT employee_email, employee_password FROM employees WHERE employee_email = ? AND employee_password = ?", new String[]{user, new String(pass)});
        
        System.out.println("Checking: " + user + " " + new String(pass));
        
        try{
            while(res.next()){
                if(res.getString("employee_email").equals(user) && res.getString("employee_password").equals(new String(pass))){
                    System.out.println("Credentials Correct!");
                    DatabaseManager.Disconnect();
                    return true;
                }else{
                    DatabaseManager.Disconnect();
                    return false;
                }
            }
        }catch(java.sql.SQLException e) {
            System.out.println("Login Handler -> Login Match Method");
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        return false;
    }
        
    public static boolean formValid(){
        return false;
    }
}
