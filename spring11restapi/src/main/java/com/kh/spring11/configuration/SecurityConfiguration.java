package com.kh.spring11.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//보안을 위해 필요한 도구 및 설정을 작성
@Configuration
public class SecurityConfiguration {
	
	@Bean
	public BCryptPasswordEncoder bCrytPasswordEncoder() {
		//업캐스팅
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
