//EmployerDAO.java
package com.sri.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import com.sri.bo.EmployerBO;
import com.sri.util.DBConnectionClass;

public class EmployerDAO implements IEmployer {
	private static Connection con;
	static PreparedStatement ps, ps1;
	int i;
	private final static String Select_employer = "SELECT * FROM EMPLOYER";
	private final static String Select_Query = "SELECT ID,NAME ,SALARY FROM EMPLOYEE1";
	private final static String Select_Query1 = "SELECT ID,NAME ,SALARY FROM EMPLOYEE1 WHERE NAME=? AND ID=?";
	private final static String insert_Query = "INSERT INTO EMPLOYEE1(ID,NAME,SALARY) VALUES(T1ID.NEXTVAL,? , ?)";
	private final static String select_Query2 = "SELECT ID FROM EMPLOYEE1 WHERE NAME=?";
	private final static String Delete_Query = "DELETE FROM EMPLOYEE1 WHERE ID=? and name=?";
	private final static String Update_Query = "UPDATE EMPLOYEE1 SET NAME=?,SALARY=? WHERE ID=?";

	public ArrayList<EmployerBO> al;

	@Override
	public ArrayList<EmployerBO> employerRetrive(EmployerBO bo) {
		String name = bo.getName();

		int id = bo.getId();

		System.out.println(name + " " + id);
		al = new ArrayList<EmployerBO>();
		try {
			con = DBConnectionClass.getConnections();
			ps1 = con.prepareStatement(Select_employer);
			ResultSet rs1 = ps1.executeQuery();
			if (rs1 != null) {
				rs1.next();
				if (rs1.getInt("id") == id && rs1.getString("name").equals(name)) {
					ps = con.prepareStatement(Select_Query);
					ResultSet rs = ps.executeQuery();
					if (rs != null) {
						while (rs.next()) {
							bo = new EmployerBO();

							bo.setId(rs.getInt("id"));
							bo.setName(rs.getString("name"));
							bo.setSalary(rs.getInt("salary"));

							al.add(bo);
						} // while
					} // if
				} // if
			} // if
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} // catch
		return al;
	}

	@Override
	public ArrayList<EmployerBO> retrive(EmployerBO bo) {
		String name = bo.getName();
		int id = bo.getId();

		System.out.println(name + " " + id);
		al = new ArrayList<EmployerBO>();
		try {
			con = DBConnectionClass.getConnections();
			ps = con.prepareStatement(Select_Query1);
			ps.setString(1, name);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					bo = new EmployerBO();

					bo.setName(name);
					bo.setSalary(rs.getInt("salary"));

					System.out.println("e----------d");

					al.add(bo);
				}
			}
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} // catch
		return al;
	}

	@Override
	public int insert(EmployerBO bo) {

		try {
			con = DBConnectionClass.getConnections();
			ps = con.prepareStatement(insert_Query);

			// encode
			String name = bo.getName();
			System.out.println(name);

			if (ps != null) {
				ps.setString(1, name);
				ps.setDouble(2, bo.getSalary());
				i = ps.executeUpdate();

				if (i != 0) {
					ps1 = con.prepareStatement(select_Query2);

					ps1.setString(1, name);
					ResultSet rs = ps1.executeQuery();
					if (rs != null) {
						while (rs.next())
							bo.setId(rs.getInt("id"));
						System.out.println("1....." + bo.getId());
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
