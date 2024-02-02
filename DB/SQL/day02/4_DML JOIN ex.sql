use shoppingmall;

# INNER JOIN ============================================================================
# 제품 별 카테고리 명을 조회하기 위한 INNER JOIN 쿼리
select * from product;
select * from category;
SELECT product.*, cate_name
	FROM
		product
	JOIN
		category ON product.pro_cate_num = category.cate_num;
        
# 기타로 등록된 제품들을 조회하는 쿼리
select product.*, cate_name from product join category ON product.pro_cate_num = category.cate_num 
	where category.cate_name = "기타";

# abc123회원이 주문한 제품 목록을 조회하는 쿼리
select product.*, `order`.* from `order` join product  on product.pro_code = `order`.pro_code
	where `order`.cli_id = "abc123" and or_state NOT IN("환불", "반품");

#각 제품 별 판매된 개수(판매된 제품에 한해서)
select pro_name, sum(or_amount) from `order` join product on `order`.pro_code = product.pro_code
	where or_state not in("반품", "환불") group by pro_code;

# OUTER JOIN ==================================================================
# 각 제품 별 판매된 개수(모든 제품에 대하여)
# IFNULL(속성, 값) : 속성이 NULL인 경우, NULL 대신 값으로 변경
select pro_name, IFNULL(sum(or_amount), 0) as "판매 수량"	from product left join `order` on `order`.pro_code = product.pro_code
	where or_state not in("반품", "환불") group by product.pro_code;
    
