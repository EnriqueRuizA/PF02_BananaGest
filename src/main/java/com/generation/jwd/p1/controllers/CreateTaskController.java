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
import org.springframework.web.bind.annotation.ResponseBody;

import com.generation.jwd.p1.beans.Task;


@Controller
@RequestMapping ("/showform")
public class CreateTaskController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String printTask() {
		
		return "createtask";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String submit(HttpServletRequest request){
		
		System.out.println("######## POST #########");
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
		

        Task createtask = new Task();
        createtask.setName(request.getParameter("name"));
        createtask.setDesc(request.getParameter("desc"));
        createtask.setNotes(request.getParameter("notes"));
        createtask.setDateBegin(request.getParameter("dateBegin"));
        createtask.setDateEnd(request.getParameter("dateEnd"));
        createtask.setId_user(Integer.parseInt(request.getParameter("id_user")));
        createtask.setId_project(Integer.parseInt(request.getParameter("id_project")));
        createtask.setStatus(request.getParameter("status"));
		
        
        System.out.println("######## AFTER CREATETASK #########");

		session.persist(createtask);
		session.getTransaction().commit();
		session.close();
		
		return "homeuser";
			
	}
	
}