package com.yedam.spring.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.board.service.BoardService;
import com.yedam.spring.board.service.BoardVO;

//@RequestMapping("/board") // 컨트롤러 자체에 경로를 설정해줄수 있음
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI - getBoardList, return - board/boardList
	@GetMapping("/getBoardList")
	public String getBoardList(Model model) { // Model : 데이터를 보낼때 필요한 클래스
		// req.setAttribute와 같은 기능을함
		model.addAttribute("boardList",boardService.getBoardList());
		return "board/boardList";
	}
	
	// 단건조회 : URI - getBoardInfo, return - board/boardInfo
	@GetMapping("/getBoardInfo")
	// 요청정보받기 : 커멘드객체로 받음 => 내부 필드명이 key형태여야함, value는 데이터 타입에 맞는 값이여야함 
	public String getBoardInfo(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo", boardService.getBoardInfo(boardVO));
		return "board/boardInfo";
	}
	
	// 등록 - 입력을 받기위한 페이지를 요청 : URI - boardInsert, return - board/boardInsert
	// 등록 - Form => GET방식
	@GetMapping("/boardInsert")
	public String boardInsertForm(Model model) {
		model.addAttribute("boardInfo",boardService.getBoardNo()); // VO 클래스 단위로 넘어감
		// model.addAttribute("boardInfo",boardService.getBoardNo().getBno()); // bno 글번호가 넘어감
		return "board/boardInsert";
	}
	
	// 등록 - 등록 자체를 처리하는것 : URI - boardInsert, return - 전체조회 다시 호출
	// 등록 - Process => POST방식
	@PostMapping("/boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {

		boardService.insertBoardInfo(boardVO);
		return "redirect:getBoardList"; // redirect는 경로를 호출하는것임
	}
	
	// 수정 - 수정을 하기위한 페이지 : URI - boardUpdate, return - board/boardUpdate
	// 수정 - Form => GET방식
	@GetMapping("/boardUpdate")
	public String boardUpdateForm(BoardVO boardVO, Model model) {
		model.addAttribute("boardInfo",boardService.getBoardInfo(boardVO)); // 수정할 정보 넘겨줌
		return "board/boardUpdate";
	}
	
	// 수정 - 수정을 처리하는것 : URI - boardUpdate, return - 단건조회 다시 호출
	// 수정 - Process => POST방식
	@PostMapping("/boardUpdate")
	public String boardUpdateProcess(BoardVO boardVO) {
		int boardNo = boardService.updateBoardInfo(boardVO);
		return "redirect:getBoardInfo?bno=" + boardNo; // redirect는 경로를 호출하는것임
	}
	
	// 삭제 : URI - boardDelete , return - 전체조회 다시 호출
	@GetMapping("/boardDelete")
	public String boardDelete(@RequestParam int bno){
		boardService.deleteBoardInfo(bno);
		return "redirect:getBoardList";
	}
}
