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



--통계를 위한 그룹 쿼리
-- group by 를 이용하여 원하는 집단별 데이터를 조회
-- 그룹 생성 제한조건을 having으로 설정할 수 있다. 

--현재 홈페이지에 존재하는 데이터 :국가, 강의, 도서, 회원, 게시글, 댓글 등
--국가 : 대륙별 국가 수, 대륙별 인구 합/평균/최대/최소, 
--강의 : 카테고리/유형 별 강의 수, 수강료 합/평균/최대/최소, 강의 시간 합/평균/최대/최소
--도서 : 장르별 도서 수, 판매 금액 합/평균/최대/최소
--회원 : 등급별 회원 수, 포인트 합/평균/최대/최소 
--게시글 : 말머리/작성자 별 글 수, 조회수/ 좋아요수/ 댓글 수 합/평균/최대/최소


--계산을 통해서 만들어내는 그룹
--인구 구간별 국가 수, 수강료 구간별 강의 수 ,강의시간 별 강의 수, 연도별 출간된 도서 수 
--일자별 가입/로그인 회원 수, 일자별 작성된 게시글 수 


--[1] 대륙별 국가 수 
select 
	country_region, count(*), sum(country_population), 
	max(country_population), min(country_population) 
from country group by country_region;

--[2] 카테고리/유형 별 강의 수, 수강료 합/평균/최대/최소, 강의 시간 합/평균/최대/최소
select 
	lecture_category, count(*), sum(lecture_price), 
	avg(lecture_price), max(lecture_price), min(lecture_price), 
	sum(lecture_duration), avg(lecture_duration), 
	max(lecture_duration), min(lecture_duration)
from lecture group by lecture_category;

select 
	lecture_type, count(*), sum(lecture_price), 
	avg(lecture_price), max(lecture_price), min(lecture_price), 
	sum(lecture_duration), avg(lecture_duration), max(lecture_duration), min(lecture_duration) 
from lecture group by lecture_type order by count(*) desc;



--[3]도서 : 장르별 도서 수, 판매 금액 합/평균/최대/최소

select 
	book_genre, count(*), sum(book_price), 
	avg(book_price), max(book_price), min(book_price) 
from book group by book_genre;


--[4]회원 : 등급별 회원 수, 포인트 합/평균/최대/최소 

select
  		member_level, count(*) count, sum(member_point), 
		avg(member_point), max(member_point), min(member_point) 
from member group by member_level order by count desc;

--[5]게시글 : 말머리/작성자 별 글 수, 조회수/ 좋아요수/ 댓글 수 합/평균/최대/최소

select 
	board_head, count(*), sum(board_readCount), 
	avg(board_readCount), max(board_readCount), min(board_readCount), 
	sum(board_likeCount), 
	avg(board_likeCount), max(board_likeCount), min(board_likeCount),
	sum(board_replyCount), 
	avg(board_replyCount), max(board_replyCount), min(board_replyCount) 
from board group by board_head;

select 
	board_writer, count(*), sum(board_readCount), 
	avg(board_readCount), max(board_readCount), min(board_readCount), 
	sum(board_likeCount), 
	avg(board_likeCount), max(board_likeCount), min(board_likeCount),
	sum(board_replyCount), 
	avg(board_replyCount), max(board_replyCount), min(board_replyCount) 
from board group by board_writer;













