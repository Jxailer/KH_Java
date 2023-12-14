package day05;

import java.util.Arrays;

public class LottoEx1 {

	public static void main(String[] args) {
		// 1~45 사이의 랜덤한 수 6개를 생성하여 출력하는 예제를 작성하기
		// 단, 정렬이 되도록.
		
		int min = 1, max = 45;
		int lotto[] = new int[6];
		int r;
		int count = 0;
		
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
		
		//정렬
		Arrays.sort(lotto);
		for (int i =0; i<lotto.length; i++)
			System.out.print(lotto[i]+" ");
	}

}
