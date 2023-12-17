package day06;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*숫자 야구 게임을 구현하세요
		 * - 1~9 사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
		 * - S : 숫자가 있고, 위치가 다른 경우
		 * - B : 숫자가 있지만 위치가 다른 경우
		 * - O : 일치하는 숫자가 하나도 없는 경우
		 * - 3S가 되면 게임 종료
		 * 
		 * 예시
		 * 랜덤으로 생성된 숫자 : 3 9 1
		 * 입력 : 1 2 3
		 * 결과 2B
		 * 입력 4 5 6
		 * 결과: O
		 * 입력 7 8 9
		 * 결과: 1S
		 * 입력: 3 1 9
		 * 결과: 3S
		 * 정답입니다.
		 * 프로그램 종료
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 9;
		int r, i, count; 
		int [] enter = new int[3];
		
		for(count = 0; count<3; ) {
			r = (int)(Math.random()*(max-min+1)+min);
			
			// 중복 확인
			
			for(i=0; i<3;i++) {
				if(enter[i] == r) {
					break;
				}
			}
			if(i == 3) { // 중복되지 않음. 위의 for문이 정상 종료됨.
				enter[count++]= r; // 후위연산자의 특징을 이용해 코드를 1줄 줄임.
			}
		}
		
		System.out.println("랜덤으로 생성된 숫자: ");
		for(int j=0; j<3; j++) {
		}

	}

}
