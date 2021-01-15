package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.nt.db.DBConnection;

@SuppressWarnings("serial")
public class RegisterDAO extends HttpServlet {

	private final static String insert_Query = "INSERT INTO public.employees_data(\r\n" + "	\"Name\", \"Gender\", \"DateofJoining \", \"DateofBirth \", pan, \"Qualification\")\r\n" + "	VALUES ( ?, ?, ?, ?, ?, ?);";

	int i;
	public int insert(HttpServletRequest req) {
		// calling the connection (OR) Creating the connection
		Connection con = DBConnection.getCon();
		
		// Accept the input values
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String pan = req.getParameter("pan");

		String dob = req.getParameter("dob");
		java.sql.Date dob1 = java.sql.Date.valueOf(dob);

		String doj = req.getParameter("doj");
		java.sql.Date doj1 = java.sql.Date.valueOf(doj);
		
		String qlf = req.getParameter("qlf");
		try {
			PreparedStatement ps = con.prepareStatement(insert_Query);

			if (ps != null) {
				ps.setString(1, name);
				ps.setString(2, gender);
				ps.setDate(3, dob1);
				ps.setDate(4, doj1);
				ps.setString(5, pan);
				ps.setString(6, qlf);

				 i = ps.executeUpdate();
			}//if

		} // try

		catch (SQLException e) {
			e.printStackTrace();
		} // catch
		return i;

	}// method

}// class
