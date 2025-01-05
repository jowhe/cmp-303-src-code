/*
 */
package cmp_303_systems_development_software.utils;

/**
 *
 * @author joe
 */
public class StyleSetting {    
    public static void applyButtonStyles(java.util.List<javax.swing.JButton> components, java.awt.Color bg, javax.swing.border.Border bd){
        for(javax.swing.JButton b: components){
            b.getModel().addChangeListener(e -> {
                final javax.swing.ButtonModel model = (javax.swing.ButtonModel) e.getSource();

                if(model.isRollover()){
                    b.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 102, 102)));
                    b.setBackground(new java.awt.Color(214, 214, 214));
                }else{
                    b.setBackground(bg);
                    b.setBorder(bd);
                }
            }); 
        }
    }
}
