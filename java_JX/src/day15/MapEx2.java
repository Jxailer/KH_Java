package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx2 {
	// 회원을 관리하는 프로그램을 작성하세요
			/* 메뉴
			 * 1. 회원가입
			 * - 아이디와 비번만 입력
			 * - 이미 가입된 회원인지 체크함(containsKey 이용)
			 * 
			 * 2. 회원 검색
			 * - 아이디를 입력해서 회원 정보를 조회
			 * 
			 * 3. 종료
			 * */
	
	public static Scanner scan = new Scanner(System.in);
	public static int menu = 0;
	public static Map<String, String> userMap = new HashMap<String, String>();
	
	public static void main(String[] args) {
		
		while(menu!=3) {
			printMenu();
			
		}
	}
	public static void printMenu() {
		System.out.println("--------------");
		System.out.println("메뉴");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원검색");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴입력: ");
		menu = scan.nextInt();
		scan.nextLine();
		runMenu(menu);
	}
	
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			signOut();
			break;
		case 2:
			searchUser();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	public static void signOut() {
		System.out.println("--회원가입--");
		System.out.print("아이디 입력: ");
		String id = scan.next();
		
		if(userMap.containsKey(id)) {
			System.out.println("이미 등록된 아이디입니다!");
			return;
		}
		
		System.out.print("비밀번호 입력: ");
		String pw = scan.next();
		
		userMap.put(id, pw);
		System.out.println("회원이 등록되었습니다.");
		
	}
	

	
	public static void searchUser() {
		System.out.println("--회원검색--");
		System.out.print("검색할 아이디 입력: ");
		String id = scan.nextLine();
		
		if(userMap.containsKey(id)) {
			String pw = userMap.get(id);
			System.out.println(id+" 회원 비밀번호: "+pw);
		}
		else {
			System.out.println("등록되지 않은 회원입니다.");
		}
	}

}
