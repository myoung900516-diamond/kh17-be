package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//목표: 본인 소유의 글은 조회수가 오르지 않게 하고 싶음
//최소한의 조회수 증가 방지 처리
//최소한 = 비회원이 글을 읽으면 조회수 증가 처리를 안할 거다 
//=탈퇴한 사용자가 작성한 글은 조회수 증가 처리 안함 
//=회원일 경우 본인 글은 조회수 증가 처리 안함 
@Service
public class BoardReadInterceptor2 implements HandlerInterceptor{
	@Autowired
	private BoardDao boardDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String boardNoStr = request.getParameter("boardNo");
		//1.boardNo가 없는 경우 제거 
		if(boardNoStr == null) {
			throw new TargetNotfoundException("존재하지 않는 게시글");
		}
//		2.boardNo가 유효하지 않는 번호인 경우 제거
		long boardNo = Long.parseLong(boardNoStr);
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) {
			throw new TargetNotfoundException("존재하지 않는 게시글");
		}
		//3. 비회원이면 통과 
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		if(loginId == null) {
			return true;
		}
		
		//4. 작성자가 탈퇴한 경우를 제거 
		if(boardDto.getBoardWriter()==null) {
			return true;
		}
		//5. 본인 소유인 경우를 제거 
		if(loginId.equals(boardDto.getBoardWriter())) {
			return true;
		}
		boardDao.updateBoardReadcount(boardNo);
//		if(boardNoStr != null && !boardNoStr.isEmpty()) {
//		long boardNo = Long.parseLong(boardNoStr);
//		boardDao.readCount(boardNo);
//		}
		//조회를 클릭하면 detail컨트롤러가 실행되기 전에 
		//조회수가 1늘어나는 dao를 실행하라
		return true;
	}
	

}
