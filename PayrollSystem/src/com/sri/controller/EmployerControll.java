//EmployerControll.java
package com.sri.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sri.bo.EmployerBO;
import com.sri.dto.EmployerDTO;
import com.sri.service.EmployerService;
import com.sri.service.IEmployerService;

@SuppressWarnings("serial")
@WebServlet(value = "/employerControll")
public class EmployerControll extends HttpServlet {

// remove and create service class object

	RequestDispatcher rd;
	List<EmployerDTO> listdto;
	EmployerBO bo;
	IEmployerService service;

	public void init() {
		listdto = new ArrayList<EmployerDTO>();
		bo = new EmployerBO();
		service = new EmployerService();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("EmployerControll.doGet()");
		String source = req.getParameter("source");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String salary = req.getParameter("salary");

		System.out.println("controll 1" + id + "," + name + "," + gender + "," + salary + "," + source);

		bo.setSource(source);
		bo.setName(name);
		bo.setGender(gender);
		try {
			if (source.equals("select")) {
				bo.setId(Integer.parseInt(id));
				listdto = service.retrivService(bo);
				if (listdto.isEmpty()) {
					rd = req.getRequestDispatcher("/jsp/Invalid.jsp");
					rd.forward(req, res);

				} else {
					req.setAttribute("dto", listdto);
					req.setAttribute("source",source);
					rd = req.getRequestDispatcher("/jsp/retrivejsp.jsp");
					rd.forward(req, res);
				}
			}

			else if (source.equals("register")) {
				double salary1 = Double.parseDouble(salary);
				bo.setSalary(salary1);
				int i = service.registerService(bo);
				req.setAttribute("i", i);
				req.setAttribute("id", bo.getId());

				rd = req.getRequestDispatcher("/jsp/registerjsp.jsp");
				rd.forward(req, res);
			}

			else if (source.equals("delete")) {
				bo.setId(Integer.parseInt(id));
				int i = service.deleteService(bo);
				req.setAttribute("i", i);
				rd = req.getRequestDispatcher("/jsp/deletejsp.jsp");
				rd.forward(req, res);
			} else if (source.equals("update")) {
				bo.setId(Integer.parseInt(id));
				bo.setSalary(Double.parseDouble(salary));

				int i = service.updateService(bo);
				req.setAttribute("i", i);
				rd = req.getRequestDispatcher("/jsp/updatejsp.jsp");
				rd.forward(req, res);
			} else {
				// employer
				bo.setId(Integer.parseInt(id));
				listdto = service.employerService(bo);
				if(listdto.isEmpty()) {
					rd = req.getRequestDispatcher("/jsp/Invalid.jsp");
					rd.forward(req, res);	
				}
				else {
				req.setAttribute("dto", listdto);
				req.setAttribute("source",source);
				rd = req.getRequestDispatcher("/jsp/retrivejsp.jsp");
				rd.forward(req, res);
				}
			}

		} catch (Exception e) {
			rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		} // catch
	}// doGet

	public void destory() {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
