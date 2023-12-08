package day01;

public class VariableEx5 {

	public static void main(String[] args) {
		
		// String 선언 예제
		String str1 = null;
		System.out.println(str1+"\n");
		
//		int num1 = null; // 기본 자료형은 null 로 초기화 될 수 없음.

		String str2 = "Hello";
		System.out.println(str2+"\n");
		

		// String str3 = 'A';	//String 클래스에 문자를 저장할 수 없다.
		
		String str4 = "A";
		System.out.println(str4+"\n");
		
		String str5 = ""; //String 클래스에 빈 문자열을 저장할 수 있다.
		System.out.println("빈 문자열: "+str5+"\n");
		
		String str6 = "" + 'A'; // 문자열 + (정수 or 실수 or 문자 or 논리값) = 문자열
		System.out.println(str6); // "A" 출력. (빈 문자열 + A)
		
	}

}
