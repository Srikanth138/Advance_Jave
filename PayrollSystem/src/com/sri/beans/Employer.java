//Employer.java
package com.sri.beans;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class Employer implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private long phone;
	private String address;
	private double CTC;
	private Date date;
	
	//Earning
	private long salary;
	private int HRA;
	private int TA; //Travelling Allowance 
	private int MA; //Medical Allowance (MA)
	private int OA; //Other Allowance (OA)

	//Deductions like:
	private int PF; //Provident Fund (PF)
	private int LOP; //Loss of Pay (LOP)
	private int IP; //InsurancePremium
	private int TDS;

}
