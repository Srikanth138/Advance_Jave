package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTest {
	public static void main(String args[])throws ClassNotFoundException  {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		String query=null,name=null,adrs=null;
		int count=0;
		try{
			sc=new Scanner(System.in);// scanner Object
			if(sc!=null)
			System.out.println("ENTER THE SNO");
			int sno=sc.nextInt();
			System.out.println("ENTER THE name");
			name=sc.next();
			System.out.println("ENTER THE adrs");
			adrs=sc.next();
			System.out.println("ENTER THE AVG");
			float avg=sc.nextFloat();
			name="'"+name+"'"; //gives 'king'  ->this is write on database. becase write -> "'"
			adrs="'"+adrs+"'"; //gives 'hyd' 
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"," scott"," tiger");
			
			query="UPDATE STUDENT SET NAME="+name+",ADDRS="+adrs+",AVG="+avg+" WHERE SNO="+sno;
		//  query="UPDATE  STUDENT SET SNAME="+newName+",SADD="+newAddrs+",AVG="+newAvg+" WHERE SNO="+no;
			System.out.println(query);
		if(con!=null)
			st=con.createStatement();
			
		if(st!=null)
			count=st.executeUpdate(query);
		if(count!=0){
			System.out.println("updated success fully....");
		}
			else
				System.out.println("No Record is updated....");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try {
				if(st!=null)
					st.close();
			}
			catch(SQLException se) {
			    se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}
	}

}
