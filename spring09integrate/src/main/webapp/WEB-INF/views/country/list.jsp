<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 제목 -->
<h1>국가 목록 및 검색</h1>

<!-- 검색창 -->
<form action="./list">
<!-- 	<input type="text" name="column"> -->
	<select name="column">
		<option value="country_name" ${param.column == "country_name" ? "selected": ""}>국가명</option>
		<option value="country_region" ${param.column == "country_region" ? "selected": ""}>대륙명</option>
		<option value="country_capital" ${param.column == "country_capital" ? "selected": ""}>수도</option>
	</select>
	<input type="text" name="keyword" placeholder="검색어입력"
						value="${param.keyword}" required>
	<button>검색</button>
</form>


<!-- 결과출력 -->
<h2>결과 수 : ${list.size()}</h2>

<c:forEach var="countryDto" items="${list}">
	<hr>
	<div><!-- 비어있는 영역(자동 줄바뀜) -->
			<h3>[${countryDto.countryRegion}] ${countryDto.countryName}</h3>
			수도 : ${countryDto.countryCapital}     <br>
<%-- 			인구 : ${countryDto.countryPopulation} 명 <br> --%>
			인구 : <fmt:formatNumber value="${countryDto.countryPopulation}"
												 pattern="#,##0"></fmt:formatNumber> 명
	</div>
</c:forEach>
