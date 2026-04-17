--로그인 이력을 저장할 테이블 
create table member_history(
member_history_no number primary key,
member_history_time timestamp default systimestamp not null,
member_history_origin references member(member_id) on delete cascade not null,
member_history_address varchar(45) not null,
member_history_agent varchar(512) not null
);

create sequence member_history_seq;

commit;

INSERT INTO member_history (
    member_history_no, 
    member_history_time, 
    member_history_origin, 
    member_history_address, 
    member_history_agent
)
SELECT 
    member_history_seq.NEXTVAL,
    SYSTIMESTAMP - (LEVEL / 1440),
    CASE WHEN LEVEL <= 500 THEN 'testuser1' ELSE 'testuser2' END,
    CASE 
        WHEN LEVEL <= 500 THEN '192.168.1.' || MOD(LEVEL, 255)
        ELSE '172.16.20.' || MOD(LEVEL, 255)
    END,
    'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36'
FROM DUAL
CONNECT BY LEVEL <= 1000;

COMMIT;


select * from member_history order by member_history_time desc, member_history_no desc;

--Top N Query (상위N개만 조회)

--기간 검색


--최근 로그인 이력 10개만 조회 

--전체가 다 나오는 상황 
select * from member_history 
where member_history_origin = 'testuser2' 
order by member_history_time desc, member_history_no desc;

--행번호를 추가하여 조회
select rownum, member_history.* from member_history 
where member_history_origin = 'testuser2' and rownum <=10 order by member_history_time desc, member_history_no desc;

--문제점 : 정렬전에 번호가 부여됨 
--조회 대상을 '서브쿼리'로 구현하여 원하는 상태로 만든 뒤 행번호를 추가하는 방식으로 변경 
select rownum, TMP.* from (
	select * from member_history 
	where member_history_origin = 'testuser2' 
	order by member_history_time desc, member_history_no asc
) TMP where rownum <= 10;
--문제점 :행 2부터 10까지는 조회를 못함/ 반드시 1번부터 조회를 해야만 조회가 되는 반쪽짜리 


--최종 구문
--select * from (원하는 데이터를 조회하고 줄번호까지 다 붙인 결과) where 행번호 between 2 and 35;
select * from (
	select rownum RN, TMP.* from (
		select * from member_history 
		where member_history_origin = 'testuser2' 
		order by member_history_time desc, member_history_no asc
	)TMP
) where RN between 2 and 10;
