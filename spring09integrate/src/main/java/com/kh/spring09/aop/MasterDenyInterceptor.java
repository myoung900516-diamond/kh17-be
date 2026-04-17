package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.exception.GetOutException;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class MasterDenyInterceptor implements HandlerInterceptor{
	@Autowired
	private MemberDao memberDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//인터셉터에서는 사용자정보(request)에서 파라미터를 추출한다
		String memberId = request.getParameter("memberId");
		
		if(memberId == null) {
			throw new IllegalArgumentException("잘못된 형식의 요청");
		}
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) {
			throw new TargetNotfoundException("존재하지 않는 회원");
		}
		
		
		if(memberDto.getMemberLevel().equals("마스터")) {
			throw new GetOutException();
		}
		
		return true;
	}
	

}
