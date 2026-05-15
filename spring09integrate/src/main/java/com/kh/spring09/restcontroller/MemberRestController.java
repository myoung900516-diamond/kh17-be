package com.kh.spring09.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;

@CrossOrigin//외부 접근을 허용(CORS허용)
@RestController
@RequestMapping("/rest/member")
public class MemberRestController {
	
	//아이디 중복검사
	@Autowired
	private MemberDao memberDao;
	
	//아이디 중복검사(없으면=사용가능 =true)
	@RequestMapping("/validId")
	public boolean validId(@RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		return memberDto == null;
	}
	//닉네임 중복검사(없으면 = 사용 가능하면 =true반환)
	@PostMapping("/validNickname")
	public boolean validNickname(@RequestParam String memberNickname) {
		MemberDto memberDto = memberDao.selectOneByMemberNickname(memberNickname);
		return memberDto == null;
	}
	@PostMapping("/validEmail")
	public boolean validEmail(@RequestParam String memberEmail) {
		MemberDto memberDto = memberDao.selectOneByMemberEmail(memberEmail);
		return memberDto == null;
	}
	

}
