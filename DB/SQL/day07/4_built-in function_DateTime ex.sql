# 시간 함수
SELECT ADDDATE(NOW(), 2); # 지금 시간에서 2일 증가된 날짜
SELECT SUBDATE(NOW(), 2); # 지금 시간에서 2일 감소된 날짜

SELECT ADDTIME(NOW(), "2:00:00"); # 지금 시간에서 2시간 증가된 날짜
SELECT SUBTIME(NOW(), "2:00:00"); # 지금 시간에서 2시간 감소된 날짜

SELECT YEAR(NOW()), MONTH(NOW()), DAY(NOW()); # 지금 시간의 (연, 월, 일)
SELECT DATE(NOW()), TIME(NOW()); # 지금 시간의 (연월일, 시분초) 

# DATEDIFF(날짜1, 날짜2) : 날짜1에서 날짜2의 차이를 일로 반환. 
# 날짜1 - 날짜2
SELECT DATEDIFF("2024-02-10", NOW()); # 3월 2일을 기준으로 오늘 날짜를 빼면 몇 일인지

# TIMEDIFF(날짜/시간1, 날짜/시간2) : 날짜/시간1에서 날짜/시간2의 차이를 시간:분:초로 반환. 
# 날짜/시간1 - 날짜/시간2
SELECT TIMEDIFF("11:30", "9:00");

# INSERVAL 종류(시간 유형)
-- YEAR/MONTH/DAY : 년/월/일
-- HOUR/MINUTE/SECOND/MICROSECOND : 시/분/초/마이크로초
-- QUARTER/WEEK : 분기/달

# INSERVAL 종류(조합 유형)
-- YEAR_MONTH : 년-월
-- DAY_HOUR : 일 시간
-- DAY_MINUTE : 일 시간:분
-- DAY_MICROSECOND : 일 시간:분:초.마이크로초


# DATE_ADD/DATE_SUB(기준날짜, INTERVAL) : 기준 날짜에서 INTERVAL만큼 더한/뺀 날짜
SELECT DATE_ADD(NOW(), INTERVAL 1 DAY);
SELECT DATE_ADD(NOW(), INTERVAL 3 WEEK);
SELECT DATE_ADD(NOW(), INTERVAL 5 YEAR);
SELECT DATE_ADD(NOW(), INTERVAL "1 1" YEAR_MONTH); # 지금으로부터 1년 1개월 뒤의 날짜
