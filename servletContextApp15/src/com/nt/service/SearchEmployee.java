package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@SuppressWarnings("serial")
public class SearchEmployee extends HttpServlet {
	
	private static final String GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL  FROM EMP WHERE EMPNO=?";
	
	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		ServletContext sc=getServletContext();
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String driverClass=sc.getInitParameter("driverClass");
		String url=sc.getInitParameter("url");
		String userName=sc.getInitParameter("userName");
		String pwd=sc.getInitParameter("pwd");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		res.setIntHeader("refresh",1000); //refer the page
		
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
					pw.println("<br>Server INFO ::"+sc.getServerInfo());
					pw.println("<br>Server api Version::"+sc.getMajorVersion()+"."+sc.getMinorVersion());
					pw.println("<br>Server MimeType::"+sc.getMimeType("/input.html"));
					pw.println("<br>Absolute path of input.html::"+sc.getRealPath("/input.html"));
					pw.println("<br>Absolute path of WebApplication ::"+sc.getRealPath("/"));
					
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
	}*/
	
	
	//Refer the Dec17.png and Deployed to the Wildfly server to run
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  //get PrintWriter obj
		PrintWriter pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		String empno1=req.getParameter("empno");
		int empno = Integer.parseInt(empno1);
		
		//get access to servletcontext obj
		ServletContext sc=getServletContext();
		
		//read context param value
		String jndiName=sc.getInitParameter("jndi");
		try(Connection con=getPooledJdbcConnection(jndiName)) {
		 if(con!=null)
			 try(PreparedStatement ps=con.prepareStatement(GET_EMP_DETAILS)){
				if(ps!=null) {
				//set values to query params
			 	ps.setInt(1, empno);
		
				//excecute the query
			 	ResultSet rs = ps.executeQuery();
			 	
			 	pw.println("</center>");
				//process the result
			 	if (rs != null) {
					
					if(rs.next()) {
						
						pw.println("ENAME ::" + rs.getString(2) + "<br>");
						pw.println("JOB ::" + rs.getString(3) + "<br>");
						pw.println("SAL ::" + rs.getString(4) + "<br>");
						pw.println("<br>Server INFO ::"+sc.getServerInfo());
						pw.println("<br>Server api Version::"+sc.getMajorVersion()+"."+sc.getMinorVersion());
						pw.println("<br>Server MimeType::"+sc.getMimeType("/input.html"));
						pw.println("<br>Absolute path of input.html::"+sc.getRealPath("/input.html"));
						pw.println("<br>Absolute path of WebApplication ::"+sc.getRealPath("/"));
						
					}//if
					
					else {
						pw.println("<h1 style='color:red;text-align:center'>Employee not found </h1>");				
						}//else
					
				}//if
				
				pw.println("</center>");
				
			}//if1
		}//try2
		 
		catch(Exception e) {
			pw.println("<h1 style='color:red;text-align:center'>Problem in record insertion </h1>");
			e.printStackTrace();
		}//catch
		 
		//add home hyperlink
		pw.println("<br> <a href='input.html'>home</a>");
		// close stream
			pw.close();
		} //try2
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//catch
		}//doGet(-,-)
	
	//helper method for other methods of the same class
	  private Connection  getPooledJdbcConnection(String jndiName) throws Exception{
		  //create InitialContext obj to establish the connection  Jndi registry
		  InitialContext ic=new InitialContext();
		  //get Datasource obj through lookup operation
		  DataSource ds=(DataSource)ic.lookup(jndiName); 
		  //get Pooled jdbc con object
		  Connection con=ds.getConnection();
		  return con;
	  }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         doGet(req,res);
	}
	 
	 
}//class