package day07;

import java.util.Scanner;

public class OddEvenGameEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 프로그램을 작성하세요 메서드 이용
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴선택 : 1
		 * --------------------
		 * 선택(홀:1, 짝:0) : 1
		 * 3 홀입니다.
		 * 성공! 
		 * -------------------
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴선택 : 2
		 * -------------------
		 * 결과: 1승 0패
		 * ------------------
		 * 메뉴
		 * 1. 새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴선택 : 3
		 * ------------------
		 * 프로그램 종료 
		 * */
		Scanner scan = new Scanner(System.in);
		
		int menu = 0, enter, win = 0, lose = 0;
		int max = 100, min =1;
	
		while(menu!=3) {
			printMenu();
			menu = scan.nextInt();
			System.out.println("-------------");
			if(menu<1||menu>3) {
				System.out.println("잘못된 메뉴입니다. 다시 입력해주세요\n-------------");
				continue;
			}
			
			if (menu == 1) {
				int r= random(min, max);
				System.out.print("선택(홀:1, 짝:0) :");
				while(true) {
					enter=scan.nextInt();
//					if(enter!=1 || enter!=0) {
//						System.out.print("홀짝을 다시 입력하세요! (홀:1, 짝:0): ");
//						scan.nextLine();
//						continue;
//					}
//					oddEvenGame(enter, r);
					if(oddEvenGame(enter, r)) {
						win++;
						break;
					}
					
					lose++;
					break;
					
				}
				
			}
			
			if (menu==2) {
				printRecord(win, lose);
			}
			
			if (menu==3) {
				System.out.println("프로그램을 종료합니다.");
			}
		}
	}
	public static void printMenu() {
		System.out.println("메뉴\n1. 새 게임\n2. 결과 조회\n3. 프로그램 종료");
		System.out.print("메뉴 선택: ");
		
	}
	
	public static boolean oddEvenGame(int enter, int r) {
			if((isEven(r) && enter==0)||!isEven(r) && enter==1) { // 둘다 짝수이거나 홀수인 경우 (정답)
				System.out.println(r+" 짝입니다.\n승리!\n-------------");
				return true;
			}
			System.out.println(r+" 홀입니다.\n패배!\n-------------");	
			return false;
	}
	
	
	public static boolean isEven(int r) {
		if(r%2==0) {	
//			System.out.println(r+" 짝입니다");
			// 여기다가 적으면 oddEvenGame 메서드에 있는 조건문을 시행하면서 isEven이 2번 실행되기 때문에,
			// isEven(r) && enter==0 가 false일 경우 2번 출력됨!!
			return true;
		}
//		System.out.println(r+" 홀입니다");
		return false;
	}
	
	public static int random(int max, int min) {
		if(max>min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		return (int)(Math.random()*(max-min+1)+min);
	}
	
	public static void printRecord(int win, int lose){
		System.out.println(win+"승"+lose+"패\n-------------");
	}
}
