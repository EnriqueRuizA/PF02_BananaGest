package com.generation.jwd.p1.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.generation.jwd.p1.beans.Task;


@Controller
@RequestMapping ("/showform")
public class CreateTaskController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String printTask() {
		
				return "createtask";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam( value ="name_task") String name,
			@RequestParam( value ="desc_task") String desc,
			@RequestParam( value ="notes_task") String notes,
			@RequestParam( value ="dateBegin_task") String dateBegin,
			@RequestParam( value ="dateEnd_task") String dateEnd,
			@RequestParam( value ="name_user") int name_user,
			@RequestParam( value ="name_project") int name_project,
			@RequestParam( value ="status_task") String status) throws SecurityException, HeuristicMixedException, HeuristicRollbackException, RollbackException, SystemException {
		
		System.out.println("######## POST #########");
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = (Transaction) session.beginTransaction();
		
//        Map <Integer, String> users = new HashMap <Integer, String>();
//		Map <Integer, String> projects = new HashMap <Integer, String>();

        Task createtask = new Task();
        createtask.setName(name);
        createtask.setDesc(desc);
        createtask.setNotes(notes);
        createtask.setDateBegin(dateBegin);
        createtask.setDateEnd(dateEnd);
        createtask.setId_user(name_user);
        createtask.setId_project(name_project);
        createtask.setStatus(status);
		
        
        System.out.println("######## AFTER CREATETASK #########");
//        request.setAttribute("userList", users.values());
//        request.setAttribute("projectList", projects.values());
        
		session.persist(createtask);
		t.commit();
		session.close();
		
		return "homeuser";
			
	}
	
}
