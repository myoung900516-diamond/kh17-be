create table cert(
cert_email varchar2(100) primary key,
cert_number char(6) not null,
cert_time timestamp default systimestamp not null,
check(regexp_like(cert_email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,}$')),
check(regexp_like(cert_number, '^[0-9]{6}$'))
);


drop table cert;
create table cert(
cert_email varchar2(100) primary key,
cert_number char(6) not null,
cert_time timestamp default systimestamp not null,
cert_yn char(1) default 'N' not null,
check(regexp_like(cert_email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,}$')),
check(regexp_like(cert_number, '^[0-9]{6}$')),
check(cert_yn in('Y', 'N'))
);

--테이블을 유지하고 변경만 하고 싶다면
alter table cert add(cert_yn char(1));
update cert set cert_yn = 'N';
alter table cert modify (cert_yn default 'N' not null);
alter table cert modify (check(cert_yn in ('Y', 'N')));
