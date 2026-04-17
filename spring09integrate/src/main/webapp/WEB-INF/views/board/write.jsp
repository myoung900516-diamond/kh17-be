<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<form action="./write" method="post">
		[제목]<input type="text" name="boardTitle"><br>
		[내용]<br><textarea rows="10" cols="100" name="boardContent"></textarea><br>
		<button>등록</button>
</form>
<button><a href="./list">목록</a></button>





<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>