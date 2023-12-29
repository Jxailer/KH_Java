package day15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FunctionInterfaceEx1 {

	public static void main(String[] args) {
		
		
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "홍길동", 100, 90, 70));
		list.add(new Student(1, 1, 2, "임걱정", 10, 100, 30));
		list.add(new Student(1, 1, 3, "고길동", 50, 20, 70));
		
		// 학생들의 정보 출력(Consumer 이용)
		print(list, s->{
			System.out.println(s.getGrade()+"학년 "+s.getClassNum()+"반 "
					+ s.getNum()+"번 "+ s.getName());
		});
		
		print(list, s->{
			System.out.println(s.getName()+": 국어 - "+s.getKor()
			+ ", 영어 - "+s.getEng()
			+ ", 수학 - "+s.getMath());
		});
		
		System.out.println();
		
		// 학생들의 각 과목별 총점 출력하기(Function이용)
		System.out.println("국어 ");
		printTotalScore(list, (s)->s.getKor());
		
		System.out.println("영어 ");
		printTotalScore(list, (s)->{
			return s.getEng();
		});
		
		System.out.println("수학 ");
		printTotalScore(list, (s)->{
			return s.getMath();
		});
		
		System.out.println();
		
		// 학생 정보 출력(Predicate 이용)
			// 1학년 학생들의 정보 출력
		System.out.println("----------1학년 학생들의 정보 출력----------");		
		printStudent(list, (s)->s.getGrade()==1);
			// 국어 성적이 50점 이상인 학생들의 정보 출력
		System.out.println("----------국어 성적이 50점 이상인 학생들의 정보 출력----------");
		printStudent(list, (s)->s.getKor()>=50);
			// 평균이 85점 이상인 학생들의 정보 출력
		System.out.println("----------평균이 85점 이상인 학생들의 정보 출력----------");		
		printStudent(list, (s)->(s.getKor()+s.getEng()+s.getMath())/3.0 >=85);
	}
	public static void printStudent(List<Student> list, Predicate<Student> p) {
		for(Student std: list) {
			if(p.test(std)) {
				System.out.println(std);
			}
		}
	}
	
	public static void printTotalScore(List<Student> list, Function<Student, Integer> fn)  {
		int total = 0;
		for(Student std : list) {
			total +=fn.apply(std);
		}
		System.out.println("총점: "+total);
	}
	
	
	public static void print(List<Student> list, Consumer<Student> consumer) {
		for(Student student : list) {
			consumer.accept(student);
		}
	}
	
	

}

@Data
@AllArgsConstructor
class Student{
	int grade, classNum, num;
	String name;
	int kor, eng, math;
}
