package other;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LogIn {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String query=null;
		int id=0;
		String cName=null;
		int count=0;
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("enter the id");
				id=sc.nextInt();
				System.out.println("enter the cName");
				cName=sc.next();
			}
//			convert variables to SQL
			cName="'"+cName+"'";
			
		Class.forName("oracle.jdbc.driver.OracleDriver"); //load the drivers
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger"); //establish the connection
		st=con.createStatement();
		
//		select count(*)from test2 where cid=3 and cname='c';
		query="SELECT COUNT(*)FROM TEST2 WHERE CID="+id+" AND CNAME="+cName;
		System.out.println(query);
		//count=st.executeQuery(query);
		rs=st.executeQuery(query);
			if(rs!=null){
				rs.next();
				count=rs.getInt("count(*)"); //getInt() predefine method
			}
			if(count==0){
				System.out.println("invalide detailes");
			}
				else
					System.out.println("valide details");
		}
		catch(SQLException |ClassNotFoundException se){
			se.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if(st!=null)
				st.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(sc!=null)
				sc.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		} //finall
	} //main
} //class
