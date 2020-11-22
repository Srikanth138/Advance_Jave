package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectTest {

	public static void main(String[] args) {
		Scanner sc=null;
		String query=null;
		Connection con=null;
		Statement st=null;
		boolean flag=false;
		ResultSet rs=null;
		int count=0;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("SELECT *FROM TEST1 ::Example"); //u can write QUERY at run time 
				System.out.println("Enter select or non-select SQL query(student)::");
				query=sc.nextLine();
			}
			
			
			//register JDBC driver
			   //Class.forName("oracle.jdbc.driver.OracleDriver");
			   //estalish the connection
			   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott","tiger");
			   //create JDBC statement object
			   if(con!=null)
				   st=con.createStatement();
			   //send and execute SQL query in Db s/w
			   if(st!=null)
				  flag=st.execute(query);
			       // flag=st.executeQuery(query);
			    //process the reuslts
			   if(flag) {
				   System.out.println("Select SQL query is executed");
				    rs=st.getResultSet();
				    //process the ResultSet
				    if(rs!=null) {
				    	while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getInt(3));
				    	}//while
				    }//if
			   }//if
			   else {
				   System.out.println("Non-Select SQL query is executed");
				   count=st.getUpdateCount(); //predefine method
				   System.out.println("no.of records that are effected are ::"+count);
			   }//else
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
			    se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
	}//main
}//class
