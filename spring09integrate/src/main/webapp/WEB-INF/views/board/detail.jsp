<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<style>
	.reply-viewer, .reply-editor{
		display:flex;
		padding:15px;
		box-shadow : 0 0 0 1px lightgray;
	}
	.reply-viewer > .profile-wrapper, 
	.reply-editor > .profile-wrapper
	{
		width:100px;
	}
	.reply-viewer > .profile-wrapper > img, 
	.reply-editor > .profile-wrapper > img
	 {
		width : 100%;
		aspect-ratio:1/1;
	}
	.reply-viewer > .content-wrapper, 
	.reply-editor > .content-wrapper
	{
		flex-grow: 1;
	}
</style>

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
	 
	 loadList();
	 
	 function loadList(){
		$(".reply-area").empty();
		$.ajax({
			url : "/rest/reply/list",
			method : "post",
			data : {replyOrigin : boardNo},
			success: function(response){
				/* console.log(response); */
				//response는 백엔드에서의 List<ReplyDto>이다
				//반복을 통해 템플릿을 배치하고 정보를 갈아끼운다
				for(var i=0; i<response.length; i++){
					var template = $("#reply-viewer-template").text();
					var html = $.parseHTML(template);
					
					//html에서 필요한 정보를 찾아서 변경 
					//-(중요) 수정, 삭제 등을 위하여 기본키를 영역에 설정해야함
					//-html은 .reply-wrapper이다.
					$(html).attr("data-key", response[i].replyNo);
					$(html).find(".image-profile").attr("src", "/member/profile?memberId="+response[i].replyWriter);
					$(html).find(".reply-writer").text(response[i].replyWriter);
					$(html).find(".reply-content").text(response[i].replyContent);
					/* $(html).find(".reply-wtime").text(response[i].replyWtime); */
					
					/* var wtime = moment(response[i].replyWtime).format("YYYY-MM-DD HH:mm"); */
					var wtime = moment(response[i].replyWtime).fromNow();
					$(html).find(".reply-wtime").text(wtime);
					
					$(".reply-area").append(html);
				}
			}
			
		});
	}
	 
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
			 replyContent : replyContent, 
			 replyOrigin : boardNo},
		 success : function(){
			 /* $(".reply-area").show();
			 $(".reply-area").find("label").text(loginId);
			 $(".reply-area").find("span").text(response.content); */
			 $(".field-reply").val("");
			 loadList();
		 }
	 });
	 
	/* $(".reply-area").find("textarea").text(replyContent); */
	
	});
	//삭제 버튼을 누르면 확인창을 띄우고 ajax요청을 보내 삭제가 이루어지도록 처리
	//-주의: .btn-reply-delete는 현재 시험(문서로딩후)에 존재하지 않는다
	//-따라서 이벤트 설정이 정상적인 방법으로 불가능하다
	//-이벤트를 에너지 소모가 크더라도(메모리 점유률이 크다) 영역에 설정하는 방향으로 변화시킨다
	//-동적 태그 생성
	
	//$(".btn-reply-delete").on("click", function(){
		$(".reply-area").on("click", ".btn-reply-delete", function(){
		var choice = window.confirm("정말 삭제하시겠습니까?");
		if(choice == false) return;
		
		var replyNo = $(this).closest(".reply-wrapper").data("key");
		
		$.ajax({
			url : "/rest/reply/delete",
			method : "post",
			data : {replyNo : replyNo}, 
			success : function(response){
				loadList();//목록갱신 
			}
			});
	});
		
		//목표 : 수정버튼을 누르면 수정화면을 보여주도록 처리
		$(".reply-area").on("click", ".btn-reply-edit", function(){
			var	template = $("#reply-editor-template").text();
			var html = $.parseHTML(template);
			
			//필요한 정보를 설정하고
			$(this).closest(".reply-viewer").hide().after(html);
			
		});
		$(".reply-area").on("click", ".btn-reply-save", function(){
			var choice = window.confirm("정말 삭제하시겠습니까?");
			if(choice == false) return;
			
			
		});
		
		
});
</script>
<script type="text/template" id="reply-viewer-template">
<div class="reply-viewer">
	<div class="profile-wrapper">
		<img src="https://picsum.photos/500" class="image-circle image-profile">
	</div>
	<div class="content-wrapper ms-20">
		<h3 class="mt-0 mb-0 reply-writer">작성자</h3>
		<pre class="mt-10 mb-0 reply-content">내용 샘플</pre>
		<div class="mt-20 flex-area">
			<div class="w-50">
				<span class="gray reply-wtime">yyyy-MM-dd HH:mm</span>
			</div>
			<div class="button-wrapper right w-50">
				<i class="fa-solid fa-edit btn-reply-edit"></i>
				<i class="fa-solid fa-trash btn-reply-delete"></i>
			</div>
		</div>
	</div>
