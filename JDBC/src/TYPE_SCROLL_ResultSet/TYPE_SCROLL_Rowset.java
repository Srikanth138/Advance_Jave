package TYPE_SCROLL_ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TYPE_SCROLL_Rowset {

	public static void main(String[] args) {
		Statement st=null;
		Connection con=null;
		ResultSet rs=null;
		String Query="SELECT SNO,NAME,ADDRS,AVG FROM STUDENT"; //SENSITIVE SUPPERT.  Not support (*)
		int count=0;
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger"); 
//			con=DriverManager.getConnection("jdbc:mysql:///srikanth", "root", "root");
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery(Query);
			if(rs!=null){
				System.out.println("Scrollable Resultset object is Created:");
		         		
				while(rs.next()){
					rs.refreshRow(); //INSENSITIVE comment this one
					if(count==0)
						Thread.sleep(30000);	//during this time modify the DB records from sql promt
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				count++;
				}//while
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
