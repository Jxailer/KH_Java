package day06;

import java.util.Scanner;

public class HomeworkEx2 {

	public static void main(String[] args) {
		/* 숫자 야구게임을 구현하세요.
		 * - 기록은 최대 5개. 이전 기록은 삭제
		 * - 1~9사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
		 * - S : 숫자가 있고, 위치가 같은 경우
		 * - B : 숫자가 있지만 위치가 다른 경우
		 * - O : 일치하는 수자가 하나도 없는 경우
		 * - 3S가 되면 게임이 종료
		 * 
		 * 메뉴
		 * 1. 새게임
		 * 2. 기록확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 1
		 * 
		 * (랜덤으로 생성된 숫자 : 3 9 1)
		 * 입력 : 1 2 3
		 * 결과 : 2B
		 * 입력 : 4 5 6
		 * 결과 : O
		 * 입력 : 7 9 8
		 * 결과 : 1S
		 * 입력 : 3 1 9
		 * 결과 : 1S2B
		 * 입력 : 3 9 1
		 * 결과 : 3S
		 * 정답입니다.
		 * 도전 횟수 : 5
		 * 현재 1등입니다. 이름을 기록하세요.
		 * 이름 : JIK
		 * 
		 * 메뉴
		 * 1. 새게임
		 * 2. 기록확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * --기록--
		 * 1. JIK : 5회
		 * */
		Scanner scan = new Scanner(System.in);
		int menu, trial=0;
		int [] record=new int [5];
		
		for(int i = 0; i < record.length; i++) {
			record[i] = Integer.MAX_VALUE;
		}
		
		do {
			//메뉴를 출력
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택: ");
			menu=scan.nextInt();
			
			if(menu==1) { // 게임 시작
				int min = 1, max = 9;
				int com[] = new int[3];
				int count = 0;
				String newRecord;
				
				//랜덤으로 중복되지 않은 3개의 수를 생성
				while(count < com.length) {
					//랜덤한 수 생성
					int r = (int)(Math.random() * (max - min + 1) + min);
					
					//중복 확인
					int i;
					for(i = 0; i<count; i++) {
						if(com[i] == r) {
							break;
						}
					}
					//중복되지 않으면 저장 후 count증가
					if(i == count) {
						com[count++] = r;
					}
				}
				
				//출력
				for(int i = 0; i<com.length; i++) {
					System.out.print(com[i] + " ");
				}
				System.out.println();
				//반복문 : 맞출때까지 => 스트라이크의 개수가 3개 미만인 경우 반복
				int strike, ball;
				int user [] = new int[com.length];
				do {
					//중복되지 않은 숫자 3개를 입력
					count = 0;
					System.out.print("입력 : ");
					while(count < user.length) {
						int input = scan.nextInt();
						int i;
						for(i = 0; i<count; i++) {
							if(user[i] == input) {
								break;
							}
						}
						//중복되지 않으면 저장 후 count증가
						if(i == count) {
							user[count++] = input;
						}
					}
					//스트라이크와 볼의 개수를 계산
					strike = 0;
					ball = 0;
					for(int i = 0; i<com.length; i++) {
						for(int j = 0; j<user.length; j++) {
							//두 수가 같으면
							if(com[i] == user[j]) {
								//위치가 같으면 스트라이트
								if(i == j) {
									strike++;
								}else { //다르면 볼
									ball++;
								}
							}
						}
					}
					
					//스트라이크와 볼의 개수에 따른 결과를 출력
					if(strike != 0) {
						System.out.print(strike + "S");
					}
					if(ball != 0) {
						System.out.print(ball + "B");
					}
					if(strike == 0 && ball == 0) {
						System.out.print("O");
					}
					System.out.println();
					trial++;
						
				}while(strike < 3);
				//정답입니다.를 출력
				System.out.println("정답입니다.!");
			
				for(int j = 0; j<record.length; j++) { // 기록 5개 비교하기
					if(record[j]>trial) {
						System.out.print("현재 "+(j+1)+"등 입니다. 이름을 입력하세요: ");
						newRecord=scan.nextLine();
					}
				}
				trial=0;
				
				
			}
			else if(menu==2) {
				System.out.println("최고 기록은: "+record);
			}
			else if(menu==3) {
				System.out.println("프로그램을 종료합니다.");
			}
			else
				System.out.println("잘못된 메뉴입니다.\n");
			
		}while(menu !=3);
		
		

	}

}
