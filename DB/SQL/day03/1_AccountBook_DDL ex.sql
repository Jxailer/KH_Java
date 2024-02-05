DROP DATABASE IF exists `ACCOUNT`;
CREATE DATABASE IF NOT EXISTS `ACCOUNT`;

USE `ACCOUNT`;

-- type 테이블: 수입 / 지출 중 하나를 나타내는 테이블 (외래키로 설정하는 게 유효성 검사가 쉬움) 
/*
 - ty_name: 수입/지출 중 하나의 값을 가짐
*/
DROP TABLE IF EXISTS type;
CREATE TABLE IF NOT EXISTS type(
	ty_name char(2) primary key default "지출"
);

DROP TABLE IF EXISTS category;
CREATE TABLE IF NOT EXISTS category(
	ca_num int primary key auto_increment,
    ca_ty_name char(2) NOT NULL,
    ca_name varchar(5) NOT NULL,
    foreign key(ca_ty_name) references type(ty_name)
);
-- category 테이블: 수입 카테고리 또는 지출 카테고리를 관리하는 테이블
/*
 - ca_num: 기본키, 대리키
 - ca_ty_name: 수입/지출 (type 외래키)
 - ca_name: 카테고리 명
*/

DROP TABLE IF EXISTS item;
CREATE TABLE IF NOT EXISTS item(
	it_num int primary key auto_increment,
    it_ca_num int not null,
    it_date date not null,
    it_money int not null default 0,
    it_content varchar(100) not null,
    
    foreign key(it_ca_num) references category(ca_num),
    check(it_money>=0)
);
-- item 테이블: 가계부 내역
/*
 - it_num: 기본키
 - it_date: 날짜
 - it_ca_num: 카테고리
 - it_money: 금액
 - it_content: 내용
*/