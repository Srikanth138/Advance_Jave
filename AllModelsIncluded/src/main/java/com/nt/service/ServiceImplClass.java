package com.nt.service;

import com.nt.bean.BeanClass;
import com.nt.dao.DAOClassImpl;
import com.nt.dao.IDAO;

public class ServiceImplClass implements IService {

	IDAO dao;
	@Override
	public String service(BeanClass bean,String name) {
		dao=new DAOClassImpl();
		String service = dao.insert(bean,name);
		return service;
	}

}
