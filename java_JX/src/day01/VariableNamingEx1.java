package day01;

public class VariableNamingEx1 {
	public static void main(String[] args) {
		
		// 변수명 작성 규칙 (필수)와 관례(선택이지만 추천)
		
		//1. 변수명은 대소문자를 구분함
		int num;
		int NUM;
		int Num;
		int nuM;
		
		//2. 예약어 사용 불가능함.
//		int int;
//		int public;
//		int class;

		//3. 숫자로 시작할 수 없음.
		int num2; // 가능
//		int 2num; // 불가능
		
		//4. 특수문자는 _와 $만 가능함
		int _num;
//		int #num;
//		int n um;
		int num$;
		
		//5. 중복 선언 불가능
//		int num; // 위에서 이미 선언됨. 중복선언. 
		
		
		
	}
}
