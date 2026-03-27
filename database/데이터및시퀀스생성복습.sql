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
