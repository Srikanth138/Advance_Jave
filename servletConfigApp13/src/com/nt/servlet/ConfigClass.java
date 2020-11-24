package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigClass extends HttpServlet{
	
	ServletConfig scf;
	public void init(ServletConfig scf){
		this.scf=scf;
		
		System.out.println(scf.getInitParameter("username"));
		System.out.println(scf.getInitParameter("password"));
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		pw.println("Db User name is the ::"+scf.getInitParameter("username").toUpperCase()+"<br>");
		pw.println("Db Password is the ::"+scf.getInitParameter("password").toUpperCase()+"<br>");
	}
	public void destory(){
		
		
	}

}
