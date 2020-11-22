 package postgres;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class Date_Stream_ps_Retrive {
//	private static final String Query="SELECT id, name, dob, dom, doj, photo, resume FROM public.job_portal;";
	private static final String Query="SELECT id, name, dob, dom, doj, photo, resume FROM public.job_portal where id=?";

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		int id=0;
		String name=null;
		InputStream is=null; 
		OutputStream os=null;
		Reader r=null;  
		Writer w=null;
		ResultSet rs=null;
		Scanner sc=null;
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
			System.out.println("enter the id :");
			id=sc.nextInt();
			}
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql:srikanth","postgres","root");
			if(con!=null)
				ps=con.prepareStatement(Query);
			if(ps!=null){
				ps.setInt(1, id);
				rs=ps.executeQuery();
			}
			if(rs!=null)
				while(rs.next()){
				id=rs.getInt(1);
				name=rs.getString(2);
				is=rs.getBinaryStream(6);
				r=rs.getCharacterStream(7);
				System.out.println(id+" "+name+" "+rs.getDate(3)+" "+rs.getDate(4)+" "+rs.getDate(5)+" "+rs.getBinaryStream(6)+" "+rs.getCharacterStream(7));				
				}
				os=new FileOutputStream("img1.jpg");
				w=new FileWriter("text.txt");
				if(os!=null && w!=null){
					IOUtils.copy(is, os);
					IOUtils.copy(r,w);
					System.out.println("FILES ARE SUCCESSFULLY COPIED...");
			}
			else 
				System.out.println(" file....");
		}
		catch(SQLException se){
			se.printStackTrace();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null){
					rs.close();
				}
			}
				catch(SQLException se){
					se.printStackTrace();
			}
			try{
				if(ps!=null){
					ps.close();
				}
			}
				catch(SQLException se){
					se.printStackTrace();
			}
			try{
				if(sc!=null){
					sc.close();
				}
			}
				catch(Exception se){
					se.printStackTrace();
			}
			try{
				if(con!=null){
					con.close();
				}
			}
				catch(SQLException se){
					se.printStackTrace();
			}
			try{
				if(r!=null && is!=null){
					r.close();
					is.close();
				}
			}
				catch(Exception e){
					e.printStackTrace();
			}
		} //finally
	} //main
} //class
