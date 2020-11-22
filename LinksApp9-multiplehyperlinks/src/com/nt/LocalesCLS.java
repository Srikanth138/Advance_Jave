package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocalesCLS extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		//get All available Locales
		
		Locale lcl[]=Locale.getAvailableLocales();
		
		String s1=req.getParameter("s1");
		
		if(s1.equalsIgnoreCase("Citys")){
			pw.println("All Languages ::");
			for(Locale l:lcl){
				pw.println("<br><b>"+l.getDisplayLanguage()+"</b>");
			}
			
		}
		else if(s1.equalsIgnoreCase("Area")){
			pw.println("All counstries are ::");
	 	      for(Locale l: lcl) {
	 	    	    pw.println("<br><b>"+l.getDisplayCountry()+"</b>");
	 	      }
		}
		else{
			pw.println("System.getProperties ::"+System.getProperties());
		}
		
		pw.println("<br><a href='input.html'>home</a>");
	}//doGet(-,-)
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)

}//class