package com.kh.spring11.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
public class Test08한글가지고놀기 {
	
	@Test
	public void test() {
		String text = "황";
		//char로 변경
		char ch = text.charAt(0);
		log.debug("ch = {}, {}" ,ch, (int)ch);
		int seq = ch - '가';
		log.debug("전체한글중에 순서 = {}", seq);
	}

}
