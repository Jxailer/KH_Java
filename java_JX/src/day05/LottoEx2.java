package day05;

import java.util.Arrays;
import java.util.Scanner;

public class LottoEx2 {

	public static void main(String[] args) {
		// 로또 당첨 번호를 랜덤으로 생성한 후(당첨번호 6자리 + 보너스 번호), 
		// 사용자가 로또번호를 입력하면(로또번호 6자리) 당첨 등수를 출력하는 코드 작성
		/*
		 * */
		Scanner scan = new Scanner(System.in);
		
		int min = 1, max = 45;
		int lotto[] = new int[7];
		int lotto2[] = new int[6];
		int bonus = 0;
		boolean bonusT = false;
		int lottoUser[] = new int[6];
		int r;
		int count = 0, correct = 0;
		
		while(count<lotto.length) {
			r = (int)(Math.random()*(max-min+1)+min);
			
			// 중복 확인
			int i;
			for(i=0; i<count;i++) {
				if(lotto[i] == r) {
					break;
				}
			}
			if(i == count) { // 중복되지 않음. 위의 for문이 정상 종료됨.
				lotto[count++]= r; // 후위연산자의 특징을 이용해 코드를 1줄 줄임.
			}
			
			
			
		}
//		System.out.println("원래번호: ");
//		for (int i =0; i<lotto.length; i++)
//			System.out.print(lotto[i]+" ");
		
		
		// 보너스 번호 저장
		bonus = lotto[6];
		
		// lotto 배열을 복사함
		System.arraycopy(lotto, 0, lotto2, 0, 6);
		
		Arrays.sort(lotto2); // 당첨번호 소팅
		
		System.out.println("\n\n당첨번호는: ");
		for (int i =0; i<lotto2.length; i++)
			System.out.print(lotto2[i]+" ");
		System.out.println(", 보너스 번호: "+bonus);
		
		
		System.out.println();
		System.out.print("로또 번호를 입력하세요: ");

		for(int i=0; i<lottoUser.length; i++) {
			lottoUser[i]=scan.nextInt();
		}
		
//		for (int i =0; i<lottoUser.length; i++)
//			System.out.print(lottoUser[i]+" ");
		
		Arrays.sort(lottoUser); // 유저 번호 소팅

		for (int i =0; i<lotto.length; i++) { // 일치하는 번호 찾기
			for(int j=0; j<lottoUser.length; j++) {
				if(lotto[i]==lottoUser[j]) {
					correct++;
					break; // 생략 가능하지만 불필요한 반복을 줄임.
				}
				if(lotto[i]==bonus)
					bonusT=true;
			}
				
		}
		
		if(correct == 6) {
			System.out.println("1등입니다! 일치하는 번호 개수: "+correct);
			}
			
		else if(correct == 5 && bonusT) {
			System.out.println("2등입니다! 일치하는 번호 개수: "+correct);
		}
		else if(correct == 5) {
			System.out.println("3등입니다! 일치하는 번호 개수: "+correct);
		}
		else if(correct == 4) {
			System.out.println("4등입니다! 일치하는 번호 개수: "+correct);
		}
		else if(correct == 3) {
			System.out.println("5등입니다! 일치하는 번호 개수: "+correct);
		}
		else
			System.out.println("미당첨 입니다.일치하는 번호 개수: "+correct);
		
		
	}
	

}
