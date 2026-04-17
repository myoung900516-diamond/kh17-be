package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class BoardReadInterceptor implements HandlerInterceptor{
	@Autowired
	private BoardDao boardDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String aa = request.getParameter("boardNo");
		if(aa != null && !aa.isEmpty()) {
		int boardNo = Integer.parseInt(aa);
		boardDao.readCount(boardNo);
		}
		//조회를 클릭하면 detail컨트롤러가 실행되기 전에 
		//조회수가 1늘어나는 dao를 실행하라
		return true;
	}
	

}
