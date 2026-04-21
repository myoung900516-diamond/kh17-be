package com.kh.spring09.aop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//목표: 세션을 이용해서 읽은 글의 번호를 관리 
//-절차 
//1. 세션에 memory라는 이름의 저장소가 있다고 가정한다(저장소는 HashSet이다)
//2. 세션에서 memory저장소를 꺼낸다
//3. 2번에서 저장소가 없으면 신규 생성한다 
//4. 현재 읽으려는 글번호가 memory 저장소에 존재하는지 확인 
//5-1. 만약 존재한다면 조회수 증가 안하고 통과
//5-2. 만약 존재하지 않는다면 저장소에 번호를 등록하고 조회수 증가 처리후 통과 
@Service
public class BoardReadInterceptor3 implements HandlerInterceptor {
	@Autowired
	private BoardDao boardDao;

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
//		3. 세션에 memory 항목을 조사하여 조회수 증가 /유지 여부를 판정
		HttpSession session = request.getSession();
		Set<Long> memory = (Set<Long>) session.getAttribute("memory");

		if (memory == null) {
			memory = new HashSet<>();
		}
		// 확인용 로그
		System.out.println(memory);
		if (memory.contains(boardNo)) {
			return true;
		}

		// 세션갱신
		memory.add(boardNo);
		session.setAttribute("memory", memory);

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
