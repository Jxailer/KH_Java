package day14.lottoEx;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoEx1_1 {
	// Set만 이용하기
	
	/* 랜덤으로 당첨 번호를 생성하고, 사용자가 로또 번호를 입력하면 등수를 알려주는 코드를 작성
	 * 단, 컬렉션을 이용한다.
	 * 
	 * 당첨번호: 6개 + 보너스 1개
	 * 사용자: 6개
	 * */
	public static void main(String [] args) {
		Set<Integer> lotto = new HashSet<Integer>();
		Set<Integer> user = new HashSet<Integer>();
		
		int bonus;
		int min = 1, max = 10;
		

		// 로또 당첨 번호 6개를 랜덤으로 생성 (중복x)
		while(lotto.size()<6) {
//			Random random = new Random();
			int tmp = (int)(Math.random()*(max-min+1)+min);
			lotto.add(tmp);
		}
		System.out.println(1);
		// 보너스 번호를 생성함
		while(true) {
			bonus = (int)(Math.random()*(max-min+1)+min);
			if(!lotto.contains(bonus)) { // 보너스 번호가 당첨번호와 일치하지 않으면
				break;
			}
		}
		System.out.println(lotto+" "+bonus);
		
		// 사용자가 당첨 번호를 입력함
		Scanner scan = new Scanner(System.in);
		System.out.println("번호 6개 입력");
		while(user.size()<6) {
			int tmp = scan.nextInt();
			user.add(tmp);
		}
		
		// 일치하는 개수를 계산
		int count = 0;
		for(int tmp: user) {
			if(lotto.contains(tmp)) {
				count++;
			}
		}
		
		// 등수를 출력함
		switch(count) {
		case 6:
			System.out.println("1등입니다.");
			break;
		case 5:
			int rank = user.contains(bonus) ? 2: 3;
			System.out.println(rank+"등 입니다.");
			break;
		case 4:
			System.out.println("4등입니다.");
			break;
		case 3:
			System.out.println("5등입니다.");
			break;
		default:
			System.out.println("꽝입니다.");
		}
	}
}
