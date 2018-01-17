package com.generation.jwd.p1.services;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DataBaseConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/banana_gest";
		String user = "root";
		String password = "@p0cal1p515";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection bananaconn = DriverManager.getConnection(url, user, password);
			JOptionPane.showMessageDialog(null, "Conexión válida");
			bananaconn.close();
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		} 	
	}
}
