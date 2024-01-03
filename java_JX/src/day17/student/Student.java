package day17.student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

//@getter @setter @toString @HashcodeandEquals 등을 합쳐놓은 annotation 
@Data 
@AllArgsConstructor
public class Student implements Serializable {
	private static final long serialVersionUID = -6588474647564459241L;
	private int grade, classNum, num;
	private String name;
	
	@Override // 반, 학년, 이름만 같으면 같은 객체라고 인식하도록 설정함.
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
	@Override
	public String toString() { // 콘솔에 어떻게 출력될 지를 정의함
		return "["+grade + "학년 " + classNum+"반 "+num+"번 "+name +"]";
	}
	
	
}
