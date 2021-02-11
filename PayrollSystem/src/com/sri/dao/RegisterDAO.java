//RegisterDAO.javas
package com.sri.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.sri.bo.EmployerBO;
import com.sri.util.DBConnectionClass;

public class RegisterDAO {

	// create sequence and dynamic
//	SQL> create sequence t1ID start with 1  increment by 1;
//	insert into t1(id,name,salary) values(t1id.nextval,'mama',10000);
//	SELECT ID FROM t1 WHERE NAME='sri';

	private final static String insert_Query = "INSERT INTO T1(ID,NAME,SALARY) VALUES(T1ID.NEXTVAL,? , ?)";
	private final static String select_Query = "SELECT ID FROM t1 WHERE NAME=?";
	int i;
	public int insert(EmployerBO bo) throws ClassNotFoundException, IOException, SQLException, NamingException {
		// calling the connection (OR) Creating the connection
		Connection con = DBConnectionClass.getConnections();

		try {
			PreparedStatement ps = con.prepareStatement(insert_Query);
			String name = bo.getName();

			if (ps != null) {
				ps.setString(1, name);
				ps.setDouble(2, bo.getSalary());
				i = ps.executeUpdate();

				if (i != 0) {
					PreparedStatement ps1 = con.prepareStatement(select_Query);
					ps1.setString(1, name);
					ResultSet rs = ps1.executeQuery();
					if (rs != null) {
						while (rs.next())
							bo.setId(rs.getInt("id"));
						System.out.println("1.."+bo.getId());
					}
				}

			} // if
		} // try

		catch (SQLException e) {
			e.printStackTrace();
		} // catch
		return i;

	}// method

}// class
