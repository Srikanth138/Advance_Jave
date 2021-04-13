package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.bean.BeanClass;
import com.nt.service.IService;
import com.nt.service.ServiceImplClass;

@SuppressWarnings("serial")
//@WebServlet(value = "/welcome", name = "welcome")
public class ControllClass extends HttpServlet {

	ServletConfig cfg;
	ServletContext ctx;
	PrintWriter pw;
	IService service;
	BeanClass bean;

	public void init(ServletConfig cfg) {
		ctx = cfg.getServletContext();// #1
		this.cfg = cfg;
		service = new ServiceImplClass();
		bean = new BeanClass();
	}

//	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException { //life cycle method
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		pw = res.getWriter();
		RequestDispatcher rd;
		ctx = req.getServletContext();// #2

		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String submit = req.getParameter("submit");
		String cfgValue = cfg.getInitParameter("cfg");
		String ctxValue = ctx.getInitParameter("ctx");

		String ser = service.service(bean, name);

		HttpSession sh = req.getSession(true);

		// create the cookies

		Cookie ck1 = new Cookie("ckname1", "ckvalue1");
		Cookie ck2 = new Cookie("ckname2", "ckvalue2");
		Cookie ck3 = new Cookie("ckname3", "ckvalue3");

		ck1.setMaxAge(2 * 30);// 60sec
		// add the cookies to Response Object
		res.addCookie(ck1);
		res.addCookie(ck2);
		res.addCookie(ck3);

		// Retrieve the Cookies from request Object
		Cookie cks[] = req.getCookies();
		
		pw.println(name + "," + pwd + "," + submit + "," + cfgValue + "," + ctxValue + ", " + ser + ","
				+ cks[0].getName() + "," + cks[0].getValue());

		if (ser.equalsIgnoreCase("Hello ..sri")) {

			req.setAttribute("name", ser);
			sh.setAttribute("pwd", pwd);
			ctx.setAttribute("submit", submit);

			rd = req.getRequestDispatcher("/WEB-INF/jsp/include.jsp");
			rd.include(req, res);
		} else if (ser.equalsIgnoreCase("Hello ..patel")) {
			req.setAttribute("name", ser);
			sh.setAttribute("pwd", pwd);
			ctx.setAttribute("submit", submit);

			rd = req.getRequestDispatcher("/WEB-INF/jsp/forward.jsp");
			rd.forward(req, res);
		} else {
			res.sendRedirect("http://www.google.com?q=" + name); // Available only HttpServletResponse Interface
		}
	}

	public void destroy() {
		pw.close();
	}

}
