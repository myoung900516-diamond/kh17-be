package com.kh.spring09.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.exception.GetOutException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class MasterOnlyInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		String loginLevel = (String) session.getAttribute("loginLevel");
		
//		System.out.println(loginLevel);
//		System.out.println("아무거나");
		if(loginId != null && "마스터".equals(loginLevel)) {
			return true;
		}
		else throw new GetOutException();
//		if(loginId == null || loginLevel != "마스터") {
//			throw new GetOutException();
//		}
//		return true;
		
	}
	

}
