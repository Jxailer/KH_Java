package day07;

public class MethodEx2 {

	public static void main(String[] args) {
		/* 매개변수가 기본형 변수인 경우와 참조형 변수인 경우의 차이를 보여주는 예제
		 * */
		int num1=10, num2=20;
		int [] arr1 = {1, 2, 3, 4, 5};
		int [] arr2 = {10, 20, 30, 40, 50};
		
		System.out.println(num1);
		System.out.println(num2+"\n");
		
		swapInt(num1, num2);
		System.out.println(num1);
		System.out.println(num2); // 결과값이 바뀌지 않는다.
		
		printArray(arr1);
		printArray(arr2);
		System.out.println();
		
		swapArray(arr1, arr2);
		
		printArray(arr1);
		printArray(arr2);
		
	}
	// 정수 배열을 콘솔에 한 줄로 출력하는 메서드
	public static void printArray(int [] arr) {
		for(int tmp : arr) {
			System.out.print(tmp+" ");
		}
		System.out.println();
			
	}
	
	// 두 정수를 바꾸는 메서드
	public static void swapInt(int num1, int num2) {
		// 이곳의 num1은 메인 클래스에서 선언된 num1이 아니라, 메서드 안의 변수인 num1을 말하는 것.
		// 따라서 메인 클래스의 변수값은 변하지 않음.
		// 기본 자료형은 메서드 안에서 값이 바뀌어도 원본은 안바뀜.
		int tmp = num1; 
		num1 = num2;
		num2 = tmp;
	}
	
	// 두 정수 배열을 바꾸는 메서드
	public static void swapArray(int [] arr1, int [] arr2) {
		// 참조변수의 주소값을 직접 받아오기 때문에 실제적으로 변수값이 바뀌게 됨.
		for(int i = 0; i<arr1.length; i++) {
			int tmp = arr1[i];
			arr1[i] = arr2[i];
			arr2[i] = tmp;
		}
	}

}
