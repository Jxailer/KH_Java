package day04;

public class StarEx3 {

	public static void main(String[] args) {
		// 오른쪽으로 붙은 밑변이 5인 직각삼각형 출력
		int rows=6;
		for(int i = 1; i<=rows; i++) {
			for(int k=1; k<=rows-i;k++) {
				System.out.print(" ");
			}

			for(int k=0; k<i; k++) {
				System.out.print("*");
			}
			System.out.println();
			
			
		}


	}

}
