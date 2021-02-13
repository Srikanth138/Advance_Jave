package com.sri.dto;

import java.io.Serializable;

public class EmployerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private long phone;
	private String email;
	private String gender;
	private double salary;
	private double DTD;
	private double CTC;
	private double HRA;
	private double TA;
	private double MA;
	private double OA;
	private double NetSalary=salary+DTD;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getDTD() {
//		return DTD;
		DTD=salary-(CTC+HRA+MA+TA+OA);
		return DTD;
	}
	public void setDTD(double DTD) {
		this.DTD = DTD;
	}
	public double getCTC() {
//		return CTC;
		return salary*0.14;
	}
	public void setCTC(double cTC) {
		CTC = cTC;		
	}
	public double getHRA() {
//		return HRA;
		return salary*0.14;
	}
	public void setHRA(double hRA) {
		HRA = hRA;
		
	}
	public double getTA() {
//		return TA;
		return salary*0.10;
	}
	public void setTA(double tA) {
		TA = tA;
	}
	public double getMA() {
//		return MA;
		return salary*0.10;
	}
	public void setMA(double mA) {
		MA = mA;
	}
	public double getOA() {
//		return OA;
		return salary*0.15;
	}
	public void setOA(double oA) {
		OA = oA;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "EmployerDTO [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", gender="
				+ gender + ", salary=" + salary + ", basicSalary=" + DTD + ", CTC=" + CTC + ", HRA=" + HRA
				+ ", TA=" + TA + ", MA=" + MA + ", OA=" + OA + "]";
	}
	
	

}