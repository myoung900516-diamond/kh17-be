<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>
<c:if test="${pageVO.hasPrevious()}">
<a href="./list?page=${pageVO.getPreviousBlock()}&${pageVO.getSearchParams()}">&lt;</a></c:if>
<c:forEach var="i" begin="${pageVO.getBeginBlock()}" end="${pageVO.getEndBlock()}" step="1">
<a href="./list?page=${i}&${pageVO.getSearchParams()}">${i}</a> 
</c:forEach>
<c:if test="${pageVO.hasNext()}">
<a href="./list?page=${pageVO.getNextBlock()}&${pageVO.getSearchParams()}">&gt;</a></c:if>
</h2>