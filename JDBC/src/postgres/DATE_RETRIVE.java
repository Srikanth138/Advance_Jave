package postgres;
/* SELECT CURRENT_DATE; // current date
 * select CURRENT_DATE - interval '1 year';
 * select now(); //current date and time 
 * select now() - interval '1 year'*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DATE_RETRIVE {
//	SELECT id, name, dob, dom, doj, photo, resume, age(now(),dob) as years FROM job_portal;
	private static final String Query="SELECT id, name, dob, dom, doj, photo, resume, age(now(),dob) as years FROM job_portal where id=?";
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		int id=0;
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
			if(rs!=null){
				rs.next();
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDate(3));
				System.out.println(rs.getDate(4));
				System.out.println(rs.getDate(5));
				System.out.println(rs.getBinaryStream(6));
				System.out.println(rs.getCharacterStream(7));
				System.out.println(rs.getString(8)); //System.out.println(rs.getString("years")); 
			}
			String d1="19-11-1996";
			SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date ud1=sdf.parse(d1);
			System.out.println(" this"+ud1);
			
			java.util.Date d=new java.util.Date();
			long ms=d.getTime();
			java.sql.Date sd=new java.sql.Date(ms);	
			System.out.println(sd);
			
			
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
		}//finally
	} //main
} //class
