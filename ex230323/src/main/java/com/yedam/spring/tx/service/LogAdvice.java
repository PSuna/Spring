package com.yedam.spring.tx.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

	// 포인트컷 : 비지니스 로직과 관련된 메소드 중에서 Advice(공통 코드)가 적용될 메소드
	// @PointCut("표현식")
	// 하위에 모드 메소드에 적용하겠다 라는말
	// 언제 어떻게 어느 어드바이스랑 매핑할건지 포인트 컷을 불러와야함
	@Pointcut("within(com.yedam.spring.tx.service.*)")
	public void allPointCut() {}
	
	// Weaving : 포인트컷 + Advice + 타이밍
	// 실행하고자 하는 애의 메소드명을 주면됨
	@Around("allPointCut()")
	public Object logger(ProceedingJoinPoint joinpoint) throws Throwable {
		
		// Aop가 적용되는 메서드 이름
		String signatuerStr = joinpoint.getSignature().toString();
		System.out.println("시작 : " + signatuerStr);
		
		//공통기능
		System.out.println("핵심 기능 전 실행 - 공통 기능 : " + System.currentTimeMillis());
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
			System.out.println("핵심 기능 후 실행 - 공통 기능 : " + System.currentTimeMillis());
			System.out.println("끝 : " + signatuerStr);
		}
	
	}
}
