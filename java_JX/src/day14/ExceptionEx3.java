package day14;

public class ExceptionEx3 {

	public static void main(String[] args) {
		// throws와 throw를 이용한 예외 처리
		
		try {
			printDiv(1, 0);
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		printDiv(1, 0);

	}
	
	// 두 수를 나눈 후 결과를 출력하는 메서드
	
	public static void printDiv(int num1, int num2) {
		if (num2==0) {
			throw new ArithmeticException("0으로 나눌 수 없습니다.");
		}
		System.out.println(num1 / (double)num2);
	}
	
}
