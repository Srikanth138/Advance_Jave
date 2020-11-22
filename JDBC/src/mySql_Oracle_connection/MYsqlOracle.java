package mySql_Oracle_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**BEST example on ANDHRA BANK & UNIOUN BANK COMBIN THE BOTH DATA.
 * using oracle AND mysql  */
public class MYsqlOracle {
	private static final String slt  ="SELECT NAME,ADDRS,AVG FROM STUDENT";
	private static final String ins ="INSERT INTO STUDENT(NAME,ADDRS,AVG) VALUES(?,?,?)";
	
	public static void main(String[] args) {
		Connection con=null;
		Connection mycon=null;
		Statement st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		try{
//			Class.forName("oracle.jdbc.driver.oracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			
			mycon=DriverManager.getConnection("jdbc:mysql:///srikanth","root","root");
			
			if(con!=null)
				st=con.createStatement();
						
			if(st!=null)
				rs=st.executeQuery(slt);
			
			if(mycon!=null)
				ps=mycon.prepareStatement(ins);
			
			if(rs!=null)
			while(rs.next()){
				
				if(ps!=null)
				ps.setString(1,rs.getString(1));
				ps.setString(2,rs.getString(2));
				ps.setFloat(3,rs.getFloat(3));
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getFloat(3));
				count=ps.executeUpdate();
			}
			
			if(rs!=null && count!=0)
			System.out.println("succesed...");
			else
				System.out.println("faile......");
		}
		catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		} 
		finally{
			try {
				ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				mycon.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
