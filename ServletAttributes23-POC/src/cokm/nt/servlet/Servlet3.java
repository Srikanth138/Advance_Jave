package cokm.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ser3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		pw = res.getWriter();
		res.setContentType("text/html");

		System.out.println("Servlet3.doGet()");

		pw.println("/ser3");
		// this is only request level work Scoop
		pw.println(req.getAttribute("name"));
		pw.println(req.getAttribute("no"));

		pw.println("<br>");

		// browser
		HttpSession hs = req.getSession();
		pw.println(hs.getAttribute("name1"));
		pw.println(hs.getAttribute("no1"));

		pw.println("<br>");
		
		ServletContext sct = getServletContext();
		pw.println(sct.getAttribute("name2"));
		pw.println(sct.getAttribute("no2"));

		pw.println("<br>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
