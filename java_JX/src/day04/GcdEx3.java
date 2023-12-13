package day04;

public class GcdEx3 {

	public static void main(String[] args) {
		// 두 정수의 최대 공약수를 구하는 코드를 작성하세요
		int num1 = 32, num2 = 24;
		int i=1, gcd=1; // 최소공약수는 1이기 때문에 gcd를 1로 초기화함
		
		while(i<=num1) {
			if(num1%i == 0 && num2%i == 0 /*&& i>gcd 조건은 필요가 없음.*/) {
				gcd=i;
			}
			i++;
		}
		System.out.println(num1 + "과 "+num2+"의 최대 공약수: "+ gcd);

		
		for (i=num1;i!=1;i--) {
			if(num1%i==0 && num2%i ==0) {
				System.out.println("\n거꾸로 찾은 "+num1 + "과 "+num2+"의 최대 공약수: "+ gcd);
				break;
			}
		}
	}

}
