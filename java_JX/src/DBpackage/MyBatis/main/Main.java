package DBpackage.MyBatis.main;

import java.util.Scanner;

import DBpackage.MyBatis.controller.MemberController;

public class Main {
	private static MemberController memberController = new MemberController();
	public static void main (String [] args) {
		int menu;
		Scanner scan = new Scanner(System.in);
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu != 2);
	}
		
		private static void runMenu(int menu) {
			switch(menu) {
			case 1:
				memberController.run();
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		
		}

		private static void printMenu() {
			System.out.println("1. 회원 가입");
//			System.out.println("2. 회원 수정");
//			System.out.println("3. 회원 탈퇴");
//			System.out.println("4. 회원 조회");
//			System.out.println("5. 프로그램 종료");
			System.out.println("2. 프로그램 종료");
			System.out.print("메뉴 선택: ");
		}
}
