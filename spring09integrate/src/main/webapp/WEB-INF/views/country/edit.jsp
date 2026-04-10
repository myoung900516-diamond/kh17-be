<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>국가 정보 수정</h1>
 
<form action="./edit" method="post">
	<input type="hidden" name="countryNo" value="${countryDto.countryNo}">
	
	대륙 <input type="text" name="countryRegion" value="${countryDto.countryRegion}"><br><br>
	이름 <input type="text" name="countryName" value="${countryDto.countryName}"><br><br>
	수도 <input type="text" name="countryCapital" value="${countryDto.countryCapital}"><br><br>
	인구 <input type="text" name="countryPopulation" value="${countryDto.countryPopulation}"><br><br>
	<button>수정하기</button>
</form>