/*
여러 줄 주석
*/

# DB 추가삭제 ======================================================
-- DB 추가(없으면)
create database if not exists TEST;
# create schema if not exists `TEST`;

-- DB 삭제(있으면)
# drop database if exists TEST;
drop schema if exists TEST;
 
 
# 테이블 추가삭제 ======================================================
 -- 테이블 삭제(있으면)
 drop table if exists MEMBER;
 
-- 테이블 생성(member)
create table if not exists MEMBER(
	ID VARCHAR(13) PRIMARY KEY,
    PW VARCHAR(15) NOT NULL,
    EMAIL VARCHAR(30) NOT NULL UNIQUE
);

desc member;

-- 테이블 삭제(있으면)
 drop table if exists BOARD;

-- 테이블 생성(board)
create table if not exists BOARD(
	NUM INT AUTO_INCREMENT,
    TITLE VARCHAR(50) NOT NULL,
    CONTENT LONGTEXT NOT NULL,
    VIEW INT NOT NULL DEFAULT 0,
    ID VARCHAR(13) NOT NULL,
    
    PRIMARY KEY(NUM), -- 기본키를 아래에 따로 설정함.
    FOREIGN KEY(ID) references MEMBER(ID) -- MEMBER(ID)에서 BOARD(ID)를 외래키로 연결함
);

desc board;

# ALTER ========================================================================
# MEMBER 테이블에 가입일 컬럼을 추가하는 코드를 작성
ALTER table `member` add `date` datetime not null;

# MEMBER 테이블에 가입일을 의미하는 DATE를 REG_DATE로 변경함
ALTER TABLE `member` change `date` `reg_date` datetime not null;

# MEMBER 테이블에 불필요한 컬럼 COUNT를 추가함
ALTER TABLE `member` add `count` int not null;

# MEMBER 테이블에서 COUNT 컬럼을 삭제함
ALTER TABLE `member` drop `count`;

