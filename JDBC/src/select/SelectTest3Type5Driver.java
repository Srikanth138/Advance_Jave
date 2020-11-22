package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest3Type5Driver {
	public static void main(String[] args) {
		System.out.println("PsSelectTest3Type5Driver.main()");
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		int no=0;
		String query=null; 
		ResultSet rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Employee number");
				no=sc.nextInt();
			}//if
			
			//register jdbc driver s/w Type 5 Driver
			Class.forName("com.ddtek.jdbc.oracle.OracleDriver"); //set the year dd-09-2011**(MM-Year) .jar work
			//establish the connection
			 con=DriverManager.getConnection("jdbc:datadirect:oracle://localhost:1521;serviceName=orcl","scott","tiger"); //Type5 Driver 
			 //create statement object
			 if(con!=null)
				 st=con.createStatement();
			 //prepare SQL Query
			    //select empno,ename,job,sal from  emp where empno=7499;
			   query="SELECT EMPNO,ENAME,JOB,SAL FROM  EMP WHERE EMPNO="+no;
			   //send and execute in DB s/w 
			   if(st!=null)
				   rs=st.executeQuery(query);
			   //process the ResultSet obj
			   if(rs!=null) {
				    if(rs.next())
	                      System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3)+"   "+rs.getFloat(4));			    	
				    else
				    	System.out.println("No records found");
			   }//if

		}//try
		catch(SQLException se) {  //known exceptions
			se.printStackTrace();
		}
		catch(Exception e) {  //for unknown exceptions
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}//try
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}//finally

	}// main

} //class
