USE movie;

# 영화관에 상영관이 추가되면 영화관의 전체 상영관 수가 수정되는 트리거

DROP TRIGGER IF EXISTS insert_screen;

DELIMITER //
CREATE TRIGGER insert_screen
	AFTER INSERT ON screen FOR EACH ROW
BEGIN 
	DECLARE _th_num INT;
    DECLARE _th_screen INT;
    
    # 새로 입력받은 영화관 번호
    SET _th_num = NEW.sc_th_num;
    # 현재 영화관 상영관 수를 불러옴
    SET _th_screen = (SELECT COUNT(*) FROM screen WHERE sc_th_num = _th_num);
    # 영화관에 있는 전체 좌석 수를 업데이트함
    UPDATE theater SET th_screen = _th_screen WHERE th_num = _th_num;
END //
DELIMITER ;

INSERT INTO SCREEN(SC_NAME, SC_SEAT, SC_TH_NUM) VALUES(4, 0, 1);
