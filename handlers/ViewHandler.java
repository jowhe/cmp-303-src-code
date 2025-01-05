/*
 */
package cmp_303_systems_development_software.handlers;

/**
 *
 * @author joe
 */
public class ViewHandler {
    
    private javax.swing.JPanel currentView;
    private javax.swing.JPanel parentPanel;
        
    public void changeView(javax.swing.JPanel view, javax.swing.JPanel parent){
        currentView = view;
        
        if(parentPanel != null)
            parentPanel.removeAll();
        else
            parentPanel = parent;
        
        parentPanel.add(currentView);
        parentPanel.revalidate();
        parentPanel.repaint();
    }
    
    public void refresh(){
        
    }
    
    public void dispose(){
        currentView = null;
        parentPanel = null;
    }
    
}
