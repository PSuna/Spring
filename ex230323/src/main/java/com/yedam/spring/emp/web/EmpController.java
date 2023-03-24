package com.yedam.spring.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	// [규칙]
	// 조회(데이터, 입력폼같은 일반페이지도 마찬가지) -> GET 방식
	// 등록, 수정, 삭제 -> POST 방식
	
	// 전체 조회
	@GetMapping("/empList")
	public String getEmpAllList(Model model) {
		// req.setAttribute와 같은 기능을함
		model.addAttribute("empList",empService.getEmpAll());
		
		// views 폴더 아래의 해당 페이지 반환해주면됨
		// views/emp/empList.jsp 라는 의미
		return "emp/empList";
	}
	
	// 단건조회
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmp(empVO));
		return "emp/empInfo";
	}
	
	
	// 등록 - Form
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	// 등록 - Process
	@PostMapping("/empInsert")
	//<모델은 컨트롤러를 거쳐서 못감>
	//redirect할땐 model로 넘겨주면 안됨 ⇒ redirect할때 넘겨주는 RedirectAttribuetes를 사용해야함
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rrtt) {
		int empId = empService.insertEmp(empVO);
		String result = null;
		if(empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		}else{
			result="정상적으로 등록되었습니다."+"\n등록된 사원의 사번은 " + empId + " 입니다.";
		}
		// RedirectAttribuetes에 데이터를 저장할수있는 메소드 addFlashAttribute
		rrtt.addFlashAttribute("result", result);
		
		return "redirect:empList";
	}
	
	// 수정 - Process
	// 1) Client - JSON => Server
	// 2) Server - text => Client
	@PostMapping("/empUpdate")
	@ResponseBody
	public Map<String,String> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);
	}
	
}
