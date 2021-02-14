package com.sri.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmployerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private long phone;
	private String email;
	private String gender;
	private double salary;
	private String source;
	private double DTD;
	private double CTC;
	private double PF;
	private double HRA;
	private double TA;
	private double MA;
	private double OA;
	private double NetSalary;

}