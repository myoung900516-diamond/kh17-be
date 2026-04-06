package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
	

}
