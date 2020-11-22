package excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExcelSelectTest {
	//<Workbookname>.<SheetName> is  the db table
    private static final String EXCEL_ALL_SELECT="SELECT * FROM Book1.SHEET1 ";  //Book1 ->save excel-name, sheet1-> SHEET1
	public static void main(String[] args) {
		
		try(Connection con=DriverManager.getConnection("jdbc:Excel:///E:/ADVJAVA")){
			try(PreparedStatement ps=con.prepareStatement(EXCEL_ALL_SELECT)){
			     try(ResultSet rs=ps.executeQuery()){
			    	 while(rs.next()) {
			    		 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
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
