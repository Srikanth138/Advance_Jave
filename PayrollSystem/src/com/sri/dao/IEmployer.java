package com.sri.dao;

import java.util.ArrayList;

import com.sri.bo.EmployerBO;

public interface IEmployer {
	public ArrayList<EmployerBO> retrive(EmployerBO bo);
	public ArrayList<EmployerBO> employerRetrive(EmployerBO bo);
	public int insert(EmployerBO bo);
	public int update(EmployerBO bo);
	public int delete(EmployerBO bo);
}
