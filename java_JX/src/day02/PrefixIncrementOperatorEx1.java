package day02;

public class PrefixIncrementOperatorEx1 {
	public static void main (String[] ar) {
		// 증감 연산자 전위형 예제
		
		int num1 = 1, num2 = 1, num3; // num1은 전위형 증가 연산자를 사용, num2는 후위형 증가 연산자를 이용함.
		System.out.println("증가 전: num1 = " + num1 + ", num2 = " + num2);
		System.out.println("증가 중: ++num1 = " + ++num1 + ", num2++ = " + num2++);
		num3 = num2++;
		System.out.println("증가 후: num1 = " + num1 + ", num2 = " + num2);
		System.out.println(num3);
		
		System.out.println("================================");
		// 전위형과 후위형 동작이 잘 이해되지 않아서 전위형 하나만을 이용하여 후위형도 구현하기.
		num1 = 1; num2 = 1;
		System.out.println("증가 전: num1 = " + num1 + ", num2 = " + num2);
		++num1;
		System.out.println("증가 중: num1 = " + num1 + ", num2 = " + num2);
		++num2;
		System.out.println("증가 후: num1 = " + num1 + ", num2 = " + num2);
		System.out.println(num3);
		
	}

}
