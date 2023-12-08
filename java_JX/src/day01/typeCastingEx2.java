package day01;

public class typeCastingEx2 {

	public static void main(String[] args) {
		
		// 강제 자료형 변환 예제(명시적)
		int num1 = (int)3.14; 
		// 3.14는 double형. 값 앞에 (int)를 써서 int형으로 강제 형변환. 다운캐스팅.
		System.out.println(num1+"\n"); // 3 출력
		
		byte num2 = (byte)num1; // num1은 int 형 이기 때문에 byte 형으로 형 변환을 해야함.
		System.out.println(num2+"\n"); // 3출력. 손실되는 데이터 없음.
		
		byte num4 = (byte)128;
		System.out.println(num4+"\n"); // -128출력. byte 의 범위를 벗어났기 때문에 오버플로우.
		
		// 에러가 발생하지 않지만 필요에 의해 형변환 하는 경우
		System.out.println(1/2); // 정수 / 정수 = 정수. 실제 계산값은 0.5지만 정수형이기에 0이 반환됨.
		System.out.println((double)1/2); //0.5 출력.
		
	}

}
