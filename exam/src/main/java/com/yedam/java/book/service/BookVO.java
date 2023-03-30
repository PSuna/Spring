package com.yedam.java.book.service;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {

	private int bookNo;
	private String bookName;
	private String bookCoverimg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookDate;
	private int bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	private int total; // 대여총계
	private int count; // 대여횟수;
	
}
