package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=null;
		Statement st=null;
		Connection con=null;
		int count=0;
		String query;
		String name=null,adrs=null;		
		try{
			//load the drivers. // import the jdbc drivers.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establis the connection to the java to ORACLE DATABASE
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			
			//prepare the Query statement.
			st=con.createStatement();
			
			sc=new Scanner(System.in);
			System.out.println("enter SNo");
			int sno=sc.nextInt();
			System.out.println("enter name");
			name=sc.next();
			System.out.println("enter Address");
			adrs=sc.next();
			System.out.println("enter AVG");
			float avg=sc.nextFloat();
			
			name="'"+name+"'";  //gives 'ramesh' other wise not accept.
			adrs="'"+adrs+"'"; //gives 'delhi'
			
			query="INSERT INTO STUDENT VALUES("+sno+","+name+"," + adrs+","+avg+")";
			
			System.out.println(query);
			
			
			//this is query stmt.
			//query="INSERT INTO STUDENT VALUES(102,'SECOND','2-SRC',99.51)";
			
			//WE CAN USE executeUpdate(euery); is always int TYPE,THIS IS NOT SELECT ONLY OTHER THAN WE USE ALL TIME THIS QUERY.
			count=st.executeUpdate(query); //INT
			
			if(count!=0){
				System.out.println("INSERTED SUCCESS FULL.....");
			}
			else
				System.out.println("INSERTION FAIL.....");
			}
		catch(Exception e){
				e.printStackTrace();
			}
		finally{
			sc.close();
			con.close();
		}

	}

}
