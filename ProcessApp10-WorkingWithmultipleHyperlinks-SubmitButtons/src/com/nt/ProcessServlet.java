package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ProcessServlet extends HttpServlet{
	
	 @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 
		 res.setContentType("text/html");
		 PrintWriter pw=res.getWriter();
		  String pval=req.getParameter("s1");
		  float val1=0,val2=0;
		  if(!pval.equalsIgnoreCase("link1") && !pval.equalsIgnoreCase("link2")){ //(!pval==link1) => not a value
			  val1=Float.parseFloat(req.getParameter("t1"));
			  val2=Float.parseFloat(req.getParameter("t2"));
		  }
		//write b.logic or request processing logic
		  if(pval.equalsIgnoreCase("add")){
			  pw.println("<h1 style='color:red;text-align:center'>Subtraction (add) is ::"+(val1+val2)+"</h1>");
		  }
		  else if(pval.equalsIgnoreCase("sub")) {
				pw.println("<h1 style='color:red;text-align:center'>Subtraction (Sub) is ::"+(val1-val2)+"</h1>");
			}
			else if(pval.equalsIgnoreCase("mul")) {
				pw.println("<h1 style='color:red;text-align:center'>Product (mul) is ::"+(val1*val2)+"</h1>");
			}
			else if(pval.equalsIgnoreCase("div")) {
				pw.println("<h1 style='color:red;text-align:center'>Divsion (div) is ::"+(val1/val2)+"</h1>");
			}
			else if(pval.equalsIgnoreCase("link1")) {
				pw.println("<h1 style='color:red;text-align:center'>System date and time:: "+new Date()+"</h1>");
			}
			else {
				pw.println("<h1 style='color:red;text-align:center'>System properties are:: "+System.getProperties()+"</h1>");
			}
			//add hyperlink
			pw.println("<br><br> <a href='input.html'>home </a>");
			//close stream
			pw.close();
	}//doGet(-,-)
	 
	 @Override
	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
