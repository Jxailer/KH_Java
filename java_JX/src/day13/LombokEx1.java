package day13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class LombokEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test(1,2);
//		t.num1 = 10; // 접근 안됨. private이기 때문에.
		System.out.println(t.getNum1());
		System.out.println(t);
	}

}
@Getter
@Setter
@Data // 게터세터, 이퀄스, 투 스트링 오버라이딩 해줌.
@AllArgsConstructor // 모든 멤버들이 매개변수로 들어간 생성자를 생성해줌.
@NoArgsConstructor // 기본 생성자 추가
class Test{
	private int num1;
	private int num2;
	
	public void print() {
		System.out.println(num1);
		System.out.println(num2);
	}
}