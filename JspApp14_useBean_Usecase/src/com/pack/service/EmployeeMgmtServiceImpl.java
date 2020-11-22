package com.pack.service;

import com.pack.Dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	public EmployeeMgmtServiceImpl(){
		System.out.println("EmployeeMgmtServiceImpl:: 0-paramconstructor");
	}

	@Override
	public void generateSalaryDetails(EmployeeDTO dto) {
		float grossSalary=0.0f;
		float netSalary=0.0f;
		//calculate gross ,net salary 
		grossSalary=dto.getBasicSalary()+dto.getBasicSalary()*0.3f; 
		netSalary=grossSalary-(grossSalary*0.1f);
		
		//set gross,net salary to DTO class object
		dto.setGrossSalary(grossSalary);
		dto.setNetSalary(netSalary);
	}

}
