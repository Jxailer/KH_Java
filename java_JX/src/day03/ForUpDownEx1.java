package day03;

import java.util.Scanner;

public class ForUpDownEx1 {

	public static void main(String[] args) {
		// 숫자 업다운 게임을 작성하세요.
		/* 랜덤으로 생성된 숫자를 맞추는 게임.
		 * 예시:
		 * 	랜덤으로 생성된 숫자	:30
		 * 	정수				:50
		 * 	Down 출력.
		 * 	정수				:20
		 * 	Up 출력.
		 * 	정수				:30
		 * 	정답!
		 * */
		
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 100;
		int r = (int)(Math.random()*(max-min+1)+min);
		
		
		System.out.println("랜덤으로 생성된 숫자: "+ r);
		
		for(int enter=min-1; enter != r; ) { // 입력받을 정수를 담을 변수를, 랜덤 범위에 들어가지 않는 min-1로 초기화함.
			System.out.print("정수: ");
			enter = scan.nextInt();
			
			if(enter>r)
				System.out.println("Down!");
			else if(enter<r)
				System.out.println("Up!");
			else {
				System.out.println("\n정답!");
//				break;
			}
			
		}
		scan.close();
	}

}
