
--퀴즈 테이블
--4정규화

--퀴즈 테이블
drop table quiz;
create table quiz(
quiz_no number primary key,
quiz_content varchar(300) not null
);

--보기 테이블
drop table choice;
create table choice(
choice_no number primary key,
--외래키를 만들어서 강하게 연결된 컬럼을 생성
choice_origin references quiz(quiz_no) on delete cascade not null,
choice_text varchar(300) not null,
choice_answer char(1) not null,
check(choice_answer in('Y', 'N'))
);

--데이터 등록 : '자바를 만든사람은?' 
insert into quiz(quiz_no, quiz_content) values(1, '자바를 만든사람은?');
insert into quiz(quiz_no, quiz_content) values(2, '자바는 객체지향이다');
insert into quiz(quiz_no, quiz_content) values(3, '테스트문제');
commit;

insert into CHOICE (choice_no, choice_origin, choice_text, choice_answer) 
VALUES (1, 1, '고슬링', 'Y');
insert into CHOICE (choice_no, choice_origin, choice_text, choice_answer) 
VALUES (2, 1, '고블린', 'N');
insert into CHOICE (choice_no, choice_origin, choice_text, choice_answer) 
VALUES (3, 1, '그램린', 'N');
insert into CHOICE (choice_no, choice_origin, choice_text, choice_answer) 
VALUES (4, 1, '고구마', 'N');

insert into CHOICE (choice_no, choice_origin, choice_text, choice_answer) 
VALUES (5, 2, 'o', 'Y');
insert into CHOICE (choice_no, choice_origin, choice_text, choice_answer) 
VALUES (6, 2, 'x', 'N');
commit;



--외래키 때문 보기가 있는 문제는 지울 수 없다 (옵션을 줘서 해결가능)
--on delete set null : 퀴즈를 지웠을 때 보기의 퀴즈번호를 null로 바꿈 
--on delete cascade : 퀴즈를 비우면 연결된 보기가 자동으로 지워짐 
delete quiz where quiz_no=1;
select * from choice;
select * from quiz;
commit;


--해설테이블 
create table comments(
comments_no number primary key,
comments_origin references quiz(quiz_no) on delete cascade not null,
comments_body varchar(500) not null
);

insert into comments(comments_no, comments_origin, comments_body) 
values(1, 1, '자바의 역사');
insert into comments(comments_no, comments_origin, comments_body) 
values(2, 1, '자바의 특징');
insert into comments(comments_no, comments_origin, comments_body) 
values(3, 1, '참고사이트');

commit;


--조회는? 
--단순하게 테이블 한게만 조회하는게 아니라 원하는 목적에 맞게 합쳐서(join) 조회할 수 있다. 
select*from quiz;

--크로스 조인(cross join) : 카다시안 곱 형태로 두 테이블의 데이터를 합성하여 조회
select * from quiz, choice;

--내부 조인(inner join) : 양쪽에 모두 존재하는 경우만 조회 연결된 데이터만 조회 
select * from quiz inner join choice on quiz.quiz_no = choice.choice_origin;

select * from quiz inner join comments on quiz.quiz_no = comments.comments_origin;

--외부조인(outer join) : 한쪽을 조회하면서 다른 데이터들을 결합하여 조회(한쪽은 다 조회)
select * from quiz left outer join choice on quiz.quiz_no = choice.choice_origin;
select * from quiz left outer join comments on quiz.quiz_no = comments.comments_origin;

select * from quiz left outer join choice on quiz.quiz_no = choice.choice_origin 
					left outer join comments on quiz.quiz_no = comments.comments_origin order by quiz_no asc, choice_no asc;

 	
