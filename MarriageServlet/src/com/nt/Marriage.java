package com.nt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Marriage extends HttpServlet {
	
	PrintWriter pw;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("Marriage.doGet()");
		//response type
	res.setContentType("text/html");
		// print in console
	pw=res.getWriter();
	String name=req.getParameter("name");
	String age1=req.getParameter("age"); 
	String gender=req.getParameter("gender");
	
	if(name==""){
		pw.println("NAME IS MUST");
		return; // return type is void is not return any think to method but THIS RETURN IS NOT-EXECUTE NEXT/REST OF LINE'S	
		}
	else if(name.length()<5){
		pw.println("NAME IS MUST BE 5 CHARECTER'S");
		return;
	}
	
	if(age1==""){
		pw.println("NAME IS MUST");
		return;
	}
	else{
		int age=Integer.parseInt(age1);
		if(age<1 || age>125){
	
		pw.println("age betWeen 1 to 125");
		return;
		}
	}
	
	
	pw.println("<center>");
	//pw.println("<body background='image/backimg.jpg' > ");
	pw.println("<body bgcolor='lightpink'> ");
	pw.println("<img src='image/backimg.jpg' width=400 height=200> ");

	if(gender.equalsIgnoreCase("male")){
		int age=Integer.parseInt(age1);
	if(age>=21){
		pw.println("<h1 style='color:red; text-align:center;'>Welcome YouR Eligible for Marrige Mr."+name+" Best of luck" +age+", "+gender+"<h1>");
	}
	else{
		pw.println("<h1 style='color:green; text-align:center;'>YouR Not Eligible for Marrige Mr."+name+"</br> Wait for "+(21-age)+"Year "+gender+"</h1>");		
	}
	}
	
	else{ //if(gender.equalsIgnoreCase("FeMale"))
		int age=Integer.parseInt(age1);
		if(age>=18){
			pw.println("<h1 style='color:red; text-align:center;'> Welcome YouR Eligible for Marrige Miss."+name+" Best of luck" +age+", "+gender+"</h1>");
		}
		else{
			pw.println("<h1 style='color:green; text-align:center;'>YouR Not Eligible for Marrige Miss."+name+"</br> Wait for " +(18-age)+"Year "+gender+"</h1>");	
		}
		}
	pw.println("</center>");
	pw.println("<br></br> <a href='input.html'><img alt='home' src='image/home.jpg' width='50' height='50'> </a>");
	
	pw.close();
	}//method
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Marriage.doPost()");
		doGet(req,res);
	}
	
}//class
