package com.yedam.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	// 도서 목록
	@GetMapping("/bookList")
	public String bookList(Model model) {
		model.addAttribute("list", bookService.bookList());
		return "book/bookList";
	}
	
	// 도서 정보 - form
	@GetMapping("/bookInsert")
	public String bookInsertForm(Model model) {
		model.addAttribute("bookNo", bookService.getBookNo()); // VO 클래스 단위로 넘어감
		return "book/bookInsert";
	}

	// 도서 정보 등록
	@PostMapping("/bookInsert")
	public String bookInsert(BookVO bookVO) {
		bookService.insertBook(bookVO);
		return "book/bookInsert";
	}
	
	// 도서 대여 현황
	@GetMapping("/rentList")
	public String rentList(Model model) {
		model.addAttribute("list", bookService.rentList());
		return "book/rentList";
	}
	
	
}
