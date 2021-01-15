package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dao.PayDAO;

@SuppressWarnings("serial")
@WebServlet("/PayLogic")
public class PayService extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PayDAO dao=new PayDAO();
		int ll=dao.logic(req);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(ll==0) {
			pw.println("insetion failed..");
		}
		else {
			pw.println("insetion success..");
		}
		
		pw.println("<a href='input.html'>home</a>");
		
	}
	

}
