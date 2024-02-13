# 사용자 관리 함수

#호스트명
-- ‘localhost’ : 내부에서만 접근 가능
-- ‘%’ : 외부에서도 접근 가능 

# 사용자 등록
# CREATE USER ‘사용자아이디’@’호스트명’ IDENTIFIED BY ‘비밀번호’;
CREATE USER 'jxailer'@'%' IDENTIFIED BY 'abc123';

# 비밀번호 수정
# SET PASSWORD FOR 'username'@'hostname' = 'new_password';
SET PASSWORD FOR 'jxailer'@'%' = 'car9530';

# 사용자 삭제
DROP USER 'jxailer'@'%';

# 현재 등록된 사용자 조회
SELECT User, Host FROM mysql.user; 

# 권한 관리 ===============================================================

# 권한 종류
-- ALL PRIVILEGES : 모든 권한 
-- SELECT/INSERT/UPDATE/DELETE
-- CREATE/ALTER/DROP
-- REFERENCES
-- 등

# 권한 부여하기
# GRANT 권한종류 ON DB명.테이블명 TO ‘계정아이디’@’호스트명’;
# jxailer 유저에게 shoppingmall DB의 product 테이블의 모든 권한을 부여함
GRANT ALL PRIVILEGES ON shoppingmall.product TO 'jxailer'@'%';
# jxailer 유저에게 shoppingmall DB의 모든 테이블의 모든 권한을 부여함
GRANT ALL PRIVILEGES ON shoppingmall.* TO 'jxailer'@'%';

# 권한 제거하기
# REVOKE 권한종류 ON DB명.테이블명 FROM ‘계정아이디’@’호스트명’;
# jxailer 유저에게 shoppingmall DB의 product 테이블의 모든 권한을 제거함
REVOKE  ALL PRIVILEGES ON shoppingmall.product FROM 'jxailer'@'%'; -- 에러표시는 되지만 실행은 된다...?






