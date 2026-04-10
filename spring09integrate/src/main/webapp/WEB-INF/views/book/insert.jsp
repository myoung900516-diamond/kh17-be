<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>도서 정보 입력하기</h1>
<form action = "./insert" method = "post">
	도서제목 <input type="text" name="bookTitle" required><br><br>
	저자 <input type="text" name="bookAuthor" ><br><br>
	출간일 <input type="date" name="bookPublicationDate"><br><br>
	가격 <input type="text" name="bookPrice" required><br><br>
	출판사 <input type="text" name="bookPublisher" ><br><br>
	페이지수 <input type="text" name="bookPageCount" required><br><br>
<!-- 	장르 <input type="text" name="bookGenre" required><br><br> -->
	장르
		<select name="bookGenre" required>
			<option value = "">선택</option>
			<option>판타지</option>
			<option>교양</option>
			<option>소설</option>
			<option>역사</option>
			<option>과학</option>
			<option>추리소설</option>
			<option>자기계발</option>
		</select><br><br>
		<button>등록하기</button><br><br>
</form>

<a href="./list">목록 조회</a>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>