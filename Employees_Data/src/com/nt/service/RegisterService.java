package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.RegisterDAO;

@WebServlet("/registerService")
public class RegisterService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		RegisterDAO rdao=new  RegisterDAO();
		int i=rdao.insert(req);
		if(i==0) {
			pw.println("<h1 style='color:red; text-align: center;'> Record Insertion Faild </h1>");
		}
		else {
			pw.println("<h1 style='color:green; text-align: center;;'> Details Are succesfully Inserted </h1>");
		}
		
		pw.println("</br></br><a href='input.html'>Home<a/>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
