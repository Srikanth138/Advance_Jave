package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*CREATE PROCEDURE `STUD_CURSOR` (in name1 varchar(10),in name2 varchar(10)) //mysql is not there currors!
BEGIN
select sno,name,addrs,avg from student where name in(name1,name2);
END*/
public class Mysql_Currors {
private static final String Query="{call STUD_CURSOR(?,?)}";
	public static void main(String[] args) {
			Scanner sc=null;
			Connection con=null;
			CallableStatement cs=null;
			ResultSet rs=null;
			boolean flag=false;
		
			try{
				sc=new Scanner(System.in);
				System.out.println("enter ur name 1:");
				String name1=sc.next();
				System.out.println("enter ur name 2:");
				String name2=sc.next();
				
				con=DriverManager.getConnection("jdbc:mysql:///srikanth", "root", "root");
				cs=con.prepareCall(Query);
			
				if(cs!=null){
				cs.setString(1, name1);
				cs.setString(2, name2);
				cs.execute();
				rs=cs.getResultSet();
				
					while(rs.next()){
						flag=true;
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				}}
				if(flag==false)
					System.out.println("records not found");
				else 
					System.out.println("record found and display");
			}
		catch(SQLException se){
			se.printStackTrace();
		}
			finally{
				sc.close();
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					cs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
			} //finally
	}//main
}//class
