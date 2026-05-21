create table dept(
dept_id char(10) primary key,
dept_name varchar(40) unique not null,
dept_use_yn char(1) default 'Y',
dept_create_at timestamp default systimestamp,
check(regexp_like(dept_id, '^[0-9]{10}$')),
check(regexp_like(dept_name, '^[가-힣]{1,20}$'))
);

drop table emp;
create sequence emp_seq;
create table emp(
emp_id number primary key,
emp_dept references dept(dept_name) on delete set null,
emp_name varchar(60) not null,
emp_email varchar(100) not null unique,
emp_phone varchar(25) not null,
emp_position varchar(6) not null,
emp_hire_date char(50) null,
emp_use_yn char(1) default 'Y',
emp_created_at timestamp default systimestamp,
check(regexp_like(emp_name, '^[가-힣A-Za-z]{1,2}[가-힣A-Za-z]{1,5}$')),
check(regexp_like(emp_email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,}$')),
check(regexp_like(emp_phone, '^010[1-9][0-9]{7}$')),
check(emp_position in('사원', '대리', '과장', '차장', '부장')),
check(regexp_like(emp_hire_date, '^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$'))
);

select * from emp;
