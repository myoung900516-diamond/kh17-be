<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>국가 정보 수정</h1>
 
<form action="./edit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="countryNo" value="${countryDto.countryNo}">
	
	대륙 <input type="text" name="countryRegion" value="${countryDto.countryRegion}"><br><br>
	이름 <input type="text" name="countryName" value="${countryDto.countryName}"><br><br>
	수도 <input type="text" name="countryCapital" value="${countryDto.countryCapital}"><br><br>
	인구 <input type="text" name="countryPopulation" value="${countryDto.countryPopulation}"><br><br>
	국기 <input type="file" name="attach" accept=".png, .jpeg"><br><br>
	(기존이미지)<br>
	<img src="./flag?countryNo=${countryDto.countryNo}" width="80"><br><br>
	<button>수정하기</button>
</form>




























<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>