use shoppingmall;

# 제품코드를 자동으로 생성하는 Procedure
# 제품 코드는 카테고리 영문 3자리(주어짐)+숫자 3자리
-- 같은 카테고리로 등록된 제품들의 수를 이용함.
-- 주어지는 정보: 제품코드 영문 3자리, 제품명, 내용, 가격, 카테고리 명
-- 결과: 제품이 등록됨.

select * from product;

DROP PROCEDURE IF EXISTS insert_product;

DELIMITER //
CREATE PROCEDURE insert_product(
	# 사용할 매개변수 선언 영역
	IN _code CHAR(3),
    IN _title VARCHAR(50),
    IN _content TEXT,
    IN _price INT,
    IN _category VARCHAR(10)
)
BEGIN
	# Procedure 실행문 선언 영역
	DECLARE _count INT; # 해당 카테고리에 몇 개의 제품이 들어있는 지 저장할 변수
    DECLARE _pr_code VARCHAR(15);
    DECLARE _ca_num INT;
    
    # _category와 일치하는 등록된 제품의 개수를 찾아서 +1을 한 후 변수에 저장함.
    SET _count = (
		SELECT count(*)+1 
        FROM product 
			JOIN category ON ca_num = pr_ca_num 
		WHERE ca_name = _category); 
    
    # _code와 _count를 이용하여 _pr_code를 생성함.
    SET _pr_code = CONCAT(_code, LPAD(_count, 3, '0')); # _count가 3자리가 아니면, 앞에 '0'을 붙여서 3자리로 만들어줌.
    
    # _category를 이용하여 _ca_num을 찾음.
    SET _ca_num = (SELECT ca_num FROM category WHERE ca_name = _category);
    
    IF _ca_num IS NOT NULL
		THEN 
			INSERT INTO product(pr_code, pr_title, pr_content, pr_price, pr_ca_num)
				VALUES(_pr_code, _title, _content, _price, _ca_num);
	END IF;
    
END //
DELIMITER ;

CALL insert_product('ABC', '수정펜', '수정펜입니다', 3000, '기타');

SELECT * FROM PRODUCT;

SHOW PROCEDURE STATUS;

# 특정 카테고리의 제품 개수가 몇 개 인지 반환하는 쿼리 1
-- SELECT count(*)+1 FROM product 
-- 	JOIN category ON ca_num = pr_ca_num
-- 	WHERE ca_name = '기타';

# 특정 카테고리의 제품 개수가 몇 개 인지 반환하는 쿼리 2
# JOIN 대신 SubQuery를 사용하는 방법
-- SELECT count(*) +1 FROM product
-- 	WHERE pa_ca_num = (SELECT ca_num FROM category WHERE ca_name = '기타');


