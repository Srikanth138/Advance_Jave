package preparedSMT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PsSelectTest4 {
	private static final String QUERY="SELECT COUNT(*) FROM EMP WHERE JOB=?";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Scanner sc=null;
		String name=null;
		try{
		sc=new Scanner(System.in);
//		Class.forName("oracle.jdbc.driver.oracleDriver"); //optional ojdbc6.jar
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"," scott"," tiger");
		
		if(con!=null)
		ps=con.prepareStatement(QUERY);
		
		if(ps!=null){
		System.out.printf("ENTER THE JOB HOLDER NAME....:");
		name=sc.next();
		ps.setString(1, name);
		
		rs=ps.executeQuery();
		
		if(rs!=null)
			rs.next();
			System.out.println("RECORDS COUNT::"+rs.getInt("COUNT(*)"));
		}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			try {
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
			try {
				ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
			try {
				con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
