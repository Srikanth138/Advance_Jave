package select;

import java.sql.Connection; //ctrl+shift+O
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		SelectTest t=new SelectTest();
		System.out.println("ClassName:: "+t.getClass());
		try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM EMP"); //ctrl+shif+X
									//"SELECT EMPNO,ENAME,SAL  FROM EMP"
		if(rs!=null)
		while(rs.next())
		System.out.println(rs.getInt("EMPNO")+" "+rs.getString("ENAME")+" "+rs.getFloat("SAL"));
		//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
		}
		catch(Exception e){e.printStackTrace();}
	}

}



/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest3 {

	public static void main(String[] args) {
		System.out.println("SelectTest2.main()");
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
			
			//register jdbc driver s/w (optonal)
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
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
}// class
*/