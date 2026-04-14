<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="./goodbye" method="post">

<h1>회원 탈퇴를 위한 비밀번호 입력</h1><br>
<!-- <label>비밀번호</label> -->
<input type="password" name="memberPassword" required>
<button>탈퇴하기</button>


</form>

<c:if test="${param.error != null}">
비밀번호가 일치하지 않습니다
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>