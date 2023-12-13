package day04;

import java.util.Scanner;

public class DoWhileEx1 {

	public static void main(String[] args) {
		// q를 입력하기 전까지 입력받은 문자를 출력하는 예제
		Scanner scan = new Scanner(System.in);
		char ch;
		
		do {
			System.out.print("문자를 입력하세요: ");
			ch = scan.next().charAt(0);
			System.out.println(ch);
			
			if(ch == 'q')
				break;
			
		}while(true);

	}

}
