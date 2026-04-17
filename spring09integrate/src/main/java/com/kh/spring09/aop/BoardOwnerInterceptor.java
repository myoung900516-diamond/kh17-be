package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class BoardOwnerInterceptor implements HandlerInterceptor{
	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		String memberId = request.getParameter("memberId");
//		HttpSession session = request.getSession();
//		String loginId = (String) session.getAttribute("loginId");
//		String loginLevel = (String) session.getAttribute("loginLevel");
//		if(loginId == null || loginLevel == null) {
//			throw new WhoAreYouException();
//		}
		String memberId = request.getParameter("memberId");
		
		if(memberId == null) {
			throw new IllegalArgumentException("잘못된 형식의 요청");
		}
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) {
			throw new TargetNotfoundException("존재하지 않는 회원");
		}
//		if(memberDto.getMemberId().equals(loginId)) 
			return true;
//		return false;
	}

}
