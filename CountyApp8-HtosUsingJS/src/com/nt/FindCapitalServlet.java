package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FindCapitalServlet extends HttpServlet {
	
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		int countryCode=Integer.parseInt(req.getParameter("county"));
		String capitals[]={"New Delhi","Bejing","WeshingtoneDC","Berlin","Tokyo"};
		pw.println("<h1 style='color:red;text-align:center'>Captial City name is::"+capitals[countryCode]+"</h1>");
		pw.println("<br><a href='input.html'>home</a>");
		pw.close();
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		doPost(req, res);
	}
}
