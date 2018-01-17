package com.generation.jwd.p1.beans;

import java.io.Serializable;

public class TaskBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name_task;
	private String desc_task;
	private String dateBegin_task;
	private String dateEnd_task;
	private String notes_task;
	private String resp_task;
	private String status_task;
	
	public TaskBean() {};
	
	public TaskBean(String name_task, String desc_task, String dateBegin_task, 
					String dateEnd_task, String notes_task, String resp_task, 
					String urlFile, String status_task) {
		
		this.name_task = getNameTask();
		this.desc_task = getDescription();
		this.dateBegin_task = getdateStart();
		this.dateEnd_task = getdateFinish();
		this.notes_task = getNotes();
		this.resp_task = getResponsable();
		this.status_task = getStatus();
	}
	
	public String getNameTask() {
		return name_task;
	}

	public void setNameTask(String nameTask) {
		this.name_task = nameTask;
	}

	public String getDescription() {
		return desc_task;
	}

	public void setDescription(String description) {
		this.desc_task = description;
	}

	public String getdateStart() {
		return dateBegin_task;
	}

	public void setdateStart(String dateStart) {
		this.dateBegin_task = dateStart;
	}

	public String getdateFinish() {
		return dateEnd_task;
	}

	public void setdateFinish(String dateFinish) {
		this.dateEnd_task = dateFinish;
	}

	public String getNotes() {
		return notes_task;
	}

	public void setNotes(String notes) {
		this.notes_task = notes;
	}

	public String getResponsable() {
		return resp_task;
	}

	public void setResponsable(String responsable) {
		this.resp_task = responsable;
	}

	
	public void setStatus(String status) {
		this.status_task = status;
	}
	
	public String getStatus() {
		return status_task;
	}
	public boolean validate () {
		return this.status_task.equals("Task");
	}
}

