package streams;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class Clob_Retrive {

		private static final String Query="SELECT ID,NAME,ADDRES,PHNO,RESUME FROM JOB_POTAL WHERE ID=?";
		public static void main(String[] args) {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			Scanner sc=null;
			int id=0;
			String name=null,addrs=null;
			long phno=0;
			Reader resumeR=null;
			Writer resumeW=null;
			try{
				sc=new Scanner(System.in);
				System.out.println("ENTER THE ID : ");
				id=sc.nextInt();
//				con=DriverManager.getConnection("jdbc:mysql:///srikanth","root","root");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
				if(con!=null)
					ps=con.prepareStatement(Query);
				if(ps!=null){
					ps.setInt(1,id);
					rs=ps.executeQuery();
				}
				if(rs!=null){
					rs.next();
					id=rs.getInt(1);
					name=rs.getString(2);
					addrs=rs.getString(3);
					phno=rs.getLong(4);
					resumeR=rs.getCharacterStream(5);
					System.out.println(id+" "+name+" "+addrs+" "+phno+" "+resumeR);
					resumeW=new FileWriter("outtext.txt"); //destination location
					if(resumeR!=null && resumeW!=null ){
						IOUtils.copy(resumeR, resumeW); //External jar download and add here
						System.out.println("CLOB VALUES ARE RETRIVED .....");
					}
				}
				else
					System.out.println("RECORDS ARE NOT FOUND....");
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try{
					if(resumeR!=null && resumeW!=null)
						resumeR.close();
						resumeW.close();
				}
				catch(Exception e){
				e.printStackTrace();
				}
				try{
					if(sc!=null)
						sc.close();
				}
				catch(Exception se){
				se.printStackTrace();
				}
				try{
					if(rs!=null)
						rs.close();
				}
				catch(SQLException se){
				se.printStackTrace();
				}
				try{
					if(ps!=null)
						ps.close();
				}
				catch(SQLException se){
				se.printStackTrace();
				}
				try{
					if(con!=null)
						con.close();
				}
				catch(SQLException se){
				se.printStackTrace();
				}
				try{
					if(sc!=null)
						sc.close();
				}
				catch(Exception e){
				e.printStackTrace();
				}
			}
		} //main
}
