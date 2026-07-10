package com.kh.spring11.mybatis;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.dao.LectureDao;
import com.kh.spring11.dto.LectureDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test06 {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private LectureDao lectureDao;
	
	@Test
	public void test() {
		int size = 10;
		List<LectureDto> list = lectureDao.selectList(100, size);
		log.debug("list size = {}", list.size());
//		assertEquals(10, list.size());
		assertTrue(size >= list.size());
		
		
	}

}
