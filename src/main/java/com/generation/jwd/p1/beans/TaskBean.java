package com.generation.jwd.p1.beans;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class TaskBean implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    
    private int id_task;
    private String name_task;
    private String desc_task;
    private String dateBegin_task;
    private String dateEnd_task;
    private int idResponsible_task;
    private String notes_task;
    private String status_task;
    private int id_project;
    private int id_user;
    
    public TaskBean() {};
    
    public TaskBean(int id_task, String name_task, String desc_task, String dateBegin_task, 
            String dateEnd_task, int idResponsible_task, String notes_task,
                    String status_task, int id_project, int id_user) {
        
        this.id_task = id_task;
        this.name_task = name_task;
        this.desc_task = desc_task;
        this.dateBegin_task = dateBegin_task;
        this.dateEnd_task = dateEnd_task;
        this.idResponsible_task = idResponsible_task;
        this.notes_task = notes_task;
        this.status_task = status_task;
        this.id_project = id_project;
        this.id_user = id_user;
    }
    public int getId_task() {
        return id_task;
    }
    public void setId_task(int id_task) {
        this.id_task = id_task;
    }
    public String getName_task() {
        return name_task;
    }
    public void setName_task(String name_task) {
        this.name_task = name_task;
    }
    public String getDesc_task() {
        return desc_task;
    }
    public void setDesc_task(String desc_task) {
        this.desc_task = desc_task;
    }
    public String getDateBegin_task() {
        return dateBegin_task;
    }
    public void setDateBegin_task(String dateBegin_task) {
        this.dateBegin_task = dateBegin_task;
    }
    public String getDateEnd_task() {
        return dateEnd_task;
    }
    public void setDateEnd_task(String dateEnd_task) {
        this.dateEnd_task = dateEnd_task;
    }
    public int getIdResponsible_task() {
        return idResponsible_task;
    }
    public void setIdResponsible_task(int idResponsible_task) {
        this.idResponsible_task = idResponsible_task;
    }
    public String getNotes_task() {
        return notes_task;
    }
    public void setNotes_task(String notes_task) {
        this.notes_task = notes_task;
    }
    public String getStatus_task() {
        return status_task;
    }
    public void setStatus_task(String status_task) {
        this.status_task = status_task;
    }
    
    public int getId_project() {
        return id_project;
    }
    public void setId_project(int id_project) {
        this.id_project = id_project;
    }
    
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    
//    public boolean validate() {
//        
//        boolean bool = false;
//        if("formtask" != null) {
//            bool = true;
//            
//        }
//        return bool;
//    }
//    
//    public Timestamp convertStringToTimestamp(String str_date) throws ParseException {
//        
//          DateFormat formatter;
//          formatter = new SimpleDateFormat("yyyy/MM/dd");
//          Date date = (Date) formatter.parse(str_date);
//          java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
//          return timeStampDate;
//        
//    }
}  