<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>주사위 굴리기(행운 번호 : 6)</h1>

<c:forEach var ="number" items="${dice}">
	<h2>번호 : ${number}
			<c:if test="${number == 6}">
			(당첨)
			</c:if>
	</h2>
</c:forEach>
<hr> 