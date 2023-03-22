package com.yedam.app.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		// GenericXmlApplicationContext : 컨테이너를 만드는것
		// classpath : 기본 경로 => src/main/resources를 가리킴
		GenericXmlApplicationContext ctx
			= new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// applicationContext.xml에서 등록한 id 값을 가져오면됨 => getBean("id")
		// 오브젝트 타입 일치시켜줘야함 (TV)
		// 컨테이너 안에 있는것은 빈들의 모음 => 빈(bean)은 객체임
		// 나중에 수정이 필요할때 Main은 건드리지 않고 applicationContext.xml에서 수정해주면됨
		TV tv = (TV)ctx.getBean("tv"); 
		tv.on();
	}
}
