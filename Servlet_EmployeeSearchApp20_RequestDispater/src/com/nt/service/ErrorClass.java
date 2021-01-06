package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/error")
@SuppressWarnings("serial")
public class ErrorClass extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<h1 style=color:red; text-align:center;>500 Error </h1>");
		pw.println("<br><br> <a href='input.html'>home </a>");
		
		pw.close();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		doGet(req,res);
	}

}
