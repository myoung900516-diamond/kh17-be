--단일행 함수 : 데이터의 구조는 유지하면서 값만 변형시키는 함수 (ex : extract, to_timestamp)
--집계함수 : 테이블을 요약해서 하나의 정보로 만드는 함수 (ex : count, max, min, sum, avg)

--모든 상품의 가격 합계는 얼마인가요? (데이터 개수와 상관없이 대답은 1개만 나옴)
select sum(item_price) from item; 

--다른 데이터와 같이 조회가 가능할까? 
select item_name, sum(item_price) from item; --불가능

--모든 상품의 가격 평균을 구해봅시다! 
select avg(item_price) from item;

--과자 1개당 평균 가격을 구해봅시다!
select avg(item_price) from item where item_type = '과자';
select sum(item_price), avg(item_price) from item where item_type = '과자';
select sum(item_price) 합계, avg(item_price) 평균 from item where item_type = '과자';

-- (Q) 가장 비싼 사탕과 가장 저렴한 사탕의 가격을 출력하세요 
select max(item_price) 비싼사탕, min(item_price) 저렴한사탕 from item where item_type = '사탕';

--(Q)모든 상품의 개수
select count(*) from item;
select count(item_price) from item; --상품 가격이 개수(null은 세지 않음)
select count(item_no) from item; --상품 변호의 개수(primary key는 없을리가 없음)
select count(*) from item; --전부다 null이어도 카운트를 셈 


--(Q)등록된 과자의 개수 
select count(*) from item where item_type = '과자';
select count(*) cnt from item where item_type = '과자';

--다음 코드는 실행이 안됨 (집계함수가 조건에 들어가면 성능이 너무 저하되서 차단됨)
--select * from item where item_price = max(item_price);

--두 개의 구문을 순차적으로 실행할 수 있다면 가능할지도 
select max(item_price) from item; --아이템 중에 가장 비싼 것의 가격은? 
select * from item where item_price = 3000; --가격이 3000원인 것의 모든 정보는? = 가격이 가장 비싼 것의 모든 정보는? 

--조회 구문도 괄호를 이용해서 순서대로 실행시킬ㅇ 수 있습니다(sub query, 서브쿼리)
select * from item where item_price = (select max(item_price) from item);
