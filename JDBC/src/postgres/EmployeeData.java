package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeData {
//	INSERT INTO public.employees_data("Name", "Gender", "DateofJoining ", "DateofBirth ", "EmpId", pan) VALUES (?, ?, ?, ?, ?, ?);
	private final static String insert_Query = "INSERT INTO EMPLOYEES_DATA(\"Name\", \"Gender\", \"DateofJoining \", \"DateofBirth \", pan) VALUES ( ?, ?, ?, ?, ?)"; //nextval('EmpID'),
	
	//Oracle
//	private final static String insert_Query = "INSERT INTO EMPLOYEES_DATA VALUES (empid_seq.NEXTVAL, ?, ?, ?, ?, ?)";

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		String name = null, gender = null, pan = null, dob = null, doj = null;
		java.sql.Date sd1 = null, sd2 = null;
		Scanner sc = null;
		int count = 0;
		try {
			sc = new Scanner(System.in);

			if (sc != null) {
				System.out.println("ENTER THE NAME:");
				name = sc.next();

				System.out.println("gender");
				gender = sc.next();

				System.out.println("pan");
				pan = sc.next();

				System.out.println("ENTER THE DOB:");
				dob = sc.next();
				sd1 = java.sql.Date.valueOf(dob); // String convert directly to sql date

				System.out.println("ENTER THE DOJ:");
				doj = sc.next();
				sd2 = java.sql.Date.valueOf(doj); // String convert directly to sql date
			}

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql:srikanth", "postgres", "root");
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			if (con != null)
				ps = con.prepareStatement(insert_Query);
			if (ps != null) {
				
//				Name, Gender, DateofBirth ,DateofJoining , pan
				ps.setString(1, name);
				ps.setString(2, gender);
				ps.setDate(3, sd1);
				ps.setDate(4, sd2);
				ps.setString(5, pan); 
				System.out.println("2" + name + " " + sd1 + " " + sd2 + " "+pan+""+gender); // checking
																											
				count = ps.executeUpdate();
				System.out.println("3" + name + " " + sd1 + " " + sd2 + " " + pan+""+gender); // checking																							
			}
			if (count != 0) {
				System.out.println("INSERT SUCCESFULLY....");
			} else {
				System.out.println("INSERT FAILED....");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (sc != null) {
					sc.close();
				}
			} catch (Exception se) {
				se.printStackTrace();
			}
		} // finally
	} // main
} // class
