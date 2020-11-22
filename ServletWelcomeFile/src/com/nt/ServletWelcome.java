package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletWelcome extends HttpServlet {
	
	@Override  //doPost(-,-) is not support directly 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<center><font size='15' color='green'>Welcome ......<br>");
		pw.println("Servlet-class as a welcome file this program. ");
		pw.println("</font></center>");
	}
	
}
