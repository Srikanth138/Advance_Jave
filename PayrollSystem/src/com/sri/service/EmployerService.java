package com.sri.service;

import java.util.ArrayList;

import com.sri.bo.EmployerBO;
import com.sri.dao.EmployerDAO;
import com.sri.dao.IEmployer;
import com.sri.dto.EmployerDTO;

public class EmployerService implements IEmployerService {
	private IEmployer dao;
	
	public EmployerService() {
		dao = new EmployerDAO();
	}

	@Override
	public ArrayList<EmployerDTO> retrivService(EmployerBO bo1) {

		ArrayList<EmployerBO> listbo = null;
		ArrayList<EmployerDTO> listdto = new ArrayList<EmployerDTO>();
		String source = bo1.getSource();
		
		bo1.setId(bo1.getId());
		bo1.setName(bo1.getName());
		
		try {
			listbo = dao.retrive(bo1);
			listbo.forEach(bo -> {
				EmployerDTO dto = new EmployerDTO();
				dto.setId(bo.getId());
				dto.setName(bo.getName());
				dto.setPhone(bo.getPhone());
				dto.setEmail(bo.getEmail());
				dto.setCTC(bo.getCTC());
				dto.setSalary(bo.getSalary());
				dto.setGender(bo.getGender());
				listdto.add(dto);
			});
		} catch (Exception e) {
			e.printStackTrace();
		} // catch
			// } // if
		return listdto;
	}// method

	@Override
	public int registerService(EmployerBO bo1) {
		int i = 0;
		if (bo1.getSource().equals("register")) {
			try {
				bo1.setSalary(bo1.getSalary());
				i = dao.insert(bo1);
				bo1.setId(bo1.getId());
				System.out.println("2..." + bo1.getId());
				
			} catch (Exception e) {
				e.printStackTrace();
			} // catch
		}
		return i;
	}

	@Override
	public int deleteService(EmployerBO bo1) {
		int i = 0;
		if (bo1.getSource().equals("delete")) {
			try {
				int id = bo1.getId();
				bo1.setId(id);
				i = dao.delete(bo1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public int updateService(EmployerBO bo1) {
		int i = 0;
		if (bo1.getSource().equals("update")) {
			try {
				i = dao.update(bo1);

			} catch (Exception e) {
				e.printStackTrace();
			} // catch

		}
		return i;
	}
}
