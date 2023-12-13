package day04;

import java.util.Scanner;

public class InfiniteLoopEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("정수입력: ");
			int num = scan.nextInt();
			System.out.println(num);
		}
	}

}
