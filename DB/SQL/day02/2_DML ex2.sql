use shoppingmall;
show tables;

# 아이디가 ADMIN이고, 비번이 ADMIN, 이메일이 ADMIN@GMAIL.COM, 번호가 010-0000-0000인 관리자가 회원가입을 할 때 필요한 쿼리.
desc client;
INSERT INTO client VALUES("admin", "admin", "ADMIN@GMAIL.COM", "010-0000-0000", "ADMIN", 0);

# 유저 추가
insert into client values("abc123", "abc123", "abc123@kh.com", "010-1234-1234","USER", 0);
insert into client values("qwe123", "qwe123", "qwe123@kh.com", "010-4321-4321", "USER", 0);
select * from client;

# 관리자가 다음의 제품을 등록할 때 필요한 쿼리:
# 제품 코드: ABC001 / 제품명: 텀블러 / 가격: 20000 / 내용: 스타벅스 텀블러입니다 / 카테고리: 기타
desc category;
INSERT INTO category VALUES(null, "기타"); # 기타 카테고리를 우선 추가함. (상품의 외래키이기 때문에)
select * from category;

desc product;
INSERT INTO product VALUES("ABC001", "텀블러", "스타벅스 텀블러입니다.", 20000, 1);
select * from product;

# 카테고리 추가하기(전자제품, 의류, 식품, 자동차)
insert into category(cate_name)  values("전자제품"), ("의류"), ("식품"), ("자동차");
select * from category;

/*
코드: ABC002 / 제품명: 볼펜 / 내용: 모나미 볼펜 / 가격: 1000 / 카테고리: 기타1
코드: ABC003 / 제품명: 지우개 / 내용: 잘 지워지는 지우개 / 가격: 500 / 카테고리: 기타 1

코드: ELC001 / 제품명: 마우스 / 내용: 무선 마우스 / 가격: 10000 / 카테고리: 전자제품 2
코드: ELC002 / 제품명: 키보드 / 내용: 무선 키보드  / 가격: 50000 / 카테고리: 전자제품 2

코드: CLO001 / 제품명: 모자 / 내용: 좋은 모자  / 가격: 10000 / 카테고리: 의류 3
코드: CLO002 / 제품명: 셔츠 / 내용: 구김이 없는 셔츠  / 가격: 50000 / 카테고리: 의류 3

코드: FOO001 / 제품명: 만두 / 내용: 고기 만두  / 가격: 10000 / 카테고리: 식품 4
코드: FOO002 / 제품명: 라면 / 내용: 맛있는 라면  / 가격: 3000 / 카테고리: 식품 4

코드: CAR001 / 제품명: 자동차 방향제 / 내용: 향기 좋음  / 가격: 5000 / 카테고리: 자동차 5
*/
INSERT INTO product VALUES("ABC002", "볼펜", "모나미 볼펜", 1000, 1);
INSERT INTO product VALUES("ABC003", "지우개", "잘 지워지는 지우개", 500, 1);

INSERT INTO product VALUES("ELC001", "마우스", "무선 마우스", 10000, 2);
INSERT INTO product VALUES("ELC002", "키보드", "무선 키보드", 50000, 2);

INSERT INTO product VALUES("CLO001", "모자", "좋은 모자", 10000, 3);
INSERT INTO product VALUES("CLO002", "셔츠", "구김이 없는 셔츠", 50000, 3);

INSERT INTO product VALUES("FOO001", "만두", "고기 만두", 10000, 4);
INSERT INTO product VALUES("FOO002", "라면", "맛있는 라면", 3000, 4);

INSERT INTO product VALUES("CAR001", "자동차 방향제", " 향기 좋음", 5000, 5);

select * from product;

# 장바구니 추가 ===============================================================================
desc basket;

# abc123 회원이 마우스 2개와 키보드 1개를 장바구니에  담았을 때 실행되는 쿼리
insert into basket(ba_amount, ba_cli_id, ba_pro_code) values(2, "abc123", "ELC001");
insert into basket(ba_amount, ba_cli_id, ba_pro_code) values(1, "abc123", "ELC002");

# abc123 회원이 마우스를 장바구니에 3개 담았을 때 실행되는 쿼리
UPDATE basket 
	SET 
		ba_amount = 3
	WHERE
		ba_cli_id = 'abc123'
			AND ba_pro_code = 'elc001';

# abc123 회원이 장바구니에 담긴 모든 제품을 구매했을 때 실행되는 쿼리
desc `order`;
select * from basket where ba_cli_id = 'abc123'; # abc123 회원이 장바구니에 담은 물건 조회
select * from product where pr_code = "elec001"; # 주문한 물건 중 elc001 코드를 가진 상품의 가격 조회
select * from product where pr_code = "elec002"; # 주문한 물건 중 elc002 코드를 가진 상품의 가격 조회

# order에 들어갈 항목이 무엇인 지는 수동으로 계산함
insert into `order`(or_amount, or_total, cli_id, pro_code) values(3, 3*10000, "abc123", "elc001"), (1, 1*50000, "abc123", "elc002");
select * from `order`;
# 주문한 상품을 장바구니에서 제외시킴
delete from basket where bas_num = 1;
delete from basket where bas_num = 2;

select * from basket;

