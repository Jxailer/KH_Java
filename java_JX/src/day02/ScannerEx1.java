package day02;

import java.util.Scanner;

public class ScannerEx1 {

	public static void main(String[] args) {
		//콘솔 창에서 값을 입력받는 예제
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		int num1 = scan.nextInt();
		System.out.println("입력받은 정수: "+num1);

		// 문자열을 입력받는 예제
		//한 단어를 입력받는 예제
		System.out.print("한 단어 문자열을 입력하세요: ");
		String str1 = scan.next();
		System.out.println("입력받은 단어 문자열: "+str1); // 첫번째 단어의 앞뒤 공백을 제거하고 순수한 단어만 가져옴.

		System.out.print("실수를 입력하세요: ");
		double num2 = scan.nextDouble();
		System.out.println("입력받은 실수: "+num2);
		
		// 한 줄을 입력받는 예제
		System.out.println("한 줄 문자열을 입력하세요: ");
		scan.nextLine(); // 실수 다음에 입력한 엔터를 처리함.
		String str2 = scan.nextLine();
		System.out.println("입력받은 문장 문자열: "+str2);
		
		// 문자를 입력받는 예제
		System.out.println("문자를 입력하세요: ");
		char ch = scan.next().charAt(0);
		System.out.println(ch);
		
		scan.close();
	}

}
