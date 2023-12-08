package day01;

public class typeCastingEx1 {
	public static void main(String[] args) {
		
		// 자동 자료형 변환 예제(암묵적)
		// 작은 자료형을 큰 자료형으로 변환할 때, 혹은 정수를 실수로 변환할 때.
		double num1 = 1; // int > double 로 형변환됨. 업캐스팅.
		System.out.println(num1+"\n"); // 1.0 출력		
	
		long num2 = 2; // int > long 으로 형변환됨. 업캐스팅.
		System.out.println(num2+"\n"); 
		
		char ch = 'a';
		int num3 = ch; // 'a'의 아스키코드 값인 97이 num3에 저장됨
		System.out.println(num3); // 97 출력
		
	}
}
