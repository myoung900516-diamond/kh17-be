drop table board;

create table board(
board_no number primary key, 
board_head char(6), 
board_title varchar(300) not null, 
board_content varchar(3000) not null, 
board_writer references member(member_id) on delete set null, 
board_wtime timestamp default systimestamp not null, 
board_etime timestamp, 
board_readcount number default 0 not null, 
board_likecount number default 0 not null, 
board_replycount number default 0 not null, 
check(board_head in('공지', '유머', '자유', '정보')),
check(board_readcount >= 0),
check(board_likecount >= 0),
check(board_replycount >= 0)
);
drop sequence board_seq;
create sequence board_seq;

insert into board(
		board_no, board_head, board_title, 
		board_content, board_writer
) values(
		board_seq.nextval, '공지', '연습글', '연습글입니다', 'testuser1'
);

insert into board(
		board_no, board_title, 
		board_content, board_writer
) values(
		board_seq.nextval, '연습글', '연습글입니다', 'testuser1'
);

commit;


--뷰생성

--게시글 목록(내용 조회를 하지 않는)용 뷰 생성

create or replace view board_list as
select
	board_no, board_head, board_title, 
	board_writer, board_wtime, board_etime, 
	board_readcount, board_likecount, board_replycount 
from board;

insert into board values(board_seq.nextval, '자유', '자유 게시글 3', '자유로운 이야기 3', 'testuser2', systimestamp, null, 5, 2, 1);
insert into board values(board_seq.nextval, '정보', '정보 공유 4', '유용한 정보 4', 'adminuser1', systimestamp, null, 7, 3, 1);

insert into board values(board_seq.nextval, '공지', '공지사항 5', '공지 내용입니다 5', 'adminuser1', systimestamp, null, 20, 10, 5);
insert into board values(board_seq.nextval, '유머', '웃긴 글 6', '재밌는 내용 6', 'testuser2', systimestamp, null, 1, 0, 0);
insert into board values(board_seq.nextval, '자유', '자유 게시글 7', '자유로운 이야기 7', 'testuser2', systimestamp, null, 2, 1, 0);
insert into board values(board_seq.nextval, '정보', '정보 공유 8', '유용한 정보 8', 'adminuser1', systimestamp, null, 9, 4, 2);

insert into board values(board_seq.nextval, '공지', '공지사항 9', '공지 내용입니다 9', 'adminuser1', systimestamp, null, 15, 7, 3);
insert into board values(board_seq.nextval, '유머', '웃긴 글 10', '재밌는 내용 10', 'testuser2', systimestamp, null, 4, 2, 1);
insert into board values(board_seq.nextval, '자유', '자유 게시글 11', '자유로운 이야기 11', 'testuser2', systimestamp, null, 3, 1, 0);
insert into board values(board_seq.nextval, '정보', '정보 공유 12', '유용한 정보 12', 'adminuser1', systimestamp, null, 6, 3, 1);

insert into board values(board_seq.nextval, '공지', '공지사항 13', '공지 내용입니다 13', 'adminuser1', systimestamp, null, 25, 12, 6);
insert into board values(board_seq.nextval, '유머', '웃긴 글 14', '재밌는 내용 14', 'testuser2', systimestamp, null, 2, 1, 0);
insert into board values(board_seq.nextval, '자유', '자유 게시글 15', '자유로운 이야기 15', 'testuser2', systimestamp, null, 5, 2, 1);
insert into board values(board_seq.nextval, '정보', '정보 공유 16', '유용한 정보 16', 'adminuser1', systimestamp, null, 8, 4, 2);

insert into board values(board_seq.nextval, '공지', '공지사항 17', '공지 내용입니다 17', 'adminuser1', systimestamp, null, 30, 15, 7);
insert into board values(board_seq.nextval, '유머', '웃긴 글 18', '재밌는 내용 18', 'testuser2', systimestamp, null, 1, 0, 0);
insert into board values(board_seq.nextval, '자유', '자유 게시글 19', '자유로운 이야기 19', 'testuser2', systimestamp, null, 3, 1, 1);
insert into board values(board_seq.nextval, '정보', '정보 공유 20', '유용한 정보 20', 'adminuser1', systimestamp, null, 12, 6, 3);
insert into board values(board_seq.nextval, '공지', '공지사항 1', '공지 내용입니다 1', 'adminuser1', systimestamp, null, 10, 5, 2);
insert into board values(board_seq.nextval, '유머', '웃긴 글 2', '재밌는 내용 2', 'testuser2', systimestamp, null, 3, 1, 0);


commit;



--이전글번호를 구하는 방법

select * from board 
	where board_no=(
		select max(board_no)
		from board 
		where board_no < 10
		);

--다음글
select * from board 
	where board_no=(
		select min(board_no)
		from board 
		where board_no > 10
		);


