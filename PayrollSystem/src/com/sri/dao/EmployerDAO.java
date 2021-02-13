//EmployerDAO.java
package com.sri.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sri.bo.EmployerBO;
import com.sri.util.DBConnectionClass;

public class EmployerDAO implements IEmployer {
	private static String Select_Query;
	static PreparedStatement ps, ps1;
	private Connection con;
	// create sequence and dynamic
//	SQL> create sequence t1ID start with 1  increment by 1;
//	insert into t1(id,name,salary) values(t1id.nextval,'mama',10000);
//	SELECT ID FROM t1 WHERE NAME='sri';
	private final static String insert_Query = "INSERT INTO T1(ID,NAME,SALARY) VALUES(T1ID.NEXTVAL,? , ?)";
	private final static String select_Query = "SELECT ID FROM t1 WHERE NAME=?";
	int i;

	// delete from t1 where id=12 and name='as';
	private final static String Delete_Query = "DELETE FROM T1 WHERE ID=? and name=?";

	// update t1 set name='b',salary=7000 where id=12;
	private final static String Update_Query = "UPDATE T1 SET NAME=?,SALARY=? WHERE ID=?";

	public ArrayList<EmployerBO> al;

	@Override
	public ArrayList<EmployerBO> retrive(EmployerBO bo) {
		System.out.println("EmployerDAO.retrive()");
		al = new ArrayList<EmployerBO>();
		String name = bo.getName();
		int id = bo.getId();
		try {
			con = DBConnectionClass.getConnections();
			if (name.equalsIgnoreCase("admin") && id == 99) {
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
					bo = new EmployerBO();
					bo.setName(rs.getString("name"));
					bo.setSalary(rs.getInt("salary"));
					al.add(bo);
				}
			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} // catch
		return al;
	}

	@Override
	public int insert(EmployerBO bo){

		try {
			con = DBConnectionClass.getConnections();
			ps = con.prepareStatement(insert_Query);
			String name = bo.getName();

			if (ps != null) {
				ps.setString(1, name);
				ps.setDouble(2, bo.getSalary());
				i = ps.executeUpdate();

				if (i != 0) {
					ps1 = con.prepareStatement(select_Query);
					ps1.setString(1, name);
					ResultSet rs = ps1.executeQuery();
					if (rs != null) {
						while (rs.next())
							bo.setId(rs.getInt("id"));
						System.out.println("1.." + bo.getId());
					}
				}

			} // if
		} // try

		catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} // catch
		return i;

	}// method

	@Override
	public int delete(EmployerBO bo) {

		try {
			con = DBConnectionClass.getConnections();
			ps = con.prepareStatement(Delete_Query);

			if (ps != null) {
				ps.setInt(1, bo.getId());
				ps.setString(2, bo.getName());
				i = ps.executeUpdate();
			} // if
		} // try

		catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} // catch
		return i;

	}// method

	@Override
	public int update(EmployerBO bo) {

		try {
			con = DBConnectionClass.getConnections();
			ps = con.prepareStatement(Update_Query);

			if (ps != null) {
				ps.setString(1, bo.getName());
				ps.setDouble(2, bo.getSalary());
				ps.setInt(3, bo.getId());
				i = ps.executeUpdate();
			} // if
		} // try

		catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} // catch
		return i;

	}// method

}
