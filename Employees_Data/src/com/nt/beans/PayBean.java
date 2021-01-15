package com.nt.beans;

import java.io.Serializable;

public class PayBean implements Serializable {
	private static final long serialVersionUID = 7196520992159724160L;

	private int empId;
	private String name, pan;
	private int noOfDay, basicPay, DA, HRA, grossTotal, PF, PT, netSalary,totalSal;

	public PayBean() {
		System.out.println("PayBean.PayBean() 0-paramConstructor");
	}
	
	public int getTotalSal() {
		return totalSal;
	}

	public void setTotalSal(int totalSal) {
		this.totalSal = totalSal;
	}


	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public int getNoOfDay() {
		return noOfDay;
	}

	public void setNoOfDay(int noOfDay) {
		this.noOfDay = noOfDay;
	}

	public int getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(int basicPay) {
		this.basicPay = basicPay;
	}

	public int getDA() {
		return DA;
	}

	public void setDA(int dA) {
		DA = dA;
	}

	public int getHRA() {
		return HRA;
	}

	public void setHRA(int hRA) {
		HRA = hRA;
	}

	public int getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(int grossTotal) {
		this.grossTotal = grossTotal;
	}

	public int getPF() {
		return PF;
	}

	public void setPF(int pF) {
		PF = pF;
	}

	public int getPT() {
		return PT;
	}

	public void setPT(int pT) {
		PT = pT;
	}

	public int getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(int netSalary) {
		this.netSalary = netSalary;
	}

	@Override
	public String toString() {
		return "PayBean [empId=" + empId + ", name=" + name + ", pan=" + pan + ", noOfDay=" + noOfDay + ", basicPay="
				+ basicPay + ", DA=" + DA + ", HRA=" + HRA + ", grossTotal=" + grossTotal + ", PF=" + PF + ", PT=" + PT
				+ ", netSalary=" + netSalary + ", totalSal=" + totalSal + "]";
	}

}
