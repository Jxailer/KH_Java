use test;
select * from member;

# ID가 ID1인 회원의 정보 조회
SELECT * FROM MEMBER WHERE ID = "ID1";

# 모든 회원의 아이디와 이메일을 조회
SELECT ID, EMAIL FROM MEMBER;

#24년도에 가입한 회원을 조회
SELECT * FROM MEMBER WHERE REG_DATE LIKE '2024-%';

# email이 naver인 회원을 조회
SELECT * FROM MEMBER WHERE EMAIL LIKE '%_@naver.com';

