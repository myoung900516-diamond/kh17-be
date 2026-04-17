<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
    <h1>게시판 목록</h1>
 
<table board="1" width="900">
		<thead align="left">
				<tr>
						<th>번호</th>
						<th>구분</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>좋아요</th>
						<th>댓글수</th>
				</tr>
		</thead>
		<tbody align="left">
			<c:forEach var="boardDto" items="${list}">
				<tr>
						<td>${boardDto.boardNo}</td>
						<td>${boardDto.boardHead}</td>
						<td>
							<a href="./detail?boardNo=${boardDto.boardNo}">
							${boardDto.boardTitle}</a>
							</td>
						<td>${boardDto.boardWriter}</td>
						<td>${boardDto.boardWtime}</td>
						<td>${boardDto.boardReadcount}</td>
						<td>${boardDto.boardLikecount}</td>
						<td>${boardDto.boardReplycount}</td>
				</tr>
			</c:forEach>
		</tbody>
</table>

<a href="./write">글쓰기</a>

<form action="./list" method="get">
		<select name="column">
				<option value="board_title"  ${param.column == 'board_title' ? 'selected' : ''} >제목</option>
				<option value="board_writer" ${param.column == 'board_writer' ? 'selected' : ''}>작성자</option>
				
		</select>
				<input type="text" name="keyword" placeholder="검색어를 입력해주세요"
						value="${param.keyword}" required><button>🔍</button>
						
</form>
    
    
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>