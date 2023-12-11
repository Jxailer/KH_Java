package day02;

import java.util.Scanner;

public class TestEx5 {

	public static void main(String[] args) {
		// 월을 입력받아 입력받은 월의 계절을 출력하세요
		// 3, 4, 5 봄 / 6, 7, 8 여름 / 9, 10, 11 가을 / 12, 1, 2 겨울
		// 그 외: 잘못된 월
		
		Scanner scan = new Scanner(System.in);
		System.out.print("월을 입력하세요: ");
		int month = scan.nextInt();
		
		if(month == 3 || month == 4 || month == 5)
			System.out.println("봄입니다.");
		else if(month == 6 || month == 7 || month == 8)
			System.out.println("여름입니다.");
		else if(month == 9 || month == 10 || month == 11)
			System.out.println("가을입니다.");
		else if(month == 12 || month == 1 || month == 2)
			System.out.println("겨울입니다.");
		else
			System.out.println("잘못된 날짜입니다.");
		
		// 비교 연산을 덜 하기
		if(month < 1|| month >12)
			System.out.println("잘못된 월");
		else if(month <=2 || month ==12)
			System.out.println("겨울");
		else if(month <= 5)		// 2보다 작지 않으면서 5보다 큰 수
			System.out.println("봄");
		else if(month<=8) 		// 5보다 작지 않으면서 8보다 큰 수
			System.out.println("여름");
		else
			System.out.println("가을"); // 그 이외의 수
		
		
//		switch(month){
//		case 3: case 4: case 5:
//			System.out.println("봄입니다.");
//			break;
//		
//		case 6: case 7: case 8:
//			System.out.println("여름입니다.");
//			break;
//			
//		case 9: case 10: case 11:
//			System.out.println("가을입니다.");
//			break;
//			
//		case 12: case 1: case 2:
//			System.out.println("겨울입니다.");
//			break;
//		}
	}

}
