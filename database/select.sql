-- 데이터 조회(select)
-- DBMS에서 가장 많이 하는 작업이며 많은 종류의 문법들이 존재 
-- 구문 - select 항목 from 테이블 [조건] [정렬]; 
-- 대괄호는 없어도 되는 구문을 표시하는 의미 

-- 조회할 항목을 설정하는 법

-- [1] 원하는 항목을 골라서 조회할 수 있다 
select book_title, book_price from book;

select book.* from book; --book의 모든항목(*)을 조회
select * from book; --이렇게 사용해도 된다 
select * from lecture;

-- [2] 존재하지는 않지만 계산을 통해 값을 만들어서 조회할 수 있다. 
select book_title, book_price, book_price/book_page_count from book;
-- 조회할 항목의 이름 대신 "별칭"을 사용할 수 있다. (쌍따옴표 사용)
-- 쌍따옴표가 있으면 별칭에 띄어쓰기를 사용할 수 있고, 없으면 못씀
-- 자바에서는 문자열 내에 쌍따옴표 표기가 어려우므로 별칭에 띄어쓰기를 하지 않고
-- 쌍따옴표를 제거하여 사용 
select 
	book_title "도서명", 
	book_price "판매가",
	book_price/book_page_count "페이지당 가격" 
FROM  book;

select 
	book_title 도서명, 
	book_price 판매가,
	book_price/book_page_count 페이지당가격 
FROM  book;

select * from lecture;

select lecture_price/lecture_duration 기간당가격 from lecture;

select lecture.*, 
lecture_price/lecture_duration lecture_price_per_page 
from lecture;

select 
print_service.*, 
print_service_unit_price/print_service_make_duration price_per_duration 
from print_service;



-- 조건 : 
-- - 자바의 if문처럼 조회구문에 where 키워드와 같이 사용해서 
-- 데이터를 필터링하는 역할을 수행 
-- - 숫자, 문자열, 날짜와 관련된 조건들이 각각 다름 

-- [1] 숫자 조건 (비교 연산 : >, <, >=, <=, ==, != 과 논리 연산: and, or, not)

-- 번호가 5번인 도서를 조회 (찾는건 다 찾는데 조건에 맞는 데이터만 표시함)
select * from book where book_id = 5;

-- 가격이 2만원 이하인 도서를 조회 
select * from book where book_price <= 20000;

-- 가격이 1만원대인 도서를 조회 
select * from book where book_price >= 10000 and book_price < 20000;
select * from book where book_price between 10000 and 19999;
select * from book where book_price >= 10000 and book_price <= 19999;

-- [2] 문자열 조건(Java String처럼 일치, 유사 검사들이 핵심, 크기 비교는 잘 안함)

-- 제목이 "어린왕자"인 도서를 조회 (정확하게 일치하는 문자열 탐색)
select * from book where book_title = '어린왕자';

-- "열린책들" 출판사에서 출판한 도서를 조회 (정확하게 일치하는 문자열 탐색)
select * from book where book_publisher = '열린책들';

-- "마법사"가 제목에 포함된 도서를 조회
--		패턴을 지정한 검색(%는 글자의 존재 가능성이 있다는 의미, 자바의 contains와 유사)
select * from book where book_title like '%마법사%';
--		존재 위치가 어디인지 찾는 겁색(자바의 indexOf와 유사, 오라클은 위치가 1부터 시작하여 없으면 0)
select * from book where instr(book_title, '마법사') > 0; 
--		정규표현식 검색(매우 복잡한 걸 찾을 수 있지만 느림, 패턴이 복잡할 때 씀)
select * from book where regexp_like(book_title, '마법사');

