package streams;
/* SQL> create table Artist_INFO (id number(5) not null primary key,name varchar2(10),addrs varchar2(10),income float(10),photo blob);
   SQL> create sequence artist_id_seq minvalue 1 maxvalue 10000 increment by 1 start with 1; */

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PSBlobMySQL {
	private static final String query="INSERT INTO(NAME,ADDRS,INCOME,PHOTOIS) ARTIST_INFO VALUES(?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		String name=null,addrs=null,photoLS=null;
		float income=0.0f;
		InputStream photois=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
			System.out.println("ENTER THE NAME:");
			name=sc.next();
			System.out.println("ENTER THE addrs:");
			addrs=sc.next();
			System.out.println("ENTER THE INCOME:");
			income=sc.nextFloat();
			System.out.println("PHOTO LOCATION:"); // C:\Users\srika\Desktop\vish.jpg
			photoLS=sc.next();
			}
//			create inputeStream file
			photois=new FileInputStream(photoLS);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql:///srikanth","root","root");
			if(con!=null)
			ps=con.prepareStatement(query);
			if(ps!=null){
				ps.setString(1, name);
				ps.setString(2, addrs);
				ps.setFloat(3, income);
//				ps.setBinaryStream(4, photois); // BOTH ARE WORKING
				ps.setBlob(4, photois);
			}
			if(ps!=null)
				count=ps.executeUpdate();
			if(count!=0)
				System.out.println("RECORD'S ARE INSERTED....");
			else
				System.out.println("RECORD'S ARE NOT INSERTED....");
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
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
		}//finally
	} //main
} //class
