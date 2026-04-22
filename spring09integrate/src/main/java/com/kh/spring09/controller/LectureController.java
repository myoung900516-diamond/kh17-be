package com.kh.spring09.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.LectureDao;
import com.kh.spring09.dto.LectureDto;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.service.AttachService;
import com.kh.spring09.vo.PageVO;

@Controller
@RequestMapping("/lecture")
public class LectureController {
	@Autowired
	private LectureDao lectureDao;
	@Autowired
	private AttachService attachService;
	
//	@RequestMapping("/insert1")
	@GetMapping("/insert")
	public String insert() {
		return "lecture/insert";
	}
//	@RequestMapping("/insert2")
	@PostMapping("/insert")
	public String insert(@ModelAttribute LectureDto lectureDto, 
			//RequestParam에 value를 적으면 수신할 
							@RequestParam(value="attach") List<MultipartFile> attachList) throws IllegalStateException, IOException {
		int lectureNo = lectureDao.sequence();
		lectureDto.setLectureNo(lectureNo);
		lectureDao.insert(lectureDto);
		for(MultipartFile attach:attachList) {
			if(!attach.isEmpty()) {
				int attachNo = attachService.save(attach);
				lectureDao.connect(lectureNo, attachNo);
			}
		}
		return "redirect:./insertComplete";
	}
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "lecture/insertComplete";
	}
	@RequestMapping("/list")
	public String list(@ModelAttribute PageVO pageVO,
//			@RequestParam(required = false) String column, @RequestParam(required = false) String keyword, 
			Model model) {
//		List<LectureDto> list = lectureDao.selectList(column, keyword);
//		model.addAttribute("list", list);
		
		List<LectureDto> list = lectureDao.selectList(pageVO);
		model.addAttribute("list", list);
		int count = lectureDao.count(pageVO);
		pageVO.setCount(count);
		model.addAttribute("pageVO", pageVO);
		return "lecture/list";
	}
	@RequestMapping("/detail")
	public String detail(@RequestParam int lectureNo, Model model) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null)
			throw new TargetNotfoundException("존재하지 않는 강좌 정보");
		model.addAttribute("lectureDto", lectureDto);
		return "lecture/detail";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int lectureNo) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
			if(lectureDto == null) throw new TargetNotfoundException("존재하지 않는 강좌");
			lectureDao.delete(lectureNo);
		return "redirect:./list";
		}
	@GetMapping("/edit")
	public String edit(@RequestParam int lectureNo, Model model ) {
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		if(lectureDto == null) throw new TargetNotfoundException("존재하지 않는 강좌");
		
		model.addAttribute("lectureDto", lectureDto);
		return "lecture/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute LectureDto lectureDto) {
		lectureDao.update(lectureDto);
		return "redirect:./detail?lectureNo="+lectureDto.getLectureNo();
	}
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
