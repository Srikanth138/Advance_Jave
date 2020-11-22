package callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

/*create or replace function FX_VIEW_DELETE_STUD_BY_SNO(no in number,studdetails out SYS_REFCURSOR)
  return varchar2 as
  cnt number(3);
  result varchar2(30);
  begin
  open studdetails for
  select sno,name,addrs,avg from student where sno=no;
  delete from student where sno=no;
  cnt:=SQL%ROWCOUNT;
  if(cnt=1)then
  result:='record deleted';
  else
  result:='record not found for delection';
  end if;
  return result;
  end; */
public class Cursor_ROW_CNT {
private static final String Query="{?=call FX_VIEW_DELETE_STUD_BY_SNO(?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		int no=0;
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		try{
			sc=new Scanner(System.in);
			System.out.println("ENTER THE NO");
			no=sc.nextInt();
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			cs=con.prepareCall(Query);
			if(cs!=null){
				cs.registerOutParameter(3, OracleTypes.CURSOR);
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setInt(2, no);
				cs.execute();
				
				rs=(ResultSet)cs.getObject(3);
				while(rs.next()){
				System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getFloat(4));
				}
				System.out.println(cs.getString(1));
			}
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
