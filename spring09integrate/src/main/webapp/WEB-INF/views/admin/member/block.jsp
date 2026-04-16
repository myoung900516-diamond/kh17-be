<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<c:if test="${memberBlock == 'N'}">
    <h1>차단되었습니다</h1>
</c:if>

<c:if test="${memberBlock == 'Y'}">
    <h1>차단해제되었습니다</h1>
</c:if>

 <h2>
<a href="./list">검색으로 이동</a><br>
</h2>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>