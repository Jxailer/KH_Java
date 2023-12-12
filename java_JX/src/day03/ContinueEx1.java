package day03;

public class ContinueEx1 {

	public static void main(String[] args) {
		// continue를 이용해 짝수를 출력함
		// 홀수 이면 건너뛰고, 짝수면 출력함
		
		for(int i = 1; i <11 ; i++) {
			if (i%2 !=0)
				continue;
			System.out.println(i);
		}

	}

}
