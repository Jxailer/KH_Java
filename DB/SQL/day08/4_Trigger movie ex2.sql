USE movie;

# 영화관에 상영관이 추가되면 영화관의 전체 상영관 수가 수정되는 트리거

DROP TRIGGER IF EXISTS insert_screen;

DELIMITER //
CREATE TRIGGER insert_screen
	AFTER INSERT ON screen FOR EACH ROW
BEGIN 
	
END //
DELIMITER ;


