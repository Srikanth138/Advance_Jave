package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/* SQL> select(sysdate-dob)/365.25 from PERSON_DATE where pid=1;
 * (SYSDATE-DOB)/365.25
 * --------------------
 * 24.0161878 */
public class CalculateDate {
private static final String query="SELECT(SYSDATE-DOB)/365.25 FROM PERSON_DATE WHERE PID=?";
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
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
				if(con!=null)
					ps=con.prepareStatement(query);
					if(ps!=null)
						ps.setInt(1, pid);
					rs=ps.executeQuery();
					if(rs!=null){
						if(rs.next()){
						System.out.println("person age::"+rs.getInt(1));
						System.out.println("person age::"+rs.getFloat(1));
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
	}

}
