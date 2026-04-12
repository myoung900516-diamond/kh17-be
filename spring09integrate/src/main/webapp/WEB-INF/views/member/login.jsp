<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>로그인페이지</h1>

<form action="./login" method="post">
아이디<input type="text" name="memberId" value="${member_id}"><br><br>
비밀번호<input type="text" name="memberPassword" value="${member_password}"><br><br>
<button>로그인하기</button>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>