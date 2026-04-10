<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>도서 정보 수정하기</h1>

<form action = "./edit" method = "post">
	<input type="hidden" name="bookId" value="${bookDto.bookId}">
	
	
	도서제목 <input type="text" name="bookTitle" required value="${bookDto.bookTitle}"><br><br>
	저자 <input type="text" name="bookAuthor" value="${bookDto.bookAuthor}"><br><br>
	출간일 <input type="date" name="bookPublicationDate" value="${bookDto.bookPublicationDate}"><br><br>
	가격 <input type="text" name="bookPrice" required value="${bookDto.bookPrice}"><br><br>
	출판사 <input type="text" name="bookPublisher" value="${bookDto.bookPublisher}"><br><br>
	페이지수 <input type="text" name="bookPageCount" required value="${bookDto.bookPageCount}"><br><br>
<!-- 	장르 <input type="text" name="bookGenre" required><br><br> -->
	장르
		<select name="bookGenre" required>
			<option value = "">선택</option>
			<option ${bookDto.bookGenre=="판타지" ? "selected" : ""}>판타지</option>
			<option ${bookDto.bookGenre=="교양" ? "selected" : ""}>교양</option>
			<option ${bookDto.bookGenre=="소설" ? "selected" : ""}>소설</option>
			<option ${bookDto.bookGenre=="역사" ? "selected" : ""}>역사</option>
			<option ${bookDto.bookGenre=="과학" ? "selected" : ""}>과학</option>
			<option ${bookDto.bookGenre=="추리소설" ? "selected" : ""}>추리소설</option>
			<option ${bookDto.bookGenre=="자기계발" ? "selected" : ""}>자기계발</option>
		</select><br><br>
		<button>수정하기</button><br><br>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>