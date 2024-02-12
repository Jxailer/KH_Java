use university;

# 컴퓨터 공학을 전공한 학생 정보를 조회
select * from student where st_major="컴퓨터공학";

# 컴퓨터 공학을 다니는 1학년 학생 정보를 조회
select * from student where st_major="컴퓨터공학" AND st_grade = 1;

# 컴퓨터 공학 또는 화학 공학을 전공한 1학년 학생 정보를 조회
select * from student where (st_major="컴퓨터공학" or st_major="화학공학") and st_grade = 1;
select * from student where st_major in('컴퓨터공학', '화학공학') and st_grade = 1;

# 컴퓨터 공학을 전공한 학생 수를 조회
select st_major as "전공", count(st_name) as "학생 수"  from student where st_major = "컴퓨터공학";

# 전공 별 학생 수 조회
select st_major as "전공", count(st_name) as "학생 수"  from student group by st_major;

# 전공 조회
select distinct st_major from student;

# 학생들이 3명 이상인 학과를 조회 (having 절!!)
select st_major as "전공", count(st_name) as "학생 수"  from student group by st_major having count(st_name)>=3 ;

# 컴퓨터 개론을 수강하는 학생 수를 조회 (join 연산법!!)
select count(co_st_num) as "학생 수", le_title 
	from course join lecture on co_le_num = le_num 
    where le_title="컴퓨터개론";

# 강의별로 수강학생 수와 강의명 조회
select le_title as "강의명", count(co_st_num) as "학생 수" 
	from course join lecture on co_le_num = le_num 
    group by le_title;
    
# 홍길동 학생이 수강하는 강의 목록 조회
select le_title as "홍길동 수강 과목" from course 
	join student on co_st_num = st_num
	join lecture on co_le_num = le_num
where st_name = "홍길동";

# 기계 공학에 소속된 교수의 수를 조회
select count(*) as "기계공학 교수 인원" from professor where pr_major = "기계공학";

# 김교수가 강의하는 강의명을 조회
select le_title as "김교수 강의" from lecture
	join professor on le_pr_num = pr_num
where pr_name = "김교수";

