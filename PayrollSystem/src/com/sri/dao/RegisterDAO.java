//RegisterDAO.javas
package com.sri.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.sri.bo.EmployerBO;
import com.sri.util.DBConnectionClass;

public class RegisterDAO {

	private final static String insert_Query = "INSERT INTO t1(id,name,salary)VALUES ( ?, ?, ?)";

	int i;

	public int insert(EmployerBO bo) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// calling the connection (OR) Creating the connection
		Connection con = DBConnectionClass.getConnections();

		try {
			PreparedStatement ps = con.prepareStatement(insert_Query);

			if (ps != null) {
				ps.setInt(1, bo.getId());
				ps.setString(2, bo.getName());
				ps.setDouble(3, bo.getSalary());
				i = ps.executeUpdate();
			} // if
		} // try

		catch (SQLException e) {
			e.printStackTrace();
		} // catch
		return i;

	}// method

}// class