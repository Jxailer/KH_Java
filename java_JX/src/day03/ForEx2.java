package day03;

public class ForEx2 {

	public static void main(String[] args) {
		// 1에서 10 사이의 짝수들의 합을 구하는 코드를 작성하시오
		
		int num = 1, sum = 0, endNum=10;
		for(int i = 1; i<=endNum; i++) {
			if(i%2==0) {
				System.out.println(sum + " + " + i + " = " + (sum+i));
				sum += i;
			}
		}
		System.out.println("\n"+sum);

	}

}
