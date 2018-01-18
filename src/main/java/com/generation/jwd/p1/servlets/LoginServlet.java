package com.generation.jwd.p1.servlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.generation.jwd.p1.beans.LoginBean;
import com.generation.jwd.p1.beans.UserBean;
import com.mysql.jdbc.PreparedStatement;



@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LoginServlet() {    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserBean userBean = new UserBean();
		userBean.setName_user(request.getParameter("name_user"));
		userBean.setPassword_user(request.getParameter("password_user"));
		
		HttpSession session = request.getSession();
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
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
			
			java.sql.PreparedStatement selectUser = bananaconn.prepareStatement("SELECT email_user, password_user FROM users");
			
			ResultSet rs = selectUser.executeQuery();
			
			while(rs.next()) {
				int id_user = rs.getInt(1);
				String name_user = rs.getString(2);
				String email_user = rs.getString(4);
				String password_user = rs.getString(5);
				
				if(email_user.equals(userBean.getName_user()) && password_user.equals(userBean.getPassword_user())) {
					session.setAttribute("id_user", id_user);
					session.setAttribute("name_user", name_user);
					request.getRequestDispatcher("homeuser.jsp").forward(request, response);
					
				} else {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			
			rs.close();
			selectUser.close();
			bananaconn.close();
			
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());	
		} 

	}
}
