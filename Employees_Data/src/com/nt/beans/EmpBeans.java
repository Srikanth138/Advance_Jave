package com.nt.beans;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class EmpBeans implements Serializable {

//	"Name", "Gender", "DateofJoining ", "DateofBirth ", "EmpId",pan
	private int empId;
	private String name;
	private String Gender;
	private Date DOJ;
	private Date DOB;
	private String pan;
	private String qlf;

	public String getQlf() {
		return qlf;
	}

	public void setQlf(String qlf) {
		this.qlf = qlf;
	}

	public EmpBeans() {
		System.out.println("EmpBeans.EmpBeans() 0-Param Constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Date getDOJ() {
		return DOJ;
	}

	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "EmpBeans [empId=" + empId + ", name=" + name + ", Gender=" + Gender + ", DOJ=" + DOJ + ", DOB=" + DOB
				+ ", pan=" + pan + ", qlf=" + qlf + "]";
	}
	

}
