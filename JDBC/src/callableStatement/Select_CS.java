package callableStatement;
/*create or replace procedure p_getEmpDetails_by_No(no in number,name out varchar2,desg out varchar2,sal out number)
 * as
 * begin
 * select ename,job,sal into name,desg,sal from emp where empno=no;
 * end;
 * / */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Select_CS{
	private static final String Query="{CALL p_getEmpDetails_by_No(?,?,?,?)}"; //emp table
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		try{
			sc=new Scanner(System.in);
			System.out.println("enter the number");
			int eno=sc.nextInt();
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			cs=con.prepareCall(Query);
			if(cs!=null){
				
				cs.setInt(1,eno);
				
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.INTEGER);
				
				cs.execute();
				System.out.println("the result is :"+cs.getString(2)+" "+ cs.getString(3)+" "+cs.getInt(4));
				
			}
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				sc.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			try{
				cs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}//finally
	}//main
}//class
