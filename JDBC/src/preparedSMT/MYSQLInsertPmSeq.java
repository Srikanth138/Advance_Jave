package preparedSMT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MYSQLInsertPmSeq {
	private static final String INSERT_STUD_QUERY="INSERT INTO STUDENT(sname,sadd,avg) VALUES(?,?,?)";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try(Scanner sc=new Scanner(System.in);){
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql:///srikanth"," root"," root");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/srikanth","root", "root");
			if(con!=null)
				ps=con.prepareStatement(INSERT_STUD_QUERY);	
			System.out.println("ENTER NAME::");
			String sname=sc.next();
			System.out.println("ENTER ADDRS::");
			String sadd=sc.next();
			System.out.println("ENTER AVG::");
			float avg=sc.nextFloat();
			if(ps!=null){
				ps.setString(1, sname);
				ps.setString(2, sadd);
				ps.setFloat(3, avg);
				count=ps.executeUpdate();
			}
			if(count!=0)
				System.out.println("inserted success fully::"+count);
			else
				System.out.println("insertion is failed.....");
		}
		catch(SQLException |ClassNotFoundException se){
			se.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
