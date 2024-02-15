# 공지 커뮤니티에 등록된 모든 게시글을 조회하는 쿼리 
SELECT * FROM BOARD JOIN COMMUNITY ON BO_CO_NUM = CO_NUM WHERE CO_NAME = '공지';

# 공지 커뮤니티에 등록된 게시글 중 1페이지에 해당하는 게시글을 조회하는 쿼리 
SELECT 
    *
FROM
    BOARD
        JOIN
    COMMUNITY ON BO_CO_NUM = CO_NUM
WHERE
    CO_NAME = '공지'
ORDER BY BO_NUM DESC 
LIMIT 0, 10;

# 3번 게시글을 상세 조회했을 때 실행되는 쿼리 
# 1. 3번 게시글의 조회수를 증가하는 쿼리
UPDATE BOARD SET BO_VIEW = BO_VIEW + 1 WHERE BO_NUM = 3;
# 2. 3번 게시글 조회하는 쿼리
SELECT * FROM BOARD WHERE BO_NUM = 3;

# 게시글 목록에서 abc123 아이디를 클릭했을 때 실행되는 쿼리 
SELECT 
    *
FROM
    BOARD
WHERE
    BO_ME_ID = 'abc123'
ORDER BY BO_NUM DESC
LIMIT 0 , 10;
