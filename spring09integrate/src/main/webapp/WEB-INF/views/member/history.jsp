<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<form action="./history" method="get">
시작일<input type="date" name="beginDate" value="${param.beginDate}" required><br><br>
종료일<input type="date" name="endDate" value="${param.endDate}" required><br><br>
<button>조회하기</button>


</form>

<hr>

<h1>로그인 이력</h1>

<table border="1" width="1200">
	<thead>
			<tr>
				<th>일시</th>
				<th>접속주소</th>
				<th>에이전트</th>
			</tr>
	</thead>
	<tbody>
		<c:forEach var= "memberHistoryDto" items="${loginhistory}">
		<tr>
			<td>
				<fmt:formatDate value="${memberHistoryDto.memberHistoryTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
			</td>
			<td>${memberHistoryDto.memberHistoryAddress}</td>
			<td>${memberHistoryDto.memberHistoryAgent}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>



<jsp:include page="/WEB-INF/views/template/loginhistorypagination.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>