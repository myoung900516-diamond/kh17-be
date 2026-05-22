package com.kh.spring09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync//이제부터 이 프로그램에서는 비동기 시스템을 사용할 거에요.
@EnableScheduling //이제부터 이 프로그램에서는 스케줄링 시스템을 사용할 거에요.
@SpringBootApplication
public class Spring09integrateApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring09integrateApplication.class, args);
	}

}
