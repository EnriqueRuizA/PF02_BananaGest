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
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.jwd.p1.beans.Project;

@Controller
public class CreateProjectController {

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	
	public String addProject() {
		
		System.out.println("project get");
		return "createproject";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitProject(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("name") String name,
			@RequestParam("desc") String desc,
			@RequestParam("notes") String notes,
			@RequestParam("dateBegin") String dateBegin,
			@RequestParam("dateEnd") String dateEnd,
			@RequestParam("status") String status){
		
		System.out.println("catched data");
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = (Transaction) session.beginTransaction();
        
        Project createproject = new Project();
        createproject.setName(name);
        createproject.setDesc(desc);
        createproject.setNotes(notes);
        createproject.setDateBegin(dateBegin);
        createproject.setDateEnd(dateEnd);
        createproject.setStatus(status);
        
        System.out.println("after setting");
        
		session.persist(createproject);
		session.getTransaction().commit();
		session.close();
		
				return "homeuser";
	
	}
}
