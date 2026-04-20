<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="./edit" method="post">
<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
[제목] <input type="text" name="boardTitle" value="${boardDto.boardTitle}" required>
[구분]
				<select name="boardHead" >
						<option value="">선택 안함</option>
												<c:if test="${sessionScope.loginLevel == '마스터'}">
						<option ${boardDto.boardHead == '공지'? 'selected' : '' }>공지</option>
						</c:if>
						<option ${boardDto.boardHead == '유머'? 'selected' : '' }>유머</option>
						<option ${boardDto.boardHead == '자유'? 'selected' : '' }>자유</option>
						<option ${boardDto.boardHead == '정보'? 'selected' : '' }>정보</option>
				</select>
<hr>
[내용] <br>
<textarea rows="10" cols="100" name="boardContent" required>${boardDto.boardContent}</textarea>
<br>
<button>등록</button><br>
<a href="./list">목록</a>
</form>


<%-- type="text" name="boardTitle" value="${boardDto.boardTitle}" required --%>
<%-- name="boardContent" value="${boardDto.boardContent}" required --%>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>