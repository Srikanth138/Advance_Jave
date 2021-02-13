package com.sri.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.sri.bo.EmployerBO;

public interface IEmployer {
	public ArrayList<EmployerBO> retrive(EmployerBO bo)throws ClassNotFoundException, IOException, SQLException;
	public int insert(EmployerBO bo)throws ClassNotFoundException, IOException, SQLException;
	public int update(EmployerBO bo)throws ClassNotFoundException, IOException, SQLException;
	public int delete(EmployerBO bo)throws ClassNotFoundException, IOException, SQLException;
}
