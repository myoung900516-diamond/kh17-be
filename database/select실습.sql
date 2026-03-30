drop table item;
create table item(
item_no number primary key,
item_name varchar2(30) not null,
item_type varchar2(15) check(item_type in ('과자','아이스크림','주류','사탕','초콜릿')),
item_price number,
item_made timestamp,
item_expire timestamp
);



INSERT INTO item VALUES (1, '스크류바', '아이스크림', 1200, TO_TIMESTAMP('2022-05-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2022-10-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (2, '마이쮸', '사탕', 900, TO_TIMESTAMP('2022-01-01 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-01-01 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (3, '초코파이', '과자', 3000, TO_TIMESTAMP('2022-01-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-01-01 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (4, '맛동산', '과자', 2200, TO_TIMESTAMP('2022-02-01 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2022-10-20 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (5, '참이슬', '주류', 1000, TO_TIMESTAMP('2022-01-05 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2022-04-05 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (6, '처음처럼', '주류', 1000, TO_TIMESTAMP('2022-03-15 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2022-08-15 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (7, '바나나킥', '과자', 1500, TO_TIMESTAMP('2022-05-03 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2022-06-03 09:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (8, '빠삐코', '아이스크림', 1000, TO_TIMESTAMP('2023-12-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-06-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (9, '멘토스', '사탕', 1200, TO_TIMESTAMP('2023-03-20 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-12-31 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (10, '오레오', '과자', 2100, TO_TIMESTAMP('2023-06-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-06-01 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (11, '포카칩', '과자', 1500, TO_TIMESTAMP('2022-05-05 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-05-05 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (12, '칸쵸', '과자', 1000, TO_TIMESTAMP('2022-06-10 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-06-10 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (13, '허니버터칩', '과자', 1700, TO_TIMESTAMP('2022-07-01 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-07-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (14, '새우깡', '과자', 1200, TO_TIMESTAMP('2022-08-01 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-08-01 09:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (15, '칙촉', '과자', 2500, TO_TIMESTAMP('2022-09-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-09-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (16, '가나초콜릿', '초콜릿', 2000, TO_TIMESTAMP('2022-10-01 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-10-01 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (17, '빼빼로', '과자', 1500, TO_TIMESTAMP('2022-11-11 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-11-11 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (18, '파이리', '사탕', 1000, TO_TIMESTAMP('2022-12-31 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2023-12-01 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (19, '초코송이', '과자', 1200, TO_TIMESTAMP('2023-01-01 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-01-01 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (20, '빈츠', '과자', 1300, TO_TIMESTAMP('2023-02-01 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-02-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (21, '죠리퐁', '과자', 1400, TO_TIMESTAMP('2023-03-01 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-03-01 09:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (22, '오징어집', '과자', 1500, TO_TIMESTAMP('2023-04-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-04-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (23, '누네띠네', '과자', 1200, TO_TIMESTAMP('2023-05-01 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-05-01 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (24, '포테토칩', '과자', 1600, TO_TIMESTAMP('2023-06-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'),
TO_TIMESTAMP('2024-06-01 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (25, '새콤달콤', '사탕', 1000, TO_TIMESTAMP('2023-07-01 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-07-01 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (26, '카라멜콘', '과자', 1100, TO_TIMESTAMP('2023-08-01 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-08-01 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (27, '오징어땅콩', '과자', 1500, TO_TIMESTAMP('2023-09-01 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), 
TO_TIMESTAMP('2024-09-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));


commit;

--등록된 상품의 이름만 조회
select item_name 이름 from item; 
--등록된 상품의 이름과 가격을 조회
select item_name 이름, item_price 가격 from item;
--등록된 상품의 모든 정보를 조회
select * from item;
--등록된 상품의 모든 정보와 유통기간(제조일부터 폐기일 사이의 구간)
select item.*, (item_expire - item_made) 유통기간 from item;
--가격이 2000원 이상인 상품만 조회
select * from item where item_price >= 2000;
--가격이 2000원 이상 3000원 이하인 상품만 조회
select * from item where item_price between 2000 and 3000;
--25번 상품을 조회
select * from item where item_no = 25;
--이름이 스크류바인 상품을 조회
select * from item where item_name = '스크류바';
--이름이 참으로 시작하는 상품을 조회
select * from item where item_name like '참%';
--이름에 이가 포함된 상품을 조회
select * from item where instr(item_name, '이') > 0; 
--제조년도가 2022년인 상품을 조회
select * from item where item_made
	between '2022-01-01 00:00:00.000' and '2022-12-31 23:59:59.999';
--2020년 1월 1일부터 현재까지 제조된 상품을 조회
select * from item where item_made 
between '2001-01-01 00:00:00.000' 
and systimestamp;
--?2022년 상반기(6월 30일까지) 제조된 상품을 조회 
select * from item 
where item_made 
to '2022-06-30 23:59:59.999';
--모든 상품을 가격이 낮은 순으로 조회
select * from item order by item_price asc, item_no asc;
--모든 상품을 최근 제조한 순으로 조회
select * from item order by item_made desc, item_no asc;
--가격이 2000원 이상인 상품을 1차 이름순, 2차 제조일순으로 조회
select * from item where item_price >= 2000 order by item_name asc, item_made desc, item_no asc;
