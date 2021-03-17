package com.nt.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		} catch (SQLException e) {
			System.out.println("DBConnection.enclosing_method()-SQLException");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBConnection.enclosing_method()-ClassNotFoundException");
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}

}
