package day03;

public class NestedIfEx1 {

	public static void main(String[] args) {
		// 중첩 if문 실행 예제
		// 2의 배수이면 2의 배수라고 출력하고, 6의 배수이면 6의 배수라고 출력하고
		// 2, 6의 배수가 아니면 2, 6의 배수가 아님이라고 출력하기
		
		int num = 6;
		
		if(num%2 ==0) {
			if(num%3==0) { // 2의 배수이면서 3의 배수인 것은 6의 배수이다.
				System.out.println("6의 배수입니다.");
			}
			else
			System.out.println("의 배수입니다.");
		}
		else
			System.out.println("2, 6의 배수가 아닙니다.");
		
		
		
		// 중첩 if문을 사용하지 않기
		if(num%2 == 0 && num %3 == 0) { // 조건식이 조금 더 복잡해짐.
			System.out.println("6의 배수입니다.");
		}
		else if(num%2 ==0)
			System.out.println("2의 배수입니다.");
		else
			System.out.println("2, 6의 배수가 아니다.");

	}

}
