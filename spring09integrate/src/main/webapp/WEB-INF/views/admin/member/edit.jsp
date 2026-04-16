<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<h1>회원 정보 수정</h1>
 <ul>
 		<li>아이디 : ${memberDto.memberId}</li>
 		<li>닉네임 : ${memberDto.memberNickname}</li>
 		<li>이메일 : ${memberDto.memberEmail}</li>
 		<li>연락처 : ${memberDto.memberContact}</li>
 		<li>가입일 : ${memberDto.memberJoin}</li>

 
 
<form action="./edit" method="post">

	<li>등급 <input type="text" name="memberLevel" value="${memberDto.memberLevel}"><br><br></li>
	<li>포인트 <input type="text" name="memberPoint" value="${memberDto.memberPoint}"><br><br></li>
	<button>수정하기</button>
</form>

 </ul>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>