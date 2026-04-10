<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>강좌 상세 정보</h1>

<ul>
	<li>강좌번호 : ${lectureDto.lectureNo}</li>
	<li>강좌명 : ${lectureDto.lectureTitle}</li>
	<li>카테고리 : ${lectureDto.lectureCategory}</li>
	<li>강좌기간 : ${lectureDto.lectureDuration}H</li>
	<li>수강료 : ${lectureDto.lecturePrice}KRW</li>
	<li>강좌형태 : ${lectureDto.lectureType}</li>
</ul>

<h2><a href="./list">목록으로 이동</a><br>
<a href="./insert">신규 등록하기</a><br>
<a href="./edit?lectureNo=${lectureDto.lectureNo}">수정하기</a><br>
<a href="./delete?lectureNo=${lectureDto.lectureNo}" >삭제하기</a>
</h2>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>