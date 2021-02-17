//EmployerBO.java
package com.sri.bo;

import lombok.Data;

@Data
public class EmployerBO {

	private int id;
	transient private String name;
	private long phone;
	private String email;
	private double CTC;
	private double salary;
	private String gender;
	private String source;
}
