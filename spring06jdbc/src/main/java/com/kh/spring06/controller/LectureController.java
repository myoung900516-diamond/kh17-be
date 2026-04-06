package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.LectureDao;
import com.kh.spring06.dto.LectureDto;

@RestController
@RequestMapping("/lecture")//공용주소
public class LectureController {
	@Autowired
	private LectureDao lectureDao;
	
	@RequestMapping ("/insert")
	public String insert(@ModelAttribute LectureDto lectureDto) {
		lectureDao.insert(lectureDto);
		return "등록 완료";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute LectureDto lectureDto) {
		boolean success = lectureDao.update(lectureDto);
		if(success) {
			return "수정완료";
		}
		else {
			return "존재하지 않는 강좌입니다.";
		}
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int lectureNo) {
		boolean success = lectureDao.delete(lectureNo);
		if(success) {
			return "삭제완료";
		}
		else {
			return "존재하지 않는 강좌입니다.";
		}
	}
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column, @RequestParam(required = false) String keyword) {
		List<LectureDto> list = lectureDao.selectList(column, keyword);
		StringBuffer buffer = new StringBuffer();
		buffer.append("결과 수 : " + list.size());
		buffer.append("<br>");
		for(LectureDto lectureDto:list) {
			buffer.append(lectureDto);
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	@RequestMapping("/detail")
	public String detail(@RequestParam int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) {
			return "존재하지 않는 강좌 정보";
		}
		else {
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("번호 : " + lectureDto.getLectureNo() + " <br>");
			buffer.append("제목 : " + lectureDto.getLectureTitle() + " <br>");
			buffer.append("카테고리 : " + lectureDto.getLectureCategory() + " <br>");
			buffer.append("기간 : " + lectureDto.getLectureDuration() + " <br>");
			buffer.append("수강료 : " + lectureDto.getLecturePrice() + " <br>");
			buffer.append("형태 : " + lectureDto.getLectureType() + " <br>");
			return buffer.toString();
		}
	}
	
	
}
