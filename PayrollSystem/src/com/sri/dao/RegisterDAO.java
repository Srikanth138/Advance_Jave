//RegisterDAO.javas
package com.sri.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.sri.util.DBConnectionClass;

@SuppressWarnings("serial")
public class RegisterDAO extends HttpServlet {

	private final static String insert_Query = "INSERT INTO t1(id,name,salary)VALUES ( ?, ?, ?)";

	int i;
	public int insert(HttpServletRequest req) throws ClassNotFoundException, IOException, SQLException {
		// calling the connection (OR) Creating the connection
		Connection con = DBConnectionClass.getConnection();
		
		// Accept the input values
		String id1=req.getParameter("id");
		int id=Integer.parseInt(id1);
		String name = req.getParameter("name");
//		String gender = req.getParameter("gender");
		
		String salary1 = req.getParameter("salary");
		int salary=Integer.parseInt(salary1);

//		String dob = req.getParameter("dob");
//		java.sql.Date dob1 = java.sql.Date.valueOf(dob);
//
//		String doj = req.getParameter("doj");
//		java.sql.Date doj1 = java.sql.Date.valueOf(doj);
//		
//		String qlf = req.getParameter("qlf");
		try {
			PreparedStatement ps = con.prepareStatement(insert_Query);

			if (ps != null) {
				ps.setInt(1,id);
				ps.setString(2, name);
				ps.setInt(3, salary);
//				ps.setDate(3, dob1);
//				ps.setDate(4, doj1);

				 i = ps.executeUpdate();
			}//if

		} // try

		catch (SQLException e) {
			e.printStackTrace();
		} // catch
		return i;

	}// method

}// class
