//EmployerDAO.java
package com.sri.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.sri.beans.Employer;
import com.sri.util.DBConnectionClass;

public class EmployerDAO {
	private static String Select_Query;
	static PreparedStatement ps;

	private Connection con;

	public ArrayList<Employer> al;

	public ArrayList<Employer> retrive(HttpServletRequest req) throws SQLException, ClassNotFoundException, IOException {
		System.out.println("EmployerDAO.retrive()");
		al = new ArrayList<Employer>();
		String name = req.getParameter("name");
		String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);

		con = DBConnectionClass.getConnection();
		if (name.equalsIgnoreCase("admin") && id1.equals("99")) {
			Select_Query = "SELECT NAME ,SALARY FROM t1";
			ps = con.prepareStatement(Select_Query);

		} else {
			Select_Query = "SELECT NAME ,SALARY FROM t1 WHERE NAME=? AND ID=?";
			ps = con.prepareStatement(Select_Query);
			ps.setString(1, name);
			ps.setInt(2, id);
		}

		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Employer er = new Employer();
				er.setName(rs.getString("name"));
				er.setSalary(rs.getInt("salary"));
				al.add(er);
			}
		}
		return al;
	}
}
