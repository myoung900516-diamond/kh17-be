<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<h1>
	<c:if test="${boardDto.boardHead != null}">
[구분] : ${boardDto.boardHead}</c:if>
[제목] : ${boardDto.boardTitle}
</h1>
<!-- <hr> -->
<a href="/member/detail">${boardDto.boardWriter}</a> <br>

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
<button>
<c:if test="${sessionScope.loginId != null}">
	<a href="./write">글쓰기</a></c:if>
</button>
<c:if test="${loginId == boardDto.boardWriter}">
	<button>
		<a href="./edit?boardNo=${boardDto.boardNo}">수정</a>
	</button>
	<button>
		<a href="./delete?boardNo=${boardDto.boardNo}">삭제</a>
	</button>
</c:if>
<button><a href="./list">목록</a></button><br>





<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>