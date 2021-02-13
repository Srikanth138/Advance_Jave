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
import com.sri.dao.IEmployer;
import com.sri.dto.EmployerDTO;
import com.sri.service.EmployerService;

@SuppressWarnings("serial")
@WebServlet(value = "/employerControll")
public class EmployerControll extends HttpServlet {

	IEmployer dao;
	RequestDispatcher rd;
	ArrayList<EmployerBO> al;
	ArrayList<EmployerDTO> al1;

	EmployerBO bo;
	EmployerService service;

	ServletConfig cfg;
	ServletContext ctx;

	public void init(ServletConfig cfg) {
		this.cfg = cfg;
		dao = new EmployerDAO();
		al = new ArrayList<EmployerBO>();
		al1 = new ArrayList<EmployerDTO>();
		bo = new EmployerBO();
		service = new EmployerService();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ctx = cfg.getServletContext();
		System.out.println("EmployerControll.doGet()");

		String source = req.getParameter("source");
		String id1 = req.getParameter("id");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String salary1 = req.getParameter("salary");

		bo.setName(name);
		bo.setGender(gender);

		if (source.equals("select")) {
			try {
				int id = Integer.parseInt(id1);
				bo.setId(id);

				al = dao.retrive(bo);
				al1 = (ArrayList<EmployerDTO>) service.serviceEMP(al);
				ctx.setAttribute("dto", al1);

				rd = req.getRequestDispatcher("/jsp/select.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				rd = req.getRequestDispatcher("/error.jsp");
				rd.forward(req, res);
			} // catch
		} // if

		else if (source.equals("register")) {
			try {
				double salary = Double.parseDouble(salary1);
				bo.setSalary(salary);

				int i = dao.insert(bo);
				ctx.setAttribute("i", i);
				ctx.setAttribute("id", bo.getId());

				System.out.println("2..." + bo.getId());

				rd = req.getRequestDispatcher("/jsp/registerjsp.jsp");
				rd.forward(req, res);
			} catch (Exception e) {
				rd = req.getRequestDispatcher("/error.jsp");
				rd.forward(req, res);
			} // catch
		} // else if
		else if (source.equals("delete")) {
			try {
				int id = Integer.parseInt(id1);
				bo.setId(id);

				int i = dao.delete(bo);
				ctx.setAttribute("i", i);

				rd = req.getRequestDispatcher("/jsp/deletejsp.jsp");
				rd.forward(req, res);

			} catch (Exception e) {
				rd = req.getRequestDispatcher("/error.jsp");
				rd.forward(req, res);
			}

		} // else if
		else {
			try {
				int id = Integer.parseInt(id1);
				bo.setId(id);

				Double salary = Double.parseDouble(salary1);
				bo.setSalary(salary);
				int i = dao.update(bo);

				ctx.setAttribute("i", i);

				rd = req.getRequestDispatcher("/jsp/updatejsp.jsp");
				rd.forward(req, res);

			} catch (Exception e) {
				rd = req.getRequestDispatcher("/error.jsp");
				rd.forward(req, res);
			} // catch
		} // else
	}// doGet

	public void destory() {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
