package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.nt.beans.EmpBeans;
import com.nt.db.DBConnection;

public class SelectDAO {
	//private final static String select_Query = "SELECT \"Name\", \"Gender\", \"DateofJoining \", \"DateofBirth \", \"EmpId\", pan FROM public.employees_data where \"EmpId\"=? and \"Name\"=?";
	private final static String select_Query = "SELECT \"Name\", \"Gender\", \"DateofJoining \", \"DateofBirth \", \"EmpId\", pan, \"Qualification\" FROM public.employees_data where \"EmpId\"=? and \"Name\"=?";

	public ArrayList<EmpBeans> al = new ArrayList<EmpBeans>();

	public ArrayList<EmpBeans> retrive(HttpServletRequest req) { 
		
		String id = req.getParameter("id");
		int id1 = Integer.parseInt(id);
		String name = req.getParameter("name");
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement(select_Query);
			
			ps.setInt(1,id1);
			ps.setString(2,name);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpBeans bb = new EmpBeans();
				bb.setName(rs.getString("Name"));
				bb.setGender(rs.getString("Gender"));
				bb.setDOB(rs.getDate("DateofBirth "));
				bb.setDOJ(rs.getDate("DateofJoining "));
				bb.setEmpId(rs.getInt("EMPID"));
				bb.setPan(rs.getString("pan"));
				bb.setQlf(rs.getString("Qualification"));
				al.add(bb);
			} // end loop
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}// method
}// class
