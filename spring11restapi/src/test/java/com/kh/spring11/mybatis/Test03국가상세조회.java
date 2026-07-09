package com.kh.spring11.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.dto.CountryDto;

@SpringBootTest
public class Test03국가상세조회 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		int countryNo= 1235;
		CountryDto countryDto = sqlSession.selectOne("mapper.country.find", countryNo);
		System.out.println(countryDto);
	}

}
