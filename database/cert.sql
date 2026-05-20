create table cert(
cert_email varchar2(100) primary key,
cert_number char(6) not null,
cert_time timestamp default systimestamp not null,
check(regexp_like(cert_email, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,}$')),
check(regexp_like(cert_number, '^[0-9]{6}$'))
);
