package day14;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExceptionEx1 {
	// 두 정수와 산술 연산자를 입력받아, 산술 연산하는 코드를 작성하세요
	// 단, 0으로 나눌 때 예외 처리를 적용합니다.
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = 0, num2 = 0;
		double res = 0;
		
		System.out.println("식을 입력하세요 (ex: 1 + 2): ");
		try {
			num1 = scan.nextInt();
			char opr = scan.next().charAt(0);
			num2 = scan.nextInt();
			
			switch(opr) {
			case '+': res = num1 + num2; break;
			case '-': res = num1 - num2; break;
			case '*': res = num1 * num2; break;
			case '/': res = num1 / num2; break;
			case '%': res = num1 % num2; break;
			}
			String pattern = "{0} {1} {2} = {3}";
			System.out.println(MessageFormat.format(pattern, num1, opr, num2, res));
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(InputMismatchException e) {
			System.out.println("입력을 잘못했습니다.");
		}
		
		
		
	}
	
}
