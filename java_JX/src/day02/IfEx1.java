package day02;

public class IfEx1 {
	public static void main (String [] ar) {
		// if문 예제
		// 정수가 0이면 0이라고 출력하고, 아니면 0이 아니라고 출력하기
		int num = 1;
		
		if(num == 0) {
			System.out.println("0입니다.");
		}
//		else {
		if(num!=0) {
			System.out.println("0이 아닙니다.");
		}
	}
}
