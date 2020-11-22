package select;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Statement;

public class SelectTest4 {

		public static void main(String[] args) {
			Connection con=null;
		   Statement st=null;
		    String query=null;
		    ResultSet rs=null;
				try {
			     // register jdbc driver(Optional)
					Class.forName("oracle.jdbc.driver.OracleDriver");
				
					//establish the connection    
					/* => orcl/xe error:-java.sql.SQLException: Listener refused the connection with the following error:
					ORA-12505, TNS:listener does not currently know of "SID"->"orcl/xe" given in connect descriptor */
					
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott", "tiger");
				
					//create JDBC Statement object
					if(con!=null)
						st=con.createStatement();
					
					//prepare SQL query
					       //select count(*) from emp;
					query="SELECT COUNT(*) FROM EMP";
				
//					PreparedStatement ps=con.prepareStatement(query); this is parametrized method.
//					rs=ps.executeQuery(); -> this is non parametrized method. 
					
//					send and execute SQL query in DB s/w	
					if(st!=null)
						 rs=st.executeQuery(query);
					//process the ResultSet object
					if(rs!=null) {
						rs.next();
						//System.out.println("records count::"+rs.getInt(1));
						System.out.println("records count::"+rs.getInt("count(*)"));
					}//if
		    }//try
			catch(SQLException se) {
				System.out.println(se);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
					//close jdbc objs
				   try {
					   if(rs!=null)
						   rs.close();
				   }
				   catch(SQLException se) {
					   se.printStackTrace();
				   }
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
				}//finally
		}//main
}//class

