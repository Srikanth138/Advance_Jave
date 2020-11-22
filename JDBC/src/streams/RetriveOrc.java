package streams;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class RetriveOrc {
//	SQL> select id,name,addrs,income,photo from artist_info where id=2;
	private static final String Query="SELECT ID,NAME,ADDRS,INCOME,PHOTO FROM ARTIST_INFO WHERE ID=?";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Scanner sc=null;
		int id=0;
		String name=null,addrs=null;
		float income=0.0f;
		InputStream photois=null;
		OutputStream photoOs=null;
		try{
			sc=new Scanner(System.in);
			System.out.println("ENTER THE ID : ");
			id=sc.nextInt();
			con=DriverManager.getConnection("jdbc:mysql:///srikanth","root","root");
//			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
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
				income=rs.getFloat(4);
				photois=rs.getBinaryStream(5);
				System.out.println(id+" "+name+" "+addrs+" "+income+" "+photois);
//				photoOs=new FileOutputStream("photo.jpg");
				photoOs=new FileOutputStream("photomysql.jpg"); //destination location
				if(photois!=null){
					IOUtils.copy(photois, photoOs); //External jar download and add here
					System.out.println("BLOB VALUES ARE RETRIVED .....");
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
				if(photois!=null && photoOs!=null)
					photois.close();
					photoOs.close();
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
}  //class
