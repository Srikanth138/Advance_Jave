//DBConnectionClass.java
package com.sri.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionClass {
	public static Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
//		InputStream is = new FileInputStream("src/com/sri/util/jdbc.properties"); // with in src folder
//
//		Properties props = new Properties(); // create properties object
//		props.load(is);
//		System.out.println(props);
//		Class.forName(props.getProperty("jdbc.driver"));
//		con = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("db.user"),
//				props.getProperty("db.pwd"));
//
//		System.out.println("connection established..");

		return con;
	}

}
