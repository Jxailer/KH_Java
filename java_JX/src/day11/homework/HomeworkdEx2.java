package day11.homework;

import java.util.Scanner;

public class HomeworkdEx2 {
	public static Scanner scan = new Scanner(System.in);
	public static int i = 0;
	
	public static void main (String [] args) {
		
		System.out.print("식을 입력하세요(예: 1 + 2): ");
		int num1 = scan.nextInt();
		String oper = scan.next();
		int num2 = scan.nextInt();
		
		whichOp(oper, num1, num2);
		
	}
	/* 두 정수와 산술 연산자를 입력받아 결과를 출력하는 코드를 작성하세요
	 * 메서드를 생성하기
	 * */
	public static void whichOp(String oper, int num1, int num2) {
		if(oper.equals("+")) {
			addition(num1, num2);
		}
		else if(oper.equals("-")) {
			minus(num1, num2);
		}else if(oper.equals("*")) {
			multiply(num1, num2);
		}else if(oper.equals("/")) {
			divination(num1, num2);
		}else if(oper.equals("%")) {
			last(num1, num2);
		}
		else {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			i=0;
		}
	}
	
	public static void addition(int num1, int num2) {
		System.out.println(num1 + " + " + num2 + " = " +(num1+num2));
	}
	public static void minus(int num1, int num2) {
		System.out.println(num1 + " - " + num2 + " = " +(num1-num2));
	}
	public static void multiply(int num1, int num2) {
		System.out.println(num1 + " * " + num2 + " = " +(num1*num2));
	}
	
	public static void divination(int num1, int num2) {
		System.out.println(num1 + " / " + num2 + " = " +(num1/(double)num2));
	}
	public static void last(int num1, int num2) {
		System.out.println(num1 + " % " + num2 + " = " +(num1%(double)num2));
	}
}
