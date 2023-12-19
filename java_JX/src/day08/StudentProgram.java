package day08;

import java.util.Scanner;

public class StudentProgram {
	/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.
	 * - 1반의 성적을 관리
	 * - 최대 5명
	 * - 성적은 번호순으로 관리
	 * - 성적은 국어, 영어, 수학 성적을 관리
	 * 메뉴
	 * 1.성적수정
	 * 2.성적조회
	 * 3.프로그램 종료
	 * 메뉴 선택 : 
	 * 
	 * --성적수정--
	 * 1. 국어
	 * 2. 영어
	 * 3. 수학
	 * 과목 선택 : 1
	 * 
	 * 학생 선택 : 3 번호를 선택
	 * 성적 입력 : 100
	 * 
	 * --성적조회--
	 * 1. 과목별조회
	 * 2. 학생별조회
	 * 선택 : 1
	 * --과목별조회--
	 * 1. 국어
	 * 2. 영어
	 * 3. 수학
	 * 과목 선택 : 1
	 * 1번 : 0점
	 * 2번 : 0점
	 * 3번 : 100점
	 * ....
	 * 30번 : 0점
	 * 
	 * --성적조회--
	 * 1. 과목별조회
	 * 2. 학생별조회
	 * 선택 : 2
	 * 학생 선택 : 3
	 * 국어 : 100점
	 * 영어 : 0점
	 * 수학 : 0점
	 * */
	public static void main(String[] args) {
		// 반복문 : 프로그램 종료를 선택하지 ㅇ낳으면 밥ㄴ복
		// 학년 이름은 생략하고 반은 1반으로 고정
		// 번호는 각각 1번부터 5번으로 저장
		
		Scanner scan = new Scanner(System.in);
		Student stds[] = new Student[5];
		for(int i=0; i<stds.length;i++) {
			stds[i] = new Student();
			stds[i].studentNum = i+1;
		}
			
		
		int menu=0;
		
		while(menu!=3) {
			printMenu();
			menu = scan.nextInt();
			switch(menu) {
			
			case 1:
				int subject=0;
				menu1();
				subject = scan.nextInt();
				
				System.out.print("\n\n학생 선택: ");
				int std = scan.nextInt();
				System.out.print("성적 입력: ");
				int score = scan.nextInt();

				stds[std].changeScore(subject, score);
				break;
				
			case 2:
				menu2();
				int menu2 = scan.nextInt();
				if (menu2==1) {
					menu2_1();
					subject = scan.nextInt();
					
					for(int i=0; i<stds.length;i++) {
						System.out.println((i+1)+"번 : "+stds[i].korScore);
					}
				}
				else {
					
				}
				break;
				
			case 3:
				 break;
				 
			default:
				System.out.println("잘못된 메뉴입니다. 다시 선택해주십시오.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
		
			//메뉴 출력
			//메뉴 선택
			// 선택한 메뉴에 따른 기능 실행
		// 프로그램 종료 출력

	}
	public static void printMenu() {
		System.out.print("---------------\n메뉴\n1. 성적수정\n2. 성적조회\n3. 프로그램 종료\n메뉴 선택 : ");
	}
	
	public static void menu1() {
		System.out.print("\n--성적수정--\n1. 국어\n2. 영어\n3. 수학\n과목선택: ");
	}
	public static void menu2() {
		System.out.print("\n--성적조회--\n1. 과목별 조회\n2. 학생별 조회\n선택: ");
	}
	public static void menu2_1() {
		System.out.println("\n--과목별 조회--\n1. 국어\n2. 영어\n3. 수학\n과목선택: ");
	}
	public static void printSubject(int i) {
		
	}

}
