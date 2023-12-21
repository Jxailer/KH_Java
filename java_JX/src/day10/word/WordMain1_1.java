package day10.word;

import java.util.Scanner;

public class WordMain1_1 {

	public static void main(String[] args) {
		/* 영어 단어장 프로그램을 만드세요
		 * 1. 기능 정리
		 * - 단어는 영어 단어와 한글 뜻으로 구성되어 있음
		 * - 영어 단어는 영어이고, 공백이 없는 단어
		 * - 한글 뜻은 한글이고, 한 문장으로 되어있음.
		 * - 한 단어에 뜻이 한 개만 있다고 가정.
		 * 
		 *	- 기능
		 *		- 단어 등록
		 *		- 단어 검색
		 *		- 단어 수정
		 *		- 단어 삭제
		 *	- word 클래스
		 *		- word: 영단어
		 *		- word meanigL 뜻
		 * 		- 단어출력, 수정, 확인: 주어진 문자열과 같은 단어인지 확인
		 * 
		 * 2. 틀 작성
		 * 
		 * 3. 필요한 메서드 구현
		 * 
		 * */
		
		Scanner scan = new Scanner(System.in);

		Word words[] = new Word[10];
		int menu=0, min=0, max=words.length-1;
		int latest=0, j;
		for(int i = 0; i<words.length; i++) {
			words[i] = new Word();
		}
		
		
		while(menu!=4) {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
			switch(menu) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			default:
				System.out.println("잘못된 메뉴입니다. 다시 선택해주십시오.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
		
		scan.close();
	}
	
	
	public static void printMenu() {
		System.out.print("---------------\n메뉴\n1. 영단어 추가하기\n2. 영단어 조회\n3. 랜덤 영단어 시험\n4. 프로그램 종료\n메뉴 선택 : ");
	}
	
//	public static int random(int max, int min) {
//		int r = (int)(Math.random()*(max-min+1)+min);
//		return r;
//	}


}
