package day02;

import java.util.Scanner;

public class TestEx3 {

	public static void main(String[] args) {
		// 정수를 입력 받아 0인지 양수인지 음수인지 판별.
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		int num = scan.nextInt();
		
		if (num==0) {
			System.out.println("0입니다.");
		}
		else if(num>0)
			System.out.println("양수입니다.");
		else
			System.out.println("음수입니다.");
		
	}

}
