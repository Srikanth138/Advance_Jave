package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private final static String Query = "INSERT INTO PERSON_INFO(PNAME,FATHERNAME,MS,INFO1,INFO2)VALUES(?,?,?,?,?)";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");

		HttpSession sh = req.getSession(false);
		String name = (String) sh.getAttribute("name");
		String father = (String) sh.getAttribute("father");
		// read form2/req2 data
		String f2val1 = req.getParameter("f2t1");
		String f2val2 = req.getParameter("f2t2");

		// Generate dynamic web page displaying form1/req1 data and form2/req2 data
		pw.println("<b>form1 /req1 data is ::" + name + "...." + father + "...." + sh.getAttribute("ms") + "</b>");
		pw.println("<br><b>form2 /req2 data is ::" + f2val1 + "      " + f2val2 + "</b>");

		// add home hyperlink
		pw.println("<br> <a href='form1.html'>home </a>");
		// close stream
		pw.close();
	}// doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}
