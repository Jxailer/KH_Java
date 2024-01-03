package day07;

public class ArraymethodEx2 {

	public static void main(String[] args) {
		int arr[] = new int[5];
		int arr2[] = new int[5];
		initArray1(arr);
		printArray(arr);
		
		initArray2(arr2);
		printArray(arr2);
		
		int [] arr3 = initArray3(5);
		printArray(arr3);

	}
	public static void printArray(int [] arr) {
		for(int tmp : arr) {
			System.out.print(tmp+" ");
		}
		System.out.println();
	}
	/* 정수 배열에 1부터 순차적으로 저장하는 메서드 1 (잘못된 메서드)
	 * */
	public static void initArray1(int [] arr) {
		arr=new int[10]; 
		// 메서드 안에 배열을 새로 정의하면 메인 메서드에 정의 되어있는 배열과의 연결이 끊김.
		for(int i = 1; i<arr.length; i++) {
			arr[i] = i;
		}
	}
	
	/* 정수 배열에 1부터 순차적으로 저장하는 메서드 1 (올바른 메서드)
	 * */
	public static void initArray2(int [] arr) {
		for(int i = 0; i<arr.length; i++) {
			arr[i] = i+1;
		}
	}
	
	/* 정수가 주어지면 정수 크기의 배열을 생성하고
	 * 배열에 1부터 순차적으로 저장하여
	 * 만들어진 배열을 알려주는 메서드 (다른 메서드)
	 * */
	public static int[] initArray3(int num) {
		int [] arr = new int[num];
		for(int i = 1; i<=num; i++) {
			arr[i-1] = i;
		}
		return arr;
	}

}
