//EmployerDAO.java
package com.sri.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.sri.bo.EmployerBO;
import com.sri.util.DBConnectionClass;

public class EmployerDAO {
	private static String Select_Query;
	static PreparedStatement ps;

	private Connection con;

	public ArrayList<EmployerBO> al;

	public ArrayList<EmployerBO> retrive(EmployerBO bo) throws SQLException, ClassNotFoundException, IOException, NamingException {
		System.out.println("EmployerDAO.retrive()");
		al = new ArrayList<EmployerBO>();
		String name=bo.getName();
		int id=bo.getId();
		

		con = DBConnectionClass.getConnections();
		if (name.equalsIgnoreCase("admin") && id==99) {
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
			while(rs.next()) {
				bo=new EmployerBO();
				bo.setName(rs.getString("name"));
				bo.setSalary(rs.getInt("salary"));
				al.add(bo);
			}
		}
		return al;
	}
}
