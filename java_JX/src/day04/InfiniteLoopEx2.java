package day04;

import java.util.Scanner;

public class InfiniteLoopEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num;
		
		// 증감되지 않아서 무한루프 발생.
		for(int i = 10; i>0; ) {
			System.out.println("정수입력: ");
			num = scan.nextInt();
			System.out.println(num);
		}
		System.out.println("종료");
		
		// i가 증가하다가 int 표현범위가 넘어가면 오버플로우가 발생함. 이 때 반복문이 종료됨.
		for(int i = 10; i>0; i++) {
			System.out.println("정수입력: ");
			num = scan.nextInt();
			System.out.println(num);
		}
	}

}
