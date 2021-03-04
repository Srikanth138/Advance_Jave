package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/headerurl")
@SuppressWarnings("serial")
public class HeaderServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException {
		System.out.println("HeaderServlet.doGet()");
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<marquee style='color:red;'>Cource Details are View Here</marquee> <br>");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}
}
