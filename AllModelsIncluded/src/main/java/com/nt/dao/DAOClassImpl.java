package com.nt.dao;

import java.sql.Connection;

import com.nt.bean.BeanClass;
import com.nt.connection.DBConnection;

public class DAOClassImpl implements IDAO {

	Connection con;

	@Override
	public String insert(BeanClass bean,String name) { // here we write the DAO Logics
		System.out.println(con = DBConnection.getCon());
		bean.setName(name);
		String name1 = "Hello .."+bean.getName().toUpperCase();
		return name1;
	}

}
