<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 		글쓰기창을 답글일 때와 새글일 때로 나워서 처리 -->
<c:if test="${param.boardParent == null}">
<h1>신규 글 작성</h1>
</c:if>
<c:if test="${param.boardParent != null}">
<h1>답변 글 작성</h1>
</c:if>

타인에 대한 무분별한 비방글은 경고 없이 삭제될 수 있습니다
<form action="./write" method="post">
	<c:if test="${param.boardParent != null}">
		<input type="hidden" name="boardParent" value="${param.boardParent}">
	</c:if>
		[제목]<input type="text" name="boardTitle" required><br>
<!-- [제목]<input type="text" name="boardTitle" required value="답변: "><br> -->
		[구분]
				<select name="boardHead" >
						<option value="">선택 안함</option>
<!-- 						<option value="공지">공지</option> -->
<!-- 						<option value="유머">유머</option> -->
<!-- 						<option value="자유">자유</option> -->
<!-- 						<option value="정보">정보</option> -->
<!-- 공지는 관리자에게만 보이도록 해야함  -->
						<c:if test="${sessionScope.loginLevel == '마스터'}">
						<option>공지</option>
						</c:if>
						<option>유머</option>
						<option>자유</option>
						<option>정보</option>
				</select>
		
		[내용]<br><textarea rows="10" cols="100" name="boardContent" required></textarea><br>
		<button>글 등록하기</button>
</form>
<button><a href="./list">목록</a></button>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>