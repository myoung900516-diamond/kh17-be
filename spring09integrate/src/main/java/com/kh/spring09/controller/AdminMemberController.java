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
import com.kh.spring09.dao.MemberExitDao;
import com.kh.spring09.dao.MemberHistoryDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.dto.MemberExitDto;
import com.kh.spring09.dto.MemberHistoryDto;
import com.kh.spring09.exception.GetOutException;
import com.kh.spring09.exception.TargetNotfoundException;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberHistoryDao memberHistoryDao;
	@Autowired
	private MemberExitDao memberExitDao;
	
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column, 
							@RequestParam(required = false) String keyword, 
							Model model) {
		List<MemberDto> list = memberDao.selectList(column, keyword);
		
		model.addAttribute("list", list);
		
		return "admin/member/list";
	}
	//상대경로 : ?가 하나 정도 있을 때 좋음 
	//@RequestMapping("/detail/{memberId}")
	//public String detail(@PathVariable String memberId, Model model)
	@RequestMapping("/detail")
	public String detail(@RequestParam String memberId, Model model) {
		MemberExitDto memberDto = memberExitDao.selectOne(memberId);
//		if(memberDto == null) throw new TargetNotfoundException("대상이 존재하지 않습니다");
//		if(memberDto.getMemberLevel().equals("마스터")) throw new GetOutException();
		model.addAttribute("memberDto", memberDto);
		
		List<MemberHistoryDto> loginHistory = 
				memberHistoryDao.selectList(memberId, 1, 10);
		model.addAttribute("loginHistory", loginHistory);
		
		return "admin/member/detail";
	}
	@RequestMapping("/block")
	public String block(@RequestParam String memberId) {
//			, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
//		model.addAttribute("memberBlock", memberDto.getMemberBlock());
		if(memberDto.getMemberBlock().equals("Y")) {
			memberDao.unblock(memberId);
		}
		else {
			memberDao.block(memberId);
		}
//		return "admin/member/block";
		return "redirect:./detail?memberId="+memberId;
	}
	@GetMapping("/edit")
	public String edit(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) throw new TargetNotfoundException("대상이 존재하지 않습니다");
		model.addAttribute("memberDto", memberDto);
		return "admin/member/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto) {
		MemberDto findMemberDto = memberDao.selectOne(memberDto.getMemberId());
		if(findMemberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
		
		memberDao.updateByMaster(memberDto);
		return "redirect:./detail?memberId=" + memberDto.getMemberId();
	}
//	@RequestMapping("/profile")
//	public String profile(@RequestParam String memberId) {
//		try {
//			int attachNo = memberDao.searchProfile(memberId);
//			return "redirect:/download/modern?attachNo=" + attachNo;
//		}
//		catch(Exception e) {
//			return "redirect:/images/noimgpng.png";
//		}
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
