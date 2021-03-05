package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.beans.CBeans;
import com.nt.dao.CDAO;

@WebServlet("/select")
public class Ccontroller extends HttpServlet {
	
	CBeans cb;
	CDAO dao;
	public void init() {
		cb=new CBeans();
		dao=new CDAO();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		 String name=req.getParameter("name");
		 String mailId=req.getParameter("mail");
		
		 cb.setName(name);
		 cb.setMailId(mailId);
		 
		 try {
			String cc=dao.select(cb);
			if(cc!=null) {
				pw.println(cb.getName()+"<br>");
				pw.println(cb.getMailId()+"<br>");
				pw.println(cb.getNo()+"<br>");
			}
			else {
				pw.print("details are Not found...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
