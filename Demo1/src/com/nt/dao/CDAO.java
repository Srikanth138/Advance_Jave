package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nt.beans.CBeans;
import com.nt.db.DBConnection;

public class CDAO {
	//select *from CData where name='srikanth' and mail='Sri@gmail.com';
	private static final String select_Query="select *from CData where name=? and mail=?";
	PreparedStatement ps;
	ResultSet rs;
	
	public String select(CBeans cb) throws SQLException {
		Connection con=DBConnection.getCon();
		ps=con.prepareStatement(select_Query);
	
		ps.setString(1,cb.getName());
		ps.setString(2,cb.getMailId());
				
		rs=ps.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				cb.setName(rs.getString(1));
				cb.setMailId(rs.getString(2));
				cb.setNo(rs.getLong(3));
			}
			return cb.getName();
		}
		else {
			return null;	
		}
		
		
	}

}
