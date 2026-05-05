<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- <h1>국가 정보 등록 페이지</h1>

<form action="./insert" method="post" enctype="multipart/form-data">
	대륙* <input type="text" name="countryRegion"><br><br>
	이름* <input type="text" name="countryName"><br><br>
	수도* <input type="text" name="countryCapital"><br><br>
	인구* <input type="text" name="countryPopulation"><br><br>
	국기 <input type="file" name="attach" accept="image/png, image/jpeg"><br><br>
	<button>등록하기</button>
</form> -->
<!-- <!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>국가 등록</title>
    <link rel="icon" href="/static/images/kh.jpg" type="image/jpeg">
    <link rel="stylesheet" href="/static/css/commons.css" type="text/css">
디자인을 작성하기 위한 영역
    <style>
    </style>
</head> -->
    <form autocomplete="off" action="./insert" method="post" enctype="multipart/form-data">
        <div class="container w-400 mt-50">
            <div class="cell center">
                <h1>국가 정보 등록</h1>
            </div>
            <div class="cell">
                <label>대륙명 *</label>
                <select class="field w-100" name="countryRegion" required>
                    <option value="">선택하세요</option>
                    <option>유럽</option>
                    <option>북아메리카</option>
                    <option>남아메리카</option>
                    <option>아프리카</option>
                    <option>아시아</option>
                    <option>오세아니아</option>
                </select>
            </div>
            <div class="cell">
                <label>국가명 *</label>
                <input type="text" name="countryName" 
                    class="field w-100" required 
                    placeholder="e.g., 대한민국">
            </div>
            <div class="cell">
                <label>수도명 *</label>
                <input type="text" name="countryCapital" 
                    class="field w-100" required 
                    placeholder="e.g., 서울">
            </div>
            <div class="cell">
                <label>인구수 *</label>
                <input type="text" inputmode="numeric" 
                    name="countryPopulation" 
                    class="field w-100" required 
                    placeholder="e.g., 55000000">
            </div>
            <div class="cell">
                <label>국기</label>
                <input type="file" name="attach" class="field w-100">
            </div>             
            <div class="cell mt-40 right">
                <button class="btn btn-neutral">
                    목록으로
                </button>
                <button class="btn btn-positive">
                    등록하기
                </button>
            </div>            
        </div>

    </form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>