package com.nt.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		Cookie ck1[] = req.getCookies();

		pw.println("<h1 style='color:red;text-align:center'> All cookies are </h1>");
		for (Cookie ck : ck1) {
			pw.println("<b>" + ck.getName() + "   " + ck.getValue() + "</b><br>");
		}

		/*
		 * ArrayList<Integer> n = new ArrayList<Integer>(); n.add(100);
		 * 
		 * n.forEach(pw::println);
		 * 
		 * n.forEach(n1 -> pw.println(n1));
		 * n.forEach((n2) -> pw.println(n2));
		 * 
		 * n.forEach((n2) -> { pw.println(n2); });
		 * 
		 * // forEach( )is not support Cookies
		 * ck1.forEach(System.out::println); 
		 * ck1.forEach((ck2) ->
		 * System.out.println(ck2));
		 */
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
