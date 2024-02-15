use community;

# 공지사항인 글을 검색하는 쿼리
select * from board where bo_co_num = (select co_num from community where co_name = '공지')
	order by bo_num desc
    limit 0, 10;

# 3번 게시글을 상세 조회하는 쿼리
select * from board where bo_num = 3;

# abc123 회원이 3번 게시글에 '확인했습니다'라고 댓글을 달았을 때 쿼리
INSERT INTO COMMENT(cm_bo_num, cm_me_id, cm_content) values(3, 'abc123', '확인했습니다.');

# 3번 게시글에 댓글 1페이지를 조회하는 쿼리
select * from comment where cm_bo_num = 3
	order by cm_num desc limit 0, 5;
    
# 신고 사유를 등록함
insert into report_type values('욕설'),('허위사실유포'),('광고'),('음란'),('커뮤니티에 맞지 않음'),('기타');

# admin이 1번 댓글을 '기타'로 신고함
insert into report(rp_me_id, rp_rt_name, rp_table, rp_content , rp_state, rp_target) 
	values('admin', '기타', 'comment', '', '신고접수', 1);

# 관리자가 신고 내역을 조회 => 신고 접수된 내역을 조회
select * from report where rp_state = '신고접수';

# 관리자가 1번 신고 내역을 '신고반려'로 처리
update report
	set rp_state = "신고반려"
    where rp_num = 1;
select * from report;

# abc123회원이 1번 게시글을 '기타', '내용없음'으로 신고
insert into report(rp_me_id, rp_rt_name, rp_table, rp_content , rp_state, rp_target) 
	values('abc123', '기타', 'board', '', '신고접수', 1);

# qwer123회원이 1번 게시글을 '기타', '내용없음'으로 신고
insert into report(rp_me_id, rp_rt_name, rp_table, rp_content , rp_state, rp_target) 
	values('qwe123', '기타', 'board', '', '신고접수', 1);

# admin 관리자가 1번 게시글을 '기타', '내용없음'으로 신고
insert into report(rp_me_id, rp_rt_name, rp_table, rp_content , rp_state, rp_target) 
	values('admin', '기타', 'board', '', '신고접수', 1);

# 관리자가 1번 게시글 신고 내역을 모두 '신고처리'로 처리함
update report
	set rp_state = "신고처리"
    where rp_table = 'board' and rp_target=1 and rp_state = '신고접수';
select * from report;

# 3번 신고된 게시글을 삭제하고, 해당 게시글을 작성한 작성자에게 1달 이용 정지를 적용.
-- 1번 게시글을 삭제하기 위해 1번 게시글에 달린 댓글들을 삭제
DELETE FROM COMMENT WHERE CM_BO_NUM = 1;
-- 1번 게시글을 삭제하기 위해, 1번 게시글을 추천한 추천 정보를 삭제함
DELETE FROM RECOMMEND WHERE RE_BO_NUM = 1;
-- 1번 게시글 삭제
DELETE FROM BOARD WHERE BO_NUM =1;
-- abc123 회원을 한 달간 이용 정지시킴
UPDATE MEMBER 
	SET ME_MS_STATE = '기간정지', me_stop = DATE_ADD(NOW(), INTERVAL 1 MONTH) 
	WHERE ME_ID = 'abc123';

# qwe123 회원이 회원탈퇴함
-- 요구사항 때문에 DELETE가 아닌 UPDATE를 이용해야함.
UPDATE MEMBER SET me_ms_state = '탈퇴' where me_id = "qwe123";

