package com.sri.service;

import java.util.List;

import com.sri.bo.EmployerBO;
import com.sri.dto.EmployerDTO;

public interface IEmployerService {
	public List<EmployerDTO> retrivService(EmployerBO bo);
	public int registerService(EmployerBO bo);
	public int deleteService(EmployerBO bo);
	public int updateService(EmployerBO bo);

}
