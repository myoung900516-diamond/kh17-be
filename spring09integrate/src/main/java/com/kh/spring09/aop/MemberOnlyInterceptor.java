package com.kh.spring09.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.exception.WhoAreYouException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//비회원이란? HttpSession에 loginId와 loginLevel이 존재하지 않는 사용자
@Service
public class MemberOnlyInterceptor  implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		String loginLevel = (String) session.getAttribute("loginLevel");
		if(loginId == null || loginLevel == null) {
//			return "redirect:/member/login";
//			response.sendRedirect("/member/login");
//			response.sendError(401);
//			return false;
			throw new WhoAreYouException();
//			System.out.println("멤버온니 인터셉터가 실행되었습니다");
		}
		return true;
	}
	
		
}
