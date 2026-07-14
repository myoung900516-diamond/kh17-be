drop table account;
create table account(
account_id varchar(20) primary key,
account_email varchar(100) not null unique,
account_password varchar(60) not null,
account_nickname varchar(30) not null unique,
account_birth char(10), 
account_contact char(11), 
account_post varchar(6), 
account_address1 varchar(450),
account_address2 varchar(300),
account_level varchar(12) default '브론즈' not null,
account_message varchar(300),
account_join timestamp default SYSTIMESTAMP not null,
account_login timestamp,
account_change timestamp,
account_block char(1) default 'N' not null,
account_point number default 0 not null,
check(regexp_like(account_id, '^[a-z0-9][a-z0-9]{4,19}$')),
check(regexp_like(account_email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,}$')),
check(REGEXP_LIKE(account_password, '^(?=.*[A-Za-z])(?=.*[0-9])|(?=.*[A-Za-z])(?=.*[!@#$%^&*])|(?=.*[0-9])(?=.*[!@#$%^&*]).{8,16}$')),
check(regexp_like(account_nickname, '^[가-힣A-Za-z0-9]{1,10}$')),
check(regexp_like(account_birth, '^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(regexp_like(account_contact, '^010[1-9][0-9]{7}$')),
check(regexp_like(account_post, '^[0-9]{5,6}$')),
check(
		(account_post is null and account_address1 is null and account_address2 is null)
		or (account_post is not null and account_address1 is not null and account_address2 is not null)
		),
check(account_level in('브론즈', '실버', '골드', '플래티넘', '다이아', '마스터')),
check(account_block in('Y', 'N')),
check(account_point >= 0)
);



---------------------------------------선생님의 테이블

drop table account;
create table account(
account_id varchar(20) primary key,
account_email varchar(100) not null unique,
account_password varchar(60) not null,
account_nickname varchar(30) not null unique,
account_birth char(10),
account_contact char(11),
account_post varchar(6),
account_address1 varchar(450),
account_address2 varchar(300),
account_level varchar(12) default '브론즈' not null,
account_message varchar(300),
account_join timestamp default systimestamp not null,
account_login timestamp,
account_change timestamp,
account_block char(1) default 'N' not null,
account_point number default 0 not null,
check(regexp_like(account_id, '^[a-z][a-z0-9]{4,19}$')),
check(regexp_like(account_email, '^([a-z][a-z0-9]{4,19})@([A-Za-z0-9\-\.]{1,})(\.[a-z]{2,3})$')),
check(regexp_like(account_password, '^[]\[A-Za-z0-9!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]{8,16}$')),
check(regexp_like(account_password, '[A-Z]+')),
check(regexp_like(account_password, '[a-z]+')),
check(regexp_like(account_password, '[0-9]+')),
check(regexp_like(account_password, '[]\[\!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]+')),
check(regexp_like(account_nickname, '^[가-힣A-Za-z0-9]{1,10}$')),
check(regexp_like(account_birth, '^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(regexp_like(account_contact, '^010[1-9][0-9]{7}$')),
check(regexp_like(account_post, '^[0-9]{5,6}$')),
--미입력은 NULL이고, null은 검사방법이 다르다 (is null, is not null)
check(
    (account_post is null and account_address1 is null and account_address2 is null) 
    or 
    (account_post is not null and account_address1 is not null and account_address2 is not null) 
),
check(account_level in ('브론즈', '실버', '골드', '플래티넘', '다이아', '마스터')),
check(account_block in ('Y', 'N')),
check(account_point >= 0)
);
