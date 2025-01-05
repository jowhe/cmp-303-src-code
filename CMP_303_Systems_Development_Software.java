/*
 */
package cmp_303_systems_development_software;

import cmp_303_systems_development_software.forms.LoginForm;
import cmp_303_systems_development_software.handlers.FormHandler;


/**
 *
 * @author joe
 */
public class CMP_303_Systems_Development_Software {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        // TODO code application logic here
        FormHandler.setForm(new LoginForm());
        FormHandler.showForm();
        
    }
    
}
