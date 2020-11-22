package cSV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CSVInsertTest {
	private static String Query="Insert into database values(?,?,?,?)";
//	private static String Query="update database set name=?,addr=?,avg=? where no=?";
	
	public static void main(String[] args) {
		int count=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the sno");
		int no=sc.nextInt();
		System.out.println("enter the name");
		String name=sc.next();
		System.out.println("enter the add");
		String addr=sc.next();
		System.out.println("enter the AVG");
		Float avg=sc.nextFloat();
		
		try(Connection con=DriverManager.getConnection("jdbc:Text:///E:/ADVJAVA")){
			PreparedStatement ps=con.prepareStatement(Query);
			/*ps.setInt(1, no);
			ps.setString(2, name);
			ps.setString(3, addr);
			ps.setFloat(4, avg);*/
			
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setFloat(3, avg);
			ps.setInt(4, no);
				count=ps.executeUpdate();
			if(count!=0){
				System.out.println("Inserted successfully....");
				sc.close();
			}
			else{
				System.out.println("records or not Insertde...");
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
