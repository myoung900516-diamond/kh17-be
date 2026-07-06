package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.LectureDao;
import com.kh.spring10.dto.LectureDto;
import com.kh.spring10.vo.ListVO;

@CrossOrigin
@RestController
@RequestMapping("/api/lecture")
public class LectureRestController {
	@Autowired
	private LectureDao lectureDao;
	
	
	//리액트에 대응하는 등록(RestController)
	//-> 데이터가  AJAX 방식으로 전송
	//	-> 기본형태가 application/json
	// 	-> {'key1' : 'value1', 'key2' : 'value2', }
	// POST처럼 Body가 존재하는 방식에서만 가능
	@PostMapping("/insert")
	public void insert(@RequestBody LectureDto lectureDto) {
		int lectureNo = lectureDao.sequence();
		lectureDto.setLectureNo(lectureNo);
		lectureDao.insert(lectureDto);
	}
	
	@GetMapping("/list")
	public List<LectureDto> list(){
		return lectureDao.selectList();
	}
	
	@GetMapping("/listForReact")
	public ListVO listForReact(
			@RequestParam(required = false, defaultValue= "0") int lastLectureNo, 
			@RequestParam(required = false, defaultValue= "10") int size
			){
		List list = lectureDao.selectListFroReact(lastLectureNo, size);
		int count = lectureDao.countForReact(lastLectureNo);
		
		return ListVO.builder()
					.list(list)
					.last(count <= size)
					.build();
	}
	
	@GetMapping("/detail")
	public LectureDto detail(@RequestParam int lectureNo) {
		return lectureDao.selectOne(lectureNo);
	}
	
	@GetMapping("/delete")
	public boolean delete(@RequestParam int lectureNo) {
		return lectureDao.delete(lectureNo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
