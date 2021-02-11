//RegisterDAO.javas
package com.sri.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.sri.bo.EmployerBO;
import com.sri.util.DBConnectionClass;

public class UpdateDAO {
	// update t1 set name='b',salary=7000 where id=12;

	private final static String Update_Query = "UPDATE T1 SET NAME=?,SALARY=? WHERE ID=?";

	int i;

	public int update(EmployerBO bo) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// calling the connection (OR) Creating the connection
		Connection con = DBConnectionClass.getConnections();
		try {
			PreparedStatement ps = con.prepareStatement(Update_Query);

			if (ps != null) {
				ps.setString(1, bo.getName());
				ps.setDouble(2, bo.getSalary());
				ps.setInt(3, bo.getId());
				i = ps.executeUpdate();
			} // if
		} // try

		catch (SQLException e) {
			e.printStackTrace();
		} // catch
		return i;

	}// method

}// class
