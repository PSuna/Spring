package com.yedam.java.book.service;

import java.util.List;

public interface BookService {

	// 도서목록 조회
	public List<BookVO> bookList();
		
	// 등록하고자 하는 도서번호
	public BookVO getBookNo();
		
	// 도서 정보 등록
	int insertBook(BookVO bookVO);
	
	// 도서 대여 정보
	public List<BookVO> rentList();
	
}
