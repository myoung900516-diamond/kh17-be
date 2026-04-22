drop table lecture;
create table lecture(
lecture_no number primary key, --한개만 가능, 변경이 불가능한 데이터
--lecture_no number not null unique, --여러개 가능, 변경이 가능하지만 중복이 안되는 데이터
lecture_title varchar(40byte) not null,  --웬만하면 not null 없어도 되나? 따져보기 없으면 안되니까 
lecture_category varchar(10byte) not null, --고정이면 char(6byte)로 하면 성능이 좋음
lecture_duration number(3) not null,
lecture_price number not null,
lecture_type varchar(15byte) default '오프라인' not null,
check(lecture_duration > 0),
check(mod(lecture_duration, 30) = 0),
check(lecture_category in('이론', '실습', '시험')),
check(lecture_price > 0 and mod(lecture_price, 1000) = 0),
check(lecture_type in('온라인', '오프라인', '혼합'))
);

drop sequence lecture_seq;
create sequence lecture_seq;

insert into lecture(
	lecture_no, lecture_title, lecture_category, lecture_duration,
	lecture_price, lecture_type
)
values(
	lecture_seq.nextval, '자바 프로그래밍 기초', '이론', 60, 500000, '온라인'
);
insert into lecture(
	lecture_no, lecture_title, lecture_category, lecture_duration,
	lecture_price
)
values(
	lecture_seq.nextval, '파이썬 프로그래밍 기초', '이론', 90, 1000000
);
insert into lecture(
	lecture_no, lecture_title, lecture_category, lecture_duration,
	lecture_price, lecture_type
)
values(
	lecture_seq.nextval, '정보처리기사 필기', '시험', 30, 300000, '혼합'
);
insert into lecture(
	lecture_no, lecture_title, lecture_category, lecture_duration,
	lecture_price, lecture_type
)
values(
	lecture_seq.nextval, '빅데이터 분석기사 실기', '시험', 120, 850000, '혼합'
);

--최종저장
commit; 

select * from lecture;

--강좌 이미지 테이블 
create table lecture_image(
lecture_image_no number primary key not null,
lecture_no references lecture(lecture_no) on delete cascade not null,
attach_no references attach(attach_no) on delete cascade not null
);


create table print_service(
print_serviece_no number primary key,
--print_service_no number not null,
print_service_part_name varchar(30byte) not null,
print_service_part_category varchar(15byte) not null,
print_service_make_duration number not null,
print_service_uni_tprice number not null,
print_service_delivery_type varchar(15byte) not null,
check(print_service_part_category in('재료', '소모품', '부품', '출력')),
check(print_service_make_duration >= 0),
check(mod(print_service_make_duration, 24) = 0),
check(print_service_unit_price >=0),
check(mod(print_service_unit_price, 1000) = 0),
check(print_service_delivery_type in ('일반', '퀵', '방문수령'))
);

drop sequence print_servie_seq;
create sequence print_service_seq;

insert into print_service(print_service_no, print_service_part_name,
	print_service_part_category, print_service_make_duration, 
	print_service_unit_price, print_service_delivery_type
)
values(
	print_service_seq.nextval, '고강도 PLA 필라멘트', '재료', 24, 25000, '일반');

insert into print_service(print_service_no, print_service_part_name,
	print_service_part_category, print_service_make_duration, 
	print_service_unit_price, print_service_delivery_type
)
values(
	print_service_seq.nextval, '노즐세트', '소모품', 48, 15000, '퀵');

insert into print_service(print_service_no, print_service_part_name,
	print_service_part_category, print_service_make_duration, 
	print_service_unit_price, print_service_delivery_type
)
values(
	print_service_seq.nextval, '출력물 전용 베드', '부품', 72, 45000, '일반');

insert into print_service(print_service_no, print_service_part_name,
	print_service_part_category, print_service_make_duration, 
	print_service_unit_price, print_service_delivery_type
)
values(
	print_service_seq.nextval, '맞춤형 출력물 제작', '출력', 120, 100000, '방문수령');
commit;
select * from print_service;

drop table person;
create table person(
person_no number primary key,
--person_no number not null unique,
person_name varchar(21byte) not null,
person_job varchar(12byte) not null,
person_age number not null, --상한선을 두지 않음
person_height number not null,
person_weight number not null,
check(person_age >= 0),
check(person_height >= 0),
check(person_weight >= 0),
check(regexp_like(person_name, '^[가-힣]{2,7}$')) --또는 '^[가-힣]{2,}$'
);

drop sequence person_seq;
create sequence person_seq;

--더미데이터
insert into person(
	person_no, person_name, person_job, person_age,
	person_height, person_weight
)
values(person_seq.nextval, '마리오', '학생', 15, 160, 52);

insert into person(
	person_no, person_name, person_job, person_age,
	person_height, person_weight
)
values(person_seq.nextval, '루이지', '개발자', 22, 180, 75);

insert into person(
	person_no, person_name, person_job, person_age,
	person_height, person_weight
)
values(person_seq.nextval, '피오나', '디자이너', 20, 162, 50);

insert into person(
	person_no, person_name, person_job, person_age,
	person_height, person_weight
)
values(person_seq.nextval, '쿠파', '기획자', 30, 190, 95);

commit;

select * from person;

drop table phone;
create table phone(
phone_no number primary key,
--phone_no number not null unique,
phone_name varchar(60byte) not null,
phone_memory number not null,
phone_telecom varchar(9byte) not null,
phone_price number not null,
phone_contract number not null,
check(phone_telecom in ('SKT', 'KT', 'LG', '알뜰폰')),
check(phone_contract in (0, 24, 36)),
check(phone_price >= 0),
check(phone_memory in (64, 128, 256, 512))
);

drop sequence phone_seq;
create sequence phone_seq;

insert into phone(
	phone_no, phone_name, phone_memory, phone_telecom, 
	phone_price, phone_contract
)
values(phone_seq.nextval, '갤럭시 S26', 256, 'SKT', 1797400, 24);
 
insert into phone(
	phone_no, phone_name, phone_memory, phone_telecom, 
	phone_price, phone_contract
)
values(phone_seq.nextval, 'iPhone 17 Pro', 128, 'KT', 1555000, 24);

insert into phone(
	phone_no, phone_name, phone_memory, phone_telecom, 
	phone_price, phone_contract
)
values(phone_seq.nextval, '갤럭시 S26 Ultra', 256, 'LG', 1254000, 0);

insert into phone(
	phone_no, phone_name, phone_memory, phone_telecom, 
	phone_price, phone_contract
)
values(phone_seq.nextval, 'iPhone 17', 256, '알뜰폰', 1200000, 36);

commit;

select * from phone;


