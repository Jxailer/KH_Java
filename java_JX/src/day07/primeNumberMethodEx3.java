//package day07;
//
//public class primeNumberMethodEx1 {
//
//	public static void main(String[] args) {
//		//주어진 num가 소수인지 아닌지 판별하는 코드를 작성하세요. (메서드 이용)
//		int num1 = 12, num2=6;
//		if (isPrimeNumber(num1)) {
//			System.out.println(num1+ "은 소수입니다.");
//		}
//		else
//			System.out.println(num1+ "은 소수가 아닙니다.");
//		
//		if (isDivisor(num1, num2)) {
//			System.out.println(num2+"는 "+num1+"의 약수입니다.");
//		}
//		else
//
//			System.out.println(num2+"는 "+num1+"의 약수가 아닙니다.");
//		
//	
//	}
//	
//	// 정수인지 아닌지를 판별하는 코드
//	public static boolean isPrimeNumber(int num) {
//		int i;
//		for(i = 2; i<num; i++) { 
//			if(num%i==0) { // 1과 자기자신을 제외한 다른 약수가 있는 경우
//				return false;
//			}
//		}
//		
//		// 1과 자기자신을 제외한 다른 약수가 없는 경우(return false를 하지 않고 아래코드로 진행됨)
//		return true;
//		
//	}
//	
//	// 정수 num1과 정수 num2가 주어졌을 때, num2가 num1의 약수이면 참, 아니면 거짓이라고 알려주는 메서드
//	public static boolean isDivisor(int num1, int num2) {
////		if(num1 % num2 == 0) {
////			return true;
////		}
////		return false;
//		return num1 % num2 == 0;
//	}
//	
//	
//	//isDivisor를 이용한 메서드
//	public static boolean isPrimeNumber2(int num) {
//		for(int i = 2; i<num; i++) {
//			
//		}
//	}
//	
//
//}
