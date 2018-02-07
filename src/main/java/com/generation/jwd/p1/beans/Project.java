package com.generation.jwd.p1.beans;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name ="name")
    private String name;
    
    @Column(name ="desc")
    private String desc;
    
    @Column(name = "dateBegin")
    private String dateBegin;
    
    @Column(name = "dateEnd")
    private String dateEnd;
    
    @Column(name = "notes")
    private String notes;
    
    @Column(name = "status")
    private String status;
    
    public Project() {
    	
    }

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
    
}
