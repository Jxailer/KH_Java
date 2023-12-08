package day01;

public class VariableEx1 {
	public static void main(String[] args) {
		// 문자형 변수 선언 예제
		
		char ch1; // 문자형 변수 ch1을 선언함 (not initialized)
		char ch2 = 'A';
		
		// 변수는 초기화를 하고, 사용해야한다
		// 초기화 되지 않은 ch1을 사용하려고 하면 에러가 발생함.
		
		ch1 = '+'; // ch1 값 초기화
		System.out.println(ch1); // + 출력
		System.out.println(ch2); // A 출력
		
//		char ch3 = "A"; // 문자에는 ''를 사용함.'
//		char ch4 = "12"; // '' 안에는 한 글자만 들어가야함.
		
		char ch5 = '\u0065'; // 유니코드 65에 해당하는 문자를 저장함.
		System.out.println(ch5); // e 출력.
		
		char ch6 = 65; // 아스키코드 65에 해당하는 문자를 저장함.
		System.out.println(ch6); // A 출력. 유니코드와는 다름.
		
		// \가 들어간 문자들이 있음. \n: 엔터, \t: 탭키, \\: \문자.
		char ch7 = '\n'; // 개행자.
	}
}
