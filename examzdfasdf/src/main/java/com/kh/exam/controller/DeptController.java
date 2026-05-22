package com.kh.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.exam.dao.DeptDao;
import com.kh.exam.dto.DeptDto;

@Controller
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	private DeptDao deptDao;
	
	@GetMapping("/add")
	public String add() {
		return "dept/add";
	}
	@PostMapping("/add")
	public String add(@ModelAttribute DeptDto deptDto) {
		deptDao.insert(deptDto);
		if(deptDto == null) {
			return "redirect:./add?error"; 
	}
		//부서명이 중복되었을 때 처리
		/*
		 * if(이미 사용중인 부서명이라면) { return "redirect:add?duplicate"; }
		 */
		
		return "redirect:addFinish";
	}
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "dept/addFinish";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
