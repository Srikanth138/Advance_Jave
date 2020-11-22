package externalJDBCProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchFile{
	public static void main(String args[]) {
		Connection con=null;
		Statement st=null;
		try{
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		st=con.createStatement();
		con.setAutoCommit(false);
		
		String s1="insert into student values(1005,'malli','jpr',56.9)";
		st.addBatch(s1);
		String s2="insert into student values(1006,'lilly','ll',70.9)";
		st.addBatch(s2);
		String s3="update student set name='abc'  where sno=1001";
		st.addBatch(s3);
		
		//Create an int[] to hold returned values
		int result[]=st.executeBatch();
		
		int total=0;
		for(int i=1;i<=result.length;i++){
		total=total+1;
		}
		System.out.println(total+"excution results");
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
			
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}