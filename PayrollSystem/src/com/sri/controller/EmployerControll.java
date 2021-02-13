//EmployerControll.java
package com.sri.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sri.bo.EmployerBO;
import com.sri.dao.EmployerDAO;

@SuppressWarnings("serial")
@WebServlet(value = { "/selectService", "/registerService", "/updateService", "/deleteService" })
public class EmployerControll extends HttpServlet {

	EmployerDAO dao;
	RequestDispatcher rd;
	ArrayList<EmployerBO> al;
	EmployerBO bo;

	ServletConfig cfg;
	ServletContext ctx;

	public void init(ServletConfig cfg) {

		this.cfg = cfg;
		dao = new EmployerDAO();
		al = new ArrayList<EmployerBO>();
		bo = new EmployerBO();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ctx = cfg.getServletContext();
		System.out.println("EmployerControll.doGet()");

		String source = req.getParameter("source");

		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String salary1 = req.getParameter("salary");

		bo.setName(name);
		bo.setGender(gender);

		if (source.equals("select")) {
			try {
				String id1 = req.getParameter("id");
				int id = Integer.parseInt(id1);
				bo.setId(id);

				al = dao.retrive(bo);
				ctx.setAttribute("name", al);
				System.out.println(req.getClass());

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(cfg.getServletName().equals("ss"));
			rd = req.getRequestDispatcher("/jsp/select.jsp");
			rd.forward(req, res);
		} // if

		else if (source.equals("register")) {
			try {
				double salary = Double.parseDouble(salary1);
				bo.setSalary(salary);

//				RegisterDAO rdao = new RegisterDAO();
				int i = dao.insert(bo);

				ctx.setAttribute("i", i);
				ctx.setAttribute("id", bo.getId());

				System.out.println("2..." + bo.getId());
				System.out.println(cfg.getClass());

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(cfg.getServletName().equals(source));
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/registerjsp.jsp");
			rd.forward(req, res);
		} // else if
		else if (source.equals("delete")) {
			try {
				String id1 = req.getParameter("id");
				int id = Integer.parseInt(id1);
				bo.setId(id);
//				DeleteDAO rdao = new DeleteDAO();
				int i = dao.delete(bo);

				ctx.setAttribute("i", i);
				System.out.println(req.getClass());

			} catch (Exception e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = req.getRequestDispatcher("/jsp/deletejsp.jsp");
			rd.forward(req, res);
		} // else if
		else {
			try {
				bo.setName(name);
				String id1 = req.getParameter("id");
				int id = Integer.parseInt(id1);
				bo.setId(id);

				double salary = Double.parseDouble(salary1);
				bo.setSalary(salary);

//				UpdateDAO udao = new UpdateDAO();
				int i = dao.update(bo);

				ctx.setAttribute("i", i);
				System.out.println(req.getClass());

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(cfg.getServletName().equals(source));
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/updatejsp.jsp");
			rd.forward(req, res);

		}
	}

	public void destory() {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
