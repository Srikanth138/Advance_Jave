package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EmployeeSearchServlet extends HttpServlet {

	private static final String GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL  FROM EMP WHERE EMPNO=?";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		PrintWriter pw = null;
		pw = res.getWriter();
		
		ServletConfig cnfg=getServletConfig();
		
		String driverClass=cnfg.getInitParameter("driverClass");
		String url=cnfg.getInitParameter("url");
		String userName=cnfg.getInitParameter("userName");
		String pwd=cnfg.getInitParameter("pwd");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		

		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, userName,pwd);
			ps = con.prepareStatement(GET_EMP_DETAILS);

			String empno1=req.getParameter("empno");
			int empno = Integer.parseInt(empno1);
			
			ps.setInt(1, empno);
			rs = ps.executeQuery();

			pw.println("<center color='red'>");
			pw.println("empNO ::" + empno + "<br>");

			if (rs != null) {
				
				if(rs.next()) {
					pw.println("ENAME ::" + rs.getString(2) + "<br>");
					pw.println("JOB ::" + rs.getString(3) + "<br>");
					pw.println("SAL ::" + rs.getString(4) + "<br>");
				}
				
				else {
					pw.println("<h1 style='color:red;text-align:center'>Employee not found </h1>");				}
				
			}//if
			
			pw.println("</center>");

		} //try
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		pw.println("<br><br> <a href='input.html'>home </a>");
		// close stream
		pw.close();

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doGet(req, res);
	}
}
