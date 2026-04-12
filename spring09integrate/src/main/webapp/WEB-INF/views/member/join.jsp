<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>회원 등록 페이지</h1>
<hr>
<form action="./join" method="post">
아아디<input type="text" name="memberId"><br><br>
비밀번호<input type="text" name="memberPassword"><br><br>
이메일<input type="text" name="memberEmail"><br><br>
닉네임<input type="text" name="memberNickname"><br><br>
생년월일<input type="text" name="memberBirth"><br><br>
휴대폰<input type="text" name="memberContact"><br><br>
우편번호<input type="text" name="memberPost"><br><br>
주소<input type="text" name="memberAddress1"><br><br>
상세주소<input type="text" name="memberAddress2"><br><br>
상태메세지<input type="text" name="memberMessage"><br><br>
<button>가입하기</button>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
