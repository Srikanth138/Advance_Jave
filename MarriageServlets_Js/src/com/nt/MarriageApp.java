package com.nt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MarriageApp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("MarriageApp.doPost()");
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		String name=req.getParameter("name");
		String age1=req.getParameter("age"); 
		String gender=req.getParameter("gender");
		String vflag=req.getParameter("vflag");
		int age=0;
		
		if(vflag.equalsIgnoreCase("no")){  //it will execute when javascript code is not execute in client side web browser is disable
			//form validation logic (server side)
			List<String> errList=new ArrayList<>();
			System.out.println("server side form validation");
			if(name=="" || name.equals("") || name.length()==0){ //required rule
				errList.add("Person NAME IS MUST");
			}
			else if(name.length()<5){
				errList.add("NAME IS MUST BE 5 CHARECTER'S");
			}
			
			if(age1=="" || age1.equals("") || age1.length()==0){ //required rule
				errList.add("Person Age IS MUST");
			}
			else{
				try{
					age=Integer.parseInt(age1); //number value rule
					if(age<1 || age>125){ //range
						errList.add("age betWeen 1 to 125");
					}//if
				}
				catch(NumberFormatException e){errList.add("person age must numeric value");}
			}//else
			
			//display the form validation error
			if(!errList.isEmpty()){
				/*Iterator<String> it=errList.iterator();
				pw.println(it.hashCode()); */
				
				errList.forEach(msg->{ //multiple line
					pw.println("<li><span style='color:red'>"+msg+"</span></li>");
					}); //forEach() method    
				return; //it not return  any think  becase it return type is void. but it will stop the reaming code execution.
			}//if
		} //if
		else{
			age=Integer.parseInt(age1);
		}//else

		//write bussiness logic 
		System.out.println("Server side bussiness logic");
		
		pw.println("<center>");
		//pw.println("<body background='image/backimg.jpg' > ");
		pw.println("<body bgcolor='lightpink'> ");
		pw.println("<img src='image/backimg.jpg' width=400 height=200> ");

		if(gender.equalsIgnoreCase("male")){
			age=Integer.parseInt(age1);
			if(age>=21){
				pw.println("<h1 style='color:red; text-align:center;'>Welcome YouR Eligible for Marrige Mr."+name+" Best of luck" +age+", "+gender+"<h1>");
			}
			else{
				pw.println("<h1 style='color:green; text-align:center;'>YouR Not Eligible for Marrige Mr."+name+"</br> Wait for "+(21-age)+"Year "+gender+"</h1>");		
			}
			}
		
		else{ //if(gender.equalsIgnoreCase("FeMale"))
			age=Integer.parseInt(age1);
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
	}
}
