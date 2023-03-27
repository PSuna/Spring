package com.yedam.spring.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.emp.service.EmpService;
import com.yedam.spring.emp.service.EmpVO;

@CrossOrigin
@RestController // 다른페이지에서 요청하는것을 전제로함 따라서 @CrossOrigin 처리를 해줘야함
public class EmpRestController {

	@Autowired
	EmpService empService;
	
	// 전체조회
	@GetMapping("/emps")
	public List<EmpVO> getEmpList(Model model){
		return empService.getEmpAll();
	}
	
	// 단건조회
	@GetMapping("/emps/{employeeId}")
	public EmpVO getEmpInfo(@PathVariable int employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		return empService.getEmp(empVO);
	}
	
	// 등록
	@PostMapping("/emps")
	public EmpVO insertEmpInfo(@RequestBody EmpVO empVO) {
		empService.insertEmp(empVO);
		return empVO; // 등록한 데이터 정보 그대로 반환
	}
	
	// 수정
	@PutMapping("/emps/{employeeId}")
	// @PathVariable int employeeId : 수정할 데이터(대표값)
	// @RequestBody EmpVO empVO : 수정하려고 하는 정보들
	public EmpVO updateEmpInfo(@PathVariable int employeeId, @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(employeeId);
		empService.updateEmp(empVO);
		return empVO;
	}
	
	// 삭제
	@DeleteMapping("/emps/{employeeId}")
	public EmpVO deleteEmpInfo(@PathVariable int employeeId) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(employeeId);
		empService.deleteEmp(employeeId);
		return empVO; // 삭제한 데이터 정보 반환
	}
	
}
