package com.yedam.spring.tx.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.spring.tx.mapper.AaaMapper;
import com.yedam.spring.tx.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService {

	@Autowired
	AaaMapper aaaMapper;
	
	@Transactional //  두개의 SQL문이 하나처럼 움직일수있게 하는것
	@Override
	public void insert() {
		aaaMapper.insert("101");
		//aaaMapper.insert("값");
		aaaMapper.insert("970");
	}

}
