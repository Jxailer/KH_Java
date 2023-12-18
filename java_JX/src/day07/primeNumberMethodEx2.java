package day07;

public class primeNumberMethodEx2 {

	public static void main(String[] args) {
		//주어진 num가 소수인지 아닌지 판별하는 코드를 작성하세요. (메서드 이용)
		// 1에서 100 사이의 모든 소수를 출력하는 코드를 작성하세요. (이미 만들어진 메서드 이용)
		int num1 = 1, num2=100;
		System.out.print(num1+"과 "+num2+" 사이의 모든 소수: ");
		for(int i=num1;i<=num2;i++) {
			if(isPrimeNumber(i)&&i!=1) {
				System.out.print(i+" ");
			}
		}
		
	
	}
	
	// 정수인지 아닌지를 판별하는 코드
	public static boolean isPrimeNumber(int num) {
		int i;
		for(i = 2; i<num; i++) { 
			if(num%i==0) { // 1과 자기자신을 제외한 다른 약수가 있는 경우
				return false;
			}
		}
		// 1과 자기자신을 제외한 다른 약수가 없는 경우(return false를 하지 않고 아래코드로 진행됨)
		return true;
	}
	
	// 정수 num1과 정수 num2가 주어졌을 때, num2가 num1의 약수이면 참, 아니면 거짓이라고 알려주는 메서드
	public static boolean isDivisor(int num1, int num2) {
//		if(num1 % num2 == 0) {
//			return true;
//		}
//		return false;
		return num1 % num2 == 0;
	}
	
	
	//isDivisor를 이용한 메서드
//	public static boolean isPrimeNumber2(int num) {
//		for(int i = 2; i<num; i++) {
//			
//		}
//	}
	

}
