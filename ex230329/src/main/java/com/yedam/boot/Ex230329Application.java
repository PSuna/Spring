package com.yedam.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.yedam.boot.**.mapper") // 아니면 Mapper인터페이스에 @Mapper라고 개별로 붙이기
public class Ex230329Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex230329Application.class, args);
	}

}
