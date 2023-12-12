package day03;

import java.util.Scanner;

public class WhileTestEx3 {

	public static void main(String[] args) {
		// 1에서 10 사이의 모든 짝수를 순서대로 출력하기
		Scanner scan = new Scanner(System.in);
		
		int num = 1;
		int num2 = 10;
		
		System.out.println("첫 번째 방법: if문을 이용해 2의 배수인 수만 출력하기");
		while(num<num2+1) {
			if(num%2==0) {
				System.out.println(num);
			}
			num++;
			
		}
		
		num=2;
		System.out.println("\n두 번째 방법: 반복할 때 마다 num을 2씩 줄이기");
		while(num<num2+1) {
			System.out.println(num);
			num+=2;
		}
		
		num = 1;
		System.out.println("\n세 번째 방법: 1부터 5까지의 수에 2를 곱하기.");
		while(num<=num2/2) {
			System.out.println(num*2);
			num++;
		}
		
		num = 1;
		System.out.print("\n세 번째 방법으로 입력받은 수 보다 작은 짝수를 모두 출력하기: ");
		num2 = scan.nextInt();
		
		while(num <= num2/2) {
			System.out.println(num*2);
			num++;
		}
		
		scan.close();
	}

}
