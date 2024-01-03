package day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class StreamEx1 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student(1, 1, 1, "고길동", 10, 23, 27),
				new Student(1, 1, 2, "임꺽정", 60, 43, 21),
				new Student(2, 1, 1, "홍길동", 10, 13, 53)
				);
		Stream<Student> stream = list.stream();
		// 1학년인 객체만 필터
		stream.filter(s->s.getGrade() ==1).forEach(s->System.out.println(s)); 
		System.out.println();
		
		stream = list.stream(); // 한 번 사용한 스트림은 다시 만들어야함.
		// 국어점수만 추출해서 출력함.
		stream.map(s->s.getKor()).forEach(k->System.out.println("국어: "+k));
		System.out.println();
		
		stream = list.stream();
		// 학생들의 국어 성적 평균을 계산함
		// map : A에서 B로 변환시킴
		// mapToInt: A에서 Integer로 변환함.
		double avg = stream.mapToInt(Student::getKor).average().orElse(0.0);
		System.out.println(avg);
		System.out.println();
		
		stream = list.stream();
		//국어 성적에 2를 곱한 뒤 합을 구함.
		// reduce(0, (sum,kor): 초기값 0으로 해서 2배씩 곱하기.
		// sum은 누적, kor는 스트림에서 꺼낸 국어 성적
		// 집계 함수 만들기
		Integer res = stream.mapToInt(Student::getKor).reduce(0, (sum,kor)->{
			return sum+2*kor;
		});
		System.out.println("2배 총합: "+res);
		System.out.println();
		
		Student arr[] = new Student[] {
				new Student(1, 1, 1, "고길동", 10, 23, 27),
				new Student(1, 1, 2, "임꺽정", 60, 43, 21),
				new Student(2, 1, 1, "홍길동", 10, 13, 53)
		};
		Stream<Student> stream2 = Arrays.stream(arr);
		// 22 라인에서 작성한 예제
		// 리스트로 만든 스트림과 배열로 만든 스트림을 같은 방법을 이용하여 사용할 수 있다.
		stream2.filter(s->s.getGrade() ==1).forEach(s->System.out.println(s)); 
	}

}

@Data
@RequiredArgsConstructor
@AllArgsConstructor
class Student{
	@NonNull
	int grade, classNum, num;
	@NonNull
	String name;
	int kor, eng, math;
}
