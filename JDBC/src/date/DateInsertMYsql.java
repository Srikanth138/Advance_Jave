package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertMYsql {
	private static final String INSERT_DATE="INSERT INTO PERSON_DATE(name,addrs,dob,dom,doj) VALUES(?,?,?,?,?)";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		Scanner sc=null;
		String name=null,addrs=null, sdob=null, sdom=null, sdoj=null;
		java.util.Date udob=null, udom=null;
		SimpleDateFormat sdf1=null,sdf2=null; //simple date format
		java.sql.Date sqdob=null,sqdom=null,sqdoj=null;
		int result=0;
		try{
			sc=new Scanner(System.in);	
			if(sc!=null){
				System.out.println("ENTER THE NAME::");
				name=sc.next();						
				System.out.println("ENTER THE ADDRS::");
				addrs=sc.next();
				System.out.println("ENTER THE DOB(dd-MM-yyyy)::");
				sdob=sc.next();
				System.out.println("ENTER THE DOM(MM-dd-yyyy)::");
				sdom=sc.next();
				System.out.println("ENTER THE DOJ(yyyy-MM-dd)::");
				sdoj=sc.next();
			}// if sc
			Class.forName("com.mysql.cj.jdbc.Driver");
//		String convert to util. use parse()method
				sdf1=new SimpleDateFormat("dd-MM-yyyy");
						if(sdf1!=null)
							udob=sdf1.parse(sdob);
				sdf2=new SimpleDateFormat("MM-dd-yyyy");
						if(sdf2!=null)
							udom=sdf2.parse(sdom);
//		Util-date convert to sql-date
					if(udob!=null)
						sqdob=new java.sql.Date(udob.getTime());
					if(udom!=null)
						sqdom=new java.sql.Date(udom.getTime());
					//string conver to simple date to java.sql.Date class obj
						sqdoj = java.sql.Date.valueOf(sdoj); 
			
			con=DriverManager.getConnection("jdbc:mysql:///srikanth","root","root");
			if(con!=null)
				ps=con.prepareStatement(INSERT_DATE);
				if(ps!=null){
					ps.setString(1, name);
					ps.setString(2, addrs);
					ps.setDate(3, sqdob);
					ps.setDate(4, sqdom);
					ps.setDate(5, sqdoj);
					
					}
				if(ps!=null)
				result=ps.executeUpdate();			
				if(result!=0)
					System.out.println("INSERTED ....");
				else
					System.out.println("INSERTION FAIL....");
		}
		catch(SQLException |ClassNotFoundException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(ps!=null)
					ps.close();
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
			try{
				if(sc!=null)
					sc.close();
			}
			catch(Exception se){
				se.printStackTrace();
			}
		} //finally
		
	} //main

} //class
