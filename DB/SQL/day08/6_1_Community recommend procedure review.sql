use community;

DELIMITER //
CREATE PROCEDURE board_recommend(
	IN _id VARCHAR(13),
    IN _bo_num INT,
    IN _state INT # 1이면 추천, -1이면 비추천
)
BEGIN
	DECLARE _re_num INT;
    DECLARE _re_state INT;		# 현재 추천 상태
    DECLARE _new_state INT;		# 기존 추천 상태와 다른, 새로운 추천 상태(추천 취소, 혹은 비추>추천 으로 바꿈)
    
    # 1. 아이디, 게시글 번호를 이용하여 등록된 추천 번호를 조회해서 변수에 저장함
    SET _re_num = (SELECT re_num FROM recommend WHERE re_me_id = _id AND re_bo_num = _bo_num);
    
    # 2. 추천 테이블에 새로운 추천 정보를 반영함
    # 2-1. _re_num = null일 경우(사용자가 기존에 추천/비추천을 한 적 없는 게시글을 추천/비추천 할 경우)
    IF _re_num IS NULL
		-- 새로운 추천 정보 추가
		THEN INSERT INTO (RE_ME_ID, RE_BO_NUM, RE_STATE) VALUES(_ID, _BO_NUM, _STATE); 
        
	# 2-2. _re_num != null일 경우(사용자가 기존에 추천/비추천을 한 적이 있는 게시글일 경우)
	ELSE
		-- recommend 테이블에 있는 _id 사용자의 추천 상태를 가져옴.
		SET _re_state = (SELECT re_state FROM recommend WHERE re_num = _re_num); 
        
        /* 기존 변수만 사용하기 */
        /*
        # 2-2-1. 추천 상태가 _state와 같으면(사용자가 추천/비추천을 취소하고자 하면) 취소 상태(0)로 수정.
        IF _re_state = _state
			THEN UPDATE recommend SET re_state = 0 WHERE re_bo_num = _bo_num AND re_u_id = _id;
		
        # 2-2-2. 추천 상태가 _state와 다르면(사용자가 추천>비추천 혹은 비추천>추천 으로 수정하고자 하면) _state로 수정함
        ELSE
			THEN UPDATE recommend SET re_state = _state WHERE re_bo_num = _bo_num AND re_u_id = _id;
		END IF;
		*/
        
        /* 새로운 변수 사용하기*/
		# 2-2-1. 추천 상태가 _state와 같으면(사용자가 추천/비추천을 취소하고자 하면) _new_state를 취소(0)로 설정.
        IF _re_state = _state
			SET _new_state = 0;
		ELSE
			SET _new_state = _state;
		END IF;
        
        # 2-3. 기존에 있는 정보를 수정함.
        UPDATE recommend SET re_state = _new_state WHERE re_bo_num = _bo_num AND re_me_id = _id;
	END IF;
END //
DELIMITER ;

CALL board_recommend('abc123', 1, -1); # abc123 사용자가 1번 게시글을 비추천(-1)함.
        