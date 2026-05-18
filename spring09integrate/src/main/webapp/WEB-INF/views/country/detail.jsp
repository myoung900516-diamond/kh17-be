<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<script type="text/javascript">
 
$(function(){
	//시작하자마자 서버에 물어봐서 좋아요 상태와 좋아요 개수를 알아낸다.
	
	var params = new URLSearchParams(window.location.search);
	var countryNo = params.get("countryNo");
	
	$.ajax({
		url : "/rest/country/like-check",
		method : "post",
		data : {countryNo : countryNo },
		success : function(response){//reponse에 action, count가 있을 것으로 기대
			$(".fa-heart").removeClass("fa-regular fa-solid")
					.addClass(response.action ? "fa-solid" : "fa-regular");
			$(".fa-heart").next(".heart-count").text(response.count);	
		}
	});
});
 </script>
 <c:if test="${sessionScope.loginId != null}">
 <!--좋아요 토글 자바스크립트 (회원만 가능)  -->
 <script type="text/javascript">
 
 $(function(){
	 //하트를 클릭하면 좋아요 토글이 발생하도록 처리
	 
	 var params = new URLSearchParams(window.location.search);
	 var countryNo = params.get("countryNo");
	 
	 $(".fa-heart").on("click", function(){
		 
		 $.ajax({
			 
			 url : "/rest/country/like-action",
			 method: "post",
			 data : {countryNo : countryNo},
			 success : function(response){
				 $(".fa-heart").removeClass("fa-regular fa-solid")
					.addClass(response.action ? "fa-solid" : "fa-regular");
				 $(".fa-heart").next(".heart-count").text(response.count);	
			 }
		 });
		 
	 });
 });
</script>
</c:if>
 

<h1>국가 상세정보</h1>

<!-- 리스트 태그(ul, ol)
		- ul은 순서가 없는 리스트 (unorder list) 
		- ol은 순서가 있는 리스트 (order list)
		- li는 리스트 내부의 항목 (list item)

 -->
 
<!--  이곳에 국기를 출력하고 싶다(이것도 다운로드) -->
<%-- <img src="http://localhost:8080/download/legacy?attachNo=${attachNo}" width="200"> --%>
<%-- <img src="/download/legacy?attachNo=${attachNo}" width="200"> --%>
<img src="./flag?countryNo=${countryDto.countryNo}" width="200">
<ul>
  <li> 번호 : ${countryDto.countryNo} </li>
  <li> 대륙 : ${countryDto.countryRegion}  </li>
  <li> 이름 : ${countryDto.countryName}  </li>
  <li> 수도 : ${countryDto.countryCapital}  </li>
  <li> 인구 : ${countryDto.countryPopulation}명 </li>
</ul>
<div class="mt-10">
	좋아요 
	<i class = "fa-solid fa-heart red"></i>
	<span class="heart-count">?</span>
</div>

<h2>
<a href="./list">목록으로 이동</a><br>
<a href="./insert">신규 등록하기</a><br>
<a href="./edit?countryNo=${countryDto.countryNo}">수정하기</a><br>
<a href="./delete?countryNo=${countryDto.countryNo}">삭제하기</a>
</h2>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
