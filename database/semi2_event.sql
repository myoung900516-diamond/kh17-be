drop table event;
create table event(
event_no number primary key,
event_origin references emp(emp_no) on delete cascade not null,
event_title varchar(50) not null,
event_category varchar(12) not null,
event_content varchar(300),
event_start date not null,
event_end date not null,
event_option varchar(6),
check(event_category in('개인일정', '사내일정', '부서일정')),
check(event_option in ('allday', 'time'))
);

drop sequence event_seq;
create sequence event_seq;

commit;

event_dept references dept(dept_id) on delete cascade,
