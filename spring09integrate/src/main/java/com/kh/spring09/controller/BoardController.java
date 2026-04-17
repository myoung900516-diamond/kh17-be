package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column, 
							@RequestParam(required = false) String keyword, 
							Model model) {
		List<BoardDto> list = boardDao.selectList(column, keyword);
		model.addAttribute("list", list);
		return "board/list";
	}
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo, Model model, HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		model.addAttribute("loginId", loginId);
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException();
		model.addAttribute("boardDto", boardDto);
		return "board/detail";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		return "board/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		boardDao.update(boardDto);
		return "redirect:./detail?boardNo=" + boardDto.getBoardNo();
	}
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		boardDto.setBoardWriter(loginId);
		boardDao.insert(boardDto);
		return "redirect:./list";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
