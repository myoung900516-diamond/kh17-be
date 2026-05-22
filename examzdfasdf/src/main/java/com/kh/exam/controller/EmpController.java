package com.kh.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.exam.dao.DeptDao;
import com.kh.exam.dao.EmpDao;
import com.kh.exam.dto.DeptDto;
import com.kh.exam.dto.EmpDto;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;
	
	
	
	
	
	//사원 등록 화면에는 반드시 활성화된 부서 명단이 넘어가야함 
	@GetMapping("/create")
	public String create(Model model) {
		//List<DeptDto> list = deptDao.selectActiveList();
		//model.addAttribute("list", list);
		return "emp/create";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute EmpDto empDto) {
		int empId = empDao.sequence();
		empDto.setEmpId(empId);
		
		empDao.insert(empDto);
		
		return "redirect:./createComplate";
	}
	@RequestMapping("/createComplate")
	public String createComplate() {
		return "emp/createComplate";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
