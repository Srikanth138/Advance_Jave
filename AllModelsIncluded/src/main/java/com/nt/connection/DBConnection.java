package com.nt.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			System.out.println("DBConnection.enclosing_method()-STATIC BLOCK()");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}// static

	public static Connection getCon() {
		System.out.println("DBConnection.getCon()-STATIC METHOD()");
		return con;
	}// method

}
