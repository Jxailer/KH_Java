USE shoppingmall;

# 제품을 가격 순으로 정렬(ROW_NUMBER를 이용)
SELECT 
	ROW_NUMBER() 
		OVER(ORDER BY PR_PRICE DESC) as '순서', 
        PRODUCT.*
	FROM PRODUCT;
    
# 제품을 가격 순으로 정렬(RANK)
SELECT
	RANK() 
		OVER(ORDER BY pr_price DESC) as '금액순',
    product.*
    FROM product;
    
# 제품을 가격 순으로 정렬(DENSE_RANK)
SELECT
	DENSE_RANK() 
		OVER(ORDER BY pr_price DESC) as '금액순',
    product.*
    FROM product;

# 제품을 비싼 제품, 싼 제품으로 정렬(NTILE)
SELECT
	NTILE(2) 
		OVER(ORDER BY pr_price DESC) as '그룹',
    PRODUCT.*
	FROM product;
    
# 예제 =====================================================================
# 가장 비싼 제품들을 조회하는 쿼리(DENSE_RANK)

-- SELECT
-- 	DENSE_RANK() 
-- 		OVER(ORDER BY pr_price DESC) as 'pr_rank',
--     product.*
--     FROM product;
--     -- WHERE pr_rank = 1 # 원래 테이블에는 pr_rank 속성이 없기 때문에 조회가 되지 않음!!

-- SubQuery 사용하기 !!
SELECT * FROM(
	SELECT
	DENSE_RANK() 
		OVER(ORDER BY pr_price DESC) as 'pr_rank',
    product.*
    FROM product) as ranked_product
    where pr_rank = 1;
    
