package com.generation.jwd.p1.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.swing.JOptionPane;

public class DataBaseConnection {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		InputStream input = null;
		
//		String url = "jdbc:mysql://127.0.0.1:3306/bananagest";
//		String user = "root";
//		String password = "fred3605";
		
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
			
			
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection bananaconn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Conexion realizada");
			
//			PreparedStatement selectUser = bananaconn.prepareStatement("SELECT id_user, name_user FROM users");
//			
//			ResultSet rs = selectUser.executeQuery();
//			
//			while(rs.next()) {
//				int id_user = rs.getInt(1);
//				String name_user = rs.getString("name_user");
//				System.out.println("Datos: " + id_user + " " + name_user);
//			}
//			
//			rs.close();
//			selectUser.close();
			//bananaconn.close();
			bananaconn.close();
			
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			
		} 
	}
}
