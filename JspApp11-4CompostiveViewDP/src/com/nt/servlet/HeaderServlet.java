package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerurl")
@SuppressWarnings("serial")
public class HeaderServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<marquee style='color:red'>Header use marquee</marquee>"
				+ " <br><center>hello</center>");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doGet(req, res);
	}
}
