package day04;

public class StarEx1 {

	public static void main(String[] args) {
		// 별이 한 줄에 다섯개, 총 세줄이 출력되도록 함.
		
		for(int i =0; i<3; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		
	}

}
