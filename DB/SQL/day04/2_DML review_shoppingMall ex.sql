use shoppingmall;

# 모든 제품을 조회하는 쿼리
select * from product;

# 모든 카테고리를 조회하는 쿼리
select * from category;

# 카테고리, 제품을 조회하되 제품 별 카테고리를 조회함
select pro_name as "상품명",  cate_name as "카테고리" from product
	join category on cate_num = pro_cate_num;
    
# 기타 카테고리에 포함된 모든 제품을 조회
select pro_name as "상품명",  cate_name as "카테고리" from product
	join category on cate_num = pro_cate_num
where cate_name = "기타";

# abc123 회원이 주문한 제품 목록을 조회
select pro_name as "상품명" from product
	join `order` on `order`.pro_code = product.pro_code
where cli_id = "abc123";
    
# 제품 별 판매 수량을 조회 (if null, right join!!)
select pro_name as "상품명", ifnull(sum(or_amount), 0) as "주문량" from `order`
	right join `product` on `order`.pro_code = product.pro_code
where or_state NOT IN ("반품", "환불") OR or_state IS NULL
group by pro_name;

# 인기 제품 조회. 인기제품은 누적 판매량을 기준으로 상위 5개 제품 ( order by, limit!! )
select pro_name as "인기 Top5", pro_price, ifnull(sum(or_amount), 0) as "주문량" from `order`
	right join `product` on `order`.pro_code = product.pro_code
where or_state NOT IN ("반품", "환불") OR or_state IS NULL
group by product.pro_code
order by 주문량 desc, pro_price asc 
limit 0, 5;

# 가격이 가장 비싼 제품을 조회
select * from product order by pro_price desc limit 0, 1;