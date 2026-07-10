package com.kh.spring11.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test05국가정보삭제 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		int countryNo = 1235;
		int row = sqlSession.delete(
				"mapper.country.delete" , countryNo);
		log.debug("결과 : {}", row >0);
	}

}
