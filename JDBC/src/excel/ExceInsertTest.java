package excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExceInsertTest {
	 //<Workbookname>.<SheetName> is  the db table
//    private static final String EXCEL_INSERT="INSERT INTO  Book1.SHEET1 VALUES(?,?,?)";  
    private static final String EXCEL_INSERT="UPDATE Book1.SHEET1 SET SNAME=?,SADDR=? WHERE SNO=?";  
	public static void main(String[] args) {
	   int sno=0;
	   String name=null,sadd=null;
	   int count=0;
	   Scanner sc=null;
		try {
			sc=new Scanner(System.in);
			 System.out.println("enetr student number::");
			 sno=sc.nextInt();
			 System.out.println("enter student name::");
			 name=sc.next();
			 System.out.println("enter student address::");
			 sadd=sc.next();
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
		
		
		try(Connection con=DriverManager.getConnection("jdbc:Excel:///E:/ADVJAVA")){
			try(PreparedStatement ps=con.prepareStatement(EXCEL_INSERT)){
			         //set values to query params
//				      ps.setInt(1,sno); ps.setString(2,name); ps.setString(3, sadd);
				      ps.setInt(3,sno); ps.setString(1,name); ps.setString(2, sadd);
				      //execute the SQL query
				      count=ps.executeUpdate();
				      //process the result
				      if(count==0)
				    	  System.out.println("record not inserted");
				      else
				    	  System.out.println("record inserted");
			     }//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main

}
