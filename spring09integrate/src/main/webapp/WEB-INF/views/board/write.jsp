<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<form action="./write" method="post">
		[구분]
				<select name="boardHead" required>
						<option value="공지">공지</option>
						<option value="유머">유머</option>
						<option value="자유">자유</option>
						<option value="정보">정보</option>
				</select>
		[제목]<input type="text" name="boardTitle"><br>
		[내용]<br><textarea rows="10" cols="100" name="boardContent"></textarea><br>
		<button>등록</button>
</form>
<button><a href="./list">목록</a></button>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>