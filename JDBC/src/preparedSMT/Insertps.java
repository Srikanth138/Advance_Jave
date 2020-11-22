package preparedSMT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertps {
	
	private static final String query="INSERT INTO STUDENT VALUES(?,?,?,?)"; //never change the value because static final is fixed

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		Scanner sc=null;
		try{
			sc=new Scanner(System.in);
			//Class.forName("oracle.jdbc.driver.oracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			ps=con.prepareStatement(query);
			
			System.out.println("how many student data entered...");
			int x=sc.nextInt();
			
					for(int i=0;i<x;++i){
					System.out.println("enter the number");
					int no=sc.nextInt();
					System.out.println("enter name");
					String name=sc.next();
					System.out.println("enter Address");
					String adrs=sc.next();
					System.out.println("enter AVG");
					float avg=sc.nextFloat();
			
						ps.setInt(1,no);
						ps.setString(2, name);
						ps.setString(3, adrs);
						ps.setFloat(4, avg);
						
						if(ps!=null)
							count=ps.executeUpdate();
						}
			
			if(count==0){
				System.out.println("NOT inserted......");
			}
			else{
				System.out.println("inserted......");
			}
			}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			try {
				ps.close();
			} 
			catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				con.close();
			} 
			catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				sc.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
