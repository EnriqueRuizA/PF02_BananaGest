package com.generation.jwd.p1.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.generation.jwd.p1.beans.TaskBean;
import java.sql.Timestamp;


@WebServlet("/createtask")
public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateTask() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Properties prop = new Properties();
		InputStream input = null;
				
		try {
			
			input = new FileInputStream("C:\\Users\\Arranque 1\\git\\PF02_BananaGest\\src\\main\\webapp\\doc\\config.properties");
			prop.load(input);
			
			String driver = prop.getProperty("jdbc.driver");
			if (driver != null) {
			    Class.forName(driver) ;
			}
			
			String url = prop.getProperty("jdbc.url");
			String user = prop.getProperty("jdbc.user");
			String password = prop.getProperty("jdbc.password");
			
			
			Connection bananaconn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Conexion realizada");
			
			TaskBean createTask = new TaskBean();
			
			createTask.setName_task(request.getParameter("name_task"));
			createTask.setDesc_task(request.getParameter("desc_task"));
			createTask.convertStringToTimestamp(request.getParameter("dateBegin_task"));
			createTask.convertStringToTimestamp(request.getParameter("dateEnd_task"));
			System.out.println("datos fechas");
//			createTask.setDateBegin_task(request.getParameter("dateBegin_task"));
//			createTask.setDateEnd_task(request.getParameter("dateEnd_task"));
			createTask.setNotes_task(request.getParameter("notes_task"));
			createTask.setStatus_task(request.getParameter("status_task"));
						
			
			
			System.out.println("se ha recogido un dato del formulario");		
			
			PreparedStatement addTask = 
					bananaconn.prepareStatement(
							"INSERT INTO tasks(name_task, desc_task, dateBegin_task, dateEnd_task, notes_task, status_task) VALUES (?, ?, ?, ?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);
				
			addTask.setString(1, "name_task");
			addTask.setString(2, "desc_task");
			addTask.setTimestamp(3, createTask.convertStringToTimestamp(request.getParameter("dateBegin_task")));
			addTask.setTimestamp(4, createTask.convertStringToTimestamp(request.getParameter("dateEnd_task")));
			addTask.setString(5, "notes_task");
			addTask.setString(6, "status_task");
			
			addTask.executeUpdate();
			System.out.println("se ha añadido un campo a la BBDD");
			
			HttpSession session_name= (HttpSession)request.getSession();
			
			
			if(createTask.validate() == true) {
		    	 session_name.setAttribute("saveTask", "A new task has been created");
		    	 session_name.setAttribute("task", createTask.getName_task());
		         request.getRequestDispatcher("homeuser.jsp").forward(request, response);
		     } else {
		    	 session_name.setAttribute("saveTask", "error: a new task has not created");
		         request.getRequestDispatcher("createtask.jsp").forward(request, response);
		     }
			bananaconn.close();
			System.out.println("conexion cerrada");
			
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
			
		}
		
	}
}
