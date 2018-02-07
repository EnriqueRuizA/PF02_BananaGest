package com.generation.jwd.p1.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateProjectController {

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	
	public String addProject() {
		
		System.out.println("project get");
		return null;
	}
	
}
