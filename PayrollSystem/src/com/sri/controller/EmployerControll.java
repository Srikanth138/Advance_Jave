//EmployerControll.java
package com.sri.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sri.beans.Employer;
import com.sri.dao.EmployerDAO;

@SuppressWarnings("serial")
@WebServlet("/employer")
public class EmployerControll extends HttpServlet {

	EmployerDAO dao;

	public void init() {
		dao = new EmployerDAO();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("EmployerControll.doGet()");

		RequestDispatcher rd = req.getRequestDispatcher("/jsp/select.jsp");
		rd.forward(req, res);
	}

	public void destory() {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
