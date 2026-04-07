<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>검색화면만들기</h1>

 <form action="https://www.youtube.com/results">
 		<input name="search_query">
 		<button>검색</button>
 </form>
  <form action="https://search.shopping.naver.com/ns/search">
 		<input name="query">
 		<button>검색</button>
 </form>
<!--  type은 입력창의 형태를 결정, value는 초기값을 결정 placeholder는 도움말-->
  <form action="https://github.com/search">
 		<input type="search" name="q" placeholder="저장소 이름 입력">
 		<input type="hidden" name="type" value="repositories">
 		<button>검색</button>
 </form>
  <form action="https://search.danawa.com/dsearch.php">
 		<input name="k1" type="search" >
 		<input type="hidden" name="module" value="goods">
 		<input type="hidden" name="act" value="disaMain">
 		<button>검색</button>
 </form>
  <form action="https://search.daum.net/search">
 		<input name="q" type="text" placeholder="검색어 입력">
 		<input name="w" type="hidden" value="tot">
 		<button>검색</button>
 </form>