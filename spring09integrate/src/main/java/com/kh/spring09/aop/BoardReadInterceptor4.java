package com.kh.spring09.aop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dao.BoardReadDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//목표: 
//-데이터베이스를 이용해서 조회 이력을 저장하고 조회수 중복 중가를 차단
//-아이디를 기반으로 하기 때문에 세션이 달라도 차단이 가능
@Service
public class BoardReadInterceptor4 implements HandlerInterceptor {
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardReadDao boardReadDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String boardNoStr = request.getParameter("boardNo");
		// 1.boardNo가 없는 경우 제거
		if (boardNoStr == null) {
			throw new TargetNotfoundException("존재하지 않는 게시글");
		}
//		2.boardNo가 유효하지 않는 번호인 경우 제거
		long boardNo = Long.parseLong(boardNoStr);
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if (boardDto == null) {
			throw new TargetNotfoundException("존재하지 않는 게시글");
		}
		//3.비회원인 경우 제거
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		if(loginId == null) {
			return true;
		}
		//4.데이터베이스에 조회이력이 있으면 제거 
		int count=boardReadDao.count(loginId, boardNo);
		if(count > 0) {
			return true;
		}
		
		//5. 조회이력이 없으면 조회이력을 생성
		boardReadDao.insert(loginId, boardNo);
		
		
		
		
		
		//6.조회수 증가 처리
		boardDao.updateBoardReadcount(boardNo);
//		if(boardNoStr != null && !boardNoStr.isEmpty()) {
//		long boardNo = Long.parseLong(boardNoStr);
//		boardDao.readCount(boardNo);
//		}
		// 조회를 클릭하면 detail컨트롤러가 실행되기 전에
		// 조회수가 1늘어나는 dao를 실행하라
		return true;
	}

}
