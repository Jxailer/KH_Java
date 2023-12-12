package day03;

public class RandomEx1 {

	public static void main(String[] args) {
		// min ~ max 사이의 랜덤한 수를 생성하는 예제
		
//		Math.random(); // 0~1의 실수를 랜덤 반환.
		int min =1, max = 10;
		int r = (int)(Math.random() * (max-min+1) + min);
		System.out.println(r);
	}

}
