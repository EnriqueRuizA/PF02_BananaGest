package com.generation.jwd.p1.controllers;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginController {	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		System.out.println("Entra en login");
		return "login";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String submit(HttpServletRequest request, HttpServletResponse response,
	        @RequestParam(value="email") String email, 
	        @RequestParam(value="password") String password) throws SQLException, ServletException, IOException{
		
		System.out.println("Inicio");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
//_______________________________________________________________________________
		
		String hql = "FROM User WHERE email = :user_email AND password = :user_password";
		Query query = session.createQuery(hql);
		query.setParameter("user_email", email);
		query.setParameter("user_password", password);
		t.commit();
		
		ResultSet rs = null;
		int id_user = 0;
		
		if (rs.next()) {				
			
			id_user = rs.getInt("id");					
		}
		
		session.close();
		
		if (id_user != 0) {		
			
			((ServletRequest) session).setAttribute("id_user",id_user);		
			request.getRequestDispatcher("/homeuser").forward(request, response);
			
		} else {
			
			request.setAttribute("error", "Usuario y/o contraseña son incorrectos. Por favor, vuelva a introducir los datos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		
		}				
		
		System.out.println("Fin");
		
		return "hello";
	}
}

