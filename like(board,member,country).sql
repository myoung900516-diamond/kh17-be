--게시글 좋아요 테이블

create table board_like(
member_id references member(member_id) on delete cascade not null,
board_no references board(board_no) on delete cascade not null,
primary key(member_id, board_no)
);

--국가 좋아요 테이블
create table country_like(
member_id references member(member_id) on delete cascade not null,
country_no references country(country_no) on delete cascade not null,
primary key(member_id, country_no)
);

--회원 좋아요 테이블 
create table member_like(
member_id references member(member_id) on delete cascade not null,
board_writer references board(board_writer) on delete cascade not null,
primary key(member_id, board_writer)
);
