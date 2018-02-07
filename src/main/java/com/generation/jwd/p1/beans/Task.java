package com.generation.jwd.p1.beans;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Task implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "desc")
    private String desc;
    
    @Column(name = "dateBegin")
    private String dateBegin;
    
    @Column(name = "dateEnd")
    private String dateEnd;
    
    @Column(name = "idResponsible")
    private int idResponsible;
    
    @Column(name = "notes")
    private String notes;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "id_project")
    private int id_project;
    
    @Column(name = "id_user")
    private int id_user;
    
    public Task() {};
  
    

    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	public int getIdResponsible() {
		return idResponsible;
	}

	public void setIdResponsible(int idResponsible) {
		this.idResponsible = idResponsible;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public boolean validate() {
        
        boolean bool = false;
        if("formtask" != null) {
            bool = true;
            
        }
        return bool;
    }

}  