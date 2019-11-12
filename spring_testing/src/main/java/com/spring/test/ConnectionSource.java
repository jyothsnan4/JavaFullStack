package com.spring.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class provides DB connection like a config file cfg.xml in hibernate
public class ConnectionSource {
	static String url;
	static String username;
	static String password;
public static Connection connect() throws SQLException{
	url="jdbc:mysql://localhost:3306/demo";
	username="root";
	password="testing";
	Connection con= DriverManager.getConnection(url, username, password);
	System.out.println("connected..................");
	
	return con;
}
}
