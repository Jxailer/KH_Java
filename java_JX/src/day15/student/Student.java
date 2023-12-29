package day15.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
	@NonNull
	private int grade, classNum, num; 
	@NonNull
	private String name; 
	private int kor=0, eng=0, math=0;
		
	
	public void printInfo() {
		System.out.println(name+" 학생 정보");
		System.out.println("학년, 반, 번호 :"+grade+", "+classNum+", "+num);
		System.out.println("국어, 영어, 수학 성적: "+kor+", "+eng+", "+math);
	}
}
