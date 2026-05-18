<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script src="/js/lecture/insert.js"></script>

<form action="./insert" method="post" enctype="multipart/form-data" class="form-check">
        <div class="container w-600 mt-50 mb-50">
            <div class="cell center">
                <h1>강의등록화면</h1>
            </div>
            <div class="cell">
                <label>강의명<i class="fa-solid fa-asterisk red"></i></label>
                <input type="text" name="lectureTitle" placeholder="입력하세요"  class="field w-100">
                <div class="fail-feedback">필수 항목입니다</div>
            </div>
            <div class="cell">
                <label>강의형태<i class="fa-solid fa-asterisk red"></i></label>
                <select name="lectureCategory"  class="field w-100">
                    <option value="">선택하세요</option>
                    <option>이론</option>
                    <option>실습</option>
                    <option>시험</option>
                </select>
                <div class="fail-feedback">필수 항목입니다</div>
            </div>
            <div class="cell">
                <label>강의 시간<i class="fa-solid fa-asterisk red"></i></label>
                <input type="text" inputmode="numeric" name="lectureDuration" value="0"  class="field w-100">
                <div class="fail-feedback">30시간 단위로 입력하세요(300시간이하)</div>
            </div>
            <div class="cell">
                <label>강의료<i class="fa-solid fa-asterisk red"></i></label>
                <input type="text" inputmode="numeric" name="lecturePrice" value="0"  class="field w-100">
                <div class="fail-feedback">0원 이상 입력하세요</div>
            </div>
            <div class="cell">
                <label>강의유형<i class="fa-solid fa-asterisk red"></i></label>
                <select name="lectureType" class="field w-100">
                    <option value="">선택하세요</option>
                    <option>온라인</option>
                    <option>오프라인</option>
                    <option>혼합</option>
                    <div class="fail-feedback">필수항목입니다</div>
                </select>
            </div>
            <div class="cell">
                <button type="submit" class="btn btn-positive w-100"> 
                    <i class="fa-solid fa-plus"></i>등록하기
                </button>
            </div>
            
            
        </div>
    </form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>