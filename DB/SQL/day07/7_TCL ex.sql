# 트랜잭션을 시작함
START TRANSACTION; # BEGIN/BEGIN WORK -- START TRANSACTION과 같음.

USE shoppingmall;

# FOO002의 가격을 2000원으로 수정함
UPDATE product SET pr_price = 3000 where pr_code = "FOO002";

ROLLBACK; # 트랜잭션 실행 전으로 되돌림

SELECT * FROM product;

#====================================================================
START TRANSACTION;

# FOO002의 가격을 2000원으로 수정함
UPDATE product SET pr_price = 2000 where pr_code = "FOO002";

SAVEPOINT A;

# FOO002의 가격을 1000원으로 수정함
UPDATE product SET pr_price = 1000 where pr_code = "FOO002";

ROLLBACK TO A; # 트랜잭션 실행 전으로 되돌림

COMMIT; # 트랜잭션에서 실행한 내용을 DB에 반영함
SELECT * FROM product;
