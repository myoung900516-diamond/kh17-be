package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.exception.GetOutException;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.exception.WhoAreYouException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//본인 소유의 글일 경우만 통과시키기 위한 인터셉터 
@Service //한마디로 정의할 수 없을 때 
public class BoardOwnerInterceptor implements HandlerInterceptor{
//	@Autowired
//	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		1. 파라미터에 boardNo가 없으면 차단 
		String boardNoStr = request.getParameter("boardNo");
		if(boardNoStr == null) {
			throw new TargetNotfoundException("존재하지 않는 게시글");
		}
//		2. 로그인된 사용자가 아니면 차단 
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		if(loginId == null) {
			throw new WhoAreYouException();
		}
//		3. 존재하지 않는 글이면 차단 
		long boardNo = Long.parseLong(boardNoStr);
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) {
			throw new TargetNotfoundException("존재하지 않는 게시글");
		}
//		4. 작성자가 탈퇴했다면 차단
		if(boardDto.getBoardWriter() == null) {
			throw new GetOutException();
		}
//		5. 소유자가 아니면 차단 
		if(!loginId.equals(boardDto.getBoardWriter())) {
			throw new GetOutException();
		}
		
//		1~5을 통과하면 본인 소유의 글로 접근할 수있도록 한다 
		
//		String memberId = request.getParameter("memberId");
//		HttpSession session = request.getSession();
//		String loginId = (String) session.getAttribute("loginId");
//		String loginLevel = (String) session.getAttribute("loginLevel");
//		if(loginId == null || loginLevel == null) {
//			throw new WhoAreYouException();
//		}
//		String memberId = request.getParameter("memberId");
		
//		if(memberId == null) {
//			throw new IllegalArgumentException("잘못된 형식의 요청");
//		}
//		if(loginId == null) {
//			throw new IllegalArgumentException("잘못된 형식의 요청");
//		}
		
//		MemberDto memberDto = memberDao.selectOne(memberId);
//		if(memberDto == null) {
//			throw new TargetNotfoundException("존재하지 않는 회원");
//		}
//		if(memberDto.getMemberId().equals(loginId)) 
			return true;
//		return false;
	}

}
