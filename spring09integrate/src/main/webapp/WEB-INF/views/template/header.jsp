<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 여러 가지 정보들을 출력 -->
<%-- 세션ID : ${pageContext.session.id} , 
loginId : ${sessionScope.loginId}, 
loginLevel : ${sessionScope.loginLevel} --%>

<!-- 템플릿 페이지에서 상대경로로 작성할 경우 작동하지 않을 수 있다. -->
<!--     <h1>kh정보교육원 웹개발 수업과정</h1> -->
    
<!--  메뉴를 회원/비회원, 등급에 맞게 구분하여 출력 
		-비회원 : session이 loginId, loginLevel 중 하나 이상이 null인 경우
		-회원 : session이 loginId, loginLevel 모두 null이 아니고 loginLevel이 '마스터'가 아님
		-관리자 : session이 loginId, loginLevel 모두 null이 아니고 loginLevel이 '마스터'가 임
-->
<!-- 디자인을 불러오는 코드 -->
<%-- <link rel="stylesheet" href="/css/commons.css" type="text/css">
<link rel="stylesheet" 
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css"
        type="text/css">
<c:if test="${sessionScope.loginId == null || sessionScope.loginLevel == null}"> --%>

<!-- 비회원 메뉴 -->
<%-- 		<a href="/">HOME</a>
		<a href="/country/list">국가정보</a>
		<a href="/lecture/list">강좌정보</a>
		<a href="/book/list">도서정보</a>
		<a href="/board/list">자유게시판</a>
		<a href="/member/join">회원가입</a>
		<a href="/member/login">로그인</a>
</c:if>

<c:if test="${sessionScope.loginId != null && sessionScope.loginLevel != 'null'}"> --%>
<!-- 회원메뉴 -->
<%-- 		<c:if test="${sessionScope.loginLevel != '마스터'}">
		<a href="/">HOME</a>
		<a href="/country/list">국가정보</a>
		<a href="/lecture/list">강좌정보</a>
		<a href="/book/list">도서정보</a>
		<a href="/board/list">자유게시판</a>
		<a href="/member/mypage">마이페이지</a>
		<a href="/member/logout">로그아웃</a>
		
		</c:if>
		<c:if test="${sessionScope.loginLevel == '마스터'}"> --%>
<!-- 		관리자메뉴 -->
<%-- 		<a href="/">HOME</a>
		<a href="/country/list">국가정보</a>
		<a href="/lecture/list">강좌정보</a>
		<a href="/book/list">도서정보</a>
		<a href="/board/list">자유게시판</a>
		<a href="/member/mypage">마이페이지</a>
		<a href="/member/logout">로그아웃</a>
		<a href="/admin/member/list">회원관리</a>
		
		</c:if>
</c:if>


    <hr>
<div style="min-height: 250px"> --%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH정보교육원</title>
    <link rel="icon" href="/images/kh.jpg" type="image/jpeg">

    <!-- 아이콘 -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">

    <!-- 디자인을 작성하기 위한 영역 -->
    <link rel="stylesheet" type="text/css" href="/css/commons.css">
    <style>
        /* div { box-shadow: 0 0 0 1px gray ;} */
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="/js/checkbox.js"></script>
    <link rel="stylesheet" type="text/css" href="/lib/multipage/multipage.css">
    <script src="/lib/multipage/multipage.js"></script>
</head>
<body>
    <!-- 메인 컨테이너1 + 내부영역4 -->
    <div class="container w-1200">
        <div class="flex-area flex-vertical">
            <!-- 헤더 영역 -->
            <div class="flex-area">
                <div class="w-25 flex-area flex-center">
                    <img src="https://www.dummyimage.com/200x50">
                </div>
                <div class="w-50 flex-area flex-center">
                    <h1>KH정보교육원 스프링개발자 수업자료</h1>
                </div>
                <div class="w-25 flex-area flex-center">
                    <div class="center">
                        <h2 class="mt-0 mb-0">24시간상담</h2>
                        <div>1588-0000</div>                        
                    </div>
                </div>
            </div>

            <!-- 메뉴 -->
            <div>
				<c:if test="${sessionScope.loginId == null || sessionScope.loginLevel == null}">
					<jsp:include page="/WEB-INF/views/template/menu-normal.jsp"></jsp:include>
				</c:if>     
				<c:if test="${sessionScope.loginId != null && sessionScope.loginLevel != null}">
					<c:if test="${sessionScope.loginLevel != '마스터'}">
						<jsp:include page="/WEB-INF/views/template/menu-member.jsp"></jsp:include>
					</c:if>
					<c:if test="${sessionScope.loginLevel == '마스터'}">
						<jsp:include page="/WEB-INF/views/template/menu-admin.jsp"></jsp:include>
					</c:if>
				</c:if>
            </div>

            <!-- 사이드바 및 컨텐츠 -->
            <div style="min-height: 450px;" class="flex-area">
                <div class="w-200">
                    <div class="container w-100">
                    
                    	<c:if test="${sessionScope.loginId == null || sessionScope.loginLevel == null}">
                        <!-- 비회원 상태 -->
                        <div class="cell center">
                            <h3>비회원 상태</h3>
                        </div>
                        <div class="cell center">
                            <a href="/member/login">
                                <i class="fa-solid fa-right-to-bracket"></i>
                                <span>로그인</span>
                            </a>
                        </div>
                        <div class="cell center">
                            <a href="/member/join">
                                <i class="fa-solid fa-user-plus"></i>
                                <span>회원가입</span>
                            </a>
                        </div>
                        </c:if>

                        <!-- 회원 상태 -->
                        <c:if test="${sessionScope.loginId != null && sessionScope.loginLevel != null}">
                        <div class="cell center">
                            <h3>
                            	${sessionScope.loginId}님<br>
                            	(${sessionScope.loginLevel})
                            </h3>
                        </div>
                        
                        <c:if test="${sessionScope.loginLevel != '마스터'}">
                        <div class="cell center">
                            <!-- 이미지와 글자를 겹쳐서 배치하기 위해 영역을 설정하고 내부에 요소 배치 -->
                            <div class="image-hover image-circle image-shadow"
                                    style="width: 150px; margin: 0 auto;">
                                <img src="/member/profile?memberId=${sessionScope.loginId}">
                                <div class="content">
                                    <a href="/member/mypage" class="white">
                                        <i class="fa-solid fa-user"></i>
                                        <span>내 정보 보기</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                        </c:if>
                        
                        </c:if>
                        
                    </div>
                </div>
                <div class="w-200 flex-fill">













