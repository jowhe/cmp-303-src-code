/*
 */
package cmp_303_systems_development_software.classes;

import cmp_303_systems_development_software.utils.DatabaseManager;

/**
 *
 * @author joe
 */
public class Log{
    String timestamp;
    String description;
    int employee;
    
    public Log(String time, String desc, int emp){
        timestamp = time;
        description = desc;
        employee = emp;
    }
        
    public int getEmployee(){
        return employee;
    }
    
    public String getTimestamp(){
        return timestamp;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void send(){
        DatabaseManager.Insert("INSERT INTO `logs`(`log_timestamp`, `log_description`, `employee_id`) VALUES (?, ?, ?)", new Object[]{this.timestamp, this.description, this.employee});
        DatabaseManager.Disconnect();
    }
}
