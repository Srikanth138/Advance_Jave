package com.nt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/srikanth", "root", "root");
			con=DriverManager.getConnection("jdbc:mysql:///srikanth","root","root");
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static Connection getCon() {
		return con;
	}

}
