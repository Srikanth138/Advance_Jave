/** dto class transfer the data from one class to another class VO(Value Object) -> DTO(data transfer Object) -> BO(Bussines Object)*/
package com.nt.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String sname;
	private String sadd;
	private int marks1, marks2, marks3;

	// generate setters and getters
	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSadd() {
		return sadd;
	}

	public void setSadd(String sadd) {
		this.sadd = sadd;
	}

	public int getMarks1() {
		return marks1;
	}

	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}

	public int getMarks2() {
		return marks2;
	}

	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}

	public int getMarks3() {
		return marks3;
	}

	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}

}
