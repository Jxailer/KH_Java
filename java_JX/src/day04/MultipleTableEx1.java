package day04;

public class MultipleTableEx1 {

	public static void main(String[] args) {
		// 구구단 2단부터 9단까지 출력하기
		
		for(int i = 2; i<10;i++) {
			System.out.println("구구단 "+i+"단");
			for(int j = 1; j<10;j++) {
				System.out.println(i + " * " + j + " = " + i*j);
			}
			System.out.println("\n");
		}

	}

}
