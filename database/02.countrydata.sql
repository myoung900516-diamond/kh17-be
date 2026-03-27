--country에 데이터를 추가 
--insert into country(항목) values(값);
insert into country(
	country_no,country_region,country_name,
	country_capital,country_population
)
values (
	1, '아시아', '대한민국',
	'서울', 50000000
);

select * from country;--조회 명령

insert into country(
	country_no,country_region,country_name,
	country_capital,country_population
)
--테이블 생성 순서대로 데이터를 주면 꼭 항목은 알려주지 않아도 된다. (권장하지 않음)
values (
	2, '유럽', '프랑스', 
	'파리', 68000000
);

insert into country(
	country_no,country_region,country_name,
	country_capital,country_population
)
values (
	3, '북아메리카', '캐나다', 
	'오타와', 40000000
);

select * from country;



