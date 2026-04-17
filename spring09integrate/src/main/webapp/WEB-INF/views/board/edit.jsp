<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="./edit" method="post">
[제목] <input type="text" name="boardTitle" value="${boardDto.boardTitle}" required>
<hr>
[내용] <br>
<textarea rows="10" cols="100" name="boardContent" required>${boardDto.boardContent}</textarea>
<br>
<button>등록</button><br>

</form>


<%-- type="text" name="boardTitle" value="${boardDto.boardTitle}" required --%>
<%-- name="boardContent" value="${boardDto.boardContent}" required --%>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>