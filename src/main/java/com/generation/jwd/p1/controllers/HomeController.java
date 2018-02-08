package com.generation.jwd.p1.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.generation.jwd.p1.beans.Task;

@Controller
public class HomeController {

	
	@RequestMapping(value = "/homeuser", method = RequestMethod.GET)
	
	public Task showTasks() {
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        Connection connection = null;
		Context initContext = null;
		ResultSet rs = null;
		Context envContext = null;
		DataSource datasource = null;
		ArrayList<Task> taskList = new ArrayList<Task>();

		
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = (Transaction) session.beginTransaction();
		
//		int user_id = (Integer)session.getAttribute("id_user");
        
        	String que = "FROM Task T WHERE id_user = id_user";
        	Query query = session.createQuery(que);
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			datasource = (DataSource)envContext.lookup("jdbc/bananagest");
			connection = (Connection) datasource.getConnection();
		
			stmt.setInt(1,user_id );
			rs = stmt.executeQuery();		
			 			
			Task myTask = new Task();
			while(rs.next()) {
				myTask = new Task();
				myTask.setId(rs.getInt(1));
				myTask.setName(rs.getString(2));
				myTask.setDesc(rs.getString(3));
				myTask.setNotes(rs.getString(4));
				myTask.setDateBegin(rs.getString(5));
				myTask.setDateEnd(rs.getString(6));
				myTask.setStatus(rs.getString(9));			
				myTask.setId_user(rs.getInt(7));
				taskList.add(myTask);	
			}
		return null;
		
	}

}
