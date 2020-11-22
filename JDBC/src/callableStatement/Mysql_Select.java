package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*DELIMITER $$ --> start 
USE `srikanth`$$
CREATE PROCEDURE `S_GET_STUD_DETAILS_BY_SNO` (in no int,out name varchar(10),out addr varchar(10),out avg float)
BEGIN
select name,addrs,avg into name,addr,avg from student where sno=no; 
END$$ //table_colom namas  -- procedure_names 
DELIMITER ;--> End*/

public class Mysql_Select {
private static final String Query="{CALL S_GET_STUD_DETAILS_BY_SNO(?,?,?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;	
		CallableStatement cs=null;
		int no=0;
	try{
		sc=new Scanner(System.in);
		System.out.print("ENTER the SNo :");
		no=sc.nextInt();
		con=DriverManager.getConnection("jdbc:mysql:///srikanth", "root", "root");
		cs=con.prepareCall(Query);
		
		cs.setInt(1,no);
		//ojdbc 6/7/8/9/10 optional
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.registerOutParameter(3, Types.VARCHAR);
		cs.registerOutParameter(4, Types.FLOAT);
		
		boolean b=cs.execute();
		System.out.println(b);
		System.out.println(cs.getString(2)+" "+cs.getString(3)+" "+cs.getFloat(4));
	}
	catch(SQLException se){
		se.printStackTrace();
	}
	finally{
		try{
			if(sc!=null)
				sc.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(cs!=null)
				cs.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(con!=null)
				con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}//finally
	}//main
}//class
