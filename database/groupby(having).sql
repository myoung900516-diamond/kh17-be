--게시글 조회

select board_no, board_head, board_title, 
		board_writer, board_wtime, board_etime, 
		board_readcount, board_replycount, 
		실제 좋아요 개수
from board;

select * from board_like;


--그룹(group query)
--테이블에 존재하는 데이터를 원하는 항목별로 묶어서 보기 위한 구문
--조회할 때 사용하며, group by + having 절을 사용

--(ex) music 테이블의 장르별 곡 수 
select music_genre from music;

select distinct music_genre from music;--단순 중복 제거(그룹이 아님), 장르가 몇개있는지 물어보는 격

select music_genre from music group by music_genre; --집계함수를 쓸 수 있음. 그룹별로 볼 수 있음 
select music_genre, count(*) from music group by music_genre;
select music_genre, sum(music_play) from music group by music_genre;

--그룹을 보고 싶은 범위가 있을 때, 그룹을 필터링 하고 싶을 때 having 을 씀
select music_genre, count(*) from music group by music_genre having sum(music_play) >=10000;


--게시글 조회

select board.board_no, board.board_head, board.board_title, 
		board.board_writer, board.board_wtime, board.board_etime, 
		board.board_readcount, board.board_replycount, 
		nvl(BL.board_likecount, 0) board_likecount
from board left outer join 
(select board_no, count(*) board_likecount from board_like group by board_no) BL 
on board.board_no = Bl.board_no;


select board_no, count(*) board_likecount from board_like group by board_no;

select * from board_like;


--그룹(group query)
--테이블에 존재하는 데이터를 원하는 항목별로 묶어서 보기 위한 구문
--조회할 때 사용하며, group by + having 절을 사용

--(ex) music 테이블의 장르별 곡 수 
select music_genre from music;

select distinct music_genre from music;--단순 중복 제거(그룹이 아님), 장르가 몇개있는지 물어보는 격

select music_genre from music group by music_genre; --집계함수를 쓸 수 있음. 그룹별로 볼 수 있음 
select music_genre, count(*) from music group by music_genre;
select music_genre, sum(music_play) from music group by music_genre;

--그룹을 보고 싶은 범위가 있을 때, 그룹을 필터링 하고 싶을 때 having 을 씀
select music_genre, count(*) from music group by music_genre having sum(music_play) >=10000;
