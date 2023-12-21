package day10.word;

import java.util.Scanner;

public class WordMain {

	private static Scanner scan = new Scanner(System.in);
	private static Word [] words = new Word[10];
	
	public static void main(String[] args) {
		/* 영어 단어장 프로그램을 만드세요
		 * 1. 기능 정리
		 * - 영어 단어 추가하기
		 * - 추가된 영어 단어 조회하기
		 * - 랜덤 영단어 시험보기
		 * - 단어 검색
		 * - 단어 수정
		 * - 단어 삭제
		 * - 
		 * 
		 * 2. 틀 작성
		 * 
		 * 3. 필요한 메서드 구현
		 * 
		 * */
		
		
		int menu=0, min=0, max=words.length-1;
		int count=0, j;
//		for(int i = 0; i<words.length; i++) {
//			words[i] = new Word();
//		}
		
		
		while(menu!=7) {
			printMenu();
			menu = scan.nextInt();
			scan.nextLine();
//			runMenu(menu);
			switch(menu) {
			case 1: // 단어 추가
				System.out.print("추가할 영단어 입력: ");
				String eng = scan.next();
				scan.nextLine();
				System.out.print("영단어 뜻 입력   : ");
				String mean = scan.nextLine();
				
				for(j=0; j<words.length;j++) { // 단어자의 비어있는 칸을 찾아 새 영단어를 저장하기
					if(words[j]==null) {
						words[j] = new Word(eng, mean);
//						words[j].setEng(eng);
//						words[j].setMean(mean);
						System.out.println(++count);
						if(count==words.length-1) {
							expandWords();
						}
						break;
					}
						
				
				}
//				if(j==words.length) {
//					
//					System.out.println(words.length);
//					words[count].setEng(eng);
//					words[count++].setMean(mean);
//				}
				break;
				
			case 2: // 단어 조회
				for(int i=0; i<count; i++) {
					System.out.print((i+1)+". ");
					words[i].printWord();
				}
				break;
				
			case 3: // 랜덤 단어 시험
				int r;
				while(true) { // 뜻이 null값이 아닌 영단어 항목만 출력하도록 함.
					r = random(max, min);
					if(words[r].getEng()!=null)
						break;
				}
				System.out.println("다음 영단어의 뜻은 무엇인가요? : "+words[r].getEng());
				String enter = scan.nextLine();
				
				if(enter.equals(words[r].getMean())) {
					System.out.println("정답입니다!");
					break;
				}
				System.out.println("오답입니다! 뜻은: "+words[r].getMean());
				
			case 4: // 단어 검색
				System.out.println("찾으려는 단어를 입력하세요: ");
				String enter2 = scan.nextLine();
				int k;
				for(k = 0; k<words.length; k++) {
					if(words[k].getEng().equals(enter2)) {
						System.out.println(words[k].getEng()+"의 뜻은 : "+words[k].getMean());
						break;
					}
					else if(words[k].getMean().equals(enter2)) {
						System.out.println(words[k].getMean()+"은 영어로 : "+words[k].getEng());
						break;
					}
					
				}
				if (k==words.length)
					System.out.println("찾는 단어가 등록되어있지 않습니다!");
				break;
			default:
				System.out.println("잘못된 메뉴입니다. 다시 선택해주십시오.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
		
		scan.close();
	}
	
	
	public static void printMenu() {
		System.out.println("---------------\n메뉴");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 조회");
		System.out.println("3. 랜덤 단어 시험");
		System.out.println("4. 단어 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택: ");
	}
	
	public static void printMenu4() {
		System.out.print("단어 수정하기 1, 단어 삭제하기 2, 메뉴로 돌아가기 3: ");
	}
	
	public static int random(int max, int min) {
		int r = (int)(Math.random()*(max-min+1)+min);
		return r;
	}
	
	public static void runMenu(int menu) {
		int j, latest=0;
		switch(menu) {
		case 1:
			System.out.print("추가할 영단어 입력: ");
			String eng = scan.next();
			scan.nextLine();
			System.out.print("영단어 뜻 입력   : ");
			String mean = scan.nextLine();
			
			for(j=0; j<words.length;j++) { // 단어자의 비어있는 칸을 찾아 새 영단어를 저장하기
				System.out.println(words.length);
				if(words[j].getEng()==null) {
					words[j].setEng(eng);
					words[j].setMean(mean);
					break;
				}
			}
			if(j==words.length) {
				System.out.println("용량이 초과되었습니다. 가장 오래된 단어를 삭제합니다.");
				words[latest].setEng(eng);
				words[latest++].setMean(mean);
				if(latest == words.length) {
					latest=0;
				}
			}
//			System.out.println("단어 등록");
			break;
		case 2:
			System.out.println("단어 검색");
			break;
		case 3:
			System.out.println("단어 수정");
			break;
		case 4:
			System.out.println("단어 삭제");
			
			break;
		case 5:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴");
		}
	}
	
	public static void expandWords() {
		System.out.println("확장");
//		기존 단어장 보다 큰 단어장 생성
		Word [] tempList = new Word[words.length+10];
//		새 단어장에 기존 단어들을 복붙함
		System.arraycopy(words, 0, tempList, 0, 10);
//		새 단어장을 내 단어장이라고 선언함
		words=tempList;
		System.out.println(words.length);

	}



}
