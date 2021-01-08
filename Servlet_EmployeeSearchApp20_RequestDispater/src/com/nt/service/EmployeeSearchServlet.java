package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//initParams = @WebInitParam(name = "location", value = "D:/Uploads")
@WebServlet(urlPatterns = "/emp", initParams = {
		@WebInitParam(name = "driverClass", value = "oracle.jdbc.driver.OracleDriver"),
		/*
		 * @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:orcl"),
		 */
		@WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:or"),
		@WebInitParam(name = "userName", value = "scott"), @WebInitParam(name = "pwd", value = "tiger") })
@SuppressWarnings("serial")
public class EmployeeSearchServlet extends HttpServlet {

	private static final String GET_EMP_DETAILS = "SELECT EMPNO,ENAME,JOB,SAL  FROM EMP WHERE EMPNO=?";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, NullPointerException {

		ServletContext sct = getServletContext();

		PrintWriter pw = null;
		pw = res.getWriter();

		ServletConfig cnfg = getServletConfig();

		String driverClass = cnfg.getInitParameter("driverClass");
		String url = cnfg.getInitParameter("url");
		String userName = cnfg.getInitParameter("userName");
		String pwd = cnfg.getInitParameter("pwd");

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, userName, pwd);
			ps = con.prepareStatement(GET_EMP_DETAILS);

			String empno1 = req.getParameter("empno");
			int empno = Integer.parseInt(empno1);

			ps.setInt(1, empno);
			rs = ps.executeQuery();

			pw.println("<center color='red'>");
			pw.println("empNO ::" + empno + "<br>");

			if (rs != null) {

				if (rs.next()) {
					pw.println("ENAME ::" + rs.getString(2) + "<br>");
					pw.println("JOB ::" + rs.getString(3) + "<br>");
					pw.println("SAL ::" + rs.getString(4) + "<br>");
				}

				else {
					pw.println("<h1 style='color:red;text-align:center'>Employee not found </h1>");
				}

			} // if

			pw.println("</center>");

		} // try
		catch (Exception  e) {
			System.out.println("EmployeeSearchServlet.doGet() ->Before");
			pw.println("EmployeeSearchServlet.doGet() ->Before");

			// JAVA
//			RequestDispatcher rd = req.getRequestDispatcher("/error"); // your mention url pattern give the '/'
//			RequestDispatcher rd = sct.getRequestDispatcher("/error"); // your mention url pattern give the '/'
//			RequestDispatcher rd = sct.getNamedDispatcher("err"); //logical name '/' is not mandetory

			// HTML CONFIG
//			RequestDispatcher rd = sct.getRequestDispatcher("/errorhtml.html"); // file name
//			RequestDispatcher rd = sct.getRequestDispatcher("/error_htmlurl"); //url pattern
//			RequestDispatcher rd = sct.getNamedDispatcher("error_html"); //logical name '/' is not mandetory

			// JSP FILE CONFIG
			RequestDispatcher rd = sct.getRequestDispatcher("/errorjsp.jsp"); // file name
//			RequestDispatcher rd = sct.getRequestDispatcher("/error_jspurl"); //url pattern
//			RequestDispatcher rd = sct.getNamedDispatcher("error_jsp"); //logical name '/' is not mandetory

			rd.forward(req, res);
	

			/*//we can call multilple forward methods at a time -> first one success fully excuted 2nd one gives illegall argument Excetion
			 * RequestDispatcher rd = sct.getNamedDispatcher("erjsp");
			 * rd.forward(req, res);
			 * 
			 * RequestDispatcher rd = sct.getNamedDispatcher("err");
			 * rd.forward(req, res);
			 * 
			 */

			System.out.println("EmployeeSearchServlet.doGet() ->After");
			pw.println("EmployeeSearchServlet.doGet() ->After");
			
			
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

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}
}
