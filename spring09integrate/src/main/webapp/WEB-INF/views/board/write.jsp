<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>신규 글 작성</h1>
타인에 대한 무분별한 비방글은 경고 없이 삭제될 수 있습니다
<form action="./write" method="post">
		[구분]
				<select name="boardHead" >
						<option value="">선택 안함</option>
<!-- 						<option value="공지">공지</option> -->
<!-- 						<option value="유머">유머</option> -->
<!-- 						<option value="자유">자유</option> -->
<!-- 						<option value="정보">정보</option> -->
						<option>공지</option>
						<option>유머</option>
						<option>자유</option>
						<option>정보</option>
				</select>
		[제목]<input type="text" name="boardTitle" required><br>
		[내용]<br><textarea rows="10" cols="100" name="boardContent" required></textarea><br>
		<button>글 등록하기</button>
</form>
<button><a href="./list">목록</a></button>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>