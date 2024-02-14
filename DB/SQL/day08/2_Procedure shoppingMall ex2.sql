USE shoppingmall;

# 제품을 주문하는 Procedure
DROP PROCEDURE IF EXISTS insert_product;

DELIMITER //
CREATE PROCEDURE insert_order(
	# 사용할 매개변수 선언 영역
	IN _amount INT,
    IN _id VARCHAR(13),
    IN _pr_code VARCHAR(15)
)
BEGIN
    DECLARE _total_price INT;
    
    SET _total_price = (SELECT pr_price FROM product WHERE pr_code = _pr_code)*_amount;
    
     IF _total_price IS NOT NULL
		THEN 
			INSERT INTO `order`(or_amount, or_total_price, or_me_id, or_pr_code)
				VALUES(_amount, _total_price, _id, _pr_code);
	END IF;
END //
DELIMITER ;

CALL insert_order(3, 'qwe123', 'FOO001');

SELECT * FROM PRODUCT;
select * from member;
select * from `order`;