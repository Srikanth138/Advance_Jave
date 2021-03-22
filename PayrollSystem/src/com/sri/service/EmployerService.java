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

		bo1.setId(bo1.getId());
		bo1.setName(bo1.getName());

		try {
			listbo = dao.retrive(bo1);
			listbo.forEach(bo -> {
				EmployerDTO dto = new EmployerDTO();
				dto.setId(listdto.size()+1);
				dto.setName(bo.getName());
				dto.setPhone(bo.getPhone());
				dto.setEmail(bo.getEmail());
				dto.setSalary(bo.getSalary());
				dto.setCTC(bo.getSalary() + 100);
				dto.setDTD(bo.getSalary() * 0.2);
				dto.setHRA(bo.getSalary() * 0.05);
				dto.setTA(bo.getSalary() * 0.05);
				dto.setMA(bo.getSalary() * 0.05);
				dto.setOA(bo.getSalary() * 0.05);
				dto.setPF(bo.getSalary() * 0.05);
				dto.setGender(bo.getGender());
				dto.setNetSalary(bo.getSalary()+dto.getPF()+dto.getHRA()+dto.getTA()+dto.getOA());
//				BeanUtils.copyProperties(bo,dto);
				listdto.add(dto);
			});
		} catch (Exception e) {
			e.printStackTrace();
		} // catch
		return listdto;
	}// method

	@Override
	public ArrayList<EmployerDTO> employerService(EmployerBO bo1) {

		ArrayList<EmployerBO> listbo = null;
		ArrayList<EmployerDTO> listdto = new ArrayList<EmployerDTO>();

		bo1.setId(bo1.getId());
		bo1.setName(bo1.getName());

		try {
			listbo = dao.employerRetrive(bo1);
			listbo.forEach(bo -> {
				EmployerDTO dto = new EmployerDTO();
				dto.setId(listdto.size()+1);
				dto.setName(bo.getName());
				dto.setPhone(bo.getPhone());
				dto.setEmail(bo.getEmail());
				dto.setSalary(bo.getSalary());
				dto.setCTC(bo.getSalary() + 100);
				dto.setDTD(bo.getSalary() * 0.2);
				dto.setHRA(bo.getSalary() * 0.05);
				dto.setTA(bo.getSalary() * 0.05);
				dto.setMA(bo.getSalary() * 0.05);
				dto.setOA(bo.getSalary() * 0.05);
				dto.setPF(bo.getSalary() * 0.05);
				dto.setGender(bo.getGender());
				dto.setNetSalary(bo.getSalary()+dto.getPF()+dto.getHRA()+dto.getTA()+dto.getOA());
//				BeanUtils.copyProperties(bo,dto);
				listdto.add(dto);
			});
		} catch (Exception e) {
			e.printStackTrace();
		} // catch
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
