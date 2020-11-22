package other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginPS {
	
	private static final String query="SELECT *FROM STUDENT WHERE SNO=? AND NAME=?";

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		Scanner sc=null;
		ResultSet rs=null;
		int k=0;
		try{
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"," scott"," tiger");
			if(con!=null)
				ps=con.prepareStatement(query);
			
			sc=new Scanner(System.in);
			
			System.out.println("enter the snumber ::"); //use in Db's table always Primary Key
			int sno=sc.nextInt();
			System.out.println("enter sname ::");
			String name=sc.next();
			if(ps!=null)
				ps.setInt(1, sno);
				ps.setString(2, name);
				
				rs=ps.executeQuery();
			if(rs!=null){
				rs.next();
					System.out.println("student "+rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getFloat(4));
				k=rs.getInt(1); 
				}
			if(k==0)
				System.out.println("INVALIDE DETAIL'S....");
			else
			System.out.println("VALIDE DETAIL'S....");
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
