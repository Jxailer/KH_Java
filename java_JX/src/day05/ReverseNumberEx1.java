package day05;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class ReverseNumberEx1 {

	public static void main(String[] args) {
		/*정수를 입력받아 입력받은 정수를 거꾸로 출력하는 코드를 작성하세요
		 * 입력 1234
		 * 출력 4321
		 * */ 
		
		// 1번째 방법
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력: ");
		int num1 = scan.nextInt();
		System.out.print("거꾸로된 정수: ");
		while(num1!=0) {
			System.out.print(num1%10);
			num1/=10;
		}
		
		
		// 2번째 방법
		System.out.print("\n\n정수 입력: ");
		scan.nextLine();
		String num2 = scan.nextLine();
		
		System.out.print("거꾸로된 정수: ");
//		char arr[] = new char[num2.length()];
//		
//		for (int i=0; i<num2.length(); i++) {
//			arr[i] = num2.charAt(i);
//		}
//		for (int i=num2.length()-1; i>=0; i--) {
//			System.out.print(arr[i]);
//		}
		
		for (int i=num2.length()-1; i>=0; i--) {
			System.out.print(num2.charAt(i));
		}
	}

}
