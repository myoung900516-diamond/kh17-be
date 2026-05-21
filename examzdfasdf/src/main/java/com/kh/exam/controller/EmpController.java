package com.kh.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.exam.dao.EmpDao;
import com.kh.exam.dto.EmpDto;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpDao empDao;
	
	@GetMapping("/create")
	public String create() {
		return "emp/create";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute EmpDto empDto) {
		empDao.insert(empDto);
		return "redirect:./createComplate";
	}
	@RequestMapping("/createComplate")
	public String createComplate() {
		return "emp/createComplate";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
