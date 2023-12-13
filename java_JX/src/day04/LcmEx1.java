package day04;

public class LcmEx1 {

	public static void main(String[] args) {
		// 두 정수의 최소 공배수를 구하는 코드를 작성하세요
		
		int num1 = 10, num2 = 15;
		
		for(int i=1; i<=num1*num2; i++) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println("최소공배수: "+ i);
				break;
			}
		}
		
		// i를 num1의 배수로만 넣음.
		for(int i=num1; i<=num1*num2; i+=num1) {
			if(i % num2 == 0) {
				System.out.println("최소공배수: "+ i);
				break;
			}
		}
		
		int j=0, k=0;
		// 2중 for문 탈출이 안됨. 바깥 for문의 조건식 변경 필요함.
		// 변수를 이용하여 최소공배수를 찾았는지 여부를 확인하도록 함.
		for(int i=1; k!=1; i++) {
//			System.out.println("i="+i);
			for(j=1; j<=num1*i; j++) {
//				System.out.println("j="+j);
				if(num1*i==num2*j) {
					System.out.println("최소공배수: "+ num1*i);
					k=1;
					break;
				}
			}
			
		}
	
		
		
		
		
		
		
		

	}

}
