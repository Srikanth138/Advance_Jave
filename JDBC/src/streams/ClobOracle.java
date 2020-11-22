package streams;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ClobOracle {
//	create sequence job_id_seq start with 1000 increment by 1;
//	create table job_potal(ID number(10),name varchar2(10),addres varchar2(10),phno number(12),resume clob);
	private static final String Query="insert into job_potal values(job_ID_SEQ.NEXTVAL,?,?,?,?)";
	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		String name=null,addres=null,fileLocation=null;
		int count=0;
		long phno=0;
		Reader read=null;
		try{
			sc=new Scanner(System.in);
			System.out.println("ENTER THE NAME  :");
			name=sc.next();
			System.out.println("ENTER THE ADDRES :");
			addres=sc.next();
			System.out.println("ENTER THE PHONE NO :");
			phno=sc.nextLong();
			System.out.println("ENTER THE FILELOCATION :"); //C:\Users\srika\Desktop\text.txt.txt
			fileLocation=sc.next();
			//string conver to file format
			read=new FileReader(fileLocation);
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			if(con!=null){
				ps=con.prepareStatement(Query);	
			}
			if(ps!=null){
				ps.setString(1,name);
				ps.setString(2,addres);
				ps.setLong(3,phno);
				ps.setCharacterStream(4,read);
				
				count=ps.executeUpdate();
			}
			if(count!=0)
				System.out.println("RECORD'S ARE INSERTEDE....");
			else{
				System.out.println("RECORD'S ARE NOT INSERTEDE....");
			}
		}catch(SQLException se){
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
	}

}
