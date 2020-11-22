package delete;
import java.sql.*;
import java.util.Scanner;
public class DeleteTest {

	public static void main(String[] args)  {
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		int sno=0;
		ResultSet rs=null;
		Scanner sc=null;
		try{
			sc=new Scanner(System.in);
			if(sc!=null){
			System.out.println("ENTER YOUR DELETE SNO:");
			sno=sc.nextInt();
			}
//		loading the drivers are optional.	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			if(con!=null)
				st=con.createStatement();
			
			//delete from student where sno=103;
			query= "delete from student where sno="+sno;
			
			if(st!=null){
				rs=st.executeQuery("select *from student where sno="+sno); //select 
				while(rs.next())
					System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getFloat(4));
	      
				count=st.executeUpdate(query); //delete
				System.out.println(query);
			}
			if(count!=0){
				if(rs!=null)
					System.out.println("	DELETION IS SUCESS FULL");
					
				}
			else
				System.out.println("	THIS "+ sno + " IS NOT THERE IN DB TABLE");
				
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
		finally{
			sc.close();
			
			try{
				con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			
		}

	}

}
