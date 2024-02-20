use shoppingmall;

# 회원별 누적 주문 금액을 조회하는 쿼리 
SELECT 
   ME_ID AS '아이디', IFNULL(SUM(OR_TOTAL_PRICE), 0) AS '누적 금액'
FROM
    `ORDER`
        RIGHT JOIN
    MEMBER ON OR_ME_ID = ME_ID
GROUP BY ME_ID;

# 회원별 등급을 조회하는 쿼리. 등급은 기본이 브론즈, 누적금액이 5만원이상이면 실버, 누적 금액이 8만원이상이면 골드
# CASE문을 활용 
SELECT 
   ME_ID AS '아이디', 
   CASE
   WHEN IFNULL(SUM(OR_TOTAL_PRICE), 0) >= 80000 THEN '골드'
   WHEN IFNULL(SUM(OR_TOTAL_PRICE), 0) >= 50000 THEN '실버'
   ELSE '브론즈'
   END AS '등급'
FROM
    `ORDER`
        RIGHT JOIN
    MEMBER ON OR_ME_ID = ME_ID
GROUP BY ME_ID;

# 제품 첨부파일을 추가한 후, 추가한 파일이 이미지인지 동영상인지 조회하는 쿼리 
SELECT 
	CASE RIGHT(IM_FILE, 3)
    WHEN 'JPG' THEN '이미지'
    WHEN 'PNG' THEN '이미지'
    WHEN 'MP4' THEN '영상'
    END AS 종류,
    IM_FILE
FROM IMAGE;


