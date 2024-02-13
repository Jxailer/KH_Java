select * from `schedule`;

# 2월 9일, 10일에 예매 가능한 영화 목록 조회
-- select *
-- 	from `schedule`
-- 	join movie on sh_mo_num = mo_num
-- 	where sh_date in ('2024-02-09', '2024-02-10') ;

select sh_date as "상영일", sh_time as "시작시간", mo_title as "영화이름", mo_ag_name as "관람가"
	from `schedule`
	join movie on sh_mo_num = mo_num
	where sh_date in ('2024-02-09', '2024-02-10') ;

# between A and B 이용하기!
select * from schedule where sh_date between "2024-02-09" and "2024-02-10";

# SubQuery 이용하기===================================================================================
# SELECT
SELECT DISTINCT mo_title, sh_date
	FROM 
		(SELECT * FROM `schedule`
		WHERE 
			sh_date BETWEEN '2024-02-09' AND '2024-02-10') AS sh
        JOIN
			movie ON sh_mo_num = mo_num;
            
# 영화관의 전체 좌석 수와 전체 상영관 수를 현재 데이터를 기준으로 업데이트 하는 쿼리
select sum(sc_seat) from screen where sc_th_num = 1;

#UPDATE
UPDATE theater
	SET
		th_seat = (select sum(sc_seat) from screen where sc_th_num = 1),
		th_screen = (select count(sc_num) from screen where sc_th_num = 1)
	WHERE
		th_num = 1;

# 아래 쿼리에서 th_num = 1인 row의 th_seat value를 임의의 값으로 변경하고, update문이 제대로 작동 하는 지 확인하기.
select * from theater;
select * from screen;

# INSERT
# JOIN 테이블에서 1번 감독 row를 삭제하고 아래 쿼리 실행함

# 폴킹 감독이 웡카 영화에 감독으로 참여하는 쿼리
#insert into `join` select 1, '감독', 1, ?; 

INSERT INTO `join` SELECT 1, '감독', 1, mp_num FROM movie_person
	JOIN `character` ON mp_ch_num = ch_num
    WHERE ch_name = '폴킹' AND mp_role = '감독';

-- 감독인 폴킹의 mp_num을 가져오는 쿼리
select mp_num from movie_person 
	join `character` on mp_ch_num = ch_num
    where ch_name = '폴킹' and mp_role = '감독';

