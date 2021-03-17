package com.nt.bo;

import lombok.Data;

@Data
public class BookDetailsBO {
	private int bookId;
	private String bookName;
	private String category;
	private String author;
	private float price;
	private String status;

}