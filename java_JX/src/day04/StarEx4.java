package day04;

public class StarEx4 {

	public static void main(String[] args) {
		// 밑변이 9인 정삼각형 출력
		int rows=5;
		
		for(int i = 0; i<=rows; i++) {
			for(int j =0; j<rows-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();

		}
		
		
		
		for(int i = 0; i<=rows; i++) {
			for(int j=0; j<rows-i; j++) {
				System.out.print(" ");
			}
			
			for(int j=0; j<i; j++) {
				System.out.print("*");
				}
			
			for(int k=0; k<i-1;k++) {
				System.out.print("*");
			}
			System.out.println(); // 엔터가 가장 마지막에 있으므로.
		}

	}

}
