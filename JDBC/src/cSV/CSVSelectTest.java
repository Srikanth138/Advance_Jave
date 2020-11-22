package cSV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSVSelectTest {
	//csv file name as  the db table name
    private static final String CSV_ALL_SELECT="SELECT * FROM database.csv";  
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:Text:///E:/ADVJAVA")){
			try(PreparedStatement ps=con.prepareStatement(CSV_ALL_SELECT)){
			     try(ResultSet rs=ps.executeQuery()){
			    	 while(rs.next()) {
			    		 System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
			    	 }//while
			     }//try3
			     }//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main

}
