package preparedSMT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/** SQL> create sequence stud_sno_seq start with 1000 increment by 1;
 * */

public class InsertPmSeq {
	private static final String INSERT_STUD_QUERY="INSERT INTO STUDENT VALUES(STUD_SNO_SEQ.NEXTVAL,?,?,?)";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try(Scanner sc=new Scanner(System.in);){
//			Class.forName("oracle.jdbc.driver.oracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"," scott"," tiger");
			if(con!=null)
				ps=con.prepareStatement(INSERT_STUD_QUERY);	
			System.out.println("ENTER NAME::");
			String name=sc.next();
			System.out.println("ENTER ADDRS::");
			String addrs=sc.next();
			System.out.println("ENTER AVG::");
			float avg=sc.nextFloat();
			if(ps!=null){
				ps.setString(1, name);
				ps.setString(2, addrs);
				ps.setFloat(3, avg);
				count=ps.executeUpdate();
			}
			if(count!=0)
				System.out.println("inserted success fully::"+count);
			else
				System.out.println("insertion is failed.....");
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
