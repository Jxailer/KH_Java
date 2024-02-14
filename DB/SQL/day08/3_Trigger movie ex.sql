use movie;

# 상영관에 좌석이 추가되면, 상영관 전체 좌석 수와 영화관 전체 좌석 수를 업데이트 하는 트리거
-- seat 테이블에 좌석이 추가되면, screen 테이블과 theater 테이블의 좌석수를 수정하는 트리거.
-- 데이터 무결성 유지하기

DROP TRIGGER IF EXISTS insert_seat;

DELIMITER //
CREATE TRIGGER insert_seat
	AFTER INSERT ON seat FOR EACH ROW
BEGIN 
	# procedure과 변수 선언 방법이 같음
	DECLARE _sc_num INT; 
    DECLARE _sc_seat INT;
    DECLARE _th_num INT;
    DECLARE _th_seat INT;
    
    SET _sc_num = NEW.se_sc_num;	# 새로 입력된 상영관 번호를 변수에 저장함
    SET _sc_seat = (SELECT COUNT(*) FROM SEAT WHERE se_sc_num = _sc_num);	# 전체 좌석수를 검색해옴
    
    # 상영관에 있는 전체 좌석수를 업데이트
    UPDATE screen SET sc_seat = _sc_seat WHERE sc_num = _sc_num;
    
    # 영화관 번호
    SET _th_num = (SELECT sc_th_num FROM screen WHERE sc_num = _sc_num);
    SET _th_seat = (SELECT COUNT(*) FROM SEAT WHERE se_sc_num IN (SELECT sc_num FROM screen WHERE sc_th_num = _th_num));
    
    # 영화관에 있는 전체 좌석 수를 업데이트
    UPDATE theater SET th_seat = _th_seat WHERE th_num = _th_num;
END //
DELIMITER ;





