-- 수정(update)
-- 기존에 저장되어 있는 데이터를 변경하는 작업
-- 형식 : update 테이블명 set 변경할내용 [조건];
-- 데이터가 변하는 명령이므로 commit/rollback이 필요
-- 조건은 사실상 무조건 적는다고 봐야한다 (전체를 수정하는 경우는 극히 드물다)

update item set item_price = 0;

--1번 상품의 분류를 과자로, 가격을 1500원으로 변경(가장 많이 쓰이는 혀태, 1개 항목만 수정)
update item set item_type = '과자', item_price = 1500 where item_no = 1;

--(Q) 7번 상품의 가격을 100월 할인해보세요
update item set item_price = item_price -100 where item_no = 7;
update item set item_price -= 100 where item_no = 7;--안됨(오라클에는 복합대입연산이 없음)

--(Q) 과자를 10%할인 처리해보세요
update item set item_price = item_price*0.9 where item_type = '과자';
update item set item_price = item_price*90/100 where item_type = '과자';

select * from item;
rollback;
