package com.yedam.java.book.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.java.book.mapper.BookMapper;
import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<BookVO> bookList() {
		return bookMapper.bookList();
	}

	@Override
	public BookVO getBookNo() {
		return bookMapper.getBookNo();
	}
	
	@Override
	public int insertBook(BookVO bookVO) {
		return bookMapper.insertBook(bookVO);
	}

	@Override
	public List<BookVO> rentList() {
		return bookMapper.rentList();
	}

}
