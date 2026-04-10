<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>도서 정보 목록 조회</h1>

<h2>결과 수 : ${list.size()}</h2>

<a href="./insert">신규 등록</a>
<a href="./list">전체 목록</a>

<form action="./list" method="get">
	<select name="column">
		<option value="book_title" ${param.column == "book_title" ? "selected" : ""}>도서명</option>
		<option value="book_author" ${param.column == "book_author" ? "selected" : ""}>저자</option>
		<option value="book_publisher" ${param.column == "book_publisher" ? "selected" : ""}>출판사</option>
		<option value="book_genre" ${param.column == "book_genre" ? "selected" : ""}>장르</option>
	</select>
	<input type="text" name="keyword" placeholder="검색어 입력"
							value="${param.keyword}" required>
	<button>검색</button>
</form>


<table border="1" width="1000">
	<thead>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판일</th>
			<th>출판사</th>
			<th>가격</th>
			<th>페이지수</th>
			<th>장르</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="bookDto" items="${list}">
			<tr>
				<td>${bookDto.bookId}</td>
				<td><a href="./detail?bookId=${bookDto.bookId}">
				${bookDto.bookTitle}
				</a>
				</td>
				<td><a href="./list?column=book_author&keyword=${bookDto.bookAuthor}">
				${bookDto.bookAuthor}
				</a>
				</td>
				<td>${bookDto.bookPublicationDate}</td>
				<td><a href="./list?column=book_publisher&keyword=${bookDto.bookPublisher}">
				${bookDto.bookPublisher}
				</a>
				</td>
				<td>${bookDto.bookPrice}</td>
				<td>${bookDto.bookPageCount}</td>
				<td><a href="./list?column=book_genre&keyword=${bookDto.bookGenre}">
				${bookDto.bookGenre}
				</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>