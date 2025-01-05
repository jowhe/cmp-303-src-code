package cmp_303_systems_development_software.utils;

/**
 *
 * @author joe
 */
public class Commands {    
    public static String getDateTime(){
        java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date d = new java.util.Date();
        return f.format(d);
    }
    
}
