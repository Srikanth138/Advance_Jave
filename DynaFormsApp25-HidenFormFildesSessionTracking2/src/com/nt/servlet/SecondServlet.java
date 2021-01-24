package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.nt.bean.SerBeans;
import com.nt.dao.SerDAO;

@SuppressWarnings("serial")
@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private final static String Query = "INSERT INTO PERSON_INFO(PNAME,FATHERNAME,MS,INFO1,INFO2)VALUES(?,?,?,?,?)";

	@Resource(name = "DsJndi-mysql")
	DataSource ds;
	Connection con;

	public void init() {
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get PrintWriter
		PrintWriter pw = res.getWriter();
		// set response content type
		res.setContentType("text/html");

		// read form1/req1 data..
		String name = req.getParameter("name");
		String father = req.getParameter("father");
		String ms = req.getParameter("ms");

		// read form2/req2 data
		String f2val1 = req.getParameter("f2t1");
		String f2val2 = req.getParameter("f2t2");

		SerBeans sb = new SerBeans();
		sb.setName(name);
		sb.setFather(father);
		sb.setMs(ms);
		sb.setF2val1(f2val1);
		sb.setF2val2(f2val2);

		try {
			PreparedStatement ps = con.prepareStatement(Query);

			ps.setString(1, sb.getName());
			ps.setString(2, sb.getFather());
			ps.setString(3, sb.getMs());
			ps.setString(4, sb.getF2val1());
			ps.setString(5, sb.getF2val2());

			int i = ps.executeUpdate();
		

//		try {
//			SerDAO dao = new SerDAO();
//			int i = dao.insert(sb);
//
			if (i == 0) {
				pw.println("NOT_Inserted SuccesFully...<br/>");
			} else {
				pw.println("Inserted SuccesFully...<br/>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Generate dynamic web page displaying form1/req1 data and form2/req2 data
		pw.println("<b>form1 /req1 data is ::" + name + "...." + father + "...." + ms + "</b>");
		pw.println("<br><b>form2 /req2 data is ::" + f2val1 + "      " + f2val2 + "</b>");

		// add home hyperlink
		pw.println("<br> <a href='form1.html'>home </a>");
		// close stream
		pw.close();
	}// doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}// doPost(-,-)
}
