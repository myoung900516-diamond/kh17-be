create table country(
country_no number not null unique,
country_region varchar(15byte) not null,
country_name varchar(30byte) not null,
country_capital varchar(36byte) not null,
country_population number(10) not null,
check(country_population >= 0),
check(country_region in('아시아', '유럽', '오세아니아', '북아메리카', '남극', '남아메리카', '아프리카'))
--check(regexp_like(country_name, '^[가-힣]+$'))
);

drop table country;

create sequence country_seq;

insert into country(
	country_no, country_region, country_name, 
	country_capital, country_population
	)
values(country_seq.nextval, '아시아', '대한민국', '서울', 50000000);
insert into country(
	country_no, country_region, country_name, 
	country_capital, country_population
	)
values(country_seq.nextval, '유럽', '프랑스', '파리', 61800000);
insert into country(
	country_no, country_region, country_name, 
	country_capital, country_population
	)
values(country_seq.nextval, '북아메리카', '캐나다', '오타와', 40000000);



create table menu(
menu_no number not null unique,
menu_category varchar(20byte) not null,
menu_name varchar(40byte) not null,
menu_price number(10) not null,
menu_event char(1byte) default 'N' not null,
check(menu_category in ('음료', '디저트', '한정메뉴')),
check(menu_price >= 0),
check(menu_event in ('Y', 'N'))
);


create sequence menu_seq;

insert into menu(
	menu_no, menu_category, menu_name,
	menu_price, menu_event
)
values(menu_seq.nextval, '음료', '아메리카노', 2500, 'Y');

insert into menu(
	menu_no, menu_category, menu_name,
	menu_price
)
values(menu_seq.nextval, '음료', '고구마라떼', 3000);

insert into menu(
	menu_no, menu_category, menu_name,
	menu_price, menu_event
)
values(menu_seq.nextval, '디저트', '디라미수', 4000, 'Y');

insert into menu(
	menu_no, menu_category, menu_name,
	menu_price
)
values(menu_seq.nextval, '디저트', '마카롱', 2000);

create table product(
product_no number not null unique,
product_name varchar(60byte) not null,
product_category varchar(20byte) not null,
product_price number not null,
product_stock number not null,
product_discount number(3) default 0 not null,
product_early char(1byte) default 'N' not null,
check(product_category in('라면', '제과', '잡화', '캠핑', '공구', '이벤트')),
check(product_price >= 0),
check(product_stock >= 0),
check(product_discount between 0 and 100),
check(product_early in ('Y', 'N'))
);
drop table product;
create sequence product_seq;

insert into product(
	product_no, product_name, product_category,
	product_price, product_stock, product_early
	)
values(
	product_seq.nextval, '비김면', '라면', 16800, 2, 'Y');

insert into product(
	product_no, product_name, product_category,
	product_price, product_stock
	)
values(
	product_seq.nextval, '크림대빵', '제과', 6500, 2);

insert into product(
	product_no, product_name, product_category,
	product_price, product_stock, product_discount, product_early
	)
values(
	product_seq.nextval, '점보도시락', '라면', 8500, 3, 5, 'Y');

insert into product(
	product_no, product_name, product_category,
	product_price, product_stock, product_discount
	)
values(
	product_seq.nextval, '공간춘', '라면', 12300, 3, 20);


