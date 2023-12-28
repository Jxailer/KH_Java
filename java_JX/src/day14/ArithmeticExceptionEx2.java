package day14;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExceptionEx2 {
	// 두 정수와 산술 연산자를 입력받아, 산술 연산하는 코드를 작성하세요
	// 메서드를 이용하고, throws와 throw를 이용함.
	// 단, 0으로 나눌 때 예외 처리를 적용합니다.
	public static Scanner scan = new Scanner(System.in);
	public static void main (String [] args) {
		System.out.println("식을 입력하세요 (ex: 1 + 2): ");
		
		try {
			int num1 = scan.nextInt();
			char opr = scan.next().charAt(0);
			int num2 = scan.nextInt();
			
			double res = whichOp(num1, num2, opr);
			String pattern = "{0} {1} {2} = {3}";
			System.out.println(MessageFormat.format(pattern, num1, opr, num2, res));
		}catch (ArithmeticException e) { // throw를 통해  발생한 예외를 전달받고 메인 메서드에서 처리함.
			System.out.println("0으로 나눌 수 없습니다.");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static double whichOp(int num1, int num2, char opr) throws RuntimeException{ // throws 이하 생략 가능함.
		double res = 0.0;
		try {
			if(num2==0 && (opr=='%' ||opr=='/') ) {
				throw new ArithmeticException();
			}
			
			switch(opr) {
			case '+':return num1 + num2;
			case '-':return num1 - num2; 
			case '*':return num1 * num2; 
			case '/': return  num1 / (double)num2; 
			case '%': return num1 % (double)num2;
			default: throw new RuntimeException(opr+ "는 산술 연산자가 아닙니다."); // 일부러 예외를 발생시킴.
			}		
		}
		catch(InputMismatchException e) { // 문제 발생했을 경우 메서드에서 직접 처리함.
			System.out.println("입력을 잘못했습니다.");
		}
		return res;
	}
	
}
