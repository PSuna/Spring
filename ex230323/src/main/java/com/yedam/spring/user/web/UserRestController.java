package com.yedam.spring.user.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.spring.user.service.UserVO;

@CrossOrigin
//데이터를 반환하는 컨트롤러
//필드명이 중요함
@RestController
public class UserRestController {
	// @RequestMapping의 value : 경로 , method : 통신방식 
	// 이때 글자로 post라고 안쓰고 RequestMethod.POST라는 전역 번수를 씀
	@RequestMapping(value="/insertUser", method=RequestMethod.POST)
	public UserVO insertUser(UserVO userVO) {
		
		System.out.println("name : " + userVO.getName());
		System.out.println("age : " + userVO.getAge());
		
		return userVO;
	}
	
}
