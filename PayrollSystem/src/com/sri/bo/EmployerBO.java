//Employer.java
package com.sri.bo;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployerBO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private long phone;
	private String email;
	private double CTC;
	private double salary;
	private String gender;
}
