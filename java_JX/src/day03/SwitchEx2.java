package day03;

import java.util.Scanner;

public class SwitchEx2 {

	public static void main(String[] args) {
		// switch문 예제
		// 입력 받은 정수의 홀짝 판별 에제를 switch문을 이용하여 작성하세요
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		int num = scan.nextInt();
		
		switch(num%2){
			case 1:
				System.out.println("홀수입니다.");
				break;
			default:
				System.out.println("짝수입니다.");
		}
		
		scan.close();
	}

}
