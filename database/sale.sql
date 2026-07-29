
-- 상품()

create table sale(
sale_no number primary key,
sale_name varchar(90) not null,
sale_category varchar(60),
sale_original_price number default 0 not null,
sale_discount_price number default 0 not null,
sale_reg_time timestamp default systimestamp not null,
sale_content clob,
sale_stock number default 0 not null,
check(sale_stock >= 0),
check(sale_original_price >= sale_discount_price)
);
create sequence sale_seq;

--상품대표이미지(sale과 attachment를 연결하는 테이블)

create table sale_thumbnail(
sale_no references sale(sale_no) on delete cascade not null primary key,
attach_no references attach(attach_no) on delete cascade not null unique
);

--상품 상세 이미지(sale과 attachment를 연결하는 테이블)

create table sale_information(
sale_no references sale(sale_no) on delete cascade not null,
attach_no references attach(attach_no) on delete cascade not null,
primary key(sale_no, attach_no),
unique(attach_no)
);


