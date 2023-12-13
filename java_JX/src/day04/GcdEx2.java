package day04;

public class GcdEx2 {

	public static void main(String[] args) {
		// 두 정수의 공약수를 출력하는 코드를 작성하세요.
		
		int num1 = 12, num2 = 24;
		
		int i=1;
		System.out.println(num1 + "과 "+num2+"의 공약수: ");
		while(i<=num1 || i<=num2) {
			if(num1%i == 0 && num2%i == 0) {
				System.out.print(i+ " ");
//				if(num2%i == 0) {
//					num22 = i;
//					if (num11 == num22) {
//						System.out.print(num11+" ");
//					}
//				}
			}
			
			
			i++;
		}
		

	}

}
