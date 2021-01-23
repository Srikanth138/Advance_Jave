package cokm.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ser1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		pw = res.getWriter();
		res.setContentType("text/html");

		System.out.println("Servlet1.doGet()");
		pw.print("servlet1");

		// Request Scoop is only request level work Scoop
		req.setAttribute("name", "sri");
		req.setAttribute("no", 100);

		// Browser Level Scoop
		HttpSession hs = req.getSession();
		hs.setAttribute("name1", "session");
		hs.setAttribute("no1", 101);
		
		ServletContext sct = getServletContext();
		sct.setAttribute("name2","Context");
		sct.setAttribute("no2",102);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/ser2");
		rd.forward(req, res);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
