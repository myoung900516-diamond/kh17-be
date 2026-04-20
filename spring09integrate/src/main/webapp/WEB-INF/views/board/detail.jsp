<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<h1>
	<c:if test="${boardDto.boardHead != null}">
[구분] : ${boardDto.boardHead}</c:if>
[제목] : ${boardDto.boardTitle}
<!-- 수정되었다면 수정됨 표시 -->
<c:if test="${boardDto.boardEtime != null}">
(수정됨)
</c:if>
</h1>
<!-- <hr> -->
	<c:if test="${boardDto.boardWriter == null}" >(탈퇴한 사용자)</c:if>
	<c:if test="${boardDto.boardWriter != null}">
						<a href="/member/detail?memberId=${boardDto.boardWriter}">${boardDto.boardWriter}</a>
	</c:if>
						
<br>

<fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
&nbsp;&nbsp;&nbsp;&nbsp;
 [조회수] : ${boardDto.boardReadcount}
<hr>
<div style="min-height: 250px">

<pre>[내용]: ${boardDto.boardContent}</pre>
</div>
<br><br>

좋아요 ${boardDto.boardLikecount} 
댓글 ${boardDto.boardReplycount}

<br>
<hr>

이전글 : <a href="./detail?boardNo=${prevBoardDto.boardNo}"> ${prevBoardDto.boardTitle}</a>
<br>
다음글 : <a href="./detail?boardNo=${prevNextDto.boardNo}">${nextBoardDto.boardTitle}</a>
<hr>
<c:if test="${sessionScope.loginId != null}">
<button>
	<a href="./write">글쓰기</a>
</button>
	</c:if>
<!-- 비회원이 탈퇴한 글을 볼 때 본인으로 판정되는 걸 제거하기 위한 추가 검사 코드 -->
<c:if test="${boardDto.boardWriter != null && sessionScope.loginId == boardDto.boardWriter}">
	<button>
		<a href="./edit?boardNo=${boardDto.boardNo}">수정</a>
	</button>
	<button>
		<a href="./delete?boardNo=${boardDto.boardNo}">삭제</a>
	</button>
</c:if>
<button>
<a href="./list">목록</a>
</button>
<br>





<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>