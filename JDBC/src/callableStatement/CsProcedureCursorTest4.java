package callableStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;


/*CREATE OR REPLACE PROCEDURE P_GET_EMPDETAILS_BY_DESGS 
(
  DESG1 IN VARCHAR2 
, DESG2 IN VARCHAR2 
, EMPDETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
  open EMPDETAILS  for
     SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(DESG1,DESG2) ORDER BY JOB;
  
END P_GET_EMPDETAILS_BY_DESGS;
*/
public class CsProcedureCursorTest4 {
	  private static final  String CALL_PROCEDURE_QUERY="{ CALL P_GET_EMPDETAILS_BY_DESGS(?,?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		String desg1=null,desg2=null;
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter desg1::");
				desg1=sc.next().toUpperCase();  //gives CLERK
				System.out.println("enter desg2::");
				desg2=sc.next().toUpperCase(); //gives MANAGER
			}//if
			
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott","tiger");
			//create JDBc CallableStatement object
			if(con!=null)
				cs=con.prepareCall(CALL_PROCEDURE_QUERY);
			
			if(cs!=null) {
				//register OUT params with JDBC data types
				cs.registerOutParameter(3,OracleTypes.CURSOR);
				//set values to IN params
				cs.setString(1,desg1);
				cs.setString(2,desg2);
				//call PL/SQL procedure
				cs.execute();
				//gather results from OUT param
				rs=(ResultSet)cs.getObject(3);
				//process the ResultSet 
				 if(rs!=null) {
					 while(rs.next()) {
						 flag=true;
						 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
					 }//while
					 if(flag==false)
						  System.out.println("no records found");
					 else
						 System.out.println("records found and displayed");
					 
				 }//if
			}//if
			}///try
			catch(SQLException se) {
				if(se.getErrorCode()==6550)
					  System.out.println("No Procedure found with that name");
				   se.printStackTrace();
			   }
			  catch(Exception e) {
				  e.printStackTrace();
			  }
					finally {
						//close jdbc objs
						try {
							if(rs!=null)
								rs.close();
						}
						catch(SQLException se) {
							se.printStackTrace();
						}
						try {
							if(cs!=null)
								cs.close();
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
					}//finally	
	}//main
}//class