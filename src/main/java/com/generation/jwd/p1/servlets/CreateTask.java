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

import com.generation.jwd.p1.beans.ProjectBean;
import com.generation.jwd.p1.beans.TaskBean;
import com.generation.jwd.p1.beans.UserBean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@WebServlet("/createtask")
public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateTask() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    response.sendRedirect("createtask.jsp");   
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Properties prop = new Properties();
		InputStream input = null;
				
		try {
			
			input = new FileInputStream("C:\\Users\\Arranque 1\\Downloads\\config.properties");
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
            createTask.setNotes_task(request.getParameter("notes_task"));
            createTask.setDateBegin_task(request.getParameter("dateBegin_task"));
            createTask.setDateEnd_task(request.getParameter("dateEnd_task"));
            createTask.setStatus_task(request.getParameter("status_task"));
            
            UserBean createTask1 = new UserBean();
            createTask1.setName_user(request.getParameter("name_user"));
            
            ProjectBean createTask2 = new ProjectBean();
            createTask2.setName_project(request.getParameter("name_project"));
            
            System.out.println("Se ha recogido un dato del formulario");        
            
            PreparedStatement addTask = 
                    bananaconn.prepareStatement(
                            "INSERT INTO tasks(name_task, desc_task, notes_task, dateBegin_task, dateEnd_task, status_task) VALUES (?, ?, ?, ?, ?, ?)");
                
            addTask.setString(1, createTask.getName_task());
            addTask.setString(2, createTask.getDesc_task());
            addTask.setString(3, createTask.getDateBegin_task());
            addTask.setString(4, createTask.getDateEnd_task());
            addTask.setString(5, createTask.getNotes_task());
            addTask.setString(6, createTask.getStatus_task());
            
            addTask.executeUpdate();
            System.out.println("se ha añadido una línea a la BBDD de Task");
			
			HttpSession session_name= (HttpSession)request.getSession();
			
			
			if(createTask.validate() == true) {
		    	 session_name.setAttribute("saveTask", createTask);
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
