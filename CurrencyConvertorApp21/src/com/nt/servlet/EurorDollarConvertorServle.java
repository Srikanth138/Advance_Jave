package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eurourl")
public class EurorDollarConvertorServle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");
		// read form data
		String data = req.getParameter("currency");
		float value = Float.parseFloat(data);

		// get EURO Dollar price for INR
		float eurovalue = value / 89.0f;
		pw.println("<h1 style='color:red;text-align:center'>(EurorDollarConvertorServlet) Euro value ::" + eurovalue
				+ " for rupee value is ::" + value + "</h1>");
		// perform CrossContext communication
		// get Acccess to ServletContext obj of current web application
		ServletContext sc1 = getServletContext();
		// get foreign context of USDollarConvertorApp
		ServletContext sc2 = sc1.getContext("/USDollarConvertorApp21");
		// create RequestDispatcher object pointing to Destionation web comp of Another web applicaiton
		RequestDispatcher rd = sc2.getRequestDispatcher("/dollarurl");
		// include response
		rd.include(req, res);
		// add home hyperlink
		pw.println("<br><a href='input.html'>home</a>");
		// close stream
		pw.close(); // it is source servlet comp
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
