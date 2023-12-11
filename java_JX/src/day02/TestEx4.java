package day02;

import java.util.Scanner;

public class TestEx4 {

	public static void main(String[] args) {
		// 성인 판별 예제
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요: ");
		int age = scan.nextInt();
		
		if(age>=20)
			System.out.println("성인입니다.");
		else
			System.out.println("성인이 아닙니다.");

		scan.close();
	}

}
