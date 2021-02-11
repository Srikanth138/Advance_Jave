//RegisterDAO.javas
package com.sri.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.sri.bo.EmployerBO;
import com.sri.util.DBConnectionClass;

public class DeleteDAO {
	// delete from t1 where id=12 and name='as';

	private final static String Delete_Query = "DELETE FROM T1 WHERE ID=? and name=?";

	int i;

	public int delete(EmployerBO bo) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// calling the connection (OR) Creating the connection
		Connection con = DBConnectionClass.getConnections();
		try {
			PreparedStatement ps = con.prepareStatement(Delete_Query);

			if (ps != null) {
				ps.setInt(1, bo.getId());
				ps.setString(2, bo.getName());
				i = ps.executeUpdate();
			} // if
		} // try

		catch (SQLException e) {
			e.printStackTrace();
		} // catch
		return i;

	}// method

}// class
