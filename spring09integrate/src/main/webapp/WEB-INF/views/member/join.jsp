<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>회원 등록 페이지</h1>
<hr>
<form action="./join" method="post" enctype="multipart/form-data">

아아디*<input type="text" name="memberId" required><br><br>
비밀번호*<input type="password" name="memberPassword" required><br><br>
이메일*<input type="text" inputmode="email" name="memberEmail" required><br><br>
닉네임*<input type="text" name="memberNickname" required><br><br>
생년월일<input type="date" name="memberBirth"><br><br>
휴대폰<input type="text" inputmode="tel" name="memberContact"><br><br>
우편번호<input type="text" inputmode="numeric" name="memberPost"><br><br>
기본주소<input type="text" name="memberAddress1"><br><br>
상세주소<input type="text" name="memberAddress2"><br><br>
프로필사진 <input type="file" name="attach" accept="image/png, image/jpeg"><br><br>
상태메세지<br>
 <textarea rows="10" cols="50" name="memberMessage"></textarea>
<br><br>
프로필 사진 <input type="file" name="attach" accept=".png, .jpeg"><br><br>
<!-- <input type="text" name="memberMessage"> -->
<button>가입하기</button>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
