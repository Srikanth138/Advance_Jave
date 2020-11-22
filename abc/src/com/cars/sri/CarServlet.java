package com.cars.sri;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		//res.setHeader("refresh", "100");
		
		String name=req.getParameter("a1");

		pw.println("<center>");
		pw.println("<br>WELCOME TO HYDERABAD CAR'S");
			pw.println("<br><img src='images/backimg.jpg' height='100' widht='100'>" );	
		
		if(name.equalsIgnoreCase("MarthiSuziki")){
			pw.println("<br> "+name);
			
		}
		else if(name.equalsIgnoreCase("hyundai")){
			pw.println("<br> "+name);
			
		}
		else if(name.equalsIgnoreCase("tata")){
			pw.println("<br> "+name);
			
		}
		else if(name.equalsIgnoreCase("tayota")){
			pw.println("<br> "+name);
			
		}
		else{
			//mahindra
			pw.println("<br> "+name);
		}
		
		pw.println("</center>");
			
		pw.println("<br><a href='input.html'><img src='images/home.jpg' height='50' widht='50'></a>");
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
