package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.LectureDto;

public interface LectureDao {
	
	int sequence();
	void insert(LectureDto lectureDto);
	LectureDto selectOne(int lectureNo);
	List<LectureDto> selectList(int lastLectureNo, int size);
	boolean update(LectureDto lectureDto);
	boolean updateUnit(LectureDto lectureDto);
	boolean delete(int lectureNo);
	int count(int lectureNo);

}
