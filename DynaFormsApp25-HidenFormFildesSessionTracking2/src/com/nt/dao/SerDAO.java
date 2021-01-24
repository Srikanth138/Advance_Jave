package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nt.bean.SerBeans;
import com.nt.db.DbConnection;

public class SerDAO {
//	INSERT INTO srikanth.person_info(pid,pname,fathername,ms,info1,info2)VALUES(?,?,?,?,?,?);
	private final static String Query = "INSERT INTO PERSON_INFO(PNAME,FATHERNAME,MS,INFO1,INFO2)VALUES(?,?,?,?,?)";
//	private final static String Query="INSERT INTO PERSON_INFO(PID,PNAME,FATHERNAME,MS,INFO1,INFO2)VALUES(seq_pid.nextval,?,?,?,?,?)";
	int i;
	public int insert(SerBeans sb) {
	Connection con=DbConnection.getCon();
	try {
		PreparedStatement ps=con.prepareStatement(Query);
		
		ps.setString(1,sb.getName());
		ps.setString(2,sb.getFather());
		ps.setString(3,sb.getMs());
		ps.setString(4,sb.getF2val1());
		ps.setString(5,sb.getF2val2());
		
		i=ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return i;
	}
}
