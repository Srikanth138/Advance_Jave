package com.nt.service;

import java.io.IOException;

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
		Cookie ck1=new Cookie("name", "sri");
		Cookie ck2=new Cookie("no", "123");
		Cookie ck3=new Cookie("add", "sri");
		
		ck1.setMaxAge(2*30);
		res.addCookie(ck1);
		
		res.addCookie(ck2);
		res.addCookie(ck3);
		
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
