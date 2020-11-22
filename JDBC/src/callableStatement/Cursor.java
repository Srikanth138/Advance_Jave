package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

/*it is a In Memeory variable of oracle's pl/sql programming having ability to store bunch of records given by select SQL query. Cursor is like jdbc ResultSet object.
 * SYS_REFCURSOR is a built-inCursor data type. in oracle's PL/SQL programming.
 * empDetails sys_refcursor; //cursor variable declaration open empDetails for
 * SELECT EMPNO,ENAME,JOB,SAL FROM EMP;
 
  create procedure p_get_empdetails_by_desgs(desg1 in varchar2,desg2 in varchar2,Empdetails out SYS_REFCURSOR) AS
    begin
    open EmpDETAILS for
    select empno,ename,job,sal from emp where job in(desg1,desg2)order by job;
   end;*/
public class Cursor {
private static final String Query="{CALL p_get_empdetails_by_desgs(?,?,?)}"; //emp table
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		boolean flag=false;
		try{
			sc=new Scanner(System.in);
			System.out.println("enter ur name 1:");
			String name1=sc.next().toUpperCase();
			System.out.println("enter ur name 2:");
			String name2=sc.next().toUpperCase();
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			cs=con.prepareCall(Query);
		
			if(cs!=null){
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.setString(1, name1);
			cs.setString(2, name2);
			
			
			cs.execute();
			System.out.println(rs=(ResultSet)cs.getObject(3));
			
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
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
			try{
				rs.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			try{
				cs.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			try{
				sc.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}//finally
	} //main
}//class
