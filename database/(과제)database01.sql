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





