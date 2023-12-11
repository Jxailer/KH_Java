package day02;

public class IfElseEx1 {

	public static void main(String[] args) {
		// if else 예제
		// 정수가 0이면 0이라 출력하고, 아니면 0이 아닙니다 라고 출력하는 예제

			int num = 1;
			
			// if를 2번 쓰면, 무조건 2번 확인함.
			// if else를 쓰면, num이 0이면 1번 확인, num이 0이 아니면 2번 확인.
			if(num == 0) {
				System.out.println("0입니다.");
			}
			else {
//			if(num!=0) {
				System.out.println(num + "은 0이 아닙니다.");
			}
	}

}
