


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


