<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div class="cell">
            <div class="pagination">
<c:if test="${pageVO.hasPrevious()}">
<a href="./list?page=${pageVO.getPreviousBlock()}&${pageVO.getSearchParams()}">
<i class="fa-solid fa-chevron-left"></i>
</a></c:if>
<c:forEach var="i" begin="${pageVO.getBeginBlock()}" end="${pageVO.getEndBlock()}" step="1">

<c:if test="${pageVO.page == i}">
	<a href="./list?page=${i}" class="on">${i}</a></c:if>
<c:if test="${pageVO.page != i}">
<a href="./list?page=${i}&${pageVO.getSearchParams()}">${i}</a> 
</c:if>
</c:forEach>
<c:if test="${pageVO.hasNext()}">
<a href="./list?page=${pageVO.getNextBlock()}&${pageVO.getSearchParams()}">
<i class="fa-solid fa-chevron-right"></i>
</a></c:if>
       		</div>
</div>


<!--  <div class="cell">
            <div class="pagination">
                <a href="#">
                    <i class="fa-solid fa-chevron-left"></i>
                </a>
                <a href="#" class="on">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <a href="#">6</a>
                <a href="#">7</a>
                <a href="#">8</a>
                <a href="#">9</a>
                <a href="#">10</a>
                <a href="#">
                    <i class="fa-solid fa-chevron-right"></i>
                </a>
            </div>
        </div> -->