package com.CompanyName.ProjectName;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;


public class Lifecycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static{
		System.out.println("Lifecycle.Static block class loading..");
	}
	
	public Lifecycle() { //at the time of object creation constructor will be called and executed.
		System.out.println("Lifecycle.Lifecycle()- 0 param constructor..");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Lifecycle.init() initilization...");
		//destroy();
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//init();
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1 style='text-align:center;color:red;'>Date ::"+new java.util.Date()+"</h1>"); 
		System.out.println("Lifecycle.service()...");
		
		//destroy();
	}
	@Override
	public void destroy() { //server stop time this method execute or closing time or any edit reloading time
		System.out.println("Lifecycle.destroy()...");
	}

}
