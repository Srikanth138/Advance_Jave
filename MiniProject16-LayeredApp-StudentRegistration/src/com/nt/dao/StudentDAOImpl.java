/**
 * Context initContext = new InitialContext();
 * Context envContext  = (Context)initContext.lookup("java:/comp/env");
 * DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
 * Connection conn = ds.getConnection();
 * etc.*/

package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements IStudentDAO { 
	//CREATE SEQUENCE LAYERED_STUDENT_SNO_seq START WITH 1000 INCREMENT BY   1;
	private static final String INSERT_LAYERED_STUDENT = "INSERT INTO LAYERED_STUDENT VALUES(LAYERED_STUDENT_SNO_seq.NEXTVAL,?,?,?,?,?)";

	private DataSource ds;

//Step 1
	public StudentDAOImpl() throws Exception {
		// create InitialContext obj
		InitialContext ic = new InitialContext();
		// get DataSource obj from Jndi registry through lookup method
		ds = (DataSource) ic.lookup("java:/comp/env/DsJndi"); // DsJndi is the jndi name
	}

//step 4
	@Override
	public int insert(StudentBO bo) throws Exception {
		// get Pooled jdbc con object
		Connection con = getPooledJdbcConnection();
		// get Jdbc PreparedStatement object
		PreparedStatement ps = con.prepareStatement(INSERT_LAYERED_STUDENT);
		// set values to query params
		ps.setString(1, bo.getSname());
		ps.setInt(2, bo.getTotal());
		ps.setFloat(3, bo.getAvg());
		ps.setString(4, bo.getResult());
		ps.setString(5, bo.getSadd());
		// execute the query
		int result = ps.executeUpdate();
		// return the reult
		return result;
	}

//Step 2
	// helper methods
	private Connection getPooledJdbcConnection() throws Exception {
//step 3 ds calls's the ref
		// get Pooled jdbc con object through DataSource object ref
		Connection con = ds.getConnection(); 
		return con;
	}

}
