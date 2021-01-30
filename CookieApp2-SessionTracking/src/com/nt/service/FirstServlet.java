package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		Cookie ck1=new Cookie("name",req.getParameter("name") );
		Cookie ck2=new Cookie("no", req.getParameter("father"));
		Cookie ck3=new Cookie("add", req.getParameter("ms"));
		//Cookie ck4=new Cookie("add", req.getParameter(""));
		
		//ck1.setMaxAge(2*30);
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);
		//res.addCookie(ck4);
		
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
