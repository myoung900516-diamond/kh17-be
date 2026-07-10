package com.kh.spring11.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring11.dto.LectureDto;

@Repository
public class LectureDaoMybatis implements LectureDao{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int sequence() {
		return sqlSession.selectOne("mapper.country.sequence");
		}

		@Override
		public void insert(LectureDto lectureDto) {
			sqlSession.insert("mapper.lecture.add", lectureDto);
			
		}

		@Override
		public boolean update(LectureDto lectureDto) {
			return sqlSession.update("mapper.lecture.update", lectureDto) >0;
		}
		@Override
		public boolean updateUnit(LectureDto lectureDto) {
			return sqlSession.update("mapper.lecture.updateUnit", lectureDto) >0;
		}

		@Override
		public boolean delete(int lectureNo) {
			return sqlSession.delete("mapper.lecture.delete", lectureNo) > 0;
		}

		@Override
		public LectureDto selectOne(int lectureNo) {
			LectureDto lectureDto = sqlSession.selectOne("mapper.lecture.find", lectureNo);
			return lectureDto;
		}

		@Override
		public List<LectureDto> selectList(int lastLectureNo, int size) {
			
			//mybatis는 구문 뒤에 데이터를 딱 하나만 보낼 수 있다.
			Map<String, Object> params = new HashMap<>();
			params.put("lastLectureNo", lastLectureNo);
			params.put("size", size);
			return sqlSession.selectList("mapper.lecture.listMore", params);
		}

		@Override
		public int count(int lastLectureNo) {
			return sqlSession.selectOne("mapper.lecture.countMore", lastLectureNo);
		}
	}


