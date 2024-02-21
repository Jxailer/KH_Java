# 사용자 추가하기
-- 아이디와 비밀번호 모두 abc
create user 'abc'@'localhost' identified by 'abc';
create user 'sample'@'localhost';

select * from mysql.user; -- 추가된 계정  확인

# 해당 유저 추가하고 로그인 하기...
-- 홈 > 계정 추가 버튼 > username을 abc로 설정 > 사용자 추가 > 비밀번호 입력 접속

# 사용자 추가하기 (권한이 없어 실행이 안됨.)
-- create user 'def'@'localhost' identified by 'abc';

# 사용자에게 권한 부여하기(root)
grant all privileges on *.* to 'abc'@'localhost';
grant create on *.* to 'sample'@'localhost';
-- 부여 후 재접속을 해야 실행됨(abc 사용자일 때).
select USER, `CREATE_PRIV` from mysql.user; -- 추가된 계정 확인


# ========================================================

# 사용자에게 특정 DB 권한 부여하기
grant all privileges on Board.* to 'abc'@'localhost';
# 각 DB별 사용자 계정 권한을 조회하는 쿼리
-- 
SELECT * FROM EMPLOYEE WHERE BONUS = NULL AND MANAGER_ID !=NULL;
select * from mysql.db;
# abc 계정에 계정 생성 권한만을 부여
-- grant create user on *.* to 'abc'@'localhost';

# MySQL에서는 AND 연산자가 OR 연산자보다 우선 순위가 높다.
-- A OR B AND C와 (A OR B) AND C는 결과가 다름.

# 제품명에 '우'라는 글자가 포함된 제품을 조회하는 쿼리
USE shoppingmall;
select * from product where pr_title LIKE "%우%";

# 제품명에 '%'라는 글자가 포함된 제품을 조회하는 쿼리 (%를 문자로 인식시키려면 앞에 \를 붙임.)
select * from product where pr_title LIKE "%\%%%";

# 제품 가격 순으로 순위를 추가해서 조회함(내장함수)
select row_number() OVER(ORDER BY pr_price DESC) as '순위', product.* FROM product;

# 1위부터 3위까지 조회하는 쿼리 작성해보기
SELECT * FROM(
	SELECT row_number() OVER(ORDER BY pr_price DESC) as '순위', product.* FROM product
    ) as PRODUCT_TMP WHERE 순위 <=3;

# 각 카테고리 별 제품 가격 평균을 조회
SELECT pr_ca_num, FLOOR(AVG(pr_price)) FROM product GROUP BY pr_ca_num;

# 각 카테고리 별 가격 평균이 6500원 이상인 카테고리를 조회하는 쿼리
SELECT * FROM(
	SELECT pr_ca_num, FLOOR(AVG(pr_price)) as '가격평균' FROM product GROUP BY pr_ca_num
    ) as PRODUCT_TMP WHERE 가격평균 >= 6500;

SELECT pr_ca_num, FLOOR(AVG(pr_price)) as '가격평균' FROM product
	GROUP BY pr_ca_num
	HAVING 가격평균 >= 6500;


# 테이블 생성
CREATE TABLE M(
	ID VARCHAR(10) PRIMARY KEY,
    pw VARCHAR(20) NOT NULL
);

CREATE TABLE B(
	NUM int primary key,
    title TEXT,
    ID VARCHAR(10)
);
INSERT INTO M values('ABC123', 'ABC123');
INSERT INTO B values(1, '제목1', 'ABC123');
SELECT * FROM B JOIN M ON M.ID = B.ID;
SELECT * FROm B JOIN M USING(ID); # B테이블에 ID가 있고, A 테이블에 ID가 있을 때 (속성명이 같은 경우에) USING을 이용함


