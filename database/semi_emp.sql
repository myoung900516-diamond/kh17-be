


cud할 때 commit 안하면 안됨;
c: create
u: update
d: delete


create table emp(
emp_no varchar(8byte) primary key,
emp_id varchar(50byte) not null unique,
emp_pw varchar(50byte) not null,
emp_name varchar(60byte) not null,
emp_birth char(50byte) not null,
emp_email varchar(100byte) unique,
emp_contact varchar(25byte),
emp_post varchar(15byte),
emp_address1 varchar(450byte),
emp_address2 varchar(300byte),
emp_level varchar(12byte) default '사용자' not null,
emp_position varchar(15byte) default '사원' not null,
emp_dept varchar(6byte),
emp_approval_status char(2byte) default 'N',
emp_use_yn char(2byte) default 'N',
emp_hire_date timestamp not null,
emp_retired_date timestamp,
emp_create_at timestamp default SYSTIMESTAMP not null,
emp_mentor references emp(emp_no),
emp_pw_change timestamp,
check(regexp_like(emp_no, '^[0-9]{8}$')),
check(regexp_like(emp_id, '^[a-z][a-z0-9]{4,19}$')),
check(regexp_like(emp_pw, '^[]\[A-Za-z0-9!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]{8,16}$')),
check(regexp_like(emp_pw, '[A-Z]+')),
check(regexp_like(emp_pw, '[a-z]+')),
check(regexp_like(emp_pw, '[0-9]+')),
check(regexp_like(emp_pw, '[]\[\!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]+')),
check(regexp_like(emp_name, '^[가-힣A-Za-z]{1,2}[가-힣A-Za-z]{1,5}$')),
check(regexp_like(emp_birth, '^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(regexp_like(emp_email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,}$')),
check(regexp_like(emp_contact, '^010[1-9][0-9]{7}$')),
check(regexp_like(emp_post, '^[0-9]{5,6}$')),
check(
		(emp_post is null and emp_address1 is null and emp_address2 is null)
		or (emp_post is not null and emp_address1 is not null and emp_address2 is not null)
		),
check(emp_level in('사용자', '관리자')),
check(emp_position in('사원', '선임', '주임', '대리', '과장', '차장', '부장', '이사', '상무', '전무', '부사장', '사장', '부회장', '회장')),
check(emp_dept in('영업', '관리', '감사')),
check(emp_approval_status in('Y', 'N')),
check(emp_use_yn in('Y', 'N'))
);

commit;

create table emp_history(
emp_history_no number primary key,
emp_history_origin references emp(emp_no),
emp_history_time timestamp default systimestamp not null,
emp_history_address varchar(45) not null,
emp_history_agent varchar(512) not null
);

create sequence emp_history_seq;

commit;

create table emp_profile(
emp_no references emp(emp_no) not null,
attach_no references attach(attach_no) not null,
primary key(emp_no, attach_no)
);



commit;

alter table emp modify (emp_hire_date timestamp null);

commit;

--------------------------------------------------

