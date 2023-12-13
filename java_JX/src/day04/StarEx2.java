package day04;

public class StarEx2 {

	public static void main(String[] args) {
		// 밑변이 5인 직삼각형 만들기
		// i가 1부터 5까지 1씩 증가함. (다른 변수를 사용할 필요가 없음)
		
		for(int i=1; i<=5; i++) {
			for(int j=0; j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
