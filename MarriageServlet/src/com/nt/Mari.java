package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mari extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		System.out.println("Mari.doPost()");
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<br></br> <a href='input.html'><img alt='home' src='image/home.jpg' width='50' height='50'> </a>");
	}
}