drop table emp;
create table emp(
emp_no varchar(8byte) primary key,
emp_id varchar(50byte) not null unique,
emp_pw varchar(50byte) not null,
emp_name varchar(60byte) not null,
emp_birth char(50byte),
emp_email varchar(100byte) unique,
emp_contact varchar(25byte),
emp_post varchar(15byte),
emp_address1 varchar(450byte),
emp_address2 varchar(300byte),
emp_level varchar(12byte) default '사용자' not null,
emp_position varchar(15byte) default '사원' not null,
emp_dept varchar(6byte),
emp_approval_status char(2byte) default 'N',
emp_use_yn char(2byte) default 'N',
emp_hire_date timestamp not null,
emp_retired_date timestamp,
emp_create_at timestamp default SYSTIMESTAMP not null,
emp_mentor references emp(emp_no),
emp_pw_change timestamp,
check(regexp_like(emp_no, '^[0-9]{8}$')),
check(regexp_like(emp_id, '^[a-z][a-z0-9]{4,19}$')),
check(regexp_like(emp_pw, '^[]\[A-Za-z0-9!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]{8,16}$')),
check(regexp_like(emp_pw, '[A-Z]+')),
check(regexp_like(emp_pw, '[a-z]+')),
check(regexp_like(emp_pw, '[0-9]+')),
check(regexp_like(emp_pw, '[]\[\!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]+')),
check(regexp_like(emp_name, '^[가-힣A-Za-z]{1,2}[가-힣A-Za-z]{1,5}$')),
check(regexp_like(emp_email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,}$')),
check(regexp_like(emp_contact, '^010[1-9][0-9]{7}$')),
check(regexp_like(emp_post, '^[0-9]{5,6}$')),
check(
        (emp_post is null and emp_address1 is null and emp_address2 is null)
        or (emp_post is not null and emp_address1 is not null and emp_address2 is not null)
        ),
check(emp_level in('사용자', '관리자')),
check(emp_position in('사원', '선임', '주임', '대리', '과장', '차장', '부장', '이사', '상무', '전무', '부사장', '사장', '부회장', '회장')),
check(emp_dept in('영업', '관리', '감사')),
check(emp_approval_status in('Y', 'N')),
check(emp_use_yn in('Y', 'N'))
);


---------------------------------------------06-02

create table emp(
emp_no varchar(8byte) primary key,
emp_id varchar(50byte) not null unique,
emp_pw varchar(50byte) not null,
emp_name varchar(60byte) not null,
emp_birth char(10byte) not null,
emp_email varchar(100byte) unique,
emp_contact varchar(25byte),
emp_post varchar(15byte),
emp_address1 varchar(450byte),
emp_address2 varchar(300byte),
emp_level varchar(12byte) default '사용자' not null,
emp_position varchar(15byte) default '사원' not null,
emp_dept varchar(6byte),
emp_approval_status char(1byte) default 'N',
emp_use_yn char(1byte) default 'N',
emp_hire_date timestamp not null,
emp_retired_date timestamp,
emp_create_at timestamp default SYSTIMESTAMP not null,
emp_mentor references emp(emp_no),
emp_pw_change timestamp,
check(regexp_like(emp_no, '^[0-9]{8}$')),
check(regexp_like(emp_id, '^[a-z][a-z0-9]{4,19}$')),
check(regexp_like(emp_pw, '^[]\[A-Za-z0-9!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]{8,16}$')),
check(regexp_like(emp_pw, '[A-Z]+')),
check(regexp_like(emp_pw, '[a-z]+')),
check(regexp_like(emp_pw, '[0-9]+')),
check(regexp_like(emp_pw, '[]\[\!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]+')),
check(regexp_like(emp_name, '^[가-힣A-Za-z]{1,2}[가-힣A-Za-z]{1,5}$')),
check(regexp_like(emp_birth, '^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(regexp_like(emp_email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,}$')),
check(regexp_like(emp_contact, '^010[1-9][0-9]{7}$')),
check(regexp_like(emp_post, '^[0-9]{5,6}$')),
check(
		(emp_post is null and emp_address1 is null and emp_address2 is null)
		or (emp_post is not null and emp_address1 is not null and emp_address2 is not null)
		),
check(emp_level in('사용자', '관리자')),
check(emp_position in('사원', '선임', '주임', '대리', '과장', '차장', '부장', '이사', '상무', '전무', '부사장', '사장', '부회장', '회장')),
check(emp_dept in('영업', '관리', '감사')),
check(emp_approval_status in('Y', 'N')),
check(emp_use_yn in('Y', 'N'))
);

commit;

create table emp_history(
emp_history_no number primary key,
emp_history_origin references emp(emp_no),
emp_history_time timestamp default systimestamp not null,
emp_history_address varchar(45) not null,
emp_history_agent varchar(512) not null
);

create sequence emp_history_seq;

commit;

create table emp_profile(
emp_no references emp(emp_no) not null,
attach_no references attach(attach_no) not null,
primary key(emp_no, attach_no)
);



commit;

alter table emp modify (emp_hire_date timestamp null);

commit;

SELECT constraint_name,
       table_name,
       constraint_type
FROM user_constraints
WHERE constraint_name = 'SYS_C007586';

SELECT column_name
FROM user_cons_columns
WHERE constraint_name = 'SYS_C007586';


select * from emp;


select * from emp_history where emp_history_origin = '12345678';

alter table emp modify (emp_birth varchar2(50));
update emp set emp_birth = replace(emp_birth, ' ', '');
commit;
alter table emp modify (emp_birth char(10));

alter table emp add (new_emp_use_yn char(1) check(new_emp_use_yn in ('Y','N')));
update emp set new_emp_use_yn = trim(emp_use_yn);
commit;
alter table emp drop(emp_use_yn);
alter table emp rename column new_emp_use_yn to emp_use_yn;

alter table emp add (dummy char(1) check(dummy in ('Y','N')));
update emp set dummy = trim(emp_approval_status);
commit;
alter table emp drop(emp_approval_status);
alter table emp rename column dummy to emp_approval_status;

select * from emp;


select attach_no from emp_profile where emp_no='20260006';

select *
from attach
where attach_no = 9;

delete from emp_profile where emp_no='20260006';

commit;

select *
from attach
where attach_no = (
    select max(attach_no)
    from emp_profile
    where emp_no = '20260006'
);

select '[' || emp_birth || ']'
from emp
where emp_no = '20260006';

SELECT column_name
FROM user_cons_columns
WHERE constraint_name = 'SYS_C007585';


SELECT constraint_name, constraint_type
FROM user_constraints
WHERE constraint_name = 'SYS_C008068';

SELECT *
FROM emp_attach
WHERE emp_no = '사원번호';
	
select constraint_name,
       constraint_type,
       table_name
from user_constraints
where constraint_name = 'SYS_C007585';

select index_name,
       status
from user_indexes
where index_name = 'SYS_C007586';

alter index SYS_C007585 rebuild;

select index_name, status
from user_indexes
where index_name = 'SYS_C007586';

commit;

SELECT index_name,
       status
FROM user_indexes
WHERE index_name = 'SYS_C007586';

alter index SYS_C007586 rebuild;

SELECT column_name, data_default
FROM user_tab_columns
WHERE table_name = 'EMP'
AND column_name IN (
    'EMP_APPROVAL_STATUS',
    'EMP_USE_YN'
);

SELECT dbms_metadata.get_ddl('TABLE', 'EMP')
FROM dual;

ALTER TABLE emp
MODIFY emp_approval_status DEFAULT 'N';

ALTER TABLE emp
MODIFY emp_use_yn DEFAULT 'N';

UPDATE emp
SET emp_approval_status = 'N'
WHERE emp_approval_status IS NULL;

UPDATE emp
SET emp_use_yn = 'N'
WHERE emp_use_yn IS NULL;

COMMIT;
