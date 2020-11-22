package postgres;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Date_Stream_ps {
//	INSERT INTO public.job_portal(name, dob, dom, doj, photo, resume) VALUES (?, ?, ?, ?, ?, ?);
	private static final String Query="INSERT INTO JOB_PORTAL VALUES (nextval('ID'), ?, ?, ?, ?, ?,?)";//

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		String name=null,dob=null,dom=null,doj=null,img=null,pdf=null;
		java.sql.Date sd1=null,sd2=null,sd3=null;
		InputStream is=null;
		Reader r=null;  
		Scanner sc=null;
		int count=0;
		try{
			sc=new Scanner(System.in);
			
			if(sc!=null){
			System.out.println("ENTER THE NAME:");
			name=sc.next();
			
			System.out.println("ENTER THE DOB:");
			dob=sc.next();
			sd1=java.sql.Date.valueOf(dob); //String convert directly to sql date
			
			System.out.println("ENTER THE DOM:");
			dom=sc.next();
			sd2=java.sql.Date.valueOf(dom); //String convert directly to sql date
			
			System.out.println("ENTER THE DOJ:");
			doj=sc.next();
			sd3=java.sql.Date.valueOf(doj); //String convert directly to sql date
			
			System.out.println("ENTER THE IMAGE_LOCATION:");
			img=sc.next();
			is=new FileInputStream(img); //blob /BinarySteame
			
			System.out.println("ENTER THE FILE_LOCATION:");
			pdf=sc.next();
			r=new FileReader(pdf); //Clob /CharectorStreame
			}
			
			System.out.println("1"+name+" "+sd1+" "+sd2+" "+sd3+" "+is+" "+r);
			
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql:srikanth","postgres","root");
			if(con!=null)
				ps=con.prepareStatement(Query);
			if(ps!=null){
				ps.setString(1,name);
				ps.setDate(2, sd1);
				ps.setDate(3, sd2);
				ps.setDate(4, sd3);
				ps.setBinaryStream(5, is); //C:/Users/srika/Desktop/padi.jpg
				ps.setCharacterStream(6, r);  //C:\Users\srika\Desktop\text.txt.txt
				System.out.println("2"+name+" "+sd1+" "+sd2+" "+sd3+" "+is+" "+r); //checking data inserted or not
				count=ps.executeUpdate();
				System.out.println("3"+name+" "+sd1+" "+sd2+" "+sd3+" "+is+" "+r); //checking data inserted or not
			}
			if(count!=0){
				System.out.println("INSERT SUCCESFULLY....");
			}
			else{
				System.out.println("INSERT FAILED....");
			}
		}catch(SQLException se){
			se.printStackTrace();	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(ps!=null){
					ps.close();
				}
			}
				catch(SQLException se){
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
			try{
				if(sc!=null){
					sc.close();
				}
			}
				catch(Exception se){
					se.printStackTrace();
			}
		} //finally
	} //main
} //class
