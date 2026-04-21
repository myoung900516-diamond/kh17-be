<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
    <h1>자유게시판</h1>
    타인에 대한 무분별한 비방글은 예고 없이 삭제될 수 있습니다
    <hr>
 ${pageVO.getBeginRownum()}-${pageVO.getEndRownum()}/${pageVO.count}
<table border="1" width="900">
		<thead align="center">
				<tr>
						<th>번호</th>
						<th>구분</th>
						<th width="45%">제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>좋아요</th>
				</tr>
		</thead>
		<tbody align="left">
<!-- 		공지사항 -->
<%-- 					<c:forEach var="boardDto" items="${list}"> --%>
<%-- 					<c:forEach var="boardDto" items="${noticeList}"> --%>
<%-- 			<c:if test="${boardDto.boardHead=='공지'}"> --%>
<!-- 						<tr bgcolor="#6a89cc"> -->
<%-- 								<td>${boardDto.boardNo}</td> --%>
<%-- 								<td>${boardDto.boardHead}</td> --%>
<!-- 								<td> -->
<!-- <!-- 									<span></span> --> 
<%-- 									<a href="./detail?boardNo=${boardDto.boardNo}"> --%>
									
<%-- 									${boardDto.boardTitle}</a> --%>
<!-- 									수정되었다면 수정됨 표시 -->
<%-- 									<c:if test="${boardDto.boardEtime != null}"> --%>
<!-- 									(수정됨) -->
<%-- 									</c:if> --%>
<%-- 									<c:if test="${boardDto.boardReplycount > 0}"> --%>
<%-- 										(${boardDto.boardReplycount})</c:if> --%>
<!-- 								</td> -->
<%-- 								<td><a href="/member/detail">${boardDto.boardWriter}</a></td> --%>
<%-- 								<td>${boardDto.boardWtimeString}</td> --%>
<%-- 								<td>${boardDto.boardReadcount}</td> --%>
<%-- 								<td>${boardDto.boardLikecount}</td> --%>
<!-- 						</tr> -->
<%-- 			</c:if> --%>
<%-- 					</c:forEach> --%>

<!-- 일반게시글 -->
<!-- 		varStatus를 쓰면 반복문의 상태를 알 수 있다(index, count, first, last) -->
			<c:forEach var="boardDto" items="${list}" varStatus="stat">
<%-- 				<tr bgcolor="${boardDto.boardHead == '공지'? '#6a89cc' : ''}"> --%>
					<tr bgcolor="${stat.index < noticeCount ? '#6a89cc' : '' }">
						<td>${boardDto.boardNo}</td>
						<td>${boardDto.boardHead}</td>
						<td>
							<a href="./detail?boardNo=${boardDto.boardNo}">
							${boardDto.boardTitle}</a>
									<!-- 수정되었다면 수정됨 표시 -->
									<c:if test="${boardDto.boardEtime != null}">
									(수정됨)
									</c:if>
							
							<c:if test="${boardDto.boardReplycount > 0}">
										(${boardDto.boardReplycount})</c:if>
										
							</td>
						<td><c:if test="${boardDto.boardWriter == null}" >
						(탈퇴한 사용자)
						</c:if>
						<c:if test="${boardDto.boardWriter != null}">
						<a href="/member/detail?memberId=${boardDto.boardWriter}">${boardDto.boardWriter}</a>
						</c:if>
						</td>
						<td>${boardDto.boardWtimeString}</td>
						<td>${boardDto.boardReadcount}</td>
						<td>${boardDto.boardLikecount}</td>
				</tr>
			</c:forEach>
		</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/pagination.jsp"></jsp:include>
<!-- <h2> -->
<%-- <c:if test="${pageVO.hasPrevious()}"> --%>
<%-- <a href="./list?page=${pageVO.getPreviousBlock()}&${pageVO.getSearchParams()}">&lt;</a></c:if> --%>
<%-- <c:forEach var="i" begin="${pageVO.getBeginBlock()}" end="${pageVO.getEndBlock()}" step="1"> --%>
<%-- <a href="./list?page=${i}&${pageVO.getSearchParams()}">${i}</a>  --%>
<%-- </c:forEach> --%>
<%-- <c:if test="${pageVO.hasNext()}"> --%>
<%-- <a href="./list?page=${pageVO.getNextBlock()}&${pageVO.getSearchParams()}">&gt;</a></c:if> --%>
<%-- <a href="./list?page=2&size=${size}${searchParams}">2</a>  --%>
<%-- <a href="./list?page=3&size=${size}${searchParams}">3</a>  --%>
<%-- <a href="./list?page=4&size=${size}${searchParams}">4</a>  --%>
<%-- <a href="./list?page=5&size=${size}${searchParams}">5</a>  --%>
<%-- <a href="./list?page=6&size=${size}${searchParams}">6</a>  --%>
<%-- <a href="./list?page=7&size=${size}${searchParams}">7</a>  --%>
<%-- <a href="./list?page=8&size=${size}${searchParams}">8</a>  --%>
<%-- <a href="./list?page=9&size=${size}${searchParams}">9</a>  --%>
<%-- <a href="./list?page=10&size=${size}${searchParams}">10</a>  --%>
<!--  &gt; -->
<!-- </h2> -->
<!-- html 특수문자 코드표 -->

<c:if test="${sessionScope.loginId != null}">
<button>
	<a href="./write">글쓰기</a>
</button>
	</c:if>

<form action="./list" method="get">
		<select name="column">
				<option value="board_title"  ${param.column == 'board_title' ? 'selected' : ''} >제목</option>
				<option value="board_writer" ${param.column == 'board_writer' ? 'selected' : ''}>작성자</option>
				
		</select>
				<input type="text" name="keyword" placeholder="검색어를 입력해주세요"
						value="${param.keyword}" ><button>🔍</button>
						
</form>
    
    
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>