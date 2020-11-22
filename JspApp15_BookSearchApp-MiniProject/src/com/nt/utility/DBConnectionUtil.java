package com.nt.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
	public static Connection getPooledConnection()throws Exception{
		Connection con=null;
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger"); //type4 Driver
		
		/*InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		// create InitialContext object
		ic=new InitialContext();
		//get DataSource object ref from underlying server jndi registry
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get jdbc pooled connection
		con=ds.getConnection();*/
	
		return con;
		
	}

}
