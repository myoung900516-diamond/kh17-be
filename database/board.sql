drop table board;

create table board(
board_no number primary key not null, 
board_head varchar(6), 
board_title varchar(300) not null, 
board_content varchar(3000) not null, 
board_writer references member(member_id) on delete set null, 
board_wtime timestamp default systimestamp, 
board_etime timestamp, 
board_readcount number default 0 not null, 
board_likecount number default 0 not null, 
board_replycount number default 0 not null, 
check(board_head in('공지', '유머', '자유', '정보') or board_head is null),
check(board_readcount >= 0),
check(board_likecount >= 0),
check(board_replycount >= 0)
);
drop sequence board_seq;
create sequence board_seq;
