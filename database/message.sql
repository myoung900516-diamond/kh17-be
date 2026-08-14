--메세지를 저장할 테이블
--공용정보
drop sequence message_seq;
create sequence message_seq;
drop table message;
create table message(
message_no number primary key,
message_type varchar(10) not null,
message_content varchar(2000) not null,
message_time timestamp not null
);

--시스템 메세지(메세지와 1:1관계)
drop table message_system;
create table message_system(
message_no references message(message_no) on delete cascade,
message_level varchar(10) not null
);

--채팅 메세지(메세지와 1:1관계)
drop table message_chat;
create table message_chat(
message_no references message(message_no) on delete cascade,
message_sender_id varchar(20) not null,
message_sender_level varchar(12) not null,
message_sender_nickname varchar(30) not null
);
