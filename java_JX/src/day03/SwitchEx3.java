package day03;

import java.util.Scanner;

public class SwitchEx3 {

	public static void main(String[] args) {
		// 월을 입력받아 입력받은 월의 계절을 출력하세요
		
		Scanner scan = new Scanner(System.in);

		System.out.print("월을 입력하세요: ");
		int month = scan.nextInt();
		
		switch(month) {
		case 3: case 4: case 5:
			System.out.println("봄입니다.");
			break;
		case 6: case 7: case 8:
			System.out.println("여름입니다.");
			break;
		case 9, 10, 11:
			System.out.println("가을입니다.");
			break;
		case 1, 12, 2:
			System.out.println("겨울입니다.");
			break;
		default:
			System.out.println("잘못된 월입니다.");
		}
	}

}
