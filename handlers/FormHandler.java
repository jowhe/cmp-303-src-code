/*
 */
package cmp_303_systems_development_software.handlers;

/**
 *
 * @author joe
 */
public class FormHandler {
    private static javax.swing.JFrame currentForm;
    private static javax.swing.JFrame lastForm;
    
    private static javax.swing.JFrame currentPopup;
    
    /**
     * Public constructor for the form handler.
     * 
     */
    public FormHandler(){
        super();
    }
    
    /**
    * Public method to set the current form.
    * @param form The form to set to.
     */    
    public static void setForm(javax.swing.JFrame form){
        currentForm = form;
    }
    
    /**
    * Public method to show the currentForm.
    * 
     */    
    public static void showForm(){
        if(currentForm != null){
            currentForm.setVisible(true);
        }
    }
    
    public static void changeForm(javax.swing.JFrame form){
        if(currentForm != null){
            lastForm = currentForm;
            currentForm.dispose();
            setForm(form);
            showForm();
        }
    }
    
    public static void returnForm(){
        if(lastForm != null){
            changeForm(lastForm);
            lastForm = null;
        }
    }
    
    public static void dispose(){
        if(currentForm != null){
            currentForm.dispose();
            lastForm = null;
        }
    }
    
    public static void openPopup(javax.swing.JFrame frame){
        if(currentPopup != null)
            currentPopup.dispose();
        
        currentPopup = frame;
        currentPopup.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        currentPopup.setVisible(true);
    }
    
    public static void openMessageBox(javax.swing.JFrame frame){
        frame.setVisible(true);
    }
    
}
