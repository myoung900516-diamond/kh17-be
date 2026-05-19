package com.kh.spring09.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dao.MemberLikeDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.vo.LikeVO;

import jakarta.servlet.http.HttpSession;

@CrossOrigin//외부 접근을 허용(CORS허용)
@RestController
@RequestMapping("/rest/member")
public class MemberRestController {
	
	//아이디 중복검사
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberLikeDao memberLikeDao;
	
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
	
	//회원 좋아요 체크 및 좋아요하기
	
	@PostMapping("/like-check")
	public LikeVO likeCheck(@RequestParam String memberTarget, HttpSession session){
		String loginId = (String)session.getAttribute("loginId");
		
		boolean action = memberLikeDao.check(loginId, memberTarget);
		int count = memberLikeDao.count(memberTarget);
		
		
		return LikeVO.builder().action(action).count(count).build();
	}
	
	//2.좋아요 클릭시 좋아요 토글 처리와 결과적으로 만들어진 좋아요 개수를 구해주는 매핑/비회원 진입 불가
	//-비회원 차단은 인터셉터에서 구현
	@PostMapping("/like-action")
	public LikeVO lickAction(@RequestParam String memberTarget, HttpSession session){
		String loginId = (String)session.getAttribute("loginId");
		
		boolean current = memberLikeDao.check(loginId, memberTarget);
		if(current) {//좋아요 설정한 적이 있으면 
			memberLikeDao.delete(loginId, memberTarget);//좋아요 해제
		}
		else {
			memberLikeDao.insert(loginId, memberTarget);//좋아요 설정	
		}
		
		int count = memberLikeDao.count(memberTarget);
		
		return LikeVO.builder().action(!current).count(count).build();
	}
	

}
