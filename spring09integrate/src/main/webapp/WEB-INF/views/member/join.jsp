<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- <h1>회원 등록 페이지</h1>
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
<input type="text" name="memberMessage">
<button>가입하기</button>
</form> -->

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="icon" href="/kh.png" type="image/jpeg">
    <link rel="stylesheet" 
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css"
        type="text/css">
    <link rel="stylesheet" href="./commons.css" type="text/css">
    <style>
    </style>
</head>
<body>
    <form autocomplete="off" method="post"  enctype="multipart/form-data">
        <div class="container w-600 mt-50">
            <div class="cell center">
                <h1>회원 등록 페이지</h1>
            </div>
            <hr>
            <div class="cell">
                <label>id 
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="text" name="memberId" required class="field w-100">
            </div>
            <div class="cell">
                <label>pw
                    <i class="fa-solid fa-asterisk red"></i>
                    <i class="fa-solid fa-eye-slash"></i>

                </label>
                <input type="password" name="memberPassword" required class="field w-100">
            </div>
            <div>
                <label>비밀번호 확인
                    <!-- /* name부여 안함*/ -->
                    <i class="fa-solid fa-asterisk red"></i>
                    <i class="fa-solid fa-eye-slash"></i>
                </label>
                <input type="password" required class="field w-100">
            </div>
            <div class="cell">
                <label>
                    이메일
                </label>
                     <i class="fa-solid fa-asterisk red"></i>
                <!-- <i class="fa-solid fa-envelope"></i> -->
                <input type="text" inputmode="email" name="memberEmail" required class="field w-100">
            </div>
            <div class="cell">
                <label>
                    닉네임
                    <i class="fa-solid fa-asterisk red"></i>
                </label>
                <input type="text" name="memberNickname" required class="field w-100">
            </div>
            <div class="cell">
                <label>생년월일</label>
                <input type="date" name="memberBirth" class="field w-100">
            </div>
            <div class="cell">
                <label>휴대번호</label>
                <input type="text" inputmode="tel" name="memberContact" class="field w-100">
            </div>
            <div class="cell mt-0">
                <label>주소</label>
            </div>
            <div class="cell">
                <input type="text" inputmode="numeric" name="memberPost" 
                    class="field" size="6" maxlength="6" placeholder="우편번호">
                    <button type="button" class="btn btn-neutral">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
            </div>
            <div class="cell">
                <input type="text" name="memberAddress1" class="field w-100" placeholder="기본주소">
            </div>
            <div class="cell">
                <input type="text" name="memberAddress2" class="field w-100" placeholder="상세주소">
            </div>
            <div class="cell">
                <label>상태메세지</label>
                <textarea rows="10" name="memberMessage" class="field w-100"></textarea>
            </div>
            <div class="cell">
                <label>프로필사진</label>
                <input type="file" name="attach" class="field w-100">
            </div>
            <div class="cell mt-40 right">
                <button class="btn btn-positive">
                    <i class="fa-solid fa-user-plus"></i>
                    <span>가입하기</span>
                </button>

            </div>
        </div>
    </form>
    
</body>
</html>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
