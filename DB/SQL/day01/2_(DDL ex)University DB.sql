# 대학생 관리 프로그램 물리적 설계

drop database if exists UNIVERSITY;

# DB 생성
create database if not exists UNIVERSITY;

# DB에 선택(접속)함
use UNIVERSITY;

# 학생 테이블 삭제 후 추가
drop table if exists STUDENT;
create table if not exists STUDENT(
	ST_NUM CHAR(10) PRIMARY KEY NOT NULL,
    ST_NAME VARCHAR(30) NOT NULL,
    ST_MAJOR VARCHAR(10) NOT NULL,
    ST_GRADE INT NOT NULL
);

# 교수 테이블 삭제 후 추가
drop table if exists PROFESSOR;
create table if not exists PROFESSOR(
	PR_NUM CHAR(10) PRIMARY KEY NOT NULL,
    PR_NAME VARCHAR(30) NOT NULL,
    PR_ROOM VARCHAR(3) NOT NULL,
    PR_MAJOR VARCHAR(10) NOT NULL
);

# 강의 테이블 삭제 후 추가
drop table if exists LECTURE;
create table if not exists LECTURE(
	LE_NUM INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    LE_TITLE VARCHAR(30) NOT NULL,
    LE_ROOM VARCHAR(10) NOT NULL,
    LE_SCHEDULE VARCHAR(50) NOT NULL,
    LE_POINT INT DEFAULT 0 NOT NULL,
    LE_TIME INT DEFAULT 0 NOT NULL,
    LE_PR_NUM CHAR(10) NOT NULL,
    
    FOREIGN KEY(LE_PR_NUM) references PROFESSOR(PR_NUM)
);

# 수강 테이블 삭제 후 추가
drop table if exists COURSE;
create table if not exists COURSE(
	CO_NUM INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    CO_ST_NUM CHAR(10) NOT NULL,
    CO_le_NUM INT NOT NULL,
    
    FOREIGN KEY(CO_ST_NUM) references STUDENT(ST_NUM),
    FOREIGN KEY(CO_le_NUM) references LECTURE(le_NUM)
);

drop table if exists CONTACT;
create table if not exists CONTACT(
	CT_ST_NUM CHAR(10) PRIMARY KEY NOT NULL,
    CT_PHONE CHAR(13) NOT NULL,
    CT_ADDR VARCHAR(50) NOT NULL,
    CT_DETAIL VARCHAR(50) NOT NULL DEFAULT "", 
    -- NOT NULL로 한다고 용량이 작은 것이 아니기 때문에 빈문자열을 채워주는 게 더 효율적임 
    
     FOREIGN KEY(CT_ST_NUM) references STUDENT(ST_NUM)
);