</div>
</script>
<script type="text/template" id="reply-editor-template">
<div class="reply-editor">
	<div class="profile-wrapper">
			<img src="https://picsum.photos/500" class="image-circle image-profile">
	</div>
	<div class="content-wrapper ms-20">
			<h3 class="mt-0 mb-10 reply-writer">작성자</h3>
			<textarea class="field w-100 field-reply-edit" rows="3">내용 수정 샘플</textarea>
		<div class="mt-20 flex-area">
			<div class="w-50">
				<span class="gray reply-wtime">yyyy-MM-dd HH:mm</span>
			</div>
			<div class="button-wrapper right w-50">
				<i class="fa-solid fa-xmark btn-reply-cancel"></i>
				<i class="fa-solid fa-check btn-reply-save"></i>
			</div>
		</div>
	</div>
</div>
</script>
<h1>
	<c:if test="${boardDto.boardHead != null}">
[구분] : ${boardDto.boardHead}</c:if>
[제목] : ${boardDto.boardTitle}
<c:if test="${boardDto.boardEtime != null}">
(수정됨)
</c:if>
</h1>
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
	<span class="heart-count">0</span>
</div>
<div class="ms-20">댓글 ${boardDto.boardReplycount}</div>
</div>
<!-- 댓글 관련 정보가 표시될 자리 -->
<div class="cell reply-area" style="display= none;">
<div class="reply-viewer">
	<div class="profile-wrapper">
			<img src="https://picsum.photos/500" class="image-circle image-profile">
	</div>
	<div class="content-wrapper ms-20">
			<h3 class="mt-0 mb-0 reply-writer">작성자</h3>
			<pre class="mt-10 mb-0 reply-content">내용 샘플</pre>
		<div class="mt-20 flex-area">
			<div class="w-50">
				<span class="gray reply-wtime">yyyy-MM-dd HH:mm</span>
			</div>
			<div class="button-wrapper right w-50">
				<i class="fa-solid fa-edit btn-reply-edit"></i>
				<i class="fa-solid fa-trash btn-reply-delete"></i>
			</div>
		</div>
	</div>
</div>

<div class="reply-editor">
	<div class="profile-wrapper">
			<img src="https://picsum.photos/500" class="image-circle image-profile">
	</div>
	<div class="content-wrapper ms-20">
			<h3 class="mt-0 mb-10 reply-writer">작성자</h3>
			<textarea class="field w-100 field-reply-edit" rows="3">내용 수정 샘플</textarea>
		<div class="mt-20 flex-area">
			<div class="w-50">
				<span class="gray reply-wtime">yyyy-MM-dd HH:mm</span>
			</div>
			<div class="button-wrapper right w-50">
				<i class="fa-solid fa-xmark btn-reply-cancel"></i>
				<i class="fa-solid fa-check btn-reply-save"></i>
			</div>
		</div>
	</div>
</div>
</div>
<hr>
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