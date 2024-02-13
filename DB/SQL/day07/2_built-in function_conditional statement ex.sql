# github 8번 예제 이어서 쓰심
use shoppingmall;

# 내장함수 : 조건 ============================================================================================
# if(수식, 수식1, 수식2): 수식이 참이면 수식 1을, 거짓이면 수식 2를 반환 
# 카테고리 별 등록된 제품 수를 조회하는 쿼리
SELECT ca_name, IF(COUNT(PR_CA_NUM) > 0, COUNT(PR_CA_NUM), '등록된 제품 없음') AS '카테고리 별 제품 수'
	FROM product
		RIGHT JOIN category on pr_ca_num = ca_num
	GROUP BY ca_num;
   
# CASE 
# 회원 별 등급을 조회하는 쿼리. 등급은 기본이 브론즈, 누적 금액이 5만원 이상이면 실버, 누적 금액이 8만원 이상이면 골드
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


# 제품의 이미지 파일이 이미지인지 동영상인지 조회하는 쿼리
SELECT
		CASE RIGHT(im_file, 3) # RIGHT(속성명, idx): 속성값의 오른쪽에서부터 idx 갯수의 글자수를 추출
		WHEN 'JPG' THEN '이미지'
		WHEN 'PNG' THEN '이미지'
		WHEN 'MP4' THEN '영상'
		END as 종류, 
		im_file
	FROM image;







