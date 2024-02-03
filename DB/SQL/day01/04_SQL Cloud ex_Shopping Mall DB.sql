drop database if exists shoppingmall;
create database if not exists shoppingmall;
use shoppingmall;



DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
	`cli_id`	varchar(13)	PRIMARY KEY,
	`cli_pw`	varchar(20) not	NULL,
	`cli_email`	varchar(30) not	NULL,
	`cli_phone`	varchar(13) not	NULL,
	`cli_auth`	varchar(10) not null default "USER",
	`cli_try_count`	int not null default 0
);

DROP TABLE IF EXISTS `certification`;

CREATE TABLE `certification` (
	`cer_num`	int	PRIMARY KEY,
	`cer_code`	char(6) not	NULL,
	`cer_limit`	datetime not	NULL,
	`cer_cli_id`	varchar(13)	NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pro_code`	varchar(15)	NOT NULL PRIMARY KEY,
	`pro_name`	varchar(50) not	NULL,
	`pro_content`	text not NULL,
	`pro_price`	int not null default 0,
	`pro_cate_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`cate_num`	int	NOT NULL PRIMARY KEY auto_increment,
	`cate_name`	varchar(10) not	NULL
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`or_num`	int	NOT NULL PRIMARY KEY auto_increment,
	`or_date`	datetime not null default current_timestamp,
	`or_state`	varchar(10) not null default "결제완료",
	`or_amount`	int not null default 0,
	`or_total`	int not	NULL,
	`cli_id`	varchar(13)	NOT NULL,
	`pro_code`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `basket`;

CREATE TABLE `basket` (
	`bas_num`	int	NOT NULL PRIMARY KEY auto_increment,
	`ba_amount`	int not null default 0,
	`ba_pro_code`	varchar(15)	NOT NULL,
	`ba_cli_id`	varchar(13)	NOT NULL
);

DROP TABLE IF EXISTS `thumbnail`;

CREATE TABLE `thumbnail` (
	`thumb_num`	int	NOT NULL primary key auto_increment,
	`thumb_file`	varchar(50)	NULL,
	`thumb_pro_codeboard`	varchar(15)	NOT NULL
);

ALTER TABLE `certification` ADD CONSTRAINT `FK_client_TO_certification_1` FOREIGN KEY (
	`cer_cli_id`
)
REFERENCES `client` (
	`cli_id`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`pro_cate_num`
)
REFERENCES `category` (
	`cate_num`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_client_TO_order_1` FOREIGN KEY (
	`cli_id`
)
REFERENCES `client` (
	`cli_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_product_TO_order_1` FOREIGN KEY (
	`pro_code`
)
REFERENCES `product` (
	`pro_code`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_product_TO_basket_1` FOREIGN KEY (
	`ba_pro_code`
)
REFERENCES `product` (
	`pro_code`
);

ALTER TABLE `basket` ADD CONSTRAINT `FK_client_TO_basket_1` FOREIGN KEY (
	`ba_cli_id`
)
REFERENCES `client` (
	`cli_id`
);

ALTER TABLE `thumbnail` ADD CONSTRAINT `FK_product_TO_thumbnail_1` FOREIGN KEY (
	`thumb_pro_code`
)
REFERENCES `product` (
	`pro_code`
);

