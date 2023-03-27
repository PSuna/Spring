package com.yedam.spring.board.service;

// 만약 input 태그를 사용한다면 yyyy-MM-dd 형태여야 하므로 
// @DateTimeFormat(pattern="yyyy-MM-dd") 를 선언해야함
import java.util.Date; // yyyy/MM/dd  

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	// _(언더바)가 없으므로 필드명에 대문자가 있으면 안됨
	private int bno;
	private String title;
	private String contents;
	private String writer;
	
	// import java.util.Date; 의 기본값은 yyyy/MM/dd  
	// 만약 input 태그를 사용한다면 yyyy-MM-dd 형태여야 하므로 
	// @DateTimeFormat(pattern="yyyy-MM-dd") 를 선언해야함

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedate;
	private String image;
}
