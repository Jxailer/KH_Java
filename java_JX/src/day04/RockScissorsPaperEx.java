package day04;

import java.util.Scanner;

public class RockScissorsPaperEx {

	public static void main(String[] args) {
		// 가위바위보 게임 만들기
		/*1. 새 게임
		 * 2. 기록
		 * 3. 프로그램 종료
		 * 
		 * - 컴퓨터가 랜덤으로 내는 가위, 바위, 보와 
		 * 내가 입력한 가위, 바위 보를 비교하여
		 * 이기면 승, 지면 패, 비기면 무로 기록함.
		 * 
		 * - 바위는 R, 보는 P, 가위는 S
		 * - 기록: 승 무 패를 순서대로 출력함
		 * */
		int max=3, min=0;
		int winCount = 0, loseCount=0, drawCount=0;
		int menu, r;
		char ai, enter;
		
		Scanner scan = new Scanner(System.in);
	
		
		
		do {
			System.out.println("메뉴를 고르세요.\n1. 새 게임\n2. 최고기록 확인\n3. 프로그램 종료");
			menu = scan.nextInt();
			
			if(menu==1) { // 새 게임 시작하기
				r = (int)(Math.random()*(max-min+1)); // r이 0이면 R, 1이면 S, 2이면 P
				if(r==0)
					ai = 'R';
				else if(r==1)
					ai='S';
				else
					ai='P';
				// ai = r ==1 ? 'R' : (random ==2 ? 'P' : 'S'); // 람다함수로 변경하여 코드 간결하게 만들기
//				System.out.println(ai); // ai의 값 확인
				System.out.print("가위 바위 보를 입력하세요(R, S, P): ");
				
				do {
					enter = scan.next().charAt(0);
					if(ai == enter) {
						System.out.println("비겼습니다!: ai = "+ ai+", enter = "+enter);
						drawCount++;
					}
					// 이기는 경우의 수와 지는 경우의 수를 조건문 1개로 통합하여 코드의 길이를 줄이기
					else if (enter == 'R' && ai == 'S' || enter == 'S' && ai == 'P'  || enter == 'P' && ai == 'R') {
						System.out.println("이겼습니다!: ai = "+ ai+", enter = "+enter);
						winCount++;
					}
					else {
						System.out.println("졌습니다!: ai = "+ ai+", enter = "+enter);
						loseCount++;
					}
					break;
						
				
//					else if(ai == 'R' && enter == 'S') {
//						System.out.println("졌습니다!: ai = "+ ai+", enter = "+enter);
//						loseCount++;
//					}
//					else if(ai == 'R' && enter == 'P') {
//						System.out.println("이겼습니다!: ai = "+ ai+", enter = "+enter);
//						winCount++;
//					}
//					else if(ai == 'S' && enter == 'R') {
//						System.out.println("이겼습니다!: ai = "+ ai+", enter = "+enter);
//						winCount++;
//					}
//					else if(ai == 'S' && enter == 'P') {
//						System.out.println("졌습니다!: ai = "+ ai+", enter = "+enter);
//						loseCount++;
//					}
//					else if(ai == 'P' && enter == 'S') {
//						System.out.println("이겼습니다!: ai = "+ ai+", enter = "+enter);
//						winCount++;
//					}
//					else if(ai == 'P' && enter == 'R') {
//						System.out.println("졌습니다!: ai = "+ ai+", enter = "+enter);
//						loseCount++;
//					}
//					else
//						System.out.println(enter+"다시 입력하세요 (R, S, P): ");

				}while(ai!=enter);
				
					
			}
			
			
			if (menu==2) { // 기록 확인하기
				System.out.println("현재 기록은(승 패 무): "+winCount+" "+loseCount+" "+drawCount+"\n");
			}
			
		}while(menu!=3);
		System.out.println("\n프로그램을 종료했습니다.");
	}

}
