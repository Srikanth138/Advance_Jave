package metaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MetaDataColoumName {

	public static void main(String[] args) {
		String Query="SELECT SNO,NAME,ADDRS,AVG FROM STUDENT";
		//create JDBC con object
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger")) {
//		try(Connection con=DriverManager.getConnection("jdbc:mysql:///srikanth", "root", "root")) {
			
			 //create DatabaaseMetaData obj
			DatabaseMetaData dbmd=null;
			ResultSet rs=null;
			ResultSetMetaData rsmd=null;
			ParameterMetaData pmd=null; //even java 15 also not supported
			 if(con!=null)
				 dbmd=con.getMetaData();
			 if(dbmd!=null) { //DatabaseMetaData 
					System.out.println("db name::"+dbmd.getDatabaseProductName());
					
					System.out.println(" ");
				}
			 
			 PreparedStatement ps=con.prepareStatement(Query);
			 rs=ps.executeQuery(); 
			 
			 rsmd=rs.getMetaData(); //ResultSetMetaData
//			 rs.next(); //this use not print the rs->first column values
			 for(int i=1;i<=rsmd.getColumnCount();i++){
				 System.out.print(rsmd.getColumnName(i)+" "); //print the column NAME
			 }
			 System.out.println(" ");
			 
			 for(int i=1;i<=rsmd.getColumnCount();i++){
				 System.out.print(rsmd.getColumnTypeName(i)+":"); //print coloum DATATYPE Name
				 System.out.print(rsmd.getPrecision(i)+"."); //realvalues count
				 System.out.print(rsmd.getScale(i)+" "); //after . count
				 System.out.print(rsmd.getColumnDisplaySize(i)+" "); //the normal maximum number of characters allowed as the widthof the designated column
			 }
			 System.out.println(" ");
			 
			 while(rs.next()){
			 for(int i=1;i<=rsmd.getColumnCount();i++){
			 System.out.print(rs.getString(i)+" ");
			 }
			 System.out.println(" ");
			 }
			 System.out.println(" ");
			 
			 	pmd=ps.getParameterMetaData();
			 	if(pmd!=null){
			 	System.out.println("db vendor does NOT support ParameterMetaData");
			 	 int paramCount = pmd.getParameterCount();
			      System.out.println("paramCount=" + paramCount);
//			       System.out.println("param SQL type name=" + pmd.getParameterTypeName(1));
			 
			      for (int i= 1; i<= paramCount; i++) {
			        System.out.println("param number=" + i);
			        System.out.println("param SQL type name=" + pmd.getParameterTypeName(i));
			      }
			 	}
			 	
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}


	}

}
