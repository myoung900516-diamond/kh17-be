package com.kh.spring11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//우선 Security를 제외하도록 설정
@SpringBootApplication 
//인증을 해야 들어갈 수 있음. 
//스프링이 할 수 있는 가장 강력한 인증 수준 








//@SpringBootApplication(exclude = {
//		SecurityAutoConfiguration.class,
//		OAuth2ResourceServerAutoConfiguration.class
//})
public class Spring11restapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring11restapiApplication.class, args);
	}

}
