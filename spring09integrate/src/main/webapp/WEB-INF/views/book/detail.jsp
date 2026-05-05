<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<img src="./cover?bookId=${bookDto.bookId}" width="200">
 <ul>
 		<li>도서번호 : ${bookDto.bookId}</li>
 		<li>도서명 : ${bookDto.bookTitle}</li>
 		<li>저자 : ${bookDto.bookAuthor}</li>
 		<li>출판사 : ${bookDto.bookPublisher}</li>
 		<li>출판일 : ${bookDto.bookPublicationDate}</li>
 		<li>
 		<fmt:formatNumber value="${bookDto.bookPrice}" pattern="#,##0">
 		</fmt:formatNumber>원
 		</li>
 		<li>페이지수 : ${bookDto.bookPageCount}p</li>
 		<li>장르 : ${bookDto.bookGenre}</li>
 </ul>
 
 <h2>
<a href="./list">목록으로 이동</a><br>
<a href="./insert">신규 등록하기</a><br>
<a href="./edit?bookId=${bookDto.bookId}">수정하기</a><br>
<a href="./delete?bookId=${bookDto.bookId}">삭제하기</a>
</h2>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>