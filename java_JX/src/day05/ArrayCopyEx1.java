package day05;

public class ArrayCopyEx1 {

	public static void main(String[] args) {
		// 배열 복사 예제
		int arr1 [] = new int[] {1, 2, 3, 4, 5};
		int arr2 [] = new int[arr1.length];
		int arr3 [] = new int[arr1.length];
		int arr4 [] = new int[arr1.length];
		
		for(int i = 0; i <=arr1.length-1; i++) {
			arr2[i] = arr1[i];
			System.out.println(arr2[i]);
		}
		arr1[0]=9;
		System.out.println();
		System.out.println(arr1[0]);
		System.out.println(arr2[0]);
		
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		System.out.println("\narr3");
		for(int i = 0; i <=arr1.length-1; i++) {
			System.out.println(arr3[i]);
		}
		
		// arr1 배열의 1번지부터 2개를 복사해서 arr5 배열에 0번지부터 덮어씀
		System.arraycopy(arr1, 1, arr4, 0, 2);
		System.out.println("\narr4");
		for(int i = 0; i <=arr1.length-1; i++) {
			System.out.println(arr4[i]);
		}
	}

}
