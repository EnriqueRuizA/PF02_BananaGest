package com.generation.jwd.p1.beans;

import java.io.Serializable;

public class LoginBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	private String user;
	private String password;
	
	public LoginBean() {	
	}
	
	UserBean Mario = new UserBean(
			"muvalera",
			"12345"
			);
	
	UserBean Claudia = new UserBean(
			"claudiamas",
			"56789"
			);
	
	UserBean Daniel = new UserBean(
			"danilozano",
			"01010"
			);
	
	UserBean Borja = new UserBean(
			"borjaherranz",
			"11111"
			);
	
	UserBean Enrique = new UserBean(
			"enriqueruiz",
			"99999"
			);
	
	UserBean[] users = {Mario, Claudia, Daniel, Borja, Enrique};
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validator() {
		
		boolean bool = false;
		
		for (UserBean usuario : users) {
			if (user.equals(usuario.getEmail()) && password.equals(usuario.getPassword())){
				bool = true;		
			} 
		}		
		return bool;
	}			
}
	
		



