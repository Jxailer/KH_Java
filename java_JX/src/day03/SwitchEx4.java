package day03;

import java.util.Scanner;

public class SwitchEx4 {

	public static void main(String[] args) {
		// 산술연산자와 두 정수를 입력받아 결과를 출력하는 코드를 작성하세요
		Scanner scan = new Scanner(System.in);
		
		System.out.print("식을 입력하세요. (예: 1 + 2): ");
		int num1 = scan.nextInt();
		char opr = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		switch(opr) {
		case '+':
			System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
			break;
		case '-':
			System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
			break;
		case '*':
			System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
			break;
		case '/':
			System.out.println(num1 + " / " + num2 + " = " + (num1/(double)num2));
			break;
		case '%':
			System.out.println(num1 + " % " + num2 + " = " + (num1%num2));
			break;
		default:
			System.out.println(opr+"는 산술 연산자가 아닙니다.");
		}

	}

}
