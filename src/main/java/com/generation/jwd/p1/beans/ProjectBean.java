package com.generation.jwd.p1.beans;
import java.io.Serializable;
public class ProjectBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int id_project;
    private String name_project;
    private String desc_project;
    private String dateBegin_project;
    private String dateEnd_project;
    private String notes_project;
    private String status_project;
    
    public ProjectBean() {
    }
    public ProjectBean(int id_project, String name_project, String desc_project, String dateBegin_project, String dateEnd_project, String notes_project, String status_project){
        this.setId_project(id_project);
        this.setName_project(name_project);
        this.setDesc_project(desc_project);
        this.setDateBegin_project(dateBegin_project);
        this.setDateEnd_project(dateEnd_project);
        this.setNotes_project(notes_project);
        this.setStatus_project(status_project);
    }
	public int getId_project() {
		return id_project;
	}
	public void setId_project(int id_project) {
		this.id_project = id_project;
	}
	public String getName_project() {
		return name_project;
	}
	public void setName_project(String name_project) {
		this.name_project = name_project;
	}
	public String getDesc_project() {
		return desc_project;
	}
	public void setDesc_project(String desc_project) {
		this.desc_project = desc_project;
	}
	public String getDateBegin_project() {
		return dateBegin_project;
	}
	public void setDateBegin_project(String dateBegin_project) {
		this.dateBegin_project = dateBegin_project;
	}
	public String getDateEnd_project() {
		return dateEnd_project;
	}
	public void setDateEnd_project(String dateEnd_project) {
		this.dateEnd_project = dateEnd_project;
	}
	public String getNotes_project() {
		return notes_project;
	}
	public void setNotes_project(String notes_project) {
		this.notes_project = notes_project;
	}
	public String getStatus_project() {
		return status_project;
	}
	public void setStatus_project(String status_project) {
		this.status_project = status_project;
	}
}
