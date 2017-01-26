CREATE TABLE member(
	member_id number(10) primary key,
	member_email varchar2(256) not null,
	member_password varchar2(32)
);

INSERT INTO member
VALUES(1, test@gmail, test);


INSERT INTO member
VALUES(1, 'test', 'test', '1001000', 'tokyo', '0310001000', sysdate, 'test@gmail', 'test', null);
