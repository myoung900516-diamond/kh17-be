--결제 정보를 보관할 테이블 

--(1) 카카오페이도 생각보다 많은 정보를 가지고 있다
--(2) 카카오페이에 조회를 요청할 수 있는 TID는 필수도 저장하고 그 외 필요한 요소들을 저장한다
--(3)결제는 여러 물품을 여러개 구매할 수 있으며 이들이 하나의 결제건으로 묶여서 관리되어야 한다. 
--       구매와 구매상품정보는 1:N관계이다. 

--구매 대표정보를 저장하는 테이블(카카오페이에게 물어보지 않아도 보여줄 대략적인 구매정보)
drop table purchase;
drop sequence purchase_seq;
create sequence purchase_seq;
create table purchase(
purchase_no number primary key,
purchase_name varchar(300) not null,
purchase_total number not null,
purchase_remain number not null,
purchase_owner varchar(20) not null,
purchase_status varchar(30) default '결제완료' not null,
purchase_tid char(20) not null unique,
purchase_ctime timestamp default systimestamp not null,
purchase_utime timestamp default systimestamp not null,
check(purchase_total > 0),
check(purchase_status in('결제완료', '부분취소', '전체취소', '차단')),
check(purchase_remain between 0 and purchase_total)
);
--스냅샷은 외래키를 안쓴다. 서로 관계가 없음 
create sequence purchase_detail_seq;
create table purchase_detail(
purchase_detail_no number primary key,
purchase_detail_origin references purchase(purchase_no) on delete cascade,
purchase_detail_item number not null, --상품번호 스냅샷
purchase_detail_name varchar(90) not null, --상품명 스냅샷
purchase_detail_price number not null, --구매가격 스냅샷
purchase_detail_qty number default 1 not null, --구매수량
purchase_detail_status char(6) default '승인' not null,
check(purchase_detail_qty > 0),
check(purchase_detail_price >= 0),
check(purchase_detail_status in('승인', '취소'))
);
