package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FormValidation extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String about=req.getParameter("about");
		String gender=req.getParameter("gender");
		String married=req.getParameter("married");
		String language[]=req.getParameterValues("language");//convert array  ->req.getParameterValues("-");
		String qlf=req.getParameter("qlf");
		String hobies[]=req.getParameterValues("Hobies");
		String dob=req.getParameter("dob");
		String month=req.getParameter("month");
		String email=req.getParameter("email");
		String url=req.getParameter("url");
		long salary=Long.parseLong(req.getParameter("salary"));
		long phno=Long.parseLong(req.getParameter("phone"));
		String time=req.getParameter("time");
		String color=req.getParameter("color");
		
		pw.println("<br><b>Name: "+name+"</b>");
		if(age<5) {
			if(gender.equalsIgnoreCase("male")){
			pw.println("<br><b>Mr: "+name+" ur a baby boy</b>");
			}
			else {
				pw.println("<br><b>Miss"+name+" ur a baby girl</b>");
			} //else
		}//if
		else if(age<20){
			if(married.equalsIgnoreCase("married")){
				if(gender.equalsIgnoreCase("male")){
					pw.println("<br><b>Mr:"+name+" ur not eligible marriage boy</b>");
				}
				else {
					pw.println("<br><b>Miss :"+name+" ur not eligible for marriage girl</b>");
				}//else
			}//if -married
		}//else if
		else if(age<50){
			if(married.equalsIgnoreCase("single")){
				if(gender.equalsIgnoreCase("male")){
					pw.println("<br><b>Mr:"+name+" ur eligible for marriage boy</b>");
					}
					else {
						pw.println("<br><b>Miss :"+name+" ur eligible for marriage girl</b>");
					}//else
			}//if-married
			else{
				if(gender.equalsIgnoreCase("male")){
					pw.println("<br><b>Mr:"+name+" ur not eligible marriage boy</b>");
				}
				else {
					pw.println("<br><b>Miss :"+name+" ur not eligible for marriage girl</b>");
				}//else
			  }//else
			}//else if
		else{
			if(gender.equalsIgnoreCase("male")){
				pw.println("<br><b>Mr:"+name+" ur old man</b>");
				}
				else {
					pw.println("<br><b>Miss :"+name+" ur old woman</b>");
				}//else
		}
		
		
		pw.println("<br><b>About: "+about+"</b>");
		pw.println("<br><b>gender: "+gender+"</b>");
		pw.println("<br><b>married: "+married+"</b>");
		pw.println("<br><b>Qualification: "+qlf+"</b>");
		if(language!=null){
			pw.println("<br><b>languages: "+Arrays.toString(language)+"</b>"); 
		}
		else {
			pw.println("<br><b>your not selected languages...</b>");
		}
		if(hobies!=null){
		pw.println("<br><b>Hobies : "+Arrays.toString(hobies)+"</b>"); //hobies =>[Ljava.lang.String;@3eef52c3 / Arrays.toString(hobies); =>
		}
		else{
			pw.println("<br><b>ur not select any hobies...</b>");
		}
		pw.println("<br><b>DateofBirth: "+dob+"</b>");
		pw.println("<br><b>Month: "+month+"</b>");
		pw.println("<br><b>Email: "+email+"</b>");
		pw.println("<br><b>Url: "+url+"</b>");
		pw.println("<br><b>salary: "+salary+"</b>");
		pw.println("<br><b>Phone No: "+phno+"</b>");
		pw.println("<br><b>Time: "+time+"</b>");
		pw.println("<br><b>Color: "+color+"</b>");
		
		
		pw.println("<br><br> <a href='input.html'>home </a>");
		
		pw.close();
						
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
