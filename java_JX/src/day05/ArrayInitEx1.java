package day05;

public class ArrayInitEx1 {

	public static void main(String[] args) {
		//

		// 0번지부터 4번지까지 모두 0으로 초기화됨.
		int arr1[] = new int[5];
		
		// 0번지에 1, 1번지에 2, ... 4번지에 5가 저장됨. 총 5의 길이를 가진 배열이 됨.
		int arr2[] = new int[] {1, 2, 3, 4, 5};
		
		// arr2와 같음.
		int arr3[] = {1, 2, 3, 4, 5};
	}

}
