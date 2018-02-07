package com.generation.jwd.p1.beans;
import java.io.Serializable;
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int id_user;
    private String name_user;
    private String surname_user;
    private String email_user;
    private String password_user;
    
    public User() {
    }
    
    public User(int id_user, String name_user, String surname_user, String email_user, String password_user){
        this.id_user = id_user;
        this.name_user = name_user;
        this.surname_user = surname_user;
        this.email_user = email_user;
        this.password_user = password_user;
    }
    
	public int getId_user() {
		return id_user;
	}
	
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	public String getName_user() {
		return name_user;
	}
	
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	
	public String getSurname_user() {
		return surname_user;
	}
	
	public void setSurname_user(String surname_user) {
		this.surname_user = surname_user;
	}
	
	public String getEmail_user() {
		return email_user;
	}
	
	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}
	
	public String getPassword_user() {
		return password_user;
	}
	
	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}

}

