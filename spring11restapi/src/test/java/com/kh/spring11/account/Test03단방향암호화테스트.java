package com.kh.spring11.account;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test03단방향암호화테스트 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		//단방향 암호화 : 
		//-암호화만 가능하고 복호화는 불가능한 형태의 암호화 방식
		//-얼만지는 몰라도 비교는 가능하게 만듬 
		//-1. 복호화는 안되지만 매번 같은 값이 나오는 암호화 
		//-2. 복호화가 안되면서 매번 다른 값이 나오는 암호화 
		
		String origin = "hello";
		
		String hash = DigestUtils.sha256Hex(origin);
		
		log.debug("origin = {}", origin);
		log.debug("hash = {}", hash);
		log.debug("hash size = {}", hash.length());
		
		
	}

}
