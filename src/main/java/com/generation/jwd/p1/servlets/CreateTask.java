package com.generation.jwd.p1.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createTask")
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
			
			
			PreparedStatement createtask = 
					bananaconn.prepareStatement("INSERT INTO task(id_task, name_task, desc_task, dateBegin_task, dateEnd_task, idResponsible_task, notes_task, status_task, id_project, id_user) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
					
			
			
			bananaconn.close();
			System.out.println("conexion cerrada");
			
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			
		}
		
	}
}
