package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.exception.TargetNotfoundException;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:./joinFinish";
	}
	@RequestMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
//	@GetMapping("/login")
//	public String login(@RequestParam(required = false) String memberId, 
//						@RequestParam(required = false) String memberPassword, 
//						Model model) {
//		MemberDto memberDto = memberDao.selectOne(memberId);
//		if(memberDto == null) throw new TargetNotfoundException("회원정보를 잘못 입력하였습니다");
//		model.addAttribute("memberDto", memberDto);
//		return "/WEB-INF/views/member/login.jsp";
//	}
//	@PostMapping("/login")
//	public String login(@ModelAttribute MemberDto memberDto) {
//		memberDao.update(memberDto);
//		return "redirect:/";
//	}
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	@PostMapping("/login")
	public String login(@RequestParam String memberId, 
						@RequestParam String memberPassword) {
		boolean findDto = memberDao.login(memberId, memberPassword);
		if(findDto == false) throw new TargetNotfoundException("회원정보를 잘못 입력하였습니다");
//		if(!memberDto.getMemberId().equals(memberId) || 
//			!memberDto.getMemberPassword().equals(memberPassword))
//		throw new TargetNotfoundException("회원정보를 잘못 입력하였습니다");
//		if(memberDto.getMemberId().equals(memberId) && 
//				memberDto.getMemberPassword().equals(memberPassword))
		return "redirect:/";
	}

}
