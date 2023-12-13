package day04;

public class PrimeNumberEx1 {
	public static void main(String [] ar) {
		//2부터 100 사이의 모든 소수를 출력하는 코드를 작성.
		
		int count=0;
		System.out.println("2부터 100사이의 모든 소수: ");
		for(int i = 2; i<101; i++) {
			for(int j=2; i>j; j++) {
				if(i%j==0) {
					count++;
					break;
				}
			}
			if(count==0) {
				System.out.print(i+", ");
			}
			count=0;
			
		}
	}
}
