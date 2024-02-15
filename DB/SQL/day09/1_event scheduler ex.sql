use shoppingmall;
# 1초 마다 기간이 지난 인증번호를 삭제하도록 이벤트를 등록함
#============================================================
CREATE EVENT DELETE_CERTIFICATION
ON SCHEDULE EVERY 1 second
DO
	DELETE FROM CERTIFICATION WHERE CE_LIMIT <= NOW();
#============================================================


# 지정 시간에 이벤트가 1번만 실행되고, 실행된 후 이벤트를 삭제함(Not Preserve)
# ============================================================
CREATE EVENT DELETE_CERTIFICATION ON SCHEDULE
	AT '2024-02-15 09:50:00'
	ON COMPLETION NOT PRESERVE
	DO
		DELETE FROM certification WHERE CE_LiMIT <= NOW();
# =============================================================


SELECT * FROM SHOPPINGMALL.CERTIFICATION;
SELECT* FROM INFORMATION_SCHEMA.EVENTS;
DROP EVENT DELETE_CERTIFICATION;