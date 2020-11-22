package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*create or replace function FX_GET_STUD_DETAILS_BY_SNO(no in number,sname out varchar2,addrs out varchar2)
return Float
as
performence float;
begin
select s.name,s.addrs,s.avg into sname,addrs,performence from student s where sno=no;
return performence;
end;
 /  
  * SQL 92 Syntax is :: {return_type=call <Function_Name>(?,?,?)}
  * return param (?-->1) should be treated as out param and must be registered JDBC data type*/
public class Function {
private static final String Query="{?=call FX_GET_STUD_DETAILS_BY_SNO(?,?,?)}";
//									1								  2 3 4			
	public static void main(String[] args) {
		
		try{
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the number");
			int  no=sc.nextInt();
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			CallableStatement cs=con.prepareCall(Query);
            if(cs!=null){
			cs.setInt(2, no);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(1, Types.FLOAT);
			cs.execute();
			
			System.out.println(cs.getString(3)+" "+cs.getString(4)+" "+cs.getFloat(1));
			}
			else 
			 System.out.println("Record not found..");
			
		sc.close();
		cs.close();
		}
		
		catch(SQLException se){
			se.printStackTrace();
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
