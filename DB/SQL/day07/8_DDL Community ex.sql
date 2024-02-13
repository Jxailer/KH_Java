DROP DATABASE IF EXISTS `community`;
CREATE DATABASE IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13) primary key	NOT NULL,
	`me_ms_state`	varchar(10)	NOT NULL,
	`me_pw`	varchar(15) not	NULL,
	`me_email`	varchar(30) unique not	NULL,
	`me_authority`	varchar(5)	not	NULL DEFAULT 'USER',
	`me_stop`	datetime	NULL,
	`me_fail`	int default 0	not	NULL
);

DROP TABLE IF EXISTS `memeber_state`;

CREATE TABLE `memeber_state` (
	`ms_state`	varchar(10) primary key
);

DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
	`co_num`	int primary key AUTO_INCREMENT,
	`co_name`	varchar(10) not	NULL
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`bo_num`	int primary key auto_increment	NOT NULL,
	`bo_title`	varchar(50) not	NULL,
	`bo_content`	text not	NULL,
	`bo_view`	int default 0	NOT NULL,
	`bo_report_count`	int default 0	NULL,
	`bo_co_num`	int NOT NULL,
	`bo_me_id`	varchar(13) 	NOT NULL
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int auto_increment primary key,
	`fi_name`	varchar(150) not NULL,
	`fi_ori_name`	varchar(50) not	NULL,
	`fi_bo_num`	int NOT NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`cm_num`	int auto_increment primary key	NOT NULL,
	`cm_content`	text not	NULL,
	`cm_me_id`	varchar(13)	NOT NULL,
	`cm_bo_num`	int NOT NULL
);

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
	`re_num`	int auto_increment primary key	NOT NULL,
	`re_bo_num`	int	NOT NULL,
	`re_me_id`	varchar(13) NOT NULL,
    `re_state` int not null
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
	`rp_num`	int auto_increment primary key	NOT NULL,
	`rp_me_id`	varchar(13) NOT NULL,
	`rp_rt_name`	varchar(15)	NOT NULL,
	`rp_table`	varchar(10) not	NULL,
	`rp_target`	int	not NULL,
	`rp_content`	text	not NULL,
	`rp_state`	varchar(5)	not null default '신고 접수'
);

DROP TABLE IF EXISTS `report_type`;

CREATE TABLE `report_type` (
	`rt_name`	varchar(15) primary key	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `FK_memeber_state_TO_member_1` FOREIGN KEY (
	`me_ms_state`
)
REFERENCES `memeber_state` (
	`ms_state`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_community_TO_board_1` FOREIGN KEY (
	`bo_co_num`
)
REFERENCES `community` (
	`co_num`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`bo_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`cm_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_board_TO_comment_1` FOREIGN KEY (
	`cm_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_board_TO_recommend_1` FOREIGN KEY (
	`re_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `recommend` ADD CONSTRAINT `FK_member_TO_recommend_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (
	`rp_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_report_type_TO_report_1` FOREIGN KEY (
	`rp_rt_name`
)
REFERENCES `report_type` (
	`rt_name`
);

