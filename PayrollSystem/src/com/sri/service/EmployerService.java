package com.sri.service;

import java.util.ArrayList;
import java.util.List;

import com.sri.bo.EmployerBO;
import com.sri.dto.EmployerDTO;

public class EmployerService {
//	IEmployer dao;
//	public EmployerService() {
//		dao=new EmployerDAO();
//	}
	
	public List<EmployerDTO> serviceEMP(List<EmployerBO> listbo) {
//		List<> listbo=null;
		//listbo=dao.delete();
		List<EmployerDTO> listdto=new ArrayList<EmployerDTO>();
		
		
		listbo.forEach(bo->{
			EmployerDTO dto=new EmployerDTO();
			dto.setId(bo.getId());
			dto.setName(bo.getName());
			dto.setPhone(bo.getPhone());
			dto.setEmail(bo.getEmail());
			dto.setCTC(bo.getCTC());
			dto.setSalary(bo.getSalary());
			dto.setGender(bo.getGender());
			
			listdto.add(dto);
		});
		
		return  listdto;
	}//method
}//class
