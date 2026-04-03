--뷰(view) : 자주 사용할 것 같은 구문을 테이블처럼 쓸 수 있도록 객체로 생성
create view music_chart as
select	
	music.*,
	music_play*2 + music_like*5 - music_dislike*10 point
from music
order by point desc, music_id asc;

select * from music_chart;
