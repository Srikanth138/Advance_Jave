package TYPE_SCROLL_ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Row_Update_Insert {

	public static void main(String[] args) {
		Statement st=null;
		Connection con=null;
		ResultSet rs=null;
		String Query="SELECT SNO,NAME,ADDRS,AVG FROM STUDENT"; //SENSITIVE suppert Not support (*)

		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger"); 

			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery(Query);
			if(rs!=null){
				/* System.out.println("To insert new record in DB table:");
		            rs.moveToInsertRow(); //create empty record in rs		

					rs.updateInt(1,1006); //setting data to empty record of rs
					rs.updateString(2,"ramesh");
					rs.updateString(3,"hyd");
					rs.updateFloat(4,10.65f);
					
					rs.insertRow(); //insert new record to db table from rs  */	
				
				/*System.out.println("To update the record (with out using update sql query)");
				rs.absolute(4); //this is 4th row 
				rs.updateFloat(4, 89.56f); //this is 4th coloum value update
				rs.updateRow(); //this update reflect to DB table */
				
				System.out.println("To dalete the record");
				Scanner sc=new Scanner(System.in);
				int a=sc.nextInt();
				rs.absolute(a); //this is  4th row 
//				rs.absolute(a); //this is  4th row 
				System.out.println("DELETED SUCCESS FULLY");
				rs.deleteRow(); //dalete bd table 
				
				sc.close();
				} //if
		} //try
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(st!=null)
					st.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			
		}//finally
	}  //main
} //class
