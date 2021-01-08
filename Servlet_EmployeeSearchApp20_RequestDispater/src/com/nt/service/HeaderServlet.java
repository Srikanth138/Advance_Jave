package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/HeaderServletUrl" , name="Header")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1 style=color:red ;><marquee>Welcome  "+new java.util.Date()+"</marquee></h1>");
		
		//don't close the pw. because we can close that not display the output of response  i.e do not commit response
		//pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
