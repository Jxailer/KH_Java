package day14.lottoEx;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoEx1_2 {
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
		int min = 1, max = 45;
		

		// 로또 당첨 번호 6개를 랜덤으로 생성 (중복x)
		while(lotto.size()<7) {
//			Random random = new Random();
			int tmp = (int)(Math.random()*(max-min+1)+min);
			lotto.add(tmp);
		}
		
		
		// 보너스 번호를 생성함
		List<Integer> lotto2 = new ArrayList<Integer>();
		lotto2.addAll(lotto); // Set에 있는 중복되지 않은 숫자들을 리스트에 저장함.
		bonus = lotto2.remove(lotto2.size()-1);
		
		
		System.out.println(lotto2+" "+bonus);
		
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
			if(lotto2.contains(tmp)) {
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
