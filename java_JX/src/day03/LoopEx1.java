package day03;

import java.util.Scanner;

public class LoopEx1 {

	public static void main(String[] args) {
		// 문자를 입력받아 출력하고, q를 입력하면 종료하는 예제
		Scanner scan = new Scanner(System.in);
		char ch='a';
		
		while(ch!='q') { // for( ; ; )
			System.out.print("\n입력하세요(q입력시 종료): ");
			ch = scan.next().charAt(0);
			System.out.println(ch);
			
			if(ch=='q') {
				System.out.println("종료되었습니다.");
//				break;
			}
		}

	}

}
