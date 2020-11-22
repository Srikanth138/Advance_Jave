package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/* mysql> SELECT FROM_days(datediff(now(),dob)) from person_date where pid=2;
 *  FROM_days(datediff(now(),dob)) 
 * 0024-02-14 */
public class CalculateDateMySql {
private static final String query="SELECT FROM_DAYS(DATEDIFF(NOW(),DOB)) FROM PERSON_DATE WHERE PID=?";
	public static void main(String[] args) {
		int pid=0;
		Connection con=null;
		PreparedStatement ps=null;
		Scanner sc=null;
		ResultSet rs=null;
		try{
				sc=new Scanner(System.in);
				if(sc!=null){
				System.out.println("enter the pid:");
				pid=sc.nextInt();
				}
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql:///srikanth","root","root");
				if(con!=null)
					ps=con.prepareStatement(query);
					if(ps!=null)
						ps.setInt(1, pid);
					rs=ps.executeQuery();
					if(rs!=null){
						if(rs.next()){
						//System.out.println("person age::"+rs.getInt(1)); //not suport INT type
						System.out.println("person age::"+rs.getString(1));
						}
						else
							System.out.println("Record not found");
					}
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				sc.close();
			}
			catch(Exception s){
				s.printStackTrace();
			}
		}
	}//main
}//class
