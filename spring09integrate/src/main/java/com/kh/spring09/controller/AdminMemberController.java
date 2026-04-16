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

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dao.MemberHistoryDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.dto.MemberHistoryDto;
import com.kh.spring09.exception.TargetNotfoundException;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberHistoryDao memberHistoryDao;
	
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column, 
							@RequestParam(required = false) String keyword, 
							Model model) {
		List<MemberDto> list = memberDao.selectList(column, keyword);
		
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/admin/member/list.jsp";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) throw new TargetNotfoundException("대상이 존재하지 않습니다");
		model.addAttribute("memberDto", memberDto);
		
		List<MemberHistoryDto> loginHistory = 
				memberHistoryDao.selectList(memberId, 1, 10);
		model.addAttribute("loginHistory", loginHistory);
		
		return "/WEB-INF/views/admin/member/detail.jsp";
	}
	@RequestMapping("/block")
	public String block(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberBlock", memberDto.getMemberBlock());
		if(memberDto.getMemberBlock().equals("Y")) {
			memberDao.unblock(memberId);
		}
		else {
			memberDao.block(memberId);
		}
		return "/WEB-INF/views/admin/member/block.jsp";
	}
	@GetMapping("/edit")
	public String edit(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) throw new TargetNotfoundException("대상이 존재하지 않습니다");
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/member/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto) {
		memberDao.updateForMaster(memberDto);
		return "redirect:./detail?memberId=" + memberDto.getMemberId();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
