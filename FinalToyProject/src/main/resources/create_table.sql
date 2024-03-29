-- 테이블 삭제
drop table if exists Blog CASCADE; 
drop table if exists BLOG_USER CASCADE; 
drop table if exists Category CASCADE; 
drop table if exists Post CASCADE; 

-- 테이블 생성
create table Blog (
	blogId integer not null,
	status varchar(255),
	tag varchar(255),
	title varchar(255),
	primary key (blogId)
);
    
create table BLOG_USER (
	userId integer not null,
	name varchar(255) not null,
	password varchar(255) not null,
	role varchar(255) not null,
	username varchar(255) not null,
	primary key (userId)
);

create table Category (
	categoryId integer generated by default as identity,
	blogId integer not null,
	categoryName varchar(255),
	description varchar(255),
	displayType varchar(255),
	primary key (categoryId)
);

create table Post (
	postId integer generated by default as identity,
	blogId integer not null,
	categoryId integer not null,
	content varchar(255),
	createdDate date,
	modifiedDate date,
	title varchar(255),
	primary key (postId)
);

alter table BLOG_USER add constraint UK_cdcj82whs73cnxra4rbgby304 unique (username);

-- 회원 등록
INSERT INTO BLOG_USER (USERID, USERNAME, PASSWORD, NAME, ROLE) 
VALUES(1, 'test', 'test', '박중후', 'ADMIN');

INSERT INTO BLOG_USER (USERID, USERNAME, PASSWORD, NAME, ROLE) 
VALUES(2, 'aaa', 'aaa', '방문자', 'USER');


