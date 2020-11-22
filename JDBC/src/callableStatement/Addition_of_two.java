package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
//IN -> input(ToSupply inputs), OUT-> to gather outputs, INOUT-> ToSupply inputs and to gather outputs.
/* CREATE OR REPLACE PROCUDER p_first(X IN NUMBER,Y IN NUMBER,Z OUT NUMBER)AS
 * BEGIN
 * Z:=X+Y;   (= for comparision, := Assigment)
 * END;
 * /-> close */
public class Addition_of_two {
	private static final String Query="{CALL p_first(?,?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		CallableStatement cs=null;
		try{
			sc=new Scanner(System.in);
			System.out.println("enter the first number");
			int x=sc.nextInt();
			System.out.println("enter the second number");
			int y=sc.nextInt();
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			cs=con.prepareCall(Query);
			if(cs!=null){
				
				cs.setInt(1,x);
				cs.setInt(2,y);
				
				cs.registerOutParameter(3, Types.INTEGER);
				
				cs.execute();
				System.out.println("THE RESULT IS "+cs.getInt(3));
				
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
