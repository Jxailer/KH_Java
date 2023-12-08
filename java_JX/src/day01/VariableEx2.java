package day01;

public class VariableEx2 {

	public static void main(String[] args) {
		
		// 정수형 변수 선언 예제
		byte num1 = 1;
		System.out.println("정수형 변수 선언: "+num1+"\n"); // 1 출력.
		
//		byte num2 = 128; // byte 의 용량 크기를 벗어남. (-128 ~ 127)

		byte num3 = (byte)(127+1);
		System.out.println("오버플로우: "+num3+"\n"); // -128 출력. 오버플로우.
		
		byte num4 = (byte)(-128-1);
		System.out.println("언더플로우: "+num4+"\n"); // 127 출력. 언더플로우.
		
		int num5 = 128;
		System.out.println("int형 변수 선언: "+num5+"\n"); // 128 출력.
		
//		int num6 = 1234567890123456; // int 의 용량 크기를 벗어남.
		
		int num7 = 010; // 0으로 시작함: 8진수 10.
		int num8 = 0x10; // 0x로 시작함: 16진수 10.
		int num9 = 0b10; // 0b로 시작함: 2진수 10.
		
		System.out.println("8진수, 16진수, 2진수 출력: ");
		System.out.println(num7); // 8 출력
		System.out.println(num8); // 16 출력
		System.out.println(num9+"\n"); // 2 출력
		
		long num10 = 123456789123L; // 접미사 L을 붙여 업캐스팅.
		System.out.println("long형 변수 선언: "+num10+"\n");
		
		
		
	}

}
