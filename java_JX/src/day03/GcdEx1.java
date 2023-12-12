package day03;

public class GcdEx1 {

	public static void main(String[] args) {
		// 정수의 약수를 출력하는 예제를 작성하시오
		
		int num = 10;
		int i =0;
		
		System.out.println(num + "의 약수 출력: ");
		for(i=1 ; i <= num; i++) {
//			if (num==i) {
//				System.out.println("\n출력 완료");
//				break;
//			}
			if(num%i == 0)
				System.out.print(i + " ");
			
		} 
		// System.out.print(i+ (i == num?"\n" : ", ")); // 람다 함수로 if문을 대체할 수 있음.
		System.out.println("\n\n출력 완료\n\n");

		i=1;
		System.out.println(num + "의 약수 출력(while + break): ");
		while(true) {
			if (num<i) {
				System.out.println("\n\n출력 완료");
				break;
			}
			if (num%i == 0)
				System.out.print(i + " ");
			i++;
		}
	}

}
