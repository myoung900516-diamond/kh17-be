<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<script src="/js/book/insert.js"></script>
<form action="./insert" method="post" enctype="multipart/form-data" 
    autocomplete="off" class="form-check">
    <div class="container w-600 mt-50 mb-50">
        <div class="cell center">
            <h1>도서 신규 등록</h1>
        </div>
        <div class="cell">
            <label>도서제목<i class="fa-solid fa-asterisk red"></i></label>
            <input type="text" name="bookTitle" class="field w-100">
            <div class="fail-feedback">필수 항목 입니다</div>
        </div>
        <div class="cell">
            <label>지은이</label>
            <input type="text" name="bookAuthor" class="field w-100">
            <div class="fail-feedback">특수문자는 사용하실 수 없습니다. </div>
        </div>
        <div class="cell">
            <label>출간일</label>
            <input type="date" name="bookPublicationDate" class="field w-100">
            <div class="fail-feedback">유효한 날짜가 아닙니다.</div>
        </div>
        <div class="cell">
            <label>가격<i class="fa-solid fa-asterisk red"></i></label>
            <input type="text" name="bookPrice" class="field w-100">
            <div class="success-feedback">판매가 설정이 완료되었습니다</div>
            <div class="fail-feedback">0원 이상 이어야 합니다.</div>
        </div>
        <div class="cell">
            <label>출판사</label>
            <input type="text" name="bookPublisher" class="field w-100">
        </div>
        <div class="cell">
            <label>페이지수<i class="fa-solid fa-asterisk red"></i></label>
            <input type="text" inputmode="numeric" name="bookPageCount" class="field w-100">
            <div class="success-feedback"></div>
            <div class="fail-feedback">필수 항목입니다.</div>
        </div>
        <div class="cell">
            <label>장르<i class="fa-solid fa-asterisk red"></i></label>
            <select name="bookGenre" class="field w-100">
                <option value="">선택하세요</option>
                <option>판타지</option>
                <option>교양</option>
                <option>소설</option>
                <option>역사</option>
                <option>과학</option>
                <option>추리소설</option>
                <option>자기계발</option>
                <option>수험서</option>
            </select>
            <div class="success-feedback"></div>
            <div class="fail-feedback">필수 항목입니다</div>
        </div>
        <div class="cell">
            <label>표지</label>
            <input type="file" name="attach" accept=".png, .jpg" 
            multiple class="field w-100">
            <div class="success-feedback"></div>
            <div class="fail-feedback"></div>
        </div>
        <div class="cell right">
            <button type="button" class="btn btn-neutral">
                <i class="fa-solid fa-list"></i>
                목록으로
            </button>
            <button type="submit" class="btn btn-positive">
                <i class="fa-solid fa-plus"></i>등록하기
            </button>
        </div>


               
                
    </div>
    </form>
<a href="./list">목록 조회</a>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>