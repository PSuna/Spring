package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

// FrontController와 같은 역할
// 스프링에선 각각 기능별로 controller를 세분화 시킴
@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	@RequestMapping("/getEmpInfo")
	@ResponseBody
	public EmpVO getEmpInfo(EmpVO empVO) {
		return empService.getEmpInfo(empVO);
	}
}
