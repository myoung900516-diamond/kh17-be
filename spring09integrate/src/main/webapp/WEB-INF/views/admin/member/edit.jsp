<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<h1>회원 정보 수정</h1>
<form action="./edit" method="post">
<!--  <ul> -->
<%--  		<li>아이디 : ${memberDto.memberId}</li> --%>
<%--  		<li>닉네임 : ${memberDto.memberNickname}</li> --%>
<%--  		<li>이메일 : ${memberDto.memberEmail}</li> --%>
<%--  		<li>연락처 : ${memberDto.memberContact}</li> --%>
<%--  		<li>가입일 : ${memberDto.memberJoin}</li> --%>
		<input type="hidden" name="memberId" value="${memberDto.memberId}" ><br><br>
<!--  	<h2>변경할 정보 입력</h2> -->
     	이메일 <input type="text" inputmode="email" name="memberEmail" value="${memberDto.memberEmail}" required><br><br>
		닉네임 <input type="text" name="memberNickname" value="${memberDto.memberNickname}" required><br><br>
		생년월일 <input type="date" name="memberBirth" value="${memberDto.memberBirth}"><br><br>
		연락처 <input type="text" inputmode="tel" name="memberContact" value="${memberDto.memberContact}"><br><br>
		우편번호 <input type="text" inputmode="numeric" name="memberPost" value="${memberDto.memberPost}" 
						size="6" maxlength="6"><br><br>
		기본주소 <input type="text" name="memberAddress1" value="${memberDto.memberAddress1}"
								size="80"><br><br>
		상세주소 <input type="text" name="memberAddress2" value="${memberDto.memberAddress2}"><br><br>
		상태메세지 <input type="text" name="memberMessage" value="${memberDto.memberMessage}" size="80"><br><br>
 

<!-- 	<li> -->
		등급 
<%-- 		<input type="text" name="memberLevel" value="${memberDto.memberLevel}"><br><br> --%>
		
			<select name="memberLevel">
					<option ${memberDto.memberLevel=='브론즈'? 'selected' : '' }>브론즈</option>
					<option ${memberDto.memberLevel=='실버'? 'selected' : '' }>실버</option>
					<option ${memberDto.memberLevel=='골드'? 'selected' : '' }>골드</option>
					<option ${memberDto.memberLevel=='플래티넘'? 'selected' : '' }>플래티넘</option>
					<option ${memberDto.memberLevel=='다이아'? 'selected' : '' }>다이아</option>
			</select>
<!-- 	</li> -->
<!-- 	<li> -->
		포인트 <input type="text" name="memberPoint" value="${memberDto.memberPoint}" required><br><br>
<!-- 	</li> -->
	<button>수정하기</button>

<!--  </ul> -->

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>