create table lecture(
lecture_no number not null unique,
lecture_title varchar(40byte) not null,
lecture_category varchar(10byte) not null,
lecture_duration number(3) not null,
lecture_price number not null,
lecture_type varchar(15byte) default '오프라인' not null,
check(lecture_duration >= 30),
check(lecture_category in('이론', '실습', '시험')),
check(lecture_price >= 0),
check(lecture_type in('온라인', '오프라인', '혼합'))
);

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

create table printservice(
printservice_no number not null,
printservice_partname varchar(30byte) not null,
printservice_partcategory varchar(15byte) not null,
printservice_makeduration number not null,
printservice_unitprice number not null,
printservice_deliverytype varchar(15byte) not null,
check(printservice_partcategory in('재료', '소모품', '부품', '출력')),
check(mod(printservice_makeduration, 24) = 0),
check(mod(printservice_unitprice, 1000) = 0),
check(printservice_deliverytype in ('일반', '퀵', '방문수령'))
);

create sequence printservice_seq;

insert into printservice(printservice_no, printservice_partname,
	printservice_partcategory, printservice_makeduration, 
	printservice_unitprice, printservice_deliverytype
)
values(
	printservice_seq.nextval, '고강도 PLA 필라멘트', '재료', 24, 25000, '일반');

insert into printservice(printservice_no, printservice_partname,
	printservice_partcategory, printservice_makeduration, 
	printservice_unitprice, printservice_deliverytype
)
values(
	printservice_seq.nextval, '노즐세트', '소모품', 48, 15000, '퀵');

insert into printservice(printservice_no, printservice_partname,
	printservice_partcategory, printservice_makeduration, 
	printservice_unitprice, printservice_deliverytype
)
values(
	printservice_seq.nextval, '출력물 전용 베드', '부품', 72, 45000, '일반');

insert into printservice(printservice_no, printservice_partname,
	printservice_partcategory, printservice_makeduration, 
	printservice_unitprice, printservice_deliverytype
)
values(
	printservice_seq.nextval, '맞춤형 출력물 제작', '출력', 120, 100000, '방문수령');


create table person(
person_no number not null unique,
person_name varchar(20byte) not null,
person_job varchar(30byte) not null,
person_age number(3) not null,
person_height number(3) not null,
person_weight number(3) not null,
check(person_age >= 0),
check(person_height >= 0),
check(person_weight >= 0),
check(regexp_like(person_name, '^[가-힣]+$'))
);

create sequence person_seq;

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



create table phone(
phone_no number not null unique,
phone_name varchar(30byte) not null,
phone_memory number(3) not null,
phone_telecom varchar(15byte) not null,
phone_price number not null,
phone_contract number(2) not null,
check(phone_telecom in ('SKT', 'KT', 'LG', '알뜰폰')),
check(phone_contract in (0, 24, 36)),
check(phone_price >= 0),
check(phone_memory in (64, 128, 256, 512))
);

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




