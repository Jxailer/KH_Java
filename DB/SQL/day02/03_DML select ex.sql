use shoppingmall;

# abc123 회원이 주문 내역을 확인하는 쿼리
select * from `order`;
select * from `order` where cli_id = "abc123";

# 기타(1)에 포함된 모든 제품을 조회하는 쿼리ㅣ
desc product;
select * from product where pro_cate_num = 1;

# 기타(1), 자동차(5), 의류(3)에 포함된 모든 제품을 조회하는 쿼리
select * from product where pro_cate_num = 1 OR pro_cate_num =  5 OR pro_cate_num =  3;
select * from product where pro_cate_num IN (1, 3, 5); # 같은 결과

# 등록된 제품들의 카테고리 번호를 조회하는 쿼리(중복된 값 제거)
desc product;
SELECT DISTINCT pro_cate_num FROM product;

# 가격이 높은 순으로 제품을 정렬하는 쿼리
select * from product order by pro_price desc, pro_code; # 가격이 같은 경우 pro_code를 기준으로 정렬

# 제품 페이지에서 1페이지에 있는 제품을 조회하는 쿼리(한 페이지에 제품은 2개 조회(idx 2개씩 증가))
select * from product order by pro_price desc limit 0, 2;
# 2페이지에 있는 제품을 조회하는 쿼리(조건은 같음)
# 번지 = 컨텐츠 * (현재 페이지 -1)
# 10페이지에 있는 제품들의 번지 = 2 * (10 - 1) = 18
select * from product order by pro_price desc limit 2, 2;

# 카테고리 별 등롥된 제품의 개수를 조회
select pro_cate_num, count(pro_cate_num) as "갯수" 
	from product group by pro_cate_num order by pro_cate_num;

# 카테고리 별 등록된 제품의 개수가 2개 이상인 카테고리를 조회
SELECT 
    pro_cate_num, COUNT(pro_cate_num) AS '갯수'
	FROM
		product
	GROUP BY 
		pro_cate_num
	HAVING
		COUNT(PRo_CAte_NUM) >= 2
	ORDER BY pro_cate_num;
    
# abc123 회원이 지금까지 주문한 총 금액을 조회하는 쿼리
desc `order`;
SELECT 
    cli_id AS '주문자', SUM(or_total) AS '총 주문액'
FROM
    order
WHERE
    cli_id = 'abc123' AND or_state NOT IN("반품", "환불");
    
# 제품 별 판매된 개수를 조회하는 쿼리
desc `order`;
select pro_code as "제품 코드", sum(or_amount) as "주문 총계" from `order` group by pro_code;