/*
 */
package cmp_303_systems_development_software.classes;
import cmp_303_systems_development_software.forms.MessageBox;
import cmp_303_systems_development_software.handlers.FormHandler;
import cmp_303_systems_development_software.utils.DatabaseManager;

/**
 *
 * @author joe
 */
public class User {
    private final Integer id;
    private final String name;
    private String role;
    private int roleID;
    
    public User(String name, Integer id){
        this.name = name;
        this.id = id;
        
        setRole();
    }
    
    public String getName() {
        return name;
    }
    
    public int getRoleID(){
        return this.roleID;
    }

    private void setRoleID() {
        java.sql.ResultSet res = DatabaseManager.Query("SELECT role_id FROM roles WHERE role_name = ?", new String[]{this.role});
        
        try{            
            if(res.next()){
                this.roleID = res.getInt("role_id");
            }
        }catch(java.sql.SQLException e){
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        DatabaseManager.Disconnect();
    }
    
    public int getId(){
        return this.id;
    }
    
    private void setRole(){
        java.sql.ResultSet res = DatabaseManager.Query("SELECT role_id FROM employee_roles WHERE employee_id = ?", this.id);
        
        try{
            if(res.next()){
                java.sql.ResultSet roleName = DatabaseManager.Query("SELECT role_name FROM roles WHERE role_id = ?", res.getInt("role_id"));
                if(roleName.next()){
                    this.role = roleName.getString("role_name");
                }
            }
        }catch(java.sql.SQLException e){
            System.out.println("User -> Set Role");
            FormHandler.openMessageBox(new MessageBox("Error!", e.getMessage(), javax.swing.JOptionPane.ERROR_MESSAGE));
        }
        
        setRoleID();
    }
    
    public String getRole(){
        return this.role;
    }

}
