package day13;

import java.util.Scanner;

public class StringEx2 {
	/* 문장들을 입력받아 배열에 저장하고,
	 * 특정 단어가 들어가 있는 문장들을을 출력하는 프로그램을 작성하세요
	 * 
	 * 메뉴
	 * 1. 문장 추가
	 * 2. 검색 (내가 원하는 단어가 들어가면 검색이 됨.)
	 * 3. 종료
	 * 
	 * 안녕하세요
	 * 테스트
	 * 만나서 반갑습니다.
	 * 나는 홍길동입니다.
	 * 
	 * '나'로 검색하기
	 * 만나서 반갑습니다.
	 * 나는 홍길동입니다.
	 * */
	
	public static int menu = 0, count = 0;
	public static String [] lines = new String[10];
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(menu!=3) {
			printMenu();
		}
	}
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.print("메뉴입력: ");
		menu = scan.nextInt();
		scan.nextLine();
		runMenu(menu);
	}
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertString();
			break;
		case 2:
			searchString();
//			if(i==count) {
//				System.out.println("해당하는 문자열이 없습니다!");
//			}
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		
	}
	public static void insertString() {
		System.out.println("--문장추가--");
		System.out.print("입력: ");
		lines[count++] = scan.nextLine();
		System.out.println("문장이 추가되었습니다.");
	}
	public static void searchString() {
		System.out.println("--문장검색--");
		System.out.print("입력: ");
		String enter = scan.nextLine();
		int i;
		for(i = 0; i<count;i++) {
			if(lines[i].contains(enter)) {
				System.out.println(lines[i]);
			}
		}
	}

}
