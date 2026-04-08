<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    


<c:forEach var="CountryDto" items="${list}">
		<h2>국가목록 : ${list}</h2>
</c:forEach>