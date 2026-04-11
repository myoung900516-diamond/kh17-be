drop table member;
create table member(
member_id varchar(50byte) primary key,
member_email varchar(100byte) not null unique,
member_password varchar(50byte) not null,
member_nickname varchar(60byte) not null unique,
member_birth char(50byte) null,
member_contact varchar(25byte) null,
member_post varchar(15byte) null,
member_address1 varchar(100byte) null,
member_address2 varchar(30byte) null,
member_level varchar(12byte) default '브론즈' not null,
member_message varchar(300byte) null,
member_join timestamp default CURRENT_TIMESTAMP not null,
member_login timestamp null,
member_change timestamp null,
member_block char(1byte) default 'N' not null,
member_point number default 0 not null,
check(regexp_like(member_id, '^[a-z0-9][a-z0-9]{4,19}$')),
check(regexp_like(member_email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')),
check(REGEXP_LIKE(member_password, '^[A-Za-z0-9!@#$%^&*]{8,16}$')
    AND REGEXP_LIKE(member_password, '[A-Z]')
    AND REGEXP_LIKE(member_password, '[a-z]')
    AND REGEXP_LIKE(member_password, '[0-9]')
    AND REGEXP_LIKE(member_password, '[!@#$%^&*]')),
check(regexp_like(member_nickname, '^[가-힣A-Za-z0-9]{1,10}$')),
check(regexp_like(member_birth, '^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(regexp_like(member_contact, '^010-[1-9][0-9]{3}-[0-9]{4}$')),
check(
		(member_post is null and member_address1 is null and member_address2 is null)
		or (member_post is not null and member_address1 is not null and member_address2 is not null)
		),
check(member_level in('브론즈', '실버', '골드', '플래티넘', '다이아', '마스터')),
check(member_block in('Y', 'N'))
);
