drop table country;


create table country (
country_no number not null unique,
country_region varchar(15byte) not null,
country_name varchar(30byte) not null,
country_capital varchar(36byte) not null,
country_population number(10) not null,
--check는 뒤에 () 안에 어떤 항목이 어떤 값을 가져야 하는지 정의할 수 있다(단,null은 예외)
check(country_population >=0),
--in을 사용하면 우측 보기 중 하나만 가능하다는 뜻 (오라클은 문자열을 외따옴표로 처리)
check(country_region in ('아시아', '유럽', '북아메리카', '남아메리카', '아프리카', '오세아니아')),
--name은 정규표현식으로 한글만 가능하게 검사하도록 처리 : regexp_like(항목, '검사식')
check(regexp_like(country_name, '^[가-힣]+$'))
);
