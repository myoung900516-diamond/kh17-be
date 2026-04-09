<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>강좌정보목록조회</h1>

<!-- 등록링크 -->
<a href="./insert">신규 등록하기</a>


<form action="./list" method="post">
	<select name = "column">
		<option value= "lecture_title" ${param.column == "lecture_name" ? "selected": ""}>강의명</option>
		<option value= "lecture_category" ${param.column == "lecture_category" ? "selected": ""}>카테고리</option>
<%-- 		<option value= "lecture_price" ${param.column == "lecture_price" ? "selected": ""}>수강료</option> --%>
		<option value= "lecture_type" ${param.column == "lecture_type" ? "selected": ""}>강의형태</option>
	</select>
	<input type="text", name="keyword" placeholder = "강좌명 입력"
							value="${param.keyword}" required>
	<button>검색</button>
</form>

<!-- 출력값 -->
<h2> 강좌 수 : ${list.size()}</h2>

<table border="1" width="700">
	<thead align="center">
				<tr>
					<th>강좌번호</th>
					<th>강좌명</th>
					<th>카테고리</th>
					<th>강의기간</th>
					<th>수강료</th>
					<th>강의형태</th>
				</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="lectureDto" items="${list}">
				<tr>
					<td>${lectureDto.lectureNo}</td>
					<td>${lectureDto.lectureTitle}</td>
					<td>${lectureDto.lectureCategory}</td>
					<td>${lectureDto.lectureDuration}</td>
					<td align="right">
						<fmt:formatNumber value="${lectureDto.lecturePrice}" pattern="#,##0">
						</fmt:formatNumber>
						</td>
					<td>${lectureDto.lectureType}</td>
				</tr>
		</c:forEach>
	</tbody>
</table>







<%-- 	<c:forEach  var="lectureDto" items = "${list}"> --%>
<!-- 	<hr> -->
<!-- 	<div> -->
<%-- 	<h3>${lectureDto.lectureNo}.[${lectureDto.lectureTitle}] </h3><br> --%>
<%-- 			카테고리 : ${lectureDto.lectureCategory} / --%>
<%-- 			수업시간 : ${lectureDto.lectureDuration}H / --%>
<%-- 			수강료 :   <fmt:formatNumber value="${lectureDto.lecturePrice}" --%>
<%-- 													pattern= "#,##0"></fmt:formatNumber> 원 / --%>
<%-- 			강의형태 :${lectureDto.lectureType} <br> --%>
<!-- 	</div> -->
<%-- </c:forEach> --%>

<!-- <a href="./list">목록 조회하기</a> -->























