package day04;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		// 업다운 게임을 구현하세요
		/* 다음과 같은 메뉴를 가져야합니다.
		 * 1. 새 게임: 업다운 게임을 시작함
		 * 2. 최고기록 확인: 업다운 게임을 하면서 맞춘 횟수 중 가장 적은 횟수를 알려줌
		 * 3. 프로그램 종료: 프로그램을 종료함
		 * */
		Scanner scan = new Scanner(System.in);
		int menu, r, enter, count, record=-1, max = 100, min = 2;
		
		do {
			System.out.println("메뉴를 고르세요.\n1. 새 게임\n2. 최고기록 확인\n3. 프로그램 종료");
			menu = scan.nextInt();
			
			if(menu==1) { // 새 게임 시작하기
				count=0;  
				r= (int)(Math.random()*(max-min+1));
				while(true) {
//					System.out.println("\n r="+r);
					System.out.print("정수를 입력하세요: ");
					enter = scan.nextInt();
					
					if(enter>r) {
						System.out.println("UP!");
						count++;
					}
					else if(enter<r) {
						System.out.println("DOWN!");
						count++;
					}
					else {
						System.out.println("정답입니다!\n당신의 기록: "+count+"\n");
						if(record==-1 || record>count)
							record=count;
						break;
					}
				}
					
			}
			
			
			if (menu==2) { // 최고기록 확인하기
				if(record==-1) {
					System.out.println("플레이 한 기록이 없습니다.");
					break;
				}
					
				System.out.println("현재 최고 기록은: "+record+"\n");
				break;
			}
			
		}while(menu!=3);
		System.out.println("\n프로그램을 종료했습니다.");
	}

}
