package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DateSelect {
	private static final String Select_date="SELECT PID,NAME,ADDRS,DOB,DOM,DOJ FROM PERSON_DATE WHERE PID=?";

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int pid=0;
		try{
			sc=new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			if(con!=null)
				ps=con.prepareStatement(Select_date);
			
			System.out.println("ENTER THE PID::");
			pid=sc.nextInt();
			
			if(ps!=null)
				ps.setInt(1, pid);
				rs=ps.executeQuery();
			if(rs.next()){
				java.util.Date d=new java.util.Date();
//				long s=d.getTime();
				System.out.println(rs.getInt("pid")+" "+rs.getString("name")+" "+rs.getDate("dob")+" "+rs.getDate("dom")+" "+rs.getDate("doj")+" CUREENT DATE AND TIME :"+d);
			}	
			else
				System.out.println("RECORDS ARE NOT FOUND......");
		}
		catch(SQLException |ClassNotFoundException e){
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} //finally
	} //main
} //class
