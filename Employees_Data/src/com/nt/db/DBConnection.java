package com.nt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static Connection con;
	static {
		try {
			//postgresql
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql:srikanth", "postgres", "root");
			
			//oracle
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getCon() {
		return con;
	}

}
