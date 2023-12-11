package day02;

public class ArithmeticOperatorEx1 {

	public static void main(String[] args) {
		// 산술 연산자 예제
		
		int num1 = 1, num2 = 2;
		System.out.println(num1 + " + " + num2 + " = " +(num1 + num2));
		System.out.println(num1 + " - " + num2 + " = " +(num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + num1 * num2);
		System.out.println(num1 + " / " + num2 + " = " + (float)num1 / num2);
		System.out.println(num1 + " % " + num2 + " = " +num1 % num2);

		// /와 %는 오른쪽에 0을 둘 수 없다(0으로 나누기 불가능). 예외가 발생할 수 있다.
		num2 = 0;
//		System.out.println(num1 + " / " + num2 + " = " + num1 / num2);
		System.out.println(num1 + " / " + num2 + " = " + (float)num1 / num2); // Infinity 출력.
	}

}
