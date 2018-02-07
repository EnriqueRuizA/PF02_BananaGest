package com.generation.jwd.p1.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inicio get");
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();  
        System.out.println("Inicio sesion");
        session.invalidate();  
        System.out.println("cerramos la sesion");
        request.setAttribute("disconnect", "Has cerrado la sesion con exito");
		System.out.println("Logout successful");
		return "login";
	}
	
}