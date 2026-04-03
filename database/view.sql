--자주 사용할 것 같은 구문을 테이블처럼 쓸 수 있도록 객체로 생성
--테이블은 아니지만 테이블처럼 사용할 수 있음 
--drop view music_chart;
create or replace view music_chart as
select	
	music.*,
	music_play*2 + music_like*5 - music_dislike*10 music_point
from music
order by music_point desc, music_id asc;

--select * from music_chart;
