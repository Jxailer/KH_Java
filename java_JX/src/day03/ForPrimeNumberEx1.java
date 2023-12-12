package day03;

import java.util.Scanner;

public class ForPrimeNumberEx1 {

	public static void main(String[] args) {
		// 소수 판별 예제.
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num = scan.nextInt();
		int count = 0;
		int i;
		
		for (i = 2; i<num; i++) {
			if(num%i == 0) {
				System.out.println(num+"은 소수가 아닙니다.");
				break;
			}
			if(i == num-1)
			System.out.println(num+"은 소수입니다.\n");
		}
		
		for (i = 1; i<=num; i++) {
			if(num%i == 0) {
				count++;
				System.out.print(i + " ");
			}
		}
		if(count == 2)
			System.out.println("\n" + num + "은 소수입니다.");
		else
			System.out.println("\n" + num + "은 소수가 아닙니다. 약수 갯수: "+count);

	}

}
