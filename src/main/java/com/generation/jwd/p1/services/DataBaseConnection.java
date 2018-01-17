package com.generation.jwd.p1.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DataBaseConnection {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/bananagest";
		String user = "root";
		String password = "@p0cal1p515";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			Connection bananaconn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Conexion realizada");
			
			PreparedStatement selectUser = bananaconn.prepareStatement("SELECT * FROM users");
			
			ResultSet rs = selectUser.executeQuery();
			
			while(rs.next()) {
				int id_user = rs.getInt(1);
				String name_user = rs.getString("name_user");
				System.out.println("Datos: " + id_user + " " + name_user);
			}
			
			rs.close();
			selectUser.close();
			bananaconn.close();
			
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
			
		} 
	}
}
