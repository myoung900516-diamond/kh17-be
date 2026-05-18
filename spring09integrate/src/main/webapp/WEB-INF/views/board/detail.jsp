<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<!-- 
	좋아요 처리 관련 자바스크립트(비회원도 가능)
 -->
 <script type="text/javascript">
 
$(function(){
	//시작하자마자 서버에 물어봐서 좋아요 상태와 좋아요 개수를 알아낸다.
	
	var params = new URLSearchParams(window.location.search);
	var boardNo = params.get("boardNo");
	
	$.ajax({
		url : "/rest/board/like-check",
		method : "post",
		data : {boardNo : boardNo },
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
	 var boardNo = params.get("boardNo");
	 
	 $(".fa-heart").on("click", function(){
		 
		 $.ajax({
			 
			 url : "/rest/board/like-action",
			 method: "post",
			 data : {boardNo : boardNo},
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
<!-- 댓글 시스템을 위한 자바스크립트 -->
<script type="text/javascript">
	$(function(){
		 var params = new URLSearchParams(window.location.search);
		 var boardNo = params.get("boardNo");
		$(".btn-reply").on("click", function(){
			/* $(".reply-area").show();
			$(".reply-area").fing("label").text(loginId);
			$(".reply-area").find("span").text(response.content); */
		 var replyContent = $(".field-reply").val();
	 	 if(replyContent.length == 0)return;
		 
		 $.ajax({
			 url : "/rest/reply/write",
			 method : "post",
			 data : {
				 replyContent : replyContent
				 replyOrigin : boardNo},
			 success : function(){
				 /* $(".reply-area").show();
				 $(".reply-area").find("label").text(loginId);
				 $(".reply-area").find("span").text(response.content); */
				 console.log("emdfhrdhksfy");
				 $(".field-reply").val("");
			 }
		 });
		 
		 $(".reply-area").find("textarea").text(replyContent);
		
		});
	});

</script>
<h1>
	<c:if test="${boardDto.boardHead != null}">
[구분] : ${boardDto.boardHead}</c:if>
[제목] : ${boardDto.boardTitle}
<!-- 수정되었다면 수정됨 표시 -->
<c:if test="${boardDto.boardEtime != null}">
(수정됨)
</c:if>
</h1>
<!-- <hr> -->
	<c:if test="${boardDto.boardWriter == null}" >(탈퇴한 사용자)</c:if>
	<c:if test="${boardDto.boardWriter != null}">
						<a href="/member/detail?memberId=${boardDto.boardWriter}">${boardDto.boardWriter}</a>
	</c:if>
						
<br>

<fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
&nbsp;&nbsp;&nbsp;&nbsp;
 [조회수] : ${boardDto.boardReadcount}
<hr>
<div class="cell" style="min-height: 300px">
<pre>[내용]: ${boardDto.boardContent}</pre>
</div>

<div class="cell mt-20 flex-area">
<!-- 좋아요 처리 시나리오 
		1.이 페이지가 최초로 로딩되었을 대, 현재 사용자가 이 글에 좋아요를 누른적이 있는지 + 현재 좋아요 개수 불러옴
		-> 하트를 채울지 비울지 결정, 하트 옆에 적어야 될 숫자를 표시
		->비회원도 가능한 기능
		2. 하트를 클릭하면 글번호를 알려주면서 좋아요/해제 처리를 요청 
		-> 서버에서 결과적으로 좋아요/해제 중 어떤것이 처리되었는지와 현재 좋아요 개수를 알려줌
		->회원만 가능한 기능  
-->
<div>
	좋아요 
	<i class = "fa-solid fa-heart red"></i>
	<span class="heart-count">?</span>
</div>
<div class="ms-20">댓글 ${boardDto.boardReplycount}</div>
</div>

<!-- 댓글 관련 정보가 표시될 자리 -->
<!-- <hr>
<div class="cell reply-area" style="display= none;">
	<label></label>
	<span></span>
</div>
<hr> -->
<%-- <form action="/rest/reply/write" method="post" autocomplete="off">
<div class="cell field">
	<div class="cell">
	<label>${sessionScope.loginId}</label>
	<textarea rows="3" class="field w-100" placeholder="댓글을 남겨보세요"></textarea>
	<button type="submit" class="btn btn-positive right btn-reply">등록</button>
	</div>
</div>
</form> --%>
<c:if test="${sessionScope.loginId != null}">
<div class="cell">
	<textarea rows="4" class="field w-100 field-reply" placeholder="댓글 내용 작성"></textarea>
	<button type="button" class="btn btn-positive w-100 mt-10 btn-reply">
		<i class="fa-solid fa-pen"></i>
		<span>댓글 작성하기</span>
	</button>
</div>
</c:if>
<c:if test="${sessionScope.loginId == null}">
<div class="cell">
<h1>댓글 작성을 원하시면<a href="/member/login">로그인</a>하세요</h1>
</div>
</c:if>


<hr>

이전글 : <a href="./detail?boardNo=${prevBoardDto.boardNo}"> ${prevBoardDto.boardTitle}</a>
<br>
다음글 : <a href="./detail?boardNo=${nextBoardDto.boardNo}">${nextBoardDto.boardTitle}</a>
<hr>
<c:if test="${sessionScope.loginId != null}">
	<button>
		<a href="./write">글쓰기</a>
	</button>
	<button>
		<a href="./write?boardParent=${boardDto.boardNo}">답글쓰기</a>
	</button>
</c:if>
<!-- 비회원이 탈퇴한 글을 볼 때 본인으로 판정되는 걸 제거하기 위한 추가 검사 코드 -->
<c:if test="${boardDto.boardWriter != null && sessionScope.loginId == boardDto.boardWriter}">
	<button>
		<a href="./edit?boardNo=${boardDto.boardNo}">수정</a>
	</button>
	<button>
		<a href="./delete?boardNo=${boardDto.boardNo}">삭제</a>
	</button>
</c:if>
<button>
<a href="./list?boardNo=${boardDto.boardNo}&page=${pageVO.page}&${pageVO.searchParams}">목록</a>
</button>
<br>





<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>