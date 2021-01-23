package cokm.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ser4")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw;

	public void init(ServletConfig cfg) {
		cfg = getServletConfig();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		pw = res.getWriter();
		res.setContentType("text/html");

		System.out.println("Servlet4.doGet()");

		pw.print("servlet4");
		// this is only request level work Scoop
		pw.println(req.getAttribute("name"));
		pw.println(req.getAttribute("no"));
//		String name = (String) req.getAttribute("name");
//		int no = (int) req.getAttribute("no");
//		pw.println(name + ", " + no);
		pw.println("<br>");
		
		// Browser Level Scoop
		HttpSession hs = req.getSession();
		pw.println(hs.getAttribute("name1"));
		pw.println(hs.getAttribute("no1"));
//		String name1 = (String) hs.getAttribute("name1");
//		int no1 = (int) hs.getAttribute("no1");
//		pw.println(name1 + ", " + no1);
		pw.println("<br>");

		// Application Level Scoop
		ServletContext sct = getServletContext();
		pw.println(sct.getAttribute("name2"));
		pw.println(sct.getAttribute("no2"));
//		String name2 = (String) sct.getAttribute("name2");
//		int no2 = (int) sct.getAttribute("no2");
//		pw.println(name2 + ", " + no2);
		pw.println("<br>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void destory() {
		pw.close();
	}

}
