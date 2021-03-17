package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookDetailsDTO implements Serializable {
	private int serialNo;
	private int bookId;
	private String bookName;
	private String category;
	private  String author;
	private  float price;
	private String status;

}
