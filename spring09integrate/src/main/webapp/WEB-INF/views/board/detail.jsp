<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<button><a href="./list">목록</a></button><br>
[구분] : ${boardDto.boardHead}[제목] : ${boardDto.boardTitle}
<hr>
[작성자] : <a href="/member/detail">${boardDto.boardWriter}</a> <br>
[작성일] : ${boardDto.boardWtime} <br> 
 [조회수] : ${boardDto.boardReadcount}
<hr>
[내용]: ${boardDto.boardContent}
<br>

좋아요 ${boardDto.boardLikecount} 댓글 ${boardDto.boardReplycount}

<br>
<hr>
<button>
	<a href="./write">글쓰기</a>
</button>
<c:if test="${loginId == boardDto.boardWriter}">
	<button>
		<a href="./edit?boardNo=${boardDto.boardNo}">수정</a>
	</button>
	<button>
		<a href="./delete?boardNo=${boardDto.boardNo}">삭제</a>
	</button>
</c:if>





<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>