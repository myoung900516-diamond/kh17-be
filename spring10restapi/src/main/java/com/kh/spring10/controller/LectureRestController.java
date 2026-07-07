package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.LectureDao;
import com.kh.spring10.dto.LectureDto;
import com.kh.spring10.error.TargetNotfoundException;
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
	public LectureDto insert(@RequestBody LectureDto lectureDto) {
		int lectureNo = lectureDao.sequence();
		lectureDto.setLectureNo(lectureNo);
		lectureDao.insert(lectureDto);
		//최종적으로 완성된 정보를 반환(ex: 번호, 시간 등이 모두 포함된...)
		//->이렇게 하려면 DB를 한번 더 가야함
//		return lectureDao.selectOne(lectureNo);
		return lectureDto;
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
		//내림 차순 이기 때문에 0이면 0보다 작다가 되엇 문제가 되므로 변경
		if(lastLectureNo == 0) {
			lastLectureNo = Integer.MAX_VALUE;
		}
		List list = lectureDao.selectListFroReact(lastLectureNo, size);
		int count = lectureDao.countForReact(lastLectureNo);
		
		return ListVO.builder()
					.list(list)
					.last(count <= size)
					.build();
	}
	//query string 방식
	@GetMapping("/detail")
	public LectureDto detail(@RequestParam int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		return lectureDto;
	}
	//path variable 방식
	@GetMapping("/detail/{lectureNo}")
	public LectureDto detail2(@PathVariable int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		return lectureDto;
	}

	
	@GetMapping("/delete")
	public void delete(@RequestParam int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException();
		lectureDao.delete(lectureNo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
