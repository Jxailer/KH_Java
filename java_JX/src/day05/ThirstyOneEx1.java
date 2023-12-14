package day05;

import java.util.Scanner;

public class ThirstyOneEx1 {

	public static void main(String[] args) {
		// 베스킨라빈스 31 게임 만들기
		/* 사용자와 컴퓨터가 돌아가면서 최대 3개의 숫자를 부르고,
		 * 31을 입력한 쪽이 지는 게임
		 * com: 1 2 3
		 * 정수: 2
		 * user: 4 5
		 * com: 6
		 * 정수: 3
		 * user: 7 8 9
		 * */
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 3;
		int r, enter, lose=0;
		int num=0;
		int j=0;
		
		while(num<31) {
			r = (int)(Math.random()*(max-min+1)+min);
			System.out.print("\ncom: ");
			for(j = 1; j<r+1; j++) {
//				가능한한 31을 부르지 않는 코드
//				if(j>1&&num+j==31) {
//					j -=1;
//					break;
//				}
				System.out.print(num+j+" ");
//				System.out.println("j: "+j);
				if(num+j==31) {
					lose=0;
					break;
				}
			}

			
			
			if(num>=31) {
				lose=0;
				break;
			}
			
			num+=j-1;
			System.out.println("num: "+num);
			System.out.println("\n정수: ");
			enter = scan.nextInt();
			System.out.print("user: ");
			
			for(int i = 1; i<=enter; i++) {
				if(num+i>=31) {
					lose=1;
					System.out.print(31);
					break;
				}
				System.out.print(num+i+" ");
			}
			num+=enter;
			if(num>=31) {
				lose=1;
				break;
			}
		
		}
		
		if(lose==0)
			System.out.println("\n승리하였습니다!");
		else
			System.out.println("\n패배하였습니다!");
		

	
		
		
	}

}





